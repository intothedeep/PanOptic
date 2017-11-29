package com.kitri.user.messenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.user.main.Main;
import com.kitri.user.network.PacketInformation;

public class MessengerListener implements ActionListener {
    Messenger msg;

    public MessengerListener(Messenger msg) {
	this.msg = msg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o == msg.msgBtn || o == msg.msgTf) {
	    String temp = msg.msgTf.getText();
	    msg.msgTf.setText("");
	    Main.network.sendPacket(PacketInformation.Operation.MESSAGE, PacketInformation.PacketType.USER_MSG, temp);
	    setChatArea(temp, PacketInformation.PacketType.USER_MSG);

	}
    }

    public void setChatArea(String str, int who) {
	if (who == PacketInformation.PacketType.USER_MSG) {
	    msg.messageBuffer.append("[나] : " + str + "\n");
	} else {
	    msg.messageBuffer.append("[카운터] : " + str + "\n");
	}
	
	msg.msgtextArea.setText(msg.messageBuffer.toString());
    }

}
