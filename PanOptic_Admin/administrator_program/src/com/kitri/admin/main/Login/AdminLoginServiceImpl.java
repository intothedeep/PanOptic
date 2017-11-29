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
//		���̵�, �н����� �Է��ߴ��� Ȯ��
		if (checkIfIdEmpty())
			return;
		if (checkIfPwEmpty())
			return;
//		���̵� ���� �ϴ��� Ȯ��
		if (checkIfIdExisting ())
			return;
//		�н����尡 ��ġ�ϴ��� Ȯ��
		if (checkIfPwExisting())
			return;
		
		clearTf();
		viewMain();
		closeLogin();
	}
	
	private boolean checkIfIdEmpty () {
//		false => id �Է� ��
		String id = login.idTf.getText().trim();
		String pw = login.pwTf.getText().trim();
		boolean flag = true;
	
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(login, "id�� �Է��� �ּ���");
			return flag;
		} 
		flag = false;
		return flag;
	}
	
	private boolean checkIfPwEmpty () {
//		false => pw �Է� ��
		String id = login.idTf.getText().trim();
		String pw = login.pwTf.getText().trim();
		boolean flag = true;		

		if (pw.isEmpty()) {
			JOptionPane.showMessageDialog(login, "password�� �Է��� �ּ���");
			return flag;
		}
		flag = false;
		return flag;
	}
	
	private boolean checkIfIdExisting () {
//		false => id ���� ��
		String id = login.idTf.getText().trim();
		String pw = login.pwTf.getText().trim();
		boolean flag = true;		

		if (dao.matchId(id)) {
			JOptionPane.showMessageDialog(login, "id�� �������� �ʽ��ϴ�.");
			clearTf();
			return flag;
		} 
		flag = false;
		return flag;
	}
	
	private boolean checkIfPwExisting () {
//		false => id�� �����ϰ� pw�� ��ġ�� �� 
		String id = login.idTf.getText().trim();
		String pw = login.pwTf.getText().trim();
		boolean flag = true;		

		if (dao.matchIdPw(id, pw)) {
			JOptionPane.showMessageDialog(login, "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
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
