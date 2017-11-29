package com.kitri.admin.database.dto;

public class UserPointInfoDto {
    private int userNum;
    private int point;
    
    public int getUserNum() {
        return userNum;
    }
    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    
    @Override
    public String toString() {
        return userNum + "," + point;
    }
}
