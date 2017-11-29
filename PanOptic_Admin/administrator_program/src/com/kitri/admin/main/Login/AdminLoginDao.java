package com.kitri.admin.main.Login;

public interface AdminLoginDao {
	boolean matchId (String id);
	boolean matchIdPw (String id, String pw);
}
