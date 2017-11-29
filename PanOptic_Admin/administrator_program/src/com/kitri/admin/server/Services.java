package com.kitri.admin.server;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.kitri.admin.database.dao.*;
import com.kitri.admin.database.dto.*;
import com.kitri.admin.main.PcMain;
import com.kitri.admin.main.PcMain.ComInfo;

public class Services {
    ClientHandlerThread clientHandlerThread;
    public boolean isFoodOrderEnd = true;

    public ArrayList<OrderInfoDto> orderInfoList;

    public Services(ClientHandlerThread clientHandlerThread) {
	this.clientHandlerThread = clientHandlerThread;
    }

    public void getComPrepaidInfo() {
	Main.log("getComPrepaidInfo()");
	ComPrepaidInfoDao dao = new ComPrepaidInfoDao();
	ArrayList<ComPrepaidInfoDto> dtos = dao.selectAll();

	StringBuilder buffer = new StringBuilder("");
	int size = dtos.size();
	clientHandlerThread.sendPacket(PacketInformation.Operation.COUNT, PacketInformation.PacketType.COM_PREPAID_INFO,
		size);
	for (int i = 0; i < size; i++) {
	    buffer.append(getPacketFormat(PacketInformation.Operation.RESPONSE,
		    PacketInformation.PacketType.COM_PREPAID_INFO, dtos.get(i).toString()));
	}

	clientHandlerThread.sendPacket(buffer.toString());

    }

    public void getPointInfo() {
	Main.log("getPointInfo()");
	PointInfoDao dao = new PointInfoDao();
	ArrayList<PointInfoDto> dtos = dao.selectAll();

	StringBuilder buffer = new StringBuilder("");
	int size = dtos.size();
	clientHandlerThread.sendPacket(PacketInformation.Operation.COUNT, PacketInformation.PacketType.POINT_INFO,
		size);
	for (int i = 0; i < size; i++) {
	    buffer.append(getPacketFormat(PacketInformation.Operation.RESPONSE, PacketInformation.PacketType.POINT_INFO,
		    dtos.get(i).toString()));
	}

	clientHandlerThread.sendPacket(buffer.toString());
    }

    public void checkId(String id) {
	Main.log("checkId()");
	UserInfoDao dao = new UserInfoDao();
	if (dao.checkId(id).isEmpty()) {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.CHECK_USER_ID,
		    1);
	} else {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.CHECK_USER_ID,
		    0);
	}
    }

    public void loginUser(String data) {
	String[] datas = data.split(",");
	String id = datas[0];
	String pw = datas[1];
	String pwCheck;
	UserInfoDao dao = new UserInfoDao();
	String temp = dao.checkId(id);
	String[] temps;

	Main.log("loginUser() : " + temp);
	if (!temp.isEmpty()) {

	    temps = temp.split(",");
	    String num = temps[0]; // userNum
	    pwCheck = temps[1];
	    String leftTime = temps[2];
	    Main.log("userLeftTime : " + leftTime);
	    if (pwCheck.equals(pw)) {
		if (clientHandlerThread.clientProgramValue == PacketInformation.ProgramValue.USER
			&& isHasTime(leftTime)) {
		    clientHandlerThread.sendPacket(PacketInformation.Operation.RESPONSE,
			    PacketInformation.PacketType.IS_START, PacketInformation.PacketType.FOOD);
		    sendFoodTypeInfo();
		    sendFoodInfo();

		    clientHandlerThread.sendPacket(PacketInformation.Operation.RESPONSE,
			    PacketInformation.PacketType.IS_END, PacketInformation.PacketType.FOOD);
		    clientHandlerThread.userNum = Integer.parseInt(num);

		    UserInfoDto dto = new UserInfoDto();
		    dto = new UserInfoDao().select(Integer.parseInt(num));
		    clientHandlerThread.userInfo = dto;
		    startUsingCom(clientHandlerThread.userNum, clientHandlerThread.index);

		    UserPointInfoDto pdto = new UserPointInfoDao().select(Integer.parseInt(num));
		    if (pdto == null) {
			clientHandlerThread.sendPacket(PacketInformation.Operation.RESPONSE,
				PacketInformation.PacketType.POINT, 0);
		    } else {
			clientHandlerThread.sendPacket(PacketInformation.Operation.RESPONSE,
				PacketInformation.PacketType.POINT, pdto.getPoint());

		    }

		    clientHandlerThread.sendPacket(PacketInformation.Operation.RESPONSE,
			    PacketInformation.PacketType.USER_INFO, dto.toString());

		    clientHandlerThread.sendPacket(PacketInformation.Operation.LOGIN,
			    PacketInformation.PacketType.IS_OK, num);
		    return;

		} else if (clientHandlerThread.clientProgramValue == PacketInformation.ProgramValue.PAYMENT) {
		    clientHandlerThread.sendPacket(PacketInformation.Operation.LOGIN,
			    PacketInformation.PacketType.IS_OK, num);
		    return;
		}
	    }
	}
	clientHandlerThread.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.IS_FAIL,
		PacketInformation.IDLE);
    }

    private boolean isHasTime(String time) {
	if (time == null || time.isEmpty() || time.equals("null") || time.equals("0:0:0")) {
	    Main.log("leftTime is false");
	    return false;
	}

	return true;
    }

    private void startUsingCom(int userNum, int comNum) {
	ComDao comDao = new ComDao();
	ComDto comDto = new ComDto();
	comDto.setComNum(comNum);
	comDto.setUserNum(userNum);
	comDao.update(comDto);

	ComUseInfoDto comUseDto = new ComUseInfoDto();
	ComUseInfoDao comUseDao = new ComUseInfoDao();

	comUseDto.setComNum(comNum);
	comUseDto.setUserNum(userNum);

	if (comUseDao.insert(comUseDto)) {
	    Main.log("startUsingCom success !!!");
	} else {
	    Main.log("startUsingCom fail TTT");
	}

	clientHandlerThread.serverThread.pcMain.comInfos.get(comNum).name = clientHandlerThread.userInfo.getUserName();
	Main.log("12312312312312312");
	clientHandlerThread.serverThread.pcMain.comInfos.get(comNum).useTime = "0:0:0";
	clientHandlerThread.serverThread.pcMain.coms.get(comNum)
		.setText(clientHandlerThread.serverThread.pcMain.comInfos.get(comNum).toString());
	clientHandlerThread.serverThread.pcMain.coms.get(comNum).setForeground(Color.GREEN);
    }

    public boolean endUsingCom(int comNum, int userNum) {
	ComDao comDao = new ComDao();
	ComDto comDto = new ComDto();
	comDto.setComNum(comNum);
	comDto.setUserNum(-1);
	comDao.update(comDto);

	ComUseInfoDao comUseDao = new ComUseInfoDao();
	int comUseNum = comUseDao.selectNum(comNum, userNum);

	if (comUseDao.update(comUseNum)) {
	    Main.log("endUsingCom Success !!");
	    PcMain pcMain = clientHandlerThread.serverThread.pcMain;
	    pcMain.comInfos.get(comNum).name = "";
	    pcMain.comInfos.get(comNum).useTime = "";
	    pcMain.coms.get(comNum).setText(clientHandlerThread.serverThread.pcMain.comInfos.get(comNum).toString());
	    pcMain.coms.get(comNum).setForeground(Color.BLACK);
	    pcMain.detailViews.get(comNum).messenger.messageBuffer = new StringBuilder("");
	    pcMain.detailViews.get(comNum).messenger.msgtextArea.setText("");
	    pcMain.detailViews.get(comNum).messenger.setVisible(false);
	    return true;
	} else {
	    Main.log("endUsingCom Fail TTTT");
	    return false;
	}

    }

    public void logoutUser(String data) {
	if (endUsingCom(clientHandlerThread.index, clientHandlerThread.userNum)) {
	    clientHandlerThread.userNum = -1;
	    UserInfoDto dto = new UserInfoDto();
	    dto.setField(data);

	    if (new UserInfoDao().updateLogout(dto)) {
		Main.log("logout Success !!!!!");
	    }
	}
    }

    private void sendFoodTypeInfo() {
	FoodTypeDao dao = new FoodTypeDao();
	ArrayList<FoodTypeDto> dtos = dao.selectAll();
	int size = dtos.size();

	for (int i = 0; i < size; i++) {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.RESPONSE, PacketInformation.PacketType.FOOD_TYPE,
		    dtos.get(i).toString());
	}
    }

    private void sendFoodInfo() {
	Main.log("sendFoodInfo()");
	FoodDao dao = new FoodDao();
	ArrayList<FoodDto> dtos = dao.selectAll();

	int size = dtos.size();

	Main.log("sendFoodInfo()" + size);
	for (int i = 0; i < size; i++) {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.RESPONSE, PacketInformation.PacketType.FOOD,
		    dtos.get(i).toString());
	}

    }
    
    public void setProgram(String data){
//	Main.log("program : " + data);
	StringTokenizer token = new StringTokenizer(data, ",");
	PcMain pcMain = clientHandlerThread.serverThread.pcMain;
    	StringBuilder temp = new StringBuilder("");
//	Main.log("program size : " + token.countTokens());
//	pcMain.detailViews.get(clientHandlerThread.index).comViewUseProgramTA.setText("");
	while(token.hasMoreTokens()){
	    temp.append(token.nextToken() + "\n");
//	    Main.log(temp);
	}
	pcMain.detailViews.get(clientHandlerThread.index).comViewUseProgramTA.setText(temp + "\n");
    }

    public void setTime(String data) {
	String[] times = data.split(","); // leftTime,useTime
	PcMain pcMain = clientHandlerThread.serverThread.pcMain;
	int index = clientHandlerThread.index;
	pcMain.leftTimes.set(index, times[0]);
	pcMain.userTimes.set(index, times[1]);

	ComInfo comInfo = pcMain.comInfos.get(index);
	comInfo.useTime = times[1];
	pcMain.coms.get(index).setText(comInfo.toString());
	
	pcMain.detailViews.get(index).comViewUseTime.setText(times[1]);
	pcMain.detailViews.get(index).comViewRestTime.setText(times[0]);
	

    }

    public void joinUser(String data) {
	Main.log("joinUser()");
	UserInfoDto dto = new UserInfoDto();
	dto.setField(data);
	UserInfoDao dao = new UserInfoDao();
	Main.log(dto.joinToString());

	if (dao.insert(dto)) {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.IS_OK,
		    PacketInformation.IDLE);
	} else {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.IS_FAIL,
		    PacketInformation.IDLE);
	}
    }

    public void buyPoint(String data) {
	Main.log("buyPoint()");
	String[] datas = data.split(","); // index,userNum
	int userNum = Integer.parseInt(datas[2]);

	PointInfoDao dao = new PointInfoDao();
	PointInfoDto dto = dao.select(Integer.parseInt(datas[1]));
	Main.log(dto.toString());
	UserPointInfoDao uDao = new UserPointInfoDao();
	UserPointInfoDto uDto = uDao.select(userNum);

	if (uDto == null) {
	    uDto = new UserPointInfoDto();
	    uDto.setPoint(dto.getValue());
	    uDto.setUserNum(userNum);
	    uDao.insert(uDto);
	} else {
	    uDto.setPoint(uDto.getPoint() + dto.getValue());
	    uDao.update(uDto);
	}

	clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.IS_OK,
		PacketInformation.IDLE);

    }

    public void buyTime(String data) {
	Main.log("buyTime()");
	String[] datas = data.split(","); // payType,index,userNum
	int userNum = Integer.parseInt(datas[2]);

	ComPrepaidInfoDao comDao = new ComPrepaidInfoDao();
	ComPrepaidInfoDto comDto = comDao.select(Integer.parseInt(datas[1]));
	UserInfoDao uInfoDao = new UserInfoDao();
	UserInfoDto uInfoDto;

	if (Integer.parseInt(datas[0]) == PacketInformation.PacketType.POINT) {
	    UserPointInfoDao uPInfoDao = new UserPointInfoDao();
	    UserPointInfoDto upInfoDto = uPInfoDao.select(userNum);

	    if (upInfoDto == null) {
		clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.IS_FAIL,
			PacketInformation.IDLE);
		return;
	    }

	    Main.log(upInfoDto.toString());
	    Main.log(comDto.toString());
	    int left = upInfoDto.getPoint() - comDto.getPrepaidPrice();
	    if (left < 0) {
		clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.IS_FAIL,
			PacketInformation.IDLE);
		return;
	    } else {
		upInfoDto.setPoint(left);
		uPInfoDao.update(upInfoDto);

		uInfoDto = uInfoDao.select(userNum);
		Main.log(uInfoDto.toString());
		if (uInfoDto.getUserLeftTime().equals("null")) {
		    if (!uInfoDao.updateLeftTime(userNum, comDto.getPrepaidTime() + ":00:00")) {
			clientHandlerThread.sendPacket(PacketInformation.Operation.BUY,
				PacketInformation.PacketType.IS_FAIL, PacketInformation.IDLE);
			return;
		    }
		} else {
		    if (!uInfoDao.updateLeftTime(userNum,
			    sumTime(uInfoDto.getUserLeftTime(), comDto.getPrepaidTime() + ":00:00"))) {
			clientHandlerThread.sendPacket(PacketInformation.Operation.BUY,
				PacketInformation.PacketType.IS_FAIL, PacketInformation.IDLE);
			return;
		    }
		}

	    }
	} else {
	    uInfoDto = uInfoDao.select(userNum);
	    Main.log(uInfoDto.toString());
	    if (uInfoDto.getUserLeftTime().equals("null")) {
		if (!uInfoDao.updateLeftTime(userNum, comDto.getPrepaidTime() + ":00:00")) {
		    clientHandlerThread.sendPacket(PacketInformation.Operation.BUY,
			    PacketInformation.PacketType.IS_FAIL, PacketInformation.IDLE);
		    return;
		}
	    } else {
		if (!uInfoDao.updateLeftTime(userNum,
			sumTime(uInfoDto.getUserLeftTime(), comDto.getPrepaidTime() + ":00:00"))) {
		    clientHandlerThread.sendPacket(PacketInformation.Operation.BUY,
			    PacketInformation.PacketType.IS_FAIL, PacketInformation.IDLE);
		    return;
		}
	    }
	}

	clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.IS_OK,
		PacketInformation.IDLE);
    }

    public void addOrderInfo(String data) {
	OrderInfoDto dto = new OrderInfoDto();
	dto.setField(data);

	orderInfoList.add(dto);
    }

    public void buyFood() {
	int sumPrice = 0;
	int size = orderInfoList.size();
	OrderInfoDto dto;

	for (int i = 0; i < size; i++) {
	    dto = orderInfoList.get(i);
	    dto.setOrderMoney(dto.getOrderCount() * dto.getOrderMoney());
	    sumPrice += dto.getOrderMoney();
	}
	Main.log("sumPrice : " + sumPrice);

	UserPointInfoDao uPDao = new UserPointInfoDao();
	UserPointInfoDto uPDto = uPDao.select(orderInfoList.get(0).getUserNum());

	if (uPDto != null && uPDto.getPoint() >= sumPrice) {
	    uPDto.setPoint(uPDto.getPoint() - sumPrice);
	    if (uPDao.update(uPDto)) {
		OrderInfoDao dao = new OrderInfoDao();
		for (int i = 0; i < size; i++) {
		    dao.insert(orderInfoList.get(i));
		}

		clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.FOOD,
			PacketInformation.PacketType.IS_OK);
		return;
	    }
	}
	clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.FOOD,
		PacketInformation.PacketType.IS_FAIL);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getPacketFormat(int programValue, int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(programValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	return buff.toString();
    }

    public String getPacketFormat(int programValue, int operator, int packetType, int data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(programValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	return buff.toString();
    }

    public String getPacketFormat(int operator, int packetType, int data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(clientHandlerThread.clientProgramValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	return buff.toString();
    }

    public String getPacketFormat(int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(clientHandlerThread.clientProgramValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	return buff.toString();
    }

    private String sumTime(String time1, String time2) {
	Main.log(time1 + ", " + time2);
	String[] result = new String[3];
	for (int i = 0; i < 3; i++) {
	    result[i] = "0";
	}
	String time1s[] = time1.split(":");
	String time2s[] = time2.split(":");

	final int MAX = 60;
	int len = time1s.length;
	int temp;
	for (int i = 2; i >= 0; i--) {
	    temp = 0;
	    temp = Integer.parseInt(time1s[i]) + Integer.parseInt(time2s[i]);
	    Main.log(Integer.parseInt(time1s[i]) + ", " + Integer.parseInt(time2s[i]));

	    if (temp >= MAX) {
		if (i != 0) {
		    result[i - 1] = "1";
		    result[i] = temp % MAX + "";
		}
	    }
	    result[i] = (temp + Integer.parseInt(result[i])) + "";
	}

	return result[0] + ":" + result[1] + ":" + result[2];
    }

}
