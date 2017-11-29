package com.kitri.user.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.kitri.user.login.UserLogin;
import com.kitri.user.network.Network;

public class Main {
    // public static UserLogin mView;
    public static boolean isLog = true;
    public static Network network;

    public static SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
    
    public static void main(String[] args) {
	// mView = new UserLogin();
	// mView.setVisible(true);
	network = new Network();
	Thread thread = new Thread(network);
    }

    public static void log(String str) {
	if (isLog) {
	    System.out.println(str);
	}
    }

    public static void log(long str) {
	if (isLog) {
	    System.out.println(str);
	}
    }

    public static void log(int num) {
	if (isLog) {
	    System.out.println(num);
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
