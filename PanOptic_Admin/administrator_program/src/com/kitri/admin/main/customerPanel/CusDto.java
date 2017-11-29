package com.kitri.admin.main.customerPanel;

public class CusDto {
	private int userNum;
	private String userName;
	private String userId;
	private String userPw;
	private String userHp;
	private String userEmail;
	private String userAccuTime;
	private String userLeftTime;
	private String userJoinDate;
	private String userBirth;
	private String isMail;
	
	public CusDto() {
	}
	
	public CusDto(int userNum, String userName, String userId, String userPw, String userHp, String userEmail,
			String userAccuTime, String userLeftTime, String userJoinDate, String userBirth, String isMail) {
		super();
		this.userNum = userNum;
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
		this.userHp = userHp;
		this.userEmail = userEmail;
		this.userAccuTime = userAccuTime;
		this.userLeftTime = userLeftTime;
		this.userJoinDate = userJoinDate;
		this.userBirth = userBirth;
		this.isMail = isMail;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserHp() {
		return userHp;
	}
	public void setUserHp(String userHp) {
		this.userHp = userHp;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAccuTime() {
		return userAccuTime;
	}
	public void setUserAccuTime(String userAccuTime) {
		this.userAccuTime = userAccuTime;
	}
	public String getUserLeftTime() {
		return userLeftTime;
	}
	public void setUserLeftTime(String userLeftTime) {
		this.userLeftTime = userLeftTime;
	}
	public String getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getIsMail() {
		return isMail;
	}
	public void setIsMail(String isMail) {
		this.isMail = isMail;
	}
	
}
