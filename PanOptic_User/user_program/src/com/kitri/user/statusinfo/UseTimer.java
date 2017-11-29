package com.kitri.user.statusinfo;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.kitri.user.main.Main;
import com.kitri.user.network.PacketInformation;

public class UseTimer {

    final long TIME_GAP = TimeUnit.MINUTES.toMillis(1);
    final long INITIAL_TIME = -32400000;
    public boolean isEnd;
    public StatusInfo status;
    public Timer timer;
    Calendar cal;

    public UseTimer(StatusInfo status) {
	Main.log("start timer !!");
	cal = Calendar.getInstance();
	isEnd = false;
	this.status = status;
	timer = new Timer(true);
	status.useTimeLong = INITIAL_TIME;

	timer.scheduleAtFixedRate(new TimerTask() {

	    @Override
	    public void run() {
		status.useTimeLong += TIME_GAP;
		status.leftTimeLong -= TIME_GAP;
		status.useTimeCal.setTimeInMillis(status.useTimeLong);
		status.leftTimeCal.setTimeInMillis(status.leftTimeLong);
//		System.out.println(status.leftTimeLong);
		if (status.leftTimeLong <= INITIAL_TIME) {
		    status.listener.logout();
		    status.leftTimeLong = INITIAL_TIME;
		    status.leftTimeCal.setTimeInMillis(status.leftTimeLong);
		}
		status.restTime.setText(status.getLeftTime());
		status.usetime.setText(status.getUseTime());
		status.login.userInfo.setUserLeftTime(status.getLeftTime());
//		status.login.userInfo.setUserAccuTime(Main.sumTime(status.getUseTime(), status.login.userInfo.getUserAccuTime()));
		status.mp.mypgRestTime.setText(status.login.userInfo.getUserLeftTime());
//		status.mp.mypgAccuTime.setText(status.login.userInfo.getUserAccuTime());
		
		Main.network.sendPacket(PacketInformation.Operation.TIMER, PacketInformation.PacketType.TIME, status.getLeftTime() + "," + status.getUseTime());
		
		// Main.log(status.leftTimeCal.get(Calendar.HOUR) + ":" +
		// status.leftTimeCal.get(Calendar.MINUTE) + ":" +
		// status.leftTimeCal.get(Calendar.SECOND));
		// Main.log(status.useTimeCal.get(Calendar.HOUR) + ":" +
		// status.useTimeCal.get(Calendar.MINUTE) + ":" +
		// status.useTimeCal.get(Calendar.SECOND));

	    }
	}, TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(1));

    }

}
