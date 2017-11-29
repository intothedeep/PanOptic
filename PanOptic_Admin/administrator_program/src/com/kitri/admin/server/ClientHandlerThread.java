package com.kitri.admin.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.security.Key;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.kitri.admin.database.dto.UserInfoDto;
import com.kitri.admin.main.PcMain;
import com.kitri.admin.server.PacketInformation.ProgramValue;

public class ClientHandlerThread extends Thread {

    private Abortable abortable;
    private SocketChannel client;
    private Selector selector;
    private CharBuffer recvData;
    public String[] dataPacket;
    public ServerThread serverThread;
    public Services services;

    public int myCount;

    public int index;
    public int userNum = -1;
    public boolean isLogined;

    public StringBuilder tempRecv;
    public UserInfoDto userInfo;

    public int clientProgramValue;

    public SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

    public ClientHandlerThread(Abortable abortable, SocketChannel client, Selector selector, ServerThread serverThread,
	    int handlerCount) {
	
	this.abortable = abortable;
	this.client = client;
	services = new Services(this);
	this.serverThread = serverThread;
	// this.selector = selector;
	myCount = handlerCount;
	isLogined = false;
	tempRecv = new StringBuilder("");
    }

    @Override
    public void run() {
	super.run();

	Selector selector = null;
	Charset cs = Charset.forName("EUC-KR");
	int socketOptions = SelectionKey.OP_WRITE | SelectionKey.OP_READ | SelectionKey.OP_CONNECT;

	boolean done = false;

	try {

	    Main.log("Client :: started");
	    client.configureBlocking(false);
	    selector = Selector.open();

	    client.register(selector, socketOptions);

	    sendPacket(PacketInformation.Operation.RESPONSE, PacketInformation.PacketType.COM_NUM, index);

	    ByteBuffer buffer = ByteBuffer.allocate(4096);
	    while (!Thread.interrupted() && !abortable.isDone() && !done) {
		selector.select(3000);

		Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

		while (!abortable.isDone() && iter.hasNext() && !done) {
		    SelectionKey selected = (SelectionKey) iter.next();

		    if (selected.isConnectable()) {

			if (client.isConnectionPending()) {

			    client.finishConnect();
			}
		    } else if (selected.isReadable()) {
			int len = client.read(buffer);

			if (len < 0) {
			    done = true;
			    break;
			}

			if (buffer.position() != 0) {
			    buffer.flip();
			    recvData = cs.decode(buffer);
			    conbinePacket(recvData.toString());
			}

			if (selected.isWritable()) {
			    buffer.clear();
			}
		    }
		}

	    }

	} catch (Exception e) {
	    // deleteThreadSocket();
	    // Main.log("client error : " + e.toString());
	    // e.printStackTrace();
	    done = true;
	} finally {
	    if (userNum != -1) {
		services.endUsingCom(index, userNum);
	    }
	    if (client != null) {
		try {
		    done = true;
		    // client.finishConnect();
		    Main.log("Client :: Close Socket");
		    client.socket().close();
		    client.close();
		} catch (IOException e) {
		    Main.log("client finally error : " + e.toString());
		    e.printStackTrace();
		}
	    }

	    deleteThreadSocket();
	    Main.log("Client :: bye");
	    Server.addLog("client :: bye");
	}
    }

    void conbinePacket(String message) {
	StringTokenizer lineToken = new StringTokenizer(message, "\n");
	StringBuilder tempPacket = new StringBuilder("");
	String part;
	String[] packet = null;
	int packetSize = 0;
	int partLen = 0;
	String PATTERN = "!";

	while (lineToken.hasMoreTokens()) {
	    part = lineToken.nextToken().trim();

	    Main.log("part : " + part);
	    partLen = part.length() - 1;
	    if (part.indexOf(PATTERN) == -1) {
		tempPacket.append(part);
		continue;
	    } else {
		packet = part.split(PATTERN);
		packetSize = packet.length;
		if (tempPacket.length() != 0) {
		    packet[0] = tempPacket.toString() + packet[0];
		    tempPacket = new StringBuilder("");
		}
		if (part.indexOf(PATTERN) != partLen) {
		    tempPacket.append(packet[packetSize - 1]);
		    packetSize--;
		}
	    }

	    for (int k = 0; k < packetSize; k++) {
		String[] temp = packet[k].split(PacketInformation.PACKET_PARTITION);

		String[] newData = new String[PacketInformation.PACKET_SIZE];
		dataPacket = new String[PacketInformation.PACKET_SIZE];
		for (int i = 0; i < PacketInformation.PACKET_SIZE; i++) {
		    dataPacket[i] = temp[i];
		}

		Main.log("conbinePacket() : " + dataPacket[0] + "` " + dataPacket[1] + "` " + dataPacket[2] + "` "
			+ dataPacket[3]);
		dicisionProgram();

	    }
	}
    }

    void divisionPacket(String message) {

    }

    private void dicisionProgram() {
	Main.log("dicisionProgram()");
	int programValue;
	int operator;

	programValue = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.PROGRAM_VALUE]);
	operator = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.OPERATOR]);

	switch (programValue) {
	case PacketInformation.ProgramValue.USER:
	    clientProgramValue = PacketInformation.ProgramValue.USER;
	    break;
	case PacketInformation.ProgramValue.PAYMENT:
	    clientProgramValue = PacketInformation.ProgramValue.PAYMENT;
	    break;
	case PacketInformation.ProgramValue.ADMIN:
	    clientProgramValue = PacketInformation.ProgramValue.ADMIN;
	    break;
	default:
	    return;
	}

	dicisionOperator(operator);

    }

    private void dicisionOperator(int operator) {
	Main.log("dicisionOperator()");
	int packetType = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.PACKET_TYPE]);

	switch (operator) {
	case PacketInformation.Operation.TIMER:
	    timerRequest(packetType);
	    break;
	case PacketInformation.Operation.GET:
	    getRequest(packetType);
	    break;
	case PacketInformation.Operation.LOGIN:
	    loginRequest(packetType);
	    break;
	case PacketInformation.Operation.JOIN:
	    joinRequest(packetType);
	    break;
	case PacketInformation.Operation.BUY:
	    buyRequest(packetType);
	    break;
	case PacketInformation.Operation.START:
	    startRequest(packetType);
	    break;
	case PacketInformation.Operation.END:
	    endRequest(packetType);
	    break;
	case PacketInformation.Operation.LOGOUT:
	    logoutRequest(packetType);
//	    services.logoutUser();
	    break;
	case PacketInformation.Operation.MESSAGE:
	    messageRequest(packetType);
	    break;
	case PacketInformation.IDLE:
	    idleRequest(packetType);
	    break;

	default:
	}
    }
    
    private void messageRequest(int packetType){
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	
	switch(packetType){
	case PacketInformation.PacketType.USER_MSG:
	    serverThread.pcMain.detailViews.get(index).messenger.listener.setChatArea(data, PacketInformation.PacketType.USER_MSG);
	    serverThread.pcMain.detailViews.get(index).messenger.setVisible(true);
	    break;
	}
	
    }
    
    private void timerRequest(int packetType){
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	
	switch(packetType){
	case PacketInformation.PacketType.TIME:
	    services.setTime(data);
	    break;
	case PacketInformation.PacketType.PROGRAM:
	    services.setProgram(data);
	    break;
	}
	
    }
    
    private void logoutRequest(int packetType){
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	
	switch(packetType){
	case PacketInformation.PacketType.USER_INFO:
	    services.logoutUser(data);
	    break;
	}
    }

    private void startRequest(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.FOOD:
	    services.isFoodOrderEnd = false;
	    services.orderInfoList = new ArrayList<>();
	    break;
	default:
	}

    }

    private void endRequest(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.FOOD:
	    services.isFoodOrderEnd = true;
	    services.buyFood();
	    break;
	default:
	}
    }

    private void idleRequest(int packetType) {

	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	switch (packetType) {
	case PacketInformation.IDLE:
	    sendPacket(PacketInformation.Operation.RESPONSE, PacketInformation.PacketType.COM_NUM, index);
	    break;
	}
    }

    private void buyRequest(int packetType) {
	Main.log("buyRequest");
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.POINT:
	    services.buyPoint(data);
	    break;
	case PacketInformation.PacketType.TIME:
	    services.buyTime(data);
	    break;
	case PacketInformation.PacketType.FOOD:
	    services.addOrderInfo(data);
	    break;
	default:
	}

    }

    private void joinRequest(int packetType) {
	Main.log("joinRequest()");
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.USER_INFO:
	    services.joinUser(data);
	    break;
	case PacketInformation.PacketType.CHECK_USER_ID:
	    services.checkId(data);
	    break;
	default:
	}
    }

    private void loginRequest(int packetType) {
	Main.log("loginRequest()");
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.ID_PW:
	    services.loginUser(data);
	    break;
	default:
	}
    }

    private void getRequest(int packetType) {
	Main.log("getRequest()");
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	Main.log(packetType);
	switch (packetType) {
	case PacketInformation.PacketType.COM_PREPAID_INFO:
	    services.getComPrepaidInfo();
	    break;
	case PacketInformation.PacketType.POINT_INFO:
	    services.getPointInfo();
	    break;
	default:
	}
    }

    private void paymentComPrepaidInfo(String data) {

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
	buff.append("\n");
	Main.log("send : " + buff.toString());
	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
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
	buff.append("\n");
	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void sendPacket(int operator, int packetType, int data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(clientProgramValue);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(operator);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(packetType);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(data);
	buff.append("!");
	buff.append("\n");

	Main.log("send : " + buff.toString());
	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void sendPacket(int operator, int packetType, byte data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(clientProgramValue);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(operator);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(packetType);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(data);
	buff.append("!");
	buff.append("\n");
	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void sendPacket(int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(clientProgramValue);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(operator);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(packetType);
	buff.append(PacketInformation.PACKET_PARTITION);
	buff.append(data);
	buff.append("!");
	buff.append("\n");

	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void sendPacket(String packet) {
	try {

	    Main.log(packet);
	    packet += "\n";
	    client.write(ByteBuffer.wrap(packet.getBytes()));

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    public void deleteThreadSocket() {
	serverThread.socketList.remove(myCount);
	// serverThread.clientList.remove(index);
    }

}