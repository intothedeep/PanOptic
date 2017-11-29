package com.kitri.admin.main.controlPanel;

public class BlockedsiteDto {
    private int blockedsiteNum;
    private String blockedsiteUrl;
    private String blockedsiteName;

	public BlockedsiteDto() {
		super();
	}
	public BlockedsiteDto(int blockedsiteNum, String blockedsiteUrl, String blockedsiteName) {
		super();
		this.blockedsiteNum = blockedsiteNum;
		this.blockedsiteUrl = blockedsiteUrl;
		this.blockedsiteName = blockedsiteName;
	}
	public int getBlockedsiteNum() {
		return blockedsiteNum;
	}
	public void setBlockedsiteNum(int blockedsiteNum) {
		this.blockedsiteNum = blockedsiteNum;
	}
	public String getBlockedsiteUrl() {
		return blockedsiteUrl;
	}
	public void setBlockedsiteUrl(String blockedsiteUrl) {
		this.blockedsiteUrl = blockedsiteUrl;
	}
	public String getBlockedsiteName() {
		return blockedsiteName;
	}
	public void setBlockedsiteName(String blockedsiteName) {
		this.blockedsiteName = blockedsiteName;
	}
    
}
