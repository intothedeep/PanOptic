package com.kitri.admin.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JFrame;

/**
 *
 */
public class Server // extends JFrame
{

    public static final int PORT_NUMBER = 9831;

    private Abortable abortable;
    public static ServerThread serverThread;
    // private static JTextArea mLogView;

    /**
     * 
     */
    public Server() {
	// super("");
	// mLogView = new JTextArea ();
	// getContentPane().add (new JScrollPane(mLogView), "Center");

	// setDefaultCloseOperation(EXIT_ON_CLOSE);
	// setSize(400, 300);
	// setLocation(400, 200);
	// setVisible(true);

	abortable = new Abortable();
    }

    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

	Server server = new Server();
	server.start();

	Thread.sleep(500);

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	reader.readLine();

	server.stop();

	Main.log("BYE");
	addLog("disconnect client");
    }

    /**
     * start server
     */
    public void start() {

	abortable.init();

	if (serverThread == null || !serverThread.isAlive()) {
	    serverThread = new ServerThread(abortable);
	    serverThread.start();
	}
    }

    /**
     * s stop servers
     */
    public void stop() {

	abortable.done = true;

	if (serverThread != null && serverThread.isAlive()) {
	    serverThread.interrupt();
	}

    }

    public static void addLog(String msg) {
	// Main.log("addLog");
	// mLogView.append(msg + "\n");
    }

    /**
     *
     */

    /**
     *
     */

}
