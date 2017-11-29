package com.kitri.user.join;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.main.Main;
import com.kitri.user.network.PacketInformation;

public class UserJoinListener implements ActionListener {
    UserJoin join;

    public UserJoinListener(UserJoin join) {
	this.join = join;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o == join.overCheckBtn) {
	    checkId(join.joinId.getText().toString().trim());
	} else 	if (o == join.joinConfirmBtn) {
	    joinUser();
	} else 	if (o == join.joinCloseBtn) {
	    join.setVisible(false);
	    join.joinName.setText("");
	    join.joinId.setText("");
	    join.joinPw.setText("");
	    join.joinPwCheck.setText("");
	    join.joinEmailTf.setText("");
	    join.joinHpTf.setText("");
	    join.joinEmailTf.setText("");
	    join.yy.setSelectedIndex(0);
	    join.mm.setSelectedIndex(0);
	    join.dd.setSelectedIndex(0);
	    join.maleRadio.setSelected(true);
	    join.femaleRadio.setSelected(false);
	    join.isMale = true;
	} else if (o == join.maleRadio){
	    join.isMale = true;
	} else if( o == join.femaleRadio){
	    join.isMale = false;
	}
    }

    private void checkId(String id) {
	if (!id.isEmpty() && !id.equals("")) {
	    Main.network.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.CHECK_USER_ID, id);
	}
    }

    private void joinUser() {

	if (join.checkId) {
	    UserInfoDto dto = new UserInfoDto();
	    String name = join.joinName.getText().trim();
	    String id = join.joinId.getText().trim();
	    String pw = join.joinPw.getText().trim();
	    String pwCheck = join.joinPwCheck.getText().trim();
	    String email = join.joinEmailTf.getText().trim();
	    String hp = join.joinHpTf.getText().trim();
	    String birth = join.yy.getSelectedItem() + "-" + join.mm.getSelectedItem() + "-"
		    + join.dd.getSelectedItem();
	    String isMale = join.isMale ? "1" : "0";

	    if (checkField(pw, pwCheck, email, hp)) {
		dto.setUserName(name);
		dto.setUserId(id);
		dto.setUserPw(pw);
		dto.setUserHp(hp);
		dto.setUserEmail(email);
		dto.setUserBirth(birth);
		dto.setIsMale(isMale);
		Main.log(dto.toString());
		Main.network.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.USER_INFO,
			dto.toString());
	    }

	} else {
	    join.checkIdCheckDialog();
	}

    }

    private boolean checkField(String pw, String pwCheck, String email, String hp) {
	int len = pw.length();
	if (len < 8) {
	    join.pwTooShort();
	    return false;
	}
	if (!pw.equals(pwCheck)) {
	    join.pwCheckError();
	    return false;
	}
	if (!email.contains("@") || !email.contains(".") || email.startsWith("@") || email.startsWith(".")) {
	    join.emailInputError();
	    return false;
	}
	len = hp.length();
	boolean isHp = true;
	for (int i = 0; i < len; i++) {
	    if (hp.charAt(i) < '0' || hp.charAt(i) > '9') {
		isHp = false;
		break;
	    }
	}
	if (len != 11 || !hp.startsWith("010") || !isHp) {
	    join.hpInputError();
	    return false;
	}

	return true;
    }
}
