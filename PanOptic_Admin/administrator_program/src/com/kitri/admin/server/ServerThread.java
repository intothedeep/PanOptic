package com.kitri.admin.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.Map.Entry;

import com.kitri.admin.main.PcMain;
import com.kitri.admin.main.Login.AdminLogin;

public class ServerThread extends Thread {

    private Abortable abortable;
    public Hashtable<Integer, ClientHandlerThread> socketList = new Hashtable<Integer, ClientHandlerThread>();
    public static int handlerCount;
    public static boolean isChangeClientList;
    public PcMain pcMain;
    public AdminLogin adminLogin;

    public ServerThread(Abortable abortable) {
	this.abortable = abortable;
	handlerCount = 1;
	pcMain = new PcMain(this);
	adminLogin = new AdminLogin(pcMain);
	adminLogin.setVisible(true);
//	pcMain.setVisible(true);

    }

    @Override
    public void run() {
	super.run();

	ServerSocketChannel server = null;
	Selector selector = null;

	try {
	    Main.log("Server :: started");
	    Server.addLog("Server :: started");

	    server = ServerSocketChannel.open();
	    server.socket().bind(new InetSocketAddress(Server.PORT_NUMBER));
	    server.configureBlocking(false);

	    selector = Selector.open();
	    server.register(selector, SelectionKey.OP_ACCEPT);

	    Main.log("Server :: waiting for accept");

	    while (!Thread.interrupted() && !abortable.isDone()) {
		selector.select(3000);
		Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
		while (iter.hasNext()) {
		    SelectionKey key = iter.next();
		    if (key.isAcceptable()) {
			SocketChannel client = server.accept();

			if (client != null) {
			    System.out.printf("Server :: accepted - client [%s]\n", client);
			    Server.addLog("Server :: accepted - client [" + client + "]");
			    // Server.addLog("clientList size : " +
			    // clientList.size());
			    Server.addLog("socketList size : " + socketList.size());
			    // Main.log("clientList size : " +
			    // clientList.size());
			    Main.log("socketList size : " + socketList.size());
			    Thread t = new ClientHandlerThread(abortable, client, selector, this, handlerCount);
			    // socketList.add((ClientHandlerThread)t);
			    socketList.put(handlerCount, (ClientHandlerThread) t);
			    socketList.get(handlerCount).index = handlerCount;

			    // indexHash.put(arg0, arg1)
			    t.start();
			    // clientList.add(t);
			    // clientList.put(handlerCount,t);
			    handlerCount++;
			}
		    }
		}
	    }

	} catch (Exception e) {
	    Main.log("ServerThread : " + e.toString());
	    e.printStackTrace();

	} finally {
	    // Iterator<Integer> iter = clientList.keySet().iterator();
	    // while(iter.hasNext())
	    // {
	    // Integer key = iter.next();
	    //
	    // if(clientList.get(key) != null && clientList.get(key).isAlive())
	    // {
	    // clientList.get(key).interrupt();
	    // }
	    //
	    // try
	    // {
	    // clientList.get(key).join();
	    // }
	    // catch(InterruptedException e)
	    // {
	    // e.printStackTrace();
	    // }
	    // }
	    //
	    // if (server != null)
	    // {
	    //
	    // try
	    // {
	    // server.close();
	    // }
	    // catch (IOException e)
	    // {
	    // e.printStackTrace();
	    // }
	    // }

	    Main.log("Server :: done");
	    Server.addLog("Server :: done");

	}
    }

    void sortClientList() {
//	int size = currentClient.size();
//
//	for (int i = 0; i < size; i++) {
//	    currentClient.get(i).myCount = i;
//	}
    }

    public void broadCast(int situation, int dataType, String data) {
//	int len = socketList.size();
//	Server.addLog("broadCast();");
//	for (int i = 0; i < len; i++) {
//	    // String temp = situation + "/" + dataType + "/" + data;
//	    socketList.get(i).sendData(situation, dataType, data);
//	}
	 
	Enumeration<Integer> enums = socketList.keys();
	while(enums.hasMoreElements()){
	    socketList.get(enums.nextElement()).sendPacket(situation, dataType, data);
	}

    }
    
    public void broadCast(int programValue, int situation, int dataType, String data) {
//	int len = socketList.size();
//	Server.addLog("broadCast();");
//	for (int i = 0; i < len; i++) {
//	    // String temp = situation + "/" + dataType + "/" + data;
//	    socketList.get(i).sendData(situation, dataType, data);
//	}
	 
	Enumeration<Integer> enums = socketList.keys();
	while(enums.hasMoreElements()){
	    socketList.get(enums.nextElement()).sendPacket(programValue, situation, dataType, data);
	}

    }

}
