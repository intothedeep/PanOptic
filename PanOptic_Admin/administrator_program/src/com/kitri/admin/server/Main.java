package com.kitri.admin.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static boolean isLog = true;
    public static Server server;

    public static SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
    
//    public static void main(String[] args) {
//	server = new Server();
//	server.start();
//
////	Thread.sleep(500);
//
//	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////	reader.readLine();
//
//	server.stop();
//
//	Main.log("BYE");
////	addLog("disconnect client");
//    }

    public static void log(String str) {
	if (isLog) {
	    System.out.println(str);
	}
    }
    
    public static void log(Object o){
    }
    
    public static void log(int str) {
	if (isLog) {
	    System.out.println(str);
	}
    }
    

    public static String sumTime(String time1, String time2) {
	String result = null;

	try {
	    Date date1 = format.parse(time1);
	    Date date2 = format.parse(time2);
	    Calendar resultCal = Calendar.getInstance();
	    resultCal.setTimeInMillis(date1.getTime() + date2.getTime());

	    result = resultCal.get(Calendar.HOUR) + ":" + resultCal.get(Calendar.MINUTE) + ":"
		    + resultCal.get(Calendar.SECOND);

	} catch (ParseException e) {
	    e.printStackTrace();
	}

	return result;
    }

    public static String minusTime(String time1, String time2) {
	String result = null;

	try {
	    Date date1 = format.parse(time1);
	    Date date2 = format.parse(time2);
	    Calendar resultCal = Calendar.getInstance();
	    resultCal.setTimeInMillis(date1.getTime() - date2.getTime());
	    result = resultCal.get(Calendar.HOUR) + ":" + resultCal.get(Calendar.MINUTE) + ":"
		    + resultCal.get(Calendar.SECOND);
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	return result;
    }


}
