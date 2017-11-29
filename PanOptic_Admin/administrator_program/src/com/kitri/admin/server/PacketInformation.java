package com.kitri.admin.server;


/*
 * programvalue/operator/packettype/value
 */
public class PacketInformation {
    
    public final static byte PACKET_SIZE = 4;
    public final static byte IDLE = -99;
    public final static String PACKET_DIVISION = "!";
    public final static String PACKET_PARTITION = "//";
//    public final static String 

    public static class ProgramValue {
	public static final byte ADMIN = 0;
	public static final byte USER = 1;
	public static final byte PAYMENT = 2;
    }

    public static class PacketStructrue {
	public static final byte PROGRAM_VALUE = 0;
	public static final byte OPERATOR = 1;
	public static final byte PACKET_TYPE = 2;
	public static final byte DATA = 3;
    }
    
    public static class Operation{
	public static final byte GET = 0;
	public static final byte RESPONSE = 1;
	public static final byte COUNT = 2;
	public static final byte LOGIN = 3;
	public static final byte JOIN = 4;
	public static final byte BUY = 5;
	public static final byte START = 6;
	public static final byte END = 7;
	public static final byte LOGOUT = 8;
	public static final byte TIMER = 9;
	public static final byte MESSAGE = 10;
	public static final byte RESTRICTION = 11;
	
    }

    public static class PacketType {
	public static final byte POINT_INFO = 0;
	public static final byte COM_PREPAID_INFO = 1;
	public static final byte USER_INFO = 2;
	public static final byte CHECK_USER_ID = 3;
	public static final byte IS_OK = 4;
	public static final byte IS_FAIL = 5;
	public static final byte ID_PW = 6;
	public static final byte POINT = 7;
	public static final byte TIME = 8;
	public static final byte CARD = 9;
	public static final byte FOOD = 10;
	public static final byte FOOD_TYPE = 11;
	public static final byte IS_END = 12;
	public static final byte IS_START = 13;
	public static final byte COM_NUM = 14;
	public static final byte PROGRAM = 15;
	public static final byte USER_MSG = 16;
	public static final byte ADMIN_MSG = 17;
	public static final byte YEAR_OF_AGE = 18;
    }
    
    public static class ComPrepaidInfo{
	public static final byte NUM = 0;
	public static final byte TIME = 1;
	public static final byte PRICE = 2;
    }

}
