package com.kitri.admin.join;

import javax.swing.plaf.FontUIResource;

import com.kitri.admin.database.dao.EmployeeDao;
import com.kitri.admin.database.dto.EmployeeDto;

public class EmployeeJoinController{
	EmployeeJoin join;
	EmployeeDao dao;
	
	

	public EmployeeJoinController(EmployeeJoin join) {
		super();
		this.join = join;
		dao = new EmployeeDao(join);
	}

	public void checkId(String id) {
		if (!id.isEmpty() && !id.equals("")) {
			
		}
	}

	public void joinEmployee(EmployeeJoin join) {

		if (join.checkId) {
			EmployeeDto empdto = new EmployeeDto();
			String empName = join.nameTf.getText().trim();
			String hp = join.empjoinTf.getText().trim();
			String hire = join.hireYear.getSelectedItem() + "-" + join.hireMonth.getSelectedItem() + "-"
					+ join.hireDay.getSelectedItem();
			String id = join.IdTf.getText().trim();
			String pw = join.pwTf.getText().trim();
			String pwCheck = join.pwCheckTf.getText().trim();
			String email = join.eMailTf.getText().trim();
			String birth = join.yy.getSelectedItem() + "-" + join.mm.getSelectedItem() + "-"
					+ join.dd.getSelectedItem();
			String position = join.jobCb.getActionCommand();
			String pay = join.payTf.getText().trim();
			String isMale = join.isMale ? "1" : "0";

			if (checkField(pw, pwCheck, email, hp, pay)) {
				empdto.setEmployeeName(empName);
				empdto.setEmployeeHp(hp);
				empdto.setEmployeeHireDate(hire);
				empdto.setEmployeeId(id);
				empdto.setEmployeePw(pw);
				empdto.setEmployeeEmail(email);
				empdto.setEmployeeBirth(birth);
				empdto.setEmployeePosition(position);
				empdto.setHourPayRate(Integer.parseInt(pay));
				empdto.setEmployeeIsMale(isMale);
			} else {
				join.checkidCheckDialog();
			}

		}
	}

	private boolean checkField(String pw, String pwCheck, String email, String hp, String pay) {

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
		int len2 = pay.length();
		for (int i = 0; i < len2; i++) {		
			if (pay.charAt(i) < '0' || pay.charAt(i) > '9') {				
				return false;
			}
		}
		if (len2 >= 6470 && pay.isEmpty() && pay.equals(pay)) {
			join.payInputError();
		}
		// String pay ���� int len = pay.length() for(int i = 0; i < len; i++){
		// pay.charAt(i) // ��� �������� �Ǻ�} ���ڰ� �ƴϸ� -> �ñ��� ���ڷ� �Է����ּ��� ////
		// Integer.parseInt(pay) > �����ñ� ������ �����ñ��� 0000�Դϴ�. -> ���̷α�

		return true;
	}

}
