package com.kitri.user.statusinfo;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.*;

import javax.sound.midi.Synthesizer;

public class WindowsUtil {

    public static ArrayList<String> listRunningProcesses() {

	ArrayList<String> processes = new ArrayList<>();

	try {

	    String line;

	    // Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
	    // Process p = Runtime.getRuntime().exec("tasklist.exe /v / nh");
	    Process p = Runtime.getRuntime()
		    .exec("tasklist.exe /v /FI \"USERNAME ne NT AUTHORITY\\SYSTEM\" /FI \"STATUS eq running\" /nh");
	    // Process p = Runtime.getRuntime().exec("tasklist.exe /svc");
	    // Process p = Runtime.getRuntime().exec(System.getenv("windir") +
	    // "/system32/" + "tasklist.exe /v /FI \"USERNAME ne NT
	    // AUTHORITY\\SYSTEM\" /FI \"STATUS eq running\"");

	    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    int count = 0;
	    StringTokenizer token;
	    while ((line = input.readLine()) != null) {

		// if (!line.trim().equals("")) {
		if (!line.contains("N/A")) {

		    
		    if (line.contains(" - Chrome")) {
			int middle = line.indexOf(" - Chrome");
			int start = 0;
			for (int i = middle - 1; i >= 0; i--) {
			    if (line.charAt(i) == ' ') {
				start = i;
				break;
			    }
			}
			String result = line.substring(start, line.length());
			processes.add(result.trim());
			System.out.println(result);
		    } else if (line.contains(" - Internet Explorer")) {
			int middle = line.indexOf(" - Internet Explorer");
			int start = 0;
			for (int i = middle - 1; i >= 0; i--) {
			    if (line.charAt(i) == ' ') {
				start = i;
				break;
			    }
			}
			String result = line.substring(start, line.length());
			processes.add(result.trim());
		    } else if (line.contains(" - Java")) {
			int middle = line.indexOf(" - Java");
			int start = 0;
			for (int i = middle - 1; i >= 0; i--) {
			    if (line.charAt(i) == ' ') {
				start = i;
				break;
			    }
			}
			String result = line.substring(start, line.length());
			processes.add(result.trim());
		    }
		    
		    count++;

		}

	    }
//	    System.out.println(count);

	} catch (Exception e) {

	    e.printStackTrace();

	}

	return processes;

    }

    public static void main(String[] args) {
	ArrayList<String> array = (ArrayList<String>) listRunningProcesses();
	System.out.println(array.size());

	System.out.println(Arrays.toString(array.toArray()));

	// StringBuffer message = new StringBuffer();
	// InputStreamReader isr = null;
	// BufferedReader br = null;
	// try {
	// Process p = Runtime.getRuntime().exec(System.getenv("windir") +
	// "\\system32\\" + "tasklist.exe");
	// isr = new InputStreamReader(p.getInputStream());
	// br = new BufferedReader(isr);
	//
	// String line = null;
	// while ((line = br.readLine()) != null) {
	// System.out.println("msg=>" + line);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if (isr != null)
	// try {
	// isr.close();
	// } catch (Exception e) {
	// }
	// if (br != null)
	// try {
	// br.close();
	// } catch (Exception e) {
	// }
	// }

	// ActivityManager am = (ActivityManager)
	// getSystemService(ACTIVITY_SERVICE);
	// List<RunningAppProcessInfo> list = am.getRunningAppProcesses();
	// List<RunningServiceInfo> listservice =
	// am.getRunningServices(Integer.MAX_VALUE);
	//
	// for (int i = 0; i < listservice.size(); i++) {
	// // 실행중인 서비스 이름(패키지명)
	// system.out.println(listservice.get(i).process);
	// }
	//
	// for (int i = 0; i < list.size(); i++) {
	// // 실행중인 프로세스 이름(패키지명)
	// system.out.println(list.get(i).processName);
	// }

    }
}
