package com.kitri.user.statusinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.main.Main;

public class MyPageListener implements ActionListener {
    MyPage mp;

    public MyPageListener(MyPage mp) {
	this.mp = mp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o == mp.mypgChangeBtn) {
	    // if(!mp.mypgPwCheck.getText().equals(mp.mypgPwTf.getText())){
	    // JOptionPane.showMessageDialog(mp, "비밀번호가 다릅니다.", "비밀번호 확인",
	    // JOptionPane.WARNING_MESSAGE);
	    // }
	    // else{
	    // Main.network.view.userInfo.setUserPw(mp.mypgPwTf.getText());
	    // }
	    chageMyPage();
	}
	if (o == mp.mypgCancelBtn) {
	    mp.setVisible(false);
	}

    }

    private void chageMyPage() {

	String pw = mp.mypgPwTf.getText().trim();
	String pwCheck = mp.mypgPwCheck.getText().trim();
	String email = mp.mypgMailTf.getText().trim();
	String hp = mp.mypgHpTf.getText().trim();

	if (changeCheckMyPage(pw, pwCheck, email, hp)) {
	    Main.network.view.userInfo.setUserPw(pw);
	    Main.network.view.userInfo.setUserEmail(email);
	    Main.network.view.userInfo.setUserHp(hp);
	    mp.setVisible(false);
	}
    }

    public void setMyPageField() {

	mp.mypgName.setText(Main.network.view.userInfo.getUserName());
	mp.mypgId.setText(Main.network.view.userInfo.getUserId());
	mp.mypgPwTf.setText(Main.network.view.userInfo.getUserPw());
	mp.mypgPwCheck.setText(Main.network.view.userInfo.getUserPw());
	mp.mypgHpTf.setText(Main.network.view.userInfo.getUserHp());
	mp.mypgMailTf.setText(Main.network.view.userInfo.getUserEmail());
	mp.mypgAccuTime.setText(Main.network.view.userInfo.getUserAccuTime());
	mp.mypgRestTime.setText(Main.network.view.userInfo.getUserLeftTime());

    }

    public void getMyPageField(MyPage mp) {

	Main.network.view.userInfo.setUserEmail(mp.mypgMailTf.getText());
	Main.network.view.userInfo.setUserHp(mp.mypgHpTf.getText());
	Main.network.view.userInfo.setUserPw(mp.mypgPwTf.getText());
    }

    private boolean changeCheckMyPage(String pw, String pwCheck, String email, String hp) {
	int len = pw.length();
	if (len < 8) {
	    mp.pwTooShort();
	    return false;
	}
	if (!pw.equals(pwCheck)) {
	    mp.pwCheckError();
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
	    mp.hpInputError();
	    return false;
	}
	if (!email.contains("@") || !email.contains(".") || email.startsWith("@") || email.startsWith(".")) {
	    mp.emailInputError();
	    return false;
	}
	return true;
    }
}
