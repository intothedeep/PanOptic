package com.kitri.admin.messenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.admin.server.Main;
import com.kitri.admin.server.PacketInformation;
import com.kitri.admin.server.Server;


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
	    Server.serverThread.socketList.get(msg.detailView.index).sendPacket(PacketInformation.Operation.MESSAGE, PacketInformation.PacketType.ADMIN_MSG, temp);
	    setChatArea(temp, PacketInformation.PacketType.ADMIN_MSG);

	}
    }

    public void setChatArea(String str, int who) {
	if (who == PacketInformation.PacketType.USER_MSG) {
	    msg.messageBuffer.append("[PC " + msg.detailView.index + "] : " + str + "\n");
	} else {
	    msg.messageBuffer.append("[д╚©Нем] : " + str + "\n");
	}
	
	msg.msgtextArea.setText(msg.messageBuffer.toString());
    }

}
