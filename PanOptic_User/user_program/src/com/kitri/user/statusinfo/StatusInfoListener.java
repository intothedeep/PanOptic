package com.kitri.user.statusinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.login.UserLogin;
import com.kitri.user.main.Main;
import com.kitri.user.network.PacketInformation;

public class StatusInfoListener implements ActionListener {
    StatusInfo status;
    UserInfoDto dto;
    public StatusInfoListener(StatusInfo status) {
	this.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	Object o = e.getSource();

	if (o == status.statusOrderBtn) {
	    status.order.setVisible(true);
	} else if (o == status.statusMypageBtn) {
	    status.mp.setVisible(true);
	} else if (o == status.statusMessengerBtn) {
	    status.msg.setVisible(true);
	} else if (o == status.comMoveBtn) {
	    String name = JOptionPane.showInputDialog("이동할자리를 입력하세요.");
	    if (name != null)
		status.tf.setText(name);
	} else if (o == status.logoutBtn) {
	    logout();
	}
    }

    public void logout() {
	status.setVisible(false);
	status.login.programView.setVisible(false);
	status.login.setVisible(true);
	status.useTimer.timer.cancel();
	status.runningProcess.timer.cancel();
	status.msg.messageBuffer = new StringBuilder("");
	status.msg.msgtextArea.setText("");
	status.login.idTf.setText("");
	status.login.pwTf.setText("");
	
	UserInfoDto uDto = new UserInfoDto();
	uDto = status.login.userInfo;
	String accuTime = "";
	uDto.setUserLeftTime(status.getLeftTime());
	
	if(uDto.getUserAccuTime() == null || uDto.getUserAccuTime().equals("null")){
	accuTime = status.getUseTime();
	} else {
	accuTime = Main.sumTime(uDto.getUserAccuTime(), status.getUseTime());
	}
	uDto.setUserAccuTime(accuTime);

	Main.network.sendPacket(PacketInformation.Operation.LOGOUT, PacketInformation.PacketType.USER_INFO, uDto.toString());
//	    Main.network.sendPacket(PacketInformation.Operation.LOGOUT, PacketInformation.IDLE, PacketInformation.IDLE);

	Main.network.sendPacket(PacketInformation.Operation.LOGOUT, PacketInformation.IDLE, PacketInformation.IDLE);
	Main.network.view.pwTf.setText("");
	Main.network.view.idTf.setText("");
    }

    public void setStatusInfoField() {
	status.statusId.setText(Main.network.view.userInfo.getUserId());
	status.restTime.setText(Main.network.view.userInfo.getUserLeftTime());
	// status.usetime.setText();
	status.statusComNum.setText(Main.network.view.mainComNum.getText());
	status.point.setText(Main.network.view.userPoint+"");//포인트

    }

}
