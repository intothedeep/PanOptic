package com.kitri.user.statusinfo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.kitri.user.main.Main;
import com.kitri.user.network.PacketInformation;

public class CheckRunningProcess {
    final long TIME_GAP = TimeUnit.SECONDS.toMillis(5);

    public StatusInfo status;
    public Timer timer;
    public ArrayList<String> proceess;
    public StringBuilder result;

    public CheckRunningProcess(StatusInfo info) {
	this.status = info;

	timer = new Timer(true);
	timer.scheduleAtFixedRate(new TimerTask() {

	    @Override
	    public void run() {
		proceess = WindowsUtil.listRunningProcesses();
		result = new StringBuilder("");

		int size = proceess.size();
		for (int i = 0; i < size; i++) {
		    result.append(proceess.get(i));

		    if (i != size - 1) {
			result.append(",");
		    }
		}
		
		if(size != 0){
		    Main.network.sendPacket(PacketInformation.Operation.TIMER, PacketInformation.PacketType.PROGRAM, result.toString());
		}
	    }
	}, TimeUnit.SECONDS.toMillis(1), TIME_GAP);
    }

}
