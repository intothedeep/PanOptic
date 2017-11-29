package com.kitri.user.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.login.UserLogin;
import com.kitri.user.main.Main;

public class Network implements Runnable {
    private final int SOCKET_TIMEOUT = 3000;
    private final String IP = "192.168.18.25";
    private final int PORT = 9831;

    private Socket socket;
    private BufferedReader buffReader;
    private BufferedInputStream reader;
    private PrintWriter writer;
    private boolean isRunnable;

    private String[] dataPacket;

    public Services services;
    public UserLogin view;
    public int comNum;

    public Network() {
	view = new UserLogin();

	Thread thread = new Thread(this);
	thread.start();
    }

    @Override
    public void run() {
	byte[] byteBuffer = new byte[500];
	isRunnable = true;
	int len = 0;
	String packets;

	try {
	    socket = new Socket();
	    socket.connect(new InetSocketAddress(IP, PORT), SOCKET_TIMEOUT);
	    buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "EUC-KR"));
	    writer = new PrintWriter(socket.getOutputStream(), true);
	    sendPacket(PacketInformation.IDLE, PacketInformation.IDLE, PacketInformation.IDLE);
	    services = new Services(this);
	    while (isRunnable) {
		// len = reader.read(byteBuffer);

		packets = buffReader.readLine();
		if(packets == null){ 
		    Main.log("recv : null !!!!!!!");
		}
		Main.log("rcv : " + packets);
		divisionPacket(packets);

		packets = null;
	    }
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (buffReader != null) {
		    buffReader.close();
		}
		if (writer != null) {
		    writer.close();
		}
		if (socket != null) {
		    socket.close();
		}
		isRunnable = false;
	    } catch (Exception e2) {
		e2.printStackTrace();
	    }

	}

    }

    private void divisionPacket(String packets) {
	String PATTERN = "!";

	StringTokenizer patternToken = new StringTokenizer(packets.trim(), PATTERN);
	StringTokenizer unitToken;
	String part;
	int i = 0;

	while (patternToken.hasMoreTokens()) {
	    unitToken = new StringTokenizer(patternToken.nextToken(), PacketInformation.PACKET_PARTITION);
	    dataPacket = new String[PacketInformation.PACKET_SIZE];
	    i = 0;
	    while (unitToken.hasMoreTokens()) {
		dataPacket[i++] = unitToken.nextToken();
	    }
	    Main.log(Arrays.toString(dataPacket));
	    dicisionProgram();
	}
    }

    private void dicisionProgram() {
	if (PacketInformation.ProgramValue.USER == Integer
		.parseInt(dataPacket[PacketInformation.PacketStructrue.PROGRAM_VALUE])) {
	    dicisionOperator(Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.OPERATOR]));
	}
    }

    private void dicisionOperator(int operator) {
	int packetType = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.PACKET_TYPE]);
	Main.log("dicisionOperator()");
	switch (operator) {
	case PacketInformation.Operation.RESPONSE:
	    responsePacket(packetType);
	    break;
	case PacketInformation.Operation.GET:

	    break;
	case PacketInformation.Operation.COUNT:
	    countPacket(packetType);
	    break;
	case PacketInformation.Operation.JOIN:
	    joinResaponse(packetType);
	case PacketInformation.Operation.LOGIN:
	    loginResponse(packetType);
	    break;
	case PacketInformation.Operation.BUY:
	    buyResponse(packetType);
	    break;
	case PacketInformation.Operation.MESSAGE:
	    messageResponse(packetType);
	    break;
	case PacketInformation.Operation.RESTRICTION:
	    restrictionResponse(packetType);
	    break;
	default:

	}
    }
    
    private void restrictionResponse(int packetType){
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	
	Main.log("restrictionResponse()");
	switch(packetType){
	case PacketInformation.PacketType.YEAR_OF_AGE:
	    services.restrictionUser(data);
	    break;
	}
	
    }
    
    private void messageResponse(int packetType){
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	
	switch(packetType){
	case PacketInformation.PacketType.ADMIN_MSG:
	    view.statusInfo.msg.listener.setChatArea(data, PacketInformation.PacketType.ADMIN_MSG);
	    view.statusInfo.msg.setVisible(true);
	    break;
	}
	
    }

    private void buyResponse(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.FOOD:
	    services.buyFoodResult(data);
	    break;
	case PacketInformation.PacketType.IS_OK:
	    break;
	case PacketInformation.PacketType.IS_FAIL:
	    break;
	default:
	}
    }

    private void loginResponse(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	switch (packetType) {
	case PacketInformation.PacketType.IS_OK:
	    services.loginSuccess(data);
	    break;
	case PacketInformation.PacketType.IS_FAIL:
	    view.loginFail();
	    break;
	}
    }

    private void joinResaponse(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.CHECK_USER_ID:
	    services.checkId(data);
	    break;
	case PacketInformation.PacketType.IS_OK:
	    view.joinSuccess();
//	    view.join.setVisible(false);
	    break;
	case PacketInformation.PacketType.IS_FAIL:
	    view.join.joinFailDialog();
	    break;
	default:
	}
    }

    private void countPacket(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	int intData = Integer.parseInt(data);

	switch (packetType) {
	case PacketInformation.PacketType.COM_PREPAID_INFO:
	    break;
	case PacketInformation.PacketType.POINT_INFO:
	    break;

	}
    }

    private void responsePacket(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.FOOD:
	    services.responseFoodDatas(data);
	    break;
	case PacketInformation.PacketType.FOOD_TYPE:
	    services.responseFoodTypeDatas(data);
	    break;
	case PacketInformation.PacketType.IS_END:
	    services.isEnd(data);
	    break;
	case PacketInformation.PacketType.IS_START:
	    services.isStart(data);
	    break;
	case PacketInformation.PacketType.COM_NUM:
	    comNum = Integer.parseInt(data);
//	    Main.log("comNum : " + comNum);
	    view.statusInfo.statusComNum.setText("PC " + comNum);
	    view.mainComNum.setText("PC " + comNum);
	    break;
	case PacketInformation.PacketType.USER_INFO:
	    view.userInfo = new UserInfoDto();
	    view.userInfo.setField(data);
	    Main.log("userInfo : " + view.statusInfo.toString());
	    break;
	case PacketInformation.PacketType.POINT:
	    view.userPoint = Integer.parseInt(data);
	    Main.log("userPoint : " + view.userPoint);
	    break;
	case PacketInformation.PacketType.COM_PREPAID_INFO:
	    break;
	case PacketInformation.PacketType.POINT_INFO:
	    break;
	}
    }

    public void sendPacket(int programValue, int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(programValue);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(operator);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(packetType);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(data);
	buff.append("!");
	Main.log(buff.toString());

	writer.println(buff.toString());
    }

    public void sendPacket(int programValue, int operator, int packetType, int data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(programValue);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(operator);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(packetType);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(data);
	buff.append("!");
	Main.log(buff.toString());

	writer.println(buff.toString());
    }

    public void sendPacket(int operator, int packetType, byte data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(PacketInformation.ProgramValue.USER);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(operator);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(packetType);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(data);
	buff.append("!");

	Main.log(buff.toString());
	writer.println(buff.toString());
    }

    public void sendPacket(int operator, int packetType, int data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(PacketInformation.ProgramValue.USER);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(operator);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(packetType);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(data);
	buff.append("!");
	Main.log(buff.toString());

	Main.log(buff.toString());
	writer.println(buff.toString());
    }

    public void sendPacket(int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(PacketInformation.ProgramValue.USER);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(operator);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(packetType);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(data);
	buff.append("!");
	Main.log(buff.toString());

	writer.println(buff.toString());
    }

    public void sendPacket(String str) {
	if (writer != null) {
	    writer.println(str);
	} else {
	    Main.log("null");
	}
    }

    public static void main(String[] args) {
	Network net = new Network();
	Thread netThread = new Thread(net);
	netThread.start();

    }

}
