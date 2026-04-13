package com.jlboat.phone.service;
public class SpiritTopicListenerUtils {
    public static final int BATTERY_STATUS_MSG_FLAG = 14;
    public static final int CAMERA_STATUS_MSG_FLAG = 13;
    public static final int EME_MSG_FLAG = 2;
    public static final int IMU_STATUS_MSG_FLAG = 9;
    public static final int INIT_NAVI_MSG_FLAG = 1;
    public static final int LEFTMOTOR_STATUS_MSG_FLAG = 11;
    public static final int LIDAR_MSG_FLAG = 6;
    public static final int LOCATION_MSG_FLAG = 0;
    public static final int LOW_BATTERY = 10;
    public static int LOW_BATTERY_SHUTDOWN_FLAG = 0;
    public static final int MAPSTATUS_MSG_FLAG = 4;
    public static final int NAVINETWORK_STATUS_MSG_FLAG = 8;
    public static final int OUTCHARGE_MSG_FLAG = 5;
    public static final int RIGHTMOTOR_STATUS_MSG_FLAG = 12;
    public static final int SONAR_STATUS_MSG_FLAG = 10;
    public static final int STM32STATUS_MSG_FLAG = 7;
    public static final int VIRTUAL_MSG_FLAG = 3;
    private boolean OutCharge;
    private final String TAG;
    private boolean batteryStatus;
    private boolean cameraStatus;
    private boolean imuStatus;
    private boolean initStatus;
    private boolean isEmergencyStop;
    private boolean isLocation;
    private boolean leftMotorStatus;
    private boolean lidarStatus;
    private final com.jlboat.phone.communication.SpiritTopicListener mSpiritTopicListener;
    private boolean mapLoadStatus;
    private boolean naviNetWorkStatus;
    private boolean rightMotorStatus;
    private boolean sonarStatus;
    private boolean stm32Status;
    private boolean virtualStatus;

    static SpiritTopicListenerUtils()
    {
        com.jlboat.phone.service.SpiritTopicListenerUtils.LOW_BATTERY_SHUTDOWN_FLAG = 15;
        return;
    }

    public SpiritTopicListenerUtils(com.jlboat.phone.communication.SpiritTopicListener p2)
    {
        this.TAG = "SpiritTopicListenerUtils";
        this.imuStatus = 1;
        this.mSpiritTopicListener = p2;
        this.listener();
        return;
    }

    static synthetic boolean access$000(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.isLocation;
    }

    static synthetic boolean access$002(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.isLocation = p1;
        return p1;
    }

    static synthetic boolean access$100(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.initStatus;
    }

    static synthetic boolean access$1000(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.leftMotorStatus;
    }

    static synthetic boolean access$1002(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.leftMotorStatus = p1;
        return p1;
    }

    static synthetic boolean access$102(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.initStatus = p1;
        return p1;
    }

    static synthetic boolean access$1100(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.rightMotorStatus;
    }

    static synthetic boolean access$1102(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.rightMotorStatus = p1;
        return p1;
    }

    static synthetic boolean access$1200(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.cameraStatus;
    }

    static synthetic boolean access$1202(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.cameraStatus = p1;
        return p1;
    }

    static synthetic boolean access$1300(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.batteryStatus;
    }

    static synthetic boolean access$1302(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.batteryStatus = p1;
        return p1;
    }

    static synthetic boolean access$200(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.isEmergencyStop;
    }

    static synthetic boolean access$202(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.isEmergencyStop = p1;
        return p1;
    }

    static synthetic boolean access$300(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.virtualStatus;
    }

    static synthetic boolean access$302(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.virtualStatus = p1;
        return p1;
    }

    static synthetic boolean access$400(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.mapLoadStatus;
    }

    static synthetic boolean access$402(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.mapLoadStatus = p1;
        return p1;
    }

    static synthetic boolean access$500(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.OutCharge;
    }

    static synthetic boolean access$502(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.OutCharge = p1;
        return p1;
    }

    static synthetic boolean access$600(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.lidarStatus;
    }

    static synthetic boolean access$602(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.lidarStatus = p1;
        return p1;
    }

    static synthetic boolean access$700(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.stm32Status;
    }

    static synthetic boolean access$702(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.stm32Status = p1;
        return p1;
    }

    static synthetic boolean access$800(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.imuStatus;
    }

    static synthetic boolean access$802(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.imuStatus = p1;
        return p1;
    }

    static synthetic boolean access$900(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        return p1.sonarStatus;
    }

    static synthetic boolean access$902(com.jlboat.phone.service.SpiritTopicListenerUtils p0, boolean p1)
    {
        p0.sonarStatus = p1;
        return p1;
    }

    private void listener()
    {
        this.mSpiritTopicListener.getBattry(new com.jlboat.phone.service.SpiritTopicListenerUtils$1(this));
        this.mSpiritTopicListener.getChageMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$2(this));
        this.mSpiritTopicListener.getLocationMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$3(this));
        this.mSpiritTopicListener.getInitMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$4(this));
        this.mSpiritTopicListener.getEMEMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$5(this));
        this.mSpiritTopicListener.getVirtualMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$6(this));
        this.mSpiritTopicListener.getMapStatusMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$7(this));
        this.mSpiritTopicListener.getOutChargeMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$8(this));
        this.mSpiritTopicListener.getLidarMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$9(this));
        this.mSpiritTopicListener.getStm32Msg(new com.jlboat.phone.service.SpiritTopicListenerUtils$10(this));
        this.mSpiritTopicListener.getImuMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$11(this));
        this.mSpiritTopicListener.getSonarMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$12(this));
        this.mSpiritTopicListener.getLeftMotorMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$13(this));
        this.mSpiritTopicListener.getRightMotorMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$14(this));
        this.mSpiritTopicListener.getCameraMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$15(this));
        this.mSpiritTopicListener.getBatteryMsg(new com.jlboat.phone.service.SpiritTopicListenerUtils$16(this));
        return;
    }
}
