package com.kitri.admin.main.Login;

import javax.swing.JOptionPane;

public class AdminLoginServiceImpl implements AdminLoginService {
	AdminLogin login;
	AdminLoginDao dao;
	
	public AdminLoginServiceImpl() {

	}

	public AdminLoginServiceImpl(AdminLogin login) {
		this.login = login;
		dao = new AdminLoginDaoImpl(login);
	}

	
	@Override
	public void loginProcess() {
//		아이디, 패스워드 입력했는지 확인
		if (checkIfIdEmpty())
			return;
		if (checkIfPwEmpty())
			return;
//		아이디가 존재 하는지 확인
		if (checkIfIdExisting ())
			return;
//		패스워드가 일치하는지 확인
		if (checkIfPwExisting())
			return;
		
		clearTf();
		viewMain();
		closeLogin();
	}
	
	private boolean checkIfIdEmpty () {
//		false => id 입력 됨
		String id = login.idTf.getText().trim();
		String pw = login.pwTf.getText().trim();
		boolean flag = true;
	
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(login, "id를 입력해 주세요");
			return flag;
		} 
		flag = false;
		return flag;
	}
	
	private boolean checkIfPwEmpty () {
//		false => pw 입력 됨
		String id = login.idTf.getText().trim();
		String pw = login.pwTf.getText().trim();
		boolean flag = true;		

		if (pw.isEmpty()) {
			JOptionPane.showMessageDialog(login, "password를 입력해 주세요");
			return flag;
		}
		flag = false;
		return flag;
	}
	
	private boolean checkIfIdExisting () {
//		false => id 존재 함
		String id = login.idTf.getText().trim();
		String pw = login.pwTf.getText().trim();
		boolean flag = true;		

		if (dao.matchId(id)) {
			JOptionPane.showMessageDialog(login, "id가 존재하지 않습니다.");
			clearTf();
			return flag;
		} 
		flag = false;
		return flag;
	}
	
	private boolean checkIfPwExisting () {
//		false => id가 존재하고 pw가 일치할 때 
		String id = login.idTf.getText().trim();
		String pw = login.pwTf.getText().trim();
		boolean flag = true;		

		if (dao.matchIdPw(id, pw)) {
			JOptionPane.showMessageDialog(login, "비밀번호가 틀렸습니다.");
			clearPwTf();
			return flag;
		}
		flag = false;
		return flag;
	}
	
	private void viewMain() {
		clearTf();
		login.pcMain.setVisible(true);
	}

	private void closeLogin() {
		clearTf();
		login.setVisible(false);
	}

	private void clearTf() {
		login.pwTf.setText("");
		login.pwTf.requestFocus();
		login.idTf.setText("");
		login.idTf.requestFocus();
	}
	private void clearIdTf () {
		login.idTf.setText("");
		login.idTf.requestFocus();
	}
	private void clearPwTf () {
		login.pwTf.setText("");
		login.pwTf.requestFocus();
	}
}
