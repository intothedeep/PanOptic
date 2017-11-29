package com.kitri.user.network;

import java.text.ParseException;
import java.util.ArrayList;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.dto.FoodTypeDto;
import com.kitri.user.main.Main;
import com.kitri.user.statusinfo.CheckRunningProcess;
import com.kitri.user.statusinfo.UseTimer;

public class Services {

    private Network network;

    public Services(Network network) {
	this.network = network;

    }

    public void checkId(String data) {
	Main.log("checkId(Response)");
	if (data.equals("0")) {
	    network.view.join.checkId = false;
	    network.view.join.checkIdFalseDialog();
	} else {
	    network.view.join.checkId = true;
	    network.view.join.checkIdTrueDialog();
	}
    }

    public void responseFoodTypeDatas(String data) {
	FoodTypeDto dto = new FoodTypeDto();
	dto.setField(data);
	// Main.log(dto.toString());
	network.view.statusInfo.order.foodTypes.add(dto);
    }
    
    public void restrictionUser(String data){
	int restrictionYear = Integer.parseInt(data);
	String userBirth = network.view.userInfo.getUserBirth();
	int userYear = Integer.parseInt(userBirth.substring(0, userBirth.indexOf("-")));
	
	if(restrictionYear < userYear){
	    network.view.statusInfo.listener.logout();
	}
	
	
    }

    public void responseFoodDatas(String data) {
	FoodDto dto = new FoodDto();
	dto.setField(data);

	switch (dto.getFoodTypeNum()) {
	case 0: // 음식
	    network.view.statusInfo.order.foods.add(dto);
	    break;
	case 1: // 스낵
	    network.view.statusInfo.order.snacks.add(dto);
	    break;
	case 2: // 음료
	    network.view.statusInfo.order.beverages.add(dto);
	    break;
	default:

	}
    }

    public void buyFoodResult(String data) {
	if (Integer.parseInt(data) == PacketInformation.PacketType.IS_OK) {
	    network.view.statusInfo.order.buyFoodSuccess();
	} else {
	    network.view.statusInfo.order.buyFoodFail();
	}
    }

    public void isEnd(String data) {
	switch (Integer.parseInt(data)) {
	case PacketInformation.PacketType.FOOD:
	    network.view.statusInfo.order.foodPane.setRowData();
	    network.view.statusInfo.order.beveragePane.setRowData();
	    network.view.statusInfo.order.snackPane.setRowData();
	    break;
	}
    }

    public void isStart(String data) {
	switch (Integer.parseInt(data)) {
	case PacketInformation.PacketType.FOOD:
	    network.view.statusInfo.order.foodTypes = new ArrayList<>();
	    network.view.statusInfo.order.foods = new ArrayList<>();
	    network.view.statusInfo.order.beverages = new ArrayList<>();
	    network.view.statusInfo.order.snacks = new ArrayList<>();
	    break;
	}
    }

    public void loginSuccess(String data) {
	network.view.setVisible(false);
	network.view.userNum = Integer.parseInt(data);
	network.view.statusInfo.setVisible(true);
	network.view.programView.setVisible(true);

	try {
	    network.view.statusInfo.leftTimeLong = network.view.statusInfo.format
		    .parse(network.view.statusInfo.login.userInfo.getUserLeftTime()).getTime();
	} catch (ParseException e) {
	    System.out.println(e.toString());
	    e.printStackTrace();
	}
	network.view.statusInfo.useTimer = new UseTimer(network.view.statusInfo);
	network.view.statusInfo.runningProcess = new CheckRunningProcess(network.view.statusInfo);
	
	
	
	network.view.statusInfo.listener.setStatusInfoField();
	network.view.statusInfo.mp.listener.setMyPageField();
	
	// if (network.view.payType == PacketInformation.PacketType.POINT) {
	// if (network.view.payment.isPoint) {
	// network.view.pointException();
	// } else {
	// Main.network.sendPacket(PacketInformation.Operation.BUY,
	// PacketInformation.PacketType.TIME,
	// PacketInformation.PacketType.POINT + "," + network.view.payment.index
	// + ","
	// + network.view.payment.userNum);
	// }
	// } else {
	// network.view.payment.setVisible(true);
	//
	// Main.log("loginSuccess userNum : " + network.view.payment.userNum);
	// }

    }
}
