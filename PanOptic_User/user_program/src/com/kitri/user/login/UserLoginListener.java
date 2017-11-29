package com.kitri.user.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.user.main.Main;
import com.kitri.user.network.PacketInformation;

public class UserLoginListener implements ActionListener {

    UserLogin view;
    // UserLoginLogic logic;

    public UserLoginListener(UserLogin view) {
	this.view = view;
	// logic = new UserLoginLogic(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o == view.joinBtn) {
	    // logic.viewJoin();
	    view.join.setVisible(true);
	} else if (o == view.loginBtn || o == view.pwTf || o == view.idTf) {
	    login();
	}
    }

    public void login() {
	String id = view.idTf.getText().trim();
	String pw = view.pwTf.getText().trim();

	if (id.isEmpty() || pw.isEmpty()) {
	    view.fieldEmpty();
	} else {
	    Main.network.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.ID_PW,
		    id + "," + pw);

	}

    }
}
