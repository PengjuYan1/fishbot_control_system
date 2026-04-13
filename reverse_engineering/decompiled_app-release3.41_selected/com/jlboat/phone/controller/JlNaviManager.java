package com.jlboat.phone.controller;
public class JlNaviManager extends com.boat.base.BaseAppManager implements com.jlboat.phone.communication.MapListener$onDataCallBack, com.jlboat.phone.communication.SubMapLisener$OnDataCallBack, com.jlboat.phone.communication.TFPoseListener$OnCallBack, com.jlboat.phone.communication.PathLayerLisener$OnDataCallBack {
    private static String HOSTNAME;
    private static final android.os.RemoteCallbackList mCallBack;
    private final int BATTRY;
    private final int CHANGEMOTION;
    private final int CONNTASK;
    private final int CodeAllMapData;
    private final int CodeGPlanData;
    private final int CodeInitData;
    private final int CodeMapData;
    private final int CodeMapFileUpdateData;
    private final int CodeMapStatusData;
    private final int CodeMapStatusLocalPointData;
    private final int CodeMapUpdateData;
    private final int CodeNaviStatusData;
    private final int CodeNaviToPointData;
    private final int CodePoseData;
    private final int CodePowerData;
    private final int CodeScanData;
    private final int ELS;
    private final int GET_ROS_HOSTNAME;
    private final int INIT_STATUS;
    private final int LIST_DRIVER_STATUS;
    private final int LOCATION_STATUS;
    private final int MACHINESIGNAL;
    private final int MAPUPDATE;
    private final int MOTORLOCK;
    private final int NAVI_GOAL;
    private final int NAVI_NETWORK;
    private final int NAVI_POINTNAME;
    private final int NAVI_STATUS;
    private final int OUTCHANGESTATUS;
    private final int PING;
    private final int RESPONSE_CODE;
    private final int RESPONSE_STRING;
    private final int RE_CONN;
    private final int SALM_DOWNMAP_SUCC;
    private String TAG;
    private final int UPDATE_RECHARGE;
    private java.util.List buildMapLocalNaviPoints;
    private java.util.List buildMapLocalSystemPoint;
    private int changeMotionMode;
    private com.boat.support.slam.IResponseListener changeresponseListener;
    private boolean connectStatus;
    private int currentBattery;
    private int currentConnectStatus;
    private boolean currentConnectStatusIsOffLineUpdate;
    private String currentConnectStatusMsg;
    private int currentElsStatus;
    private boolean currentElsStatusIsOffLineUpdate;
    private String currentElsStatusMsg;
    private int currentImuStatus;
    private boolean currentImuStatusIsOffLineUpdate;
    private String currentImuStatusMsg;
    private int currentInitStatus;
    private boolean currentInitStatusIsOffLineUpdate;
    private String currentInitStatusMsg;
    private int currentLeftMotorStatus;
    private boolean currentLeftMotorStatusIsOffLineUpdate;
    private String currentLeftMotorStatusMsg;
    private int currentLidarStatus;
    private boolean currentLidarStatusIsOffLineUpdate;
    private String currentLidarStatusMsg;
    private int currentLocationStatus;
    private boolean currentLocationStatusIsOffLineUpdate;
    private String currentLocationStatusMsg;
    private int currentMapLoadStatus;
    private boolean currentMapLoadStatusIsOffLineUpdate;
    private String currentMapLoadStatusMsg;
    private boolean currentMotorEnableStatusIsOffLineUpdate;
    private String currentMotorEnabledMsg;
    private int currentMotorEnabledStatus;
    private int currentNaviMsgStatus;
    private int currentNaviNetWorkStatus;
    private boolean currentNaviNetWorkStatusIsOffLineUpdate;
    private String currentNaviNetWorkStatusMsg;
    private int currentOdomStatus;
    private boolean currentOdomStatusIsOffLineUpdate;
    private String currentOdomStatusMsg;
    private int currentRightMotorStatus;
    private boolean currentRightMotorStatusIsOffLineUpdate;
    private String currentRightMotorStatusMsg;
    private int currentSonarStatus;
    private boolean currentSonarStatusIsOffLineUpdate;
    private String currentSonarStatusMsg;
    private int currentStm32Status;
    private boolean currentStm32StatusIsOffLineUpdate;
    private String currentStm32StatusMsg;
    private int currentVirtualStatus;
    private boolean currentVirtualStatusIsOffLineUpdate;
    private String currentVirtualStatusMsg;
    private com.boat.jrosbridge.Topic currentposeLocationmiss;
    com.boat.jrosbridge.Topic erasePoseTopic;
    private com.boat.support.slam.entity.floors.Floors floors;
    private boolean hasCharging;
    private boolean hasIP;
    boolean isAllMapData;
    boolean isAllMapDataEnd;
    private boolean isCharging;
    private boolean isConnectNettWork;
    private boolean isEmergencyStop;
    boolean isGPlan;
    boolean isGPlanEnd;
    private boolean isInCharging;
    boolean isInit;
    boolean isInitEnd;
    boolean isMapData;
    boolean isMapDataEnd;
    boolean isMapStatus;
    boolean isMapStatusEnd;
    boolean isMapUpdate;
    boolean isMapUpdateEnd;
    private boolean isMotorEnabled;
    boolean isNaviStatus;
    boolean isNaviStatusUpdateEnd;
    boolean isNaviToPoint;
    boolean isNaviToPointUpdateEnd;
    private boolean isNavigationInited;
    boolean isPose;
    boolean isPoseEnd;
    boolean isPower;
    boolean isPowerUpdateEnd;
    boolean isScan;
    boolean isScanEnd;
    boolean islocalPointUpdate;
    boolean islocalPointUpdateEnd;
    private boolean ispush;
    private final int loss;
    private android.os.Handler mHandler;
    private boolean mIsTaskFinished;
    private final android.content.BroadcastReceiver mReceiver;
    private int mapBuildStatus;
    private android.os.Bundle mapDataBundle;
    private android.content.Intent mapDatanItent;
    com.jlboat.phone.communication.MapListener mapLisener;
    private com.boat.support.slam.entity.floors.MapList mapList;
    private int mapStatus;
    com.boat.jrosbridge.Topic nGlobalPlanTopicPublish;
    private String naviGoalPointName;
    private int naviLocationStatus;
    private boolean naviMotorlockStatus;
    private String naviStatus;
    private com.boat.support.slam.IResponseListener navigationToResponseListener;
    private int outChangeStatus;
    private boolean outMachineSignal;
    com.boat.jrosbridge.Topic outofChange;
    com.jlboat.phone.communication.PathLayerLisener pathLayerLisener;
    com.boat.jrosbridge.Topic pubCmdListener;
    com.jlboat.phone.communication.PubRecordBag pubRecordBagListener;
    com.boat.jrosbridge.Topic reachPointStatus;
    private int resStatus;
    com.boat.jrosbridge.Topic setTargetGoalPublish;
    com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    private com.jlboat.phone.message.map_msgs.TargetGoal targetGoal;
    com.jlboat.phone.communication.TFPoseListener tfPoseListener;
    com.boat.jrosbridge.Topic warnLedStatus;

    static JlNaviManager()
    {
        com.jlboat.phone.controller.JlNaviManager.mCallBack = new android.os.RemoteCallbackList();
        com.jlboat.phone.controller.JlNaviManager.HOSTNAME = "";
        return;
    }

    public JlNaviManager(com.boat.base.BaseApplication p4)
    {
        super(p4);
        super.TAG = "JlNaviManager";
        super.hasCharging = 1;
        super.isEmergencyStop = 0;
        super.isMotorEnabled = 0;
        super.mIsTaskFinished = 1;
        super.connectStatus = 0;
        super.isNavigationInited = 0;
        super.mapStatus = 0;
        super.buildMapLocalNaviPoints = new java.util.LinkedList();
        super.buildMapLocalSystemPoint = new java.util.LinkedList();
        super.currentBattery = -1;
        super.mapBuildStatus = 0;
        super.currentNaviMsgStatus = -1;
        super.currentConnectStatus = -1;
        super.currentConnectStatusIsOffLineUpdate = 0;
        super.currentInitStatus = -1;
        super.currentInitStatusIsOffLineUpdate = 0;
        super.currentElsStatus = -1;
        super.currentElsStatusIsOffLineUpdate = 0;
        super.currentMotorEnabledStatus = -1;
        super.currentMotorEnableStatusIsOffLineUpdate = 0;
        super.currentLocationStatus = -1;
        super.currentLocationStatusIsOffLineUpdate = 0;
        super.currentVirtualStatus = -1;
        super.currentVirtualStatusIsOffLineUpdate = 0;
        super.currentMapLoadStatus = -1;
        super.currentMapLoadStatusIsOffLineUpdate = 0;
        super.currentLidarStatus = -1;
        super.currentLidarStatusIsOffLineUpdate = 0;
        super.currentStm32Status = -1;
        super.currentStm32StatusIsOffLineUpdate = 0;
        super.currentOdomStatus = -1;
        super.currentOdomStatusIsOffLineUpdate = 0;
        super.currentNaviNetWorkStatus = -1;
        super.currentNaviNetWorkStatusIsOffLineUpdate = 0;
        super.currentImuStatus = -1;
        super.currentImuStatusIsOffLineUpdate = 0;
        super.currentSonarStatus = -1;
        super.currentSonarStatusIsOffLineUpdate = 0;
        super.currentLeftMotorStatus = -1;
        super.currentLeftMotorStatusIsOffLineUpdate = 0;
        super.currentRightMotorStatus = -1;
        super.currentRightMotorStatusIsOffLineUpdate = 0;
        super.PING = 0;
        super.GET_ROS_HOSTNAME = 1;
        super.CONNTASK = 2;
        super.LIST_DRIVER_STATUS = 3;
        super.RE_CONN = 4;
        super.UPDATE_RECHARGE = 5;
        super.ELS = 6;
        super.BATTRY = 7;
        super.NAVI_STATUS = 8;
        super.INIT_STATUS = 9;
        super.loss = 10;
        super.NAVI_POINTNAME = 11;
        super.MAPUPDATE = 12;
        super.LOCATION_STATUS = 13;
        super.MOTORLOCK = 14;
        super.CHANGEMOTION = 15;
        super.OUTCHANGESTATUS = 16;
        super.MACHINESIGNAL = 17;
        super.NAVI_GOAL = 19;
        super.NAVI_NETWORK = 22;
        super.RESPONSE_STRING = 50;
        super.RESPONSE_CODE = 100;
        super.CodeAllMapData = 1000;
        super.CodeMapData = 1001;
        super.CodePoseData = 1002;
        super.CodeScanData = 1003;
        super.CodeGPlanData = 1004;
        super.CodeInitData = 1011;
        super.CodeMapStatusData = 1012;
        super.CodeMapUpdateData = 1013;
        super.CodeMapFileUpdateData = 1014;
        super.CodeMapStatusLocalPointData = 1015;
        super.CodeNaviStatusData = 1021;
        super.CodeNaviToPointData = 1022;
        super.CodePowerData = 1031;
        super.SALM_DOWNMAP_SUCC = 1032;
        super.ispush = 1;
        super.isAllMapDataEnd = 1;
        super.isMapDataEnd = 1;
        super.isPoseEnd = 1;
        super.isScanEnd = 1;
        super.isGPlanEnd = 1;
        super.isInitEnd = 1;
        super.isMapStatusEnd = 1;
        super.isMapUpdateEnd = 1;
        super.islocalPointUpdateEnd = 1;
        super.isNaviStatusUpdateEnd = 1;
        super.isNaviToPointUpdateEnd = 1;
        super.isPowerUpdateEnd = 1;
        super.mHandler = new com.jlboat.phone.controller.JlNaviManager$1(super);
        super.mReceiver = new com.jlboat.phone.controller.JlNaviManager$2(super);
        return;
    }

    private void IssuedCocoNum()
    {
        return;
    }

    static synthetic String access$000(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.TAG;
    }

    static synthetic android.os.Handler access$100(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.mHandler;
    }

    static synthetic android.os.RemoteCallbackList access$1000()
    {
        return com.jlboat.phone.controller.JlNaviManager.mCallBack;
    }

    static synthetic boolean access$1100(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.isCharging;
    }

    static synthetic boolean access$1200(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.isEmergencyStop;
    }

    static synthetic boolean access$1202(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.isEmergencyStop = p1;
        return p1;
    }

    static synthetic void access$1300(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.onNaviStatusListener();
        return;
    }

    static synthetic String access$1400(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.naviStatus;
    }

    static synthetic String access$1402(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.naviStatus = p1;
        return p1;
    }

    static synthetic String access$1500(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.naviGoalPointName;
    }

    static synthetic String access$1502(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.naviGoalPointName = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.message.map_msgs.TargetGoal access$1600(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.targetGoal;
    }

    static synthetic com.jlboat.phone.message.map_msgs.TargetGoal access$1602(com.jlboat.phone.controller.JlNaviManager p0, com.jlboat.phone.message.map_msgs.TargetGoal p1)
    {
        p0.targetGoal = p1;
        return p1;
    }

    static synthetic int access$1700(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentNaviNetWorkStatus;
    }

    static synthetic int access$1702(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentNaviNetWorkStatus = p1;
        return p1;
    }

    static synthetic int access$1800(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentLocationStatus;
    }

    static synthetic int access$1802(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentLocationStatus = p1;
        return p1;
    }

    static synthetic boolean access$1900(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.isMotorEnabled;
    }

    static synthetic boolean access$1902(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.isMotorEnabled = p1;
        return p1;
    }

    static synthetic int access$200(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentConnectStatus;
    }

    static synthetic int access$2000(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.changeMotionMode;
    }

    static synthetic int access$2002(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.changeMotionMode = p1;
        return p1;
    }

    static synthetic int access$202(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentConnectStatus = p1;
        return p1;
    }

    static synthetic int access$2100(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.outChangeStatus;
    }

    static synthetic int access$2102(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.outChangeStatus = p1;
        return p1;
    }

    static synthetic boolean access$2200(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.outMachineSignal;
    }

    static synthetic boolean access$2202(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.outMachineSignal = p1;
        return p1;
    }

    static synthetic void access$2300(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.onInitStatusListener();
        return;
    }

    static synthetic void access$2400(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.onMapStatusListener();
        return;
    }

    static synthetic void access$2500(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.onMapUpdateListener();
        return;
    }

    static synthetic void access$2600(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.onPointUpdateListener();
        return;
    }

    static synthetic void access$2700(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.onPowerListener();
        return;
    }

    static synthetic void access$2800(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.checkOffLineHasStatus();
        return;
    }

    static synthetic void access$2900(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.IssuedCocoNum();
        return;
    }

    static synthetic String access$300(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentConnectStatusMsg;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$3000(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.mapList;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$3002(com.jlboat.phone.controller.JlNaviManager p0, com.boat.support.slam.entity.floors.MapList p1)
    {
        p0.mapList = p1;
        return p1;
    }

    static synthetic String access$302(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentConnectStatusMsg = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$3102(com.jlboat.phone.controller.JlNaviManager p0, com.boat.support.slam.entity.floors.Floors p1)
    {
        p0.floors = p1;
        return p1;
    }

    static synthetic java.util.List access$3200(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.buildMapLocalNaviPoints;
    }

    static synthetic java.util.List access$3300(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.buildMapLocalSystemPoint;
    }

    static synthetic com.boat.support.slam.IResponseListener access$3400(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.navigationToResponseListener;
    }

    static synthetic com.boat.support.slam.IResponseListener access$3500(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.changeresponseListener;
    }

    static synthetic com.boat.support.slam.IResponseListener access$3502(com.jlboat.phone.controller.JlNaviManager p0, com.boat.support.slam.IResponseListener p1)
    {
        p0.changeresponseListener = p1;
        return p1;
    }

    static synthetic void access$3600(com.jlboat.phone.controller.JlNaviManager p0, String p1, String p2)
    {
        p0.responseString(p1, p2);
        return;
    }

    static synthetic void access$3700(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.getDefDiyLineConfig();
        return;
    }

    static synthetic String access$3800(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentInitStatusMsg;
    }

    static synthetic String access$3802(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentInitStatusMsg = p1;
        return p1;
    }

    static synthetic void access$3900(com.jlboat.phone.controller.JlNaviManager p0)
    {
        p0.stopwelcomeSpeech();
        return;
    }

    static synthetic boolean access$400(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.isConnectNettWork;
    }

    static synthetic int access$4002(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentInitStatus = p1;
        return p1;
    }

    static synthetic boolean access$402(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.isConnectNettWork = p1;
        return p1;
    }

    static synthetic boolean access$4102(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentInitStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic String access$4200(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentElsStatusMsg;
    }

    static synthetic String access$4202(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentElsStatusMsg = p1;
        return p1;
    }

    static synthetic int access$4302(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentElsStatus = p1;
        return p1;
    }

    static synthetic boolean access$4402(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentElsStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic String access$4500(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentMotorEnabledMsg;
    }

    static synthetic String access$4502(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentMotorEnabledMsg = p1;
        return p1;
    }

    static synthetic int access$4602(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentMotorEnabledStatus = p1;
        return p1;
    }

    static synthetic boolean access$4702(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentMotorEnableStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic void access$4800(com.jlboat.phone.controller.JlNaviManager p0, boolean p1, String p2)
    {
        p0.checkChange(p1, p2);
        return;
    }

    static synthetic boolean access$4900(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.isInCharging;
    }

    static synthetic boolean access$4902(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.isInCharging = p1;
        return p1;
    }

    static synthetic boolean access$500(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.ispush;
    }

    static synthetic String access$5000(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentLocationStatusMsg;
    }

    static synthetic String access$5002(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentLocationStatusMsg = p1;
        return p1;
    }

    static synthetic boolean access$502(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.ispush = p1;
        return p1;
    }

    static synthetic boolean access$5102(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentLocationStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic int access$5200(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentNaviMsgStatus;
    }

    static synthetic int access$5202(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentNaviMsgStatus = p1;
        return p1;
    }

    static synthetic boolean access$5300(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.mIsTaskFinished;
    }

    static synthetic boolean access$5302(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.mIsTaskFinished = p1;
        return p1;
    }

    static synthetic void access$5400(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.updateHeadAndLight(p1);
        return;
    }

    static synthetic String access$5500(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentVirtualStatusMsg;
    }

    static synthetic String access$5502(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentVirtualStatusMsg = p1;
        return p1;
    }

    static synthetic int access$5602(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentVirtualStatus = p1;
        return p1;
    }

    static synthetic boolean access$5702(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentVirtualStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic int access$5802(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.mapStatus = p1;
        return p1;
    }

    static synthetic String access$5900(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentMapLoadStatusMsg;
    }

    static synthetic String access$5902(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentMapLoadStatusMsg = p1;
        return p1;
    }

    static synthetic int access$6002(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentMapLoadStatus = p1;
        return p1;
    }

    static synthetic boolean access$602(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentConnectStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic boolean access$6102(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentMapLoadStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic int access$6202(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.mapBuildStatus = p1;
        return p1;
    }

    static synthetic String access$6300(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentLidarStatusMsg;
    }

    static synthetic String access$6302(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentLidarStatusMsg = p1;
        return p1;
    }

    static synthetic int access$6402(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentLidarStatus = p1;
        return p1;
    }

    static synthetic boolean access$6502(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentLidarStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic String access$6600(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentStm32StatusMsg;
    }

    static synthetic String access$6602(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentStm32StatusMsg = p1;
        return p1;
    }

    static synthetic int access$6702(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentStm32Status = p1;
        return p1;
    }

    static synthetic boolean access$6802(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentStm32StatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic String access$6900(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentOdomStatusMsg;
    }

    static synthetic String access$6902(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentOdomStatusMsg = p1;
        return p1;
    }

    static synthetic boolean access$700(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.connectStatus;
    }

    static synthetic int access$7002(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentOdomStatus = p1;
        return p1;
    }

    static synthetic boolean access$702(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.connectStatus = p1;
        return p1;
    }

    static synthetic boolean access$7102(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentOdomStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic String access$7200(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentNaviNetWorkStatusMsg;
    }

    static synthetic String access$7202(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentNaviNetWorkStatusMsg = p1;
        return p1;
    }

    static synthetic boolean access$7302(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentNaviNetWorkStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic String access$7400(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentImuStatusMsg;
    }

    static synthetic String access$7402(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentImuStatusMsg = p1;
        return p1;
    }

    static synthetic int access$7502(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentImuStatus = p1;
        return p1;
    }

    static synthetic boolean access$7602(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentImuStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic String access$7700(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentSonarStatusMsg;
    }

    static synthetic String access$7702(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentSonarStatusMsg = p1;
        return p1;
    }

    static synthetic int access$7802(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentSonarStatus = p1;
        return p1;
    }

    static synthetic boolean access$7902(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentSonarStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic int access$800(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentBattery;
    }

    static synthetic void access$8000(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.checkMotorStatus(p1);
        return;
    }

    static synthetic int access$802(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentBattery = p1;
        return p1;
    }

    static synthetic String access$8100(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentLeftMotorStatusMsg;
    }

    static synthetic String access$8102(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentLeftMotorStatusMsg = p1;
        return p1;
    }

    static synthetic int access$8202(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentLeftMotorStatus = p1;
        return p1;
    }

    static synthetic boolean access$8302(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentLeftMotorStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic String access$8400(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.currentRightMotorStatusMsg;
    }

    static synthetic String access$8402(com.jlboat.phone.controller.JlNaviManager p0, String p1)
    {
        p0.currentRightMotorStatusMsg = p1;
        return p1;
    }

    static synthetic int access$8502(com.jlboat.phone.controller.JlNaviManager p0, int p1)
    {
        p0.currentRightMotorStatus = p1;
        return p1;
    }

    static synthetic boolean access$8602(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.currentRightMotorStatusIsOffLineUpdate = p1;
        return p1;
    }

    static synthetic boolean access$900(com.jlboat.phone.controller.JlNaviManager p1)
    {
        return p1.isNavigationInited;
    }

    static synthetic boolean access$902(com.jlboat.phone.controller.JlNaviManager p0, boolean p1)
    {
        p0.isNavigationInited = p1;
        return p1;
    }

    private void addNGPointLine(com.boat.support.slam.entity.floors.NLine p4)
    {
        com.jlboat.phone.message.map_msgs.NGlobalPlan v0_1 = new com.jlboat.phone.message.map_msgs.NGlobalPlan();
        v0_1.setId(p4.getId());
        v0_1.setStartNid(p4.getStartNid());
        v0_1.setEndNid(p4.getEndNid());
        v0_1.setType(p4.getType());
        v0_1.setDirection(p4.getDirection());
        v0_1.setSpeed(p4.getSpeed());
        v0_1.setWeight(p4.getWeight());
        this.nGlobalPlanTopicPublish.publish(v0_1);
        return;
    }

    private void changeMap(String p9)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            if ((p9 != null) && (!p9.isEmpty())) {
                if (this.floors != null) {
                    java.util.List v0_1 = this.getMapList();
                    if (v0_1 != null) {
                        int v1_0 = 0;
                        String v2 = "";
                        String v3_0 = v0_1.iterator();
                        while (v3_0.hasNext()) {
                            String v4_2 = ((com.boat.support.slam.entity.floors.Maps) v3_0.next());
                            if (p9.equals(new StringBuilder().append(v4_2.getMapId()).append("").toString())) {
                                v1_0 = 1;
                                v2 = v4_2.getMapName();
                                break;
                            }
                        }
                        if (v1_0 != 0) {
                            this.toast(new StringBuilder().append("updateMap: mapName: ").append(v2).append(", MapId: ").append(p9).toString());
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            android.util.Log.d(this.TAG, "changeMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 changeMap");
            return;
        }
    }

    private void checkChange(boolean p4, String p5)
    {
        android.util.Log.d(this.TAG, new StringBuilder().append("checkChange: ").append(p5).append(" newCharging : ").append(p4).append("oldCharging: ").append(this.isCharging).toString());
        if (p4 != this.isCharging) {
            this.isCharging = p4;
            this.onPowerListener();
            this.mHandler.sendEmptyMessage(5);
        }
        return;
    }

    private void checkMotorStatus(int p3)
    {
        String v0 = "";
        switch (p3) {
            case 101:
                v0 = "\u673a\u5668\u4eba\u5728\u6ca1\u6709\u6307\u4ee4\u60c5\u51b5\u4e0b\uff0c\u8f6e\u5b50\u4f9d\u7136\u5728\u8f6c\u52a8\uff0c\u5371\u9669!";
                break;
            case 102:
                v0 = "\u673a\u5668\u4eba\u5728\u6ca1\u6709\u6307\u4ee4\u60c5\u51b5\u4e0b\uff0c\u8f6e\u5b50\u9759\u6b62\uff0c\u72b6\u6001\u6b63\u5e38\u3002";
                break;
            case 119:
                v0 = "\u673a\u5668\u4eba\u5728\u6709\u79fb\u52a8\u6307\u4ee4\u60c5\u51b5\u4e0b\uff0c\u8f6e\u5b50\u9759\u6b62\u4e0d\u52a8\uff0c\u6709\u53ef\u80fd\u8f6e\u5b50\u88ab\u5361\u4f4f\u4e86\uff0c\u8bf7\u68c0\u67e5\u8f6e\u5b50";
                break;
            case 120:
                v0 = "\u673a\u5668\u4eba\u8f6e\u5b50\u54cd\u5e94\u6b63\u5e38";
                break;
            default:
        }
        if (!v0.isEmpty()) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), p3, v0);
        }
        return;
    }

    private void checkOffLineHasStatus()
    {
        android.util.Log.d(this.TAG, new StringBuilder().append("checkOffLineHasStatus: \n\u8fde\u63a5\u72b6\u6001\u662f\u5426\u9700\u8981\u66f4\u65b0: ").append(this.currentConnectStatusIsOffLineUpdate).append("\n\u68c0\u67e5\u521d\u59cb\u5316\u72b6\u6001\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentInitStatusIsOffLineUpdate).append("\n\u68c0\u67e5\u6025\u505c\u72b6\u6001\u7801\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentElsStatusIsOffLineUpdate).append("\n\u68c0\u67e5\u7535\u673a\u9501\u72b6\u6001\u7801\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentMotorEnableStatusIsOffLineUpdate).append("\n\u68c0\u67e5\u5b9a\u4f4d\u7801\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentLocationStatusIsOffLineUpdate).append("\n\u68c0\u67e5\u865a\u62df\u5899\u72b6\u6001\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentVirtualStatusIsOffLineUpdate).append("\n\u5f53\u524d\u5730\u56fe\u52a0\u8f7d\u662f\u5426\u5b8c\u6210\u7684\u72b6\u6001\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentMapLoadStatusIsOffLineUpdate).append("\n\u5f53\u524d\u96f7\u8fbe\u72b6\u6001\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentLidarStatusIsOffLineUpdate).append("\n\u5f53\u524d32\u4e3b\u677f\u72b6\u6001\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentStm32StatusIsOffLineUpdate).append("\n\u5f53\u91cc\u7a0b\u8ba1\u7801\u662f\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentOdomStatusIsOffLineUpdate).append("\n\u5f53\u91cc\u5e95\u76d8\u8054\u7f51\u72b6\u6001\u5426\u9700\u8981\u4e0a\u62a5: ").append(this.currentNaviNetWorkStatusIsOffLineUpdate).append("\nimu: ").append(this.currentImuStatusIsOffLineUpdate).append("\nsonar: ").append(this.currentSonarStatusIsOffLineUpdate).append("\n\u5de6\u8f6e\u72b6\u6001\u7801\u4e0a\u62a5\u68c0\u67e5: ").append(this.currentLeftMotorStatusIsOffLineUpdate).append("\n\u53f3\u8f6e\u72b6\u6001\u7801\u4e0a\u62a5\u68c0\u67e5: ").append(this.currentRightMotorStatusIsOffLineUpdate).toString());
        if (this.currentConnectStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentConnectStatus, this.currentConnectStatusMsg);
            this.currentConnectStatusIsOffLineUpdate = 0;
        }
        if (this.currentInitStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentInitStatus, this.currentInitStatusMsg);
            this.currentInitStatusIsOffLineUpdate = 0;
        }
        if (this.currentElsStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentElsStatus, this.currentElsStatusMsg);
            this.currentElsStatusIsOffLineUpdate = 0;
        }
        if (this.currentMotorEnableStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentMotorEnabledStatus, this.currentMotorEnabledMsg);
            this.currentMotorEnableStatusIsOffLineUpdate = 0;
        }
        if (this.currentLocationStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentLocationStatus, this.currentLocationStatusMsg);
            this.currentLocationStatusIsOffLineUpdate = 0;
        }
        if (this.currentVirtualStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentVirtualStatus, this.currentVirtualStatusMsg);
            this.currentVirtualStatusIsOffLineUpdate = 0;
        }
        if (this.currentMapLoadStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentMapLoadStatus, this.currentMapLoadStatusMsg);
            this.currentMapLoadStatusIsOffLineUpdate = 0;
        }
        if (this.currentLidarStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentLidarStatus, this.currentLidarStatusMsg);
            this.currentLidarStatusIsOffLineUpdate = 0;
        }
        if (this.currentStm32StatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentStm32Status, this.currentStm32StatusMsg);
            this.currentStm32StatusIsOffLineUpdate = 0;
        }
        if (this.currentOdomStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentOdomStatus, this.currentOdomStatusMsg);
            this.currentOdomStatusIsOffLineUpdate = 0;
        }
        if (this.currentNaviNetWorkStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentNaviNetWorkStatus, this.currentNaviNetWorkStatusMsg);
            this.currentNaviNetWorkStatusIsOffLineUpdate = 0;
        }
        if (this.currentImuStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentImuStatus, this.currentImuStatusMsg);
            this.currentImuStatusIsOffLineUpdate = 0;
        }
        if (this.currentSonarStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentSonarStatus, this.currentSonarStatusMsg);
            this.currentSonarStatusIsOffLineUpdate = 0;
        }
        if (this.currentLeftMotorStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentLeftMotorStatus, this.currentLeftMotorStatusMsg);
            this.currentLeftMotorStatusIsOffLineUpdate = 0;
        }
        if (this.currentRightMotorStatusIsOffLineUpdate) {
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.getApp(), this.currentRightMotorStatus, this.currentRightMotorStatusMsg);
            this.currentRightMotorStatusIsOffLineUpdate = 0;
        }
        return;
    }

    private void cmd_vel(double p6, double p8)
    {
        com.boat.jrosbridge.message.geometry_msgs.Twist v0_1 = new com.boat.jrosbridge.message.geometry_msgs.Twist();
        com.boat.jrosbridge.message.geometry_msgs.Vector3 v1_1 = new com.boat.jrosbridge.message.geometry_msgs.Vector3();
        com.boat.jrosbridge.message.geometry_msgs.Vector3 v2_1 = new com.boat.jrosbridge.message.geometry_msgs.Vector3();
        v1_1.setX(p6);
        v2_1.setZ((- p8));
        v0_1.setLinear(v1_1);
        v0_1.setAngular(v2_1);
        this.pubCmdListener.publish(v0_1);
        return;
    }

    private void deleteNavi(String p10, com.boat.support.slam.IResponseListener p11)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.deletePonsintService(this.floors.getFloorId(), this.floors.getDefaultmap(), Long.parseLong(p10), new com.jlboat.phone.controller.JlNaviManager$25(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "deleteNavi: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u80fd\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 deleteNavi");
            return;
        }
    }

    private static java.net.InetAddress filterInetAddresses(java.util.Collection p3)
    {
        int v0_0 = p3.iterator();
        while (v0_0.hasNext()) {
            java.net.InetAddress v1_2 = ((java.net.InetAddress) v0_0.next());
            if ((!v1_2.isLoopbackAddress()) && (com.jlboat.phone.controller.JlNaviManager.isIpv4(v1_2))) {
                return v1_2;
            }
        }
        return 0;
    }

    private void getDefDiyLineConfig()
    {
        this.statusServiceClient.getConfigsService(1, new com.jlboat.phone.controller.JlNaviManager$29(this));
        return;
    }

    private void getLocation(com.boat.support.slam.IPositionResult p3)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.getCurrentPositionListener(new com.jlboat.phone.controller.JlNaviManager$32(this, p3));
            return;
        } else {
            android.util.Log.d(this.TAG, "getLocation: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 getLocation");
            return;
        }
    }

    private void goNavito(String p3)
    {
        this.toast(new StringBuilder().append("ros\u5bfc\u822a\u4efb\u52a1 goNavito: name = ").append(p3).toString());
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.naviGoalPointName = p3;
            this.onNaviToPointListener();
            this.spiritServiceClient.setGoalServiceResponseListener(p3, new com.jlboat.phone.controller.JlNaviManager$14(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "goNavito: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 goNavito");
            if (this.navigationToResponseListener != null) {
                try {
                    this.navigationToResponseListener.onFailed("navigation RemoteException");
                } catch (android.os.RemoteException v0_8) {
                    v0_8.printStackTrace();
                }
            }
            return;
        }
    }

    private static boolean isIpv4(java.net.InetAddress p2)
    {
        int v0_2;
        if (p2.getAddress().length != 4) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    private void log(String p7, String p8)
    {
        if ((p7 != null) && ((p7.length() != 0) && ((p8 != null) && (p8.length() != 0)))) {
            if (((long) p8.length()) > ((long) 3072)) {
                while (p8.length() > 3072) {
                    String v3_3 = p8.substring(0, 3072);
                    p8 = p8.replace(v3_3, "");
                    android.util.Log.e(p7, v3_3);
                }
                android.util.Log.e(p7, p8);
            } else {
                android.util.Log.e(p7, p8);
            }
            return;
        } else {
            return;
        }
    }

    public static java.net.InetAddress newNonLoopbackForNetworkInterface(java.net.NetworkInterface p1)
    {
        return com.jlboat.phone.controller.JlNaviManager.filterInetAddresses(java.util.Collections.list(p1.getInetAddresses()));
    }

    private void onInitStatusListener()
    {
        android.os.Handler v2_0;
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 100;
        android.os.Bundle v1_2 = new android.os.Bundle();
        v1_2.putInt("code", 1011);
        if (!this.isNavigationInited) {
            v2_0 = "11";
        } else {
            v2_0 = "12";
        }
        v1_2.putString("data", v2_0);
        v0_1.setData(v1_2);
        this.mHandler.sendMessage(v0_1);
        return;
    }

    private void onMapStatusListener()
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 100;
        android.os.Bundle v1_2 = new android.os.Bundle();
        v1_2.putInt("code", 1012);
        v1_2.putString("data", new StringBuilder().append(this.mapStatus).append("").toString());
        v0_1.setData(v1_2);
        this.mHandler.sendMessage(v0_1);
        return;
    }

    private void onMapUpdateListener()
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 100;
        android.os.Bundle v1_2 = new android.os.Bundle();
        v1_2.putInt("code", 1013);
        v1_2.putString("data", "");
        v0_1.setData(v1_2);
        this.mHandler.sendMessage(v0_1);
        return;
    }

    private void onNaviStatusListener()
    {
        if (!this.isNaviStatusUpdateEnd) {
            android.os.Message v0_2 = new android.os.Message();
            v0_2.what = 100;
            android.os.Bundle v1_2 = new android.os.Bundle();
            v1_2.putInt("code", 1021);
            v1_2.putString("data", new StringBuilder().append("{\"naviStatus\":\"").append(this.naviStatus).append("\"}").toString());
            v0_2.setData(v1_2);
            this.mHandler.sendMessage(v0_2);
            return;
        } else {
            return;
        }
    }

    private void onNaviToPointListener()
    {
        if (!this.isNaviToPointUpdateEnd) {
            android.os.Message v0_2 = new android.os.Message();
            v0_2.what = 100;
            android.os.Bundle v1_2 = new android.os.Bundle();
            v1_2.putInt("code", 1022);
            v1_2.putString("data", new StringBuilder().append("{\"pointName\":\"").append(this.naviGoalPointName).append("\"}").toString());
            v0_2.setData(v1_2);
            this.mHandler.sendMessage(v0_2);
            return;
        } else {
            return;
        }
    }

    private void onPointUpdateListener()
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 100;
        android.os.Bundle v1_2 = new android.os.Bundle();
        v1_2.putInt("code", 1015);
        v1_2.putString("data", new StringBuilder().append("{\"systemPoint\":").append(new com.google.gson.Gson().toJson(this.buildMapLocalSystemPoint)).append(",\"naviPoint\":").append(new com.google.gson.Gson().toJson(this.buildMapLocalNaviPoints)).append("}").toString());
        v0_1.setData(v1_2);
        this.mHandler.sendMessage(v0_1);
        return;
    }

    private void onPowerListener()
    {
        if (!this.isPowerUpdateEnd) {
            android.os.Message v0_2 = new android.os.Message();
            v0_2.what = 100;
            android.os.Bundle v1_2 = new android.os.Bundle();
            v1_2.putInt("code", 1031);
            v1_2.putString("data", new StringBuilder().append("{\"isCharging\":").append(this.isCharging).append(",\"battery\":\"").append(this.currentBattery).append("\"}").toString());
            v0_2.setData(v1_2);
            this.mHandler.sendMessage(v0_2);
            return;
        } else {
            return;
        }
    }

    private void renamePointName(int p14, long p15, long p17, long p19, String p21, com.boat.support.slam.IResponseListener p22)
    {
        if (!this.connectStatus) {
            com.boat.support.slam.IResponseListener v12 = p22;
        } else {
            if (this.isNavigationInited) {
                this.spiritServiceClient.renamePosintService(p14, p15, p17, p19, p21, new com.jlboat.phone.controller.JlNaviManager$26(this, p22, p21));
                return;
            } else {
                v12 = p22;
            }
        }
        android.util.Log.d(this.TAG, "renamePointName: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u80fd\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 renamePointName");
        return;
    }

    private void responseString(String p4, String p5)
    {
        android.util.Log.d(this.TAG, new StringBuilder().append("responseString: type ").append(p4).toString());
        if (this.mHandler != null) {
            com.jlboat.phone.bean.ResponseString v0_3 = new com.jlboat.phone.bean.ResponseString();
            v0_3.setType(p4);
            v0_3.setValue(p5);
            android.os.Message v1_2 = new android.os.Message();
            v1_2.obj = v0_3;
            v1_2.what = 50;
            this.mHandler.sendMessage(v1_2);
        }
        return;
    }

    private void setCocoNum(int p4)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.setCocoNumServiceResponseListener(p4, new com.jlboat.phone.controller.JlNaviManager$3(this));
            return;
        } else {
            android.util.Log.d(this.TAG, new StringBuilder().append("setCocoNum: \u521d\u59cb\u5316\u672a\u6210\u529f  setCocoNum \u5931\u8d25\uff0c connectStatus\uff1a ").append(this.connectStatus).append(", isNavigationInited: ").append(this.isNavigationInited).toString());
            return;
        }
    }

    private void setMoveMode(int p5)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.setMoveModeListener(((long) p5), new com.jlboat.phone.controller.JlNaviManager$22(this, p5));
            return;
        } else {
            android.util.Log.d(this.TAG, "setMoveMode: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u80fd\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 setMoveMode");
            return;
        }
    }

    private void setPoint(long p3, String p5, com.boat.support.slam.IResponseListener p6)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.addPosintServices(p3, p5, new com.jlboat.phone.controller.JlNaviManager$27(this, p6));
            return;
        } else {
            android.util.Log.d(this.TAG, "setPoint: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 setPoint");
            return;
        }
    }

    private void slamDownLoadMapData(String p4)
    {
        android.util.Log.d(this.TAG, new StringBuilder().append("slamDownLoadMapData json:").append(p4).toString());
        this.spiritServiceClient.downLoadMapData(p4, new com.jlboat.phone.controller.JlNaviManager$34(this));
        return;
    }

    private void stopwelcomeSpeech()
    {
        return;
    }

    private void uodateDiyLineConfig(com.boat.support.slam.entity.floors.NLine p10)
    {
        java.util.LinkedList v0_1 = new java.util.LinkedList();
        com.jlboat.phone.message.map_msgs.Config v1_1 = new com.jlboat.phone.message.map_msgs.Config();
        v1_1.setType(1);
        v1_1.setConfigName("ng_path_df_type");
        v1_1.setConfigValue(new StringBuilder().append(p10.getType()).append("").toString());
        com.jlboat.phone.message.map_msgs.Config v3_4 = new com.jlboat.phone.message.map_msgs.Config();
        v3_4.setType(1);
        v3_4.setConfigName("ng_path_df_direction");
        v3_4.setConfigValue(new StringBuilder().append(p10.getDirection()).append("").toString());
        com.jlboat.phone.message.map_msgs.Config v5_7 = new com.jlboat.phone.message.map_msgs.Config();
        v5_7.setType(1);
        v5_7.setConfigName("ng_path_df_speed");
        v5_7.setConfigValue(new StringBuilder().append(p10.getSpeed()).append("").toString());
        com.jlboat.phone.message.map_msgs.Config v6_8 = new com.jlboat.phone.message.map_msgs.Config();
        v6_8.setType(1);
        v6_8.setConfigName("ng_path_df_weight");
        v6_8.setConfigValue(new StringBuilder().append(p10.getWeight()).append("").toString());
        v0_1.add(v1_1);
        v0_1.add(v3_4);
        v0_1.add(v5_7);
        v0_1.add(v6_8);
        this.statusServiceClient.setOrDelConfigsService(v0_1, 1, new com.jlboat.phone.controller.JlNaviManager$30(this));
        return;
    }

    private void updateHeadAndLight(boolean p1)
    {
        return;
    }

    public void Navigational_state(int p1)
    {
        return;
    }

    public boolean Ping(String p7)
    {
        int v0 = 0;
        try {
            InterruptedException v1_0 = Runtime.getRuntime().exec(new StringBuilder().append("ping -c 3 -w 100 ").append(p7).toString());
        } catch (InterruptedException v1_1) {
            v1_1.printStackTrace();
            return v0;
        } catch (InterruptedException v1_1) {
        }
        if (v1_0.waitFor() != 0) {
            v0 = 0;
        } else {
            v0 = 1;
        }
        android.util.Log.d(this.TAG, new StringBuilder().append("Ping: ").append(v1_0.toString()).toString());
        return v0;
    }

    public void addCurrentPosition(String p4, com.boat.support.slam.IResponseListener p5)
    {
        int v0 = 0;
        if ("\u5145\u7535\u6869".equals(p4)) {
            v0 = 1;
        }
        if ("\u521d\u59cb\u70b9".equals(p4)) {
            v0 = 2;
        }
        this.setPoint(((long) v0), p4, p5);
        return;
    }

    public void addMenuPoint(long p26, String p28, double p29, double p31, double p33, com.boat.support.slam.IResponseListener p35)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            android.util.Log.d(this.TAG, new StringBuilder().append("addMenuPoint:  yaw = ").append(p33).toString());
            String v1_1 = new com.jlboat.phone.util.EulerAngles;
            v1_1(0, p33, 0);
            String v1_2 = v1_1.ToQuaternion();
            this.spiritServiceClient.addManuPosintServices(p26, p28, p29, p31, v1_2.z, v1_2.w, new com.jlboat.phone.controller.JlNaviManager$28(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "addMenuPoint: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 addMenuPoint ");
            return;
        }
    }

    public void addPosition(String p14, double p15, double p17, double p19, com.boat.support.slam.IResponseListener p21)
    {
        com.jlboat.phone.controller.JlNaviManager v0_0 = 0;
        if ("\u5145\u7535\u6869".equals(p14)) {
            v0_0 = 1;
        }
        int v12;
        if (!"\u521d\u59cb\u70b9".equals(p14)) {
            v12 = v0_0;
        } else {
            v12 = 2;
        }
        this.addMenuPoint(((long) v12), p14, p15, p17, p19, p21);
        return;
    }

    public void changePositionName(long p12, String p14, com.boat.support.slam.IResponseListener p15)
    {
        this.renamePointName(0, this.floors.getDefaultmap(), this.mapList.getDefaultFloor(), p12, p14, p15);
        return;
    }

    public void clearMap()
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.toast(this.getApp().getResources().getString(2131493116));
            this.toast(this.getApp().getResources().getString(2131493117));
            this.spiritServiceClient.clearMapService(new com.jlboat.phone.controller.JlNaviManager$16(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "clearMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 clearMap");
            return;
        }
    }

    public void connect(com.boat.base.BaseApplication p4)
    {
        android.content.IntentFilter v0_1 = new android.content.IntentFilter();
        v0_1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        v0_1.addAction("com.boat.launcher.action.network");
        v0_1.addAction("com.boat.action.WiFICONFIG_ROS");
        v0_1.addAction("com.boat.action.CocoNum");
        v0_1.addAction("com.jboat.action.allmap_and_res");
        android.util.Log.d(this.TAG, "JlNaviManager: registerReceiver ");
        this.getApp().registerReceiver(this.mReceiver, v0_1);
        this.mHandler.sendEmptyMessage(1);
        return;
    }

    public void deleteBag()
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            android.util.Log.d(this.TAG, "onSuccess:deleteBag ");
            this.spiritServiceClient.deleteBagService(new com.jlboat.phone.controller.JlNaviManager$5(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "deleteBag: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 deleteBag");
            return;
        }
    }

    public void deleteLog()
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            android.util.Log.d(this.TAG, "onSuccess:deleteLog ");
            this.spiritServiceClient.deleteLogService(new com.jlboat.phone.controller.JlNaviManager$6(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "deleteLog: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 deleteLog");
            return;
        }
    }

    public void deleteMap(String p8)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.deleteMapService(this.floors.getFloorId(), Long.parseLong(p8), new com.jlboat.phone.controller.JlNaviManager$20(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "deleteMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 deleteMap");
            return;
        }
    }

    public void deletePosition(String p1, com.boat.support.slam.IResponseListener p2)
    {
        this.deleteNavi(p1, p2);
        return;
    }

    public void downLoadMapData(String p4)
    {
        if ((p4 != null) && (!p4.isEmpty())) {
            if ((this.connectStatus) && (this.isNavigationInited)) {
                this.slamDownLoadMapData(p4);
                return;
            } else {
                android.util.Log.d(this.TAG, "downLoadMapData: \u521d\u59cb\u5316\u672a\u6210\u529f \u901a\u77e5\u5e95\u76d8\u4e0b\u8f7d\u5730\u56fe\u6587\u4ef6\u5931\u8d25");
                return;
            }
        } else {
            android.util.Log.d(this.TAG, new StringBuilder().append("downLoadMapData: json\u6570\u636e\u4e3a\u7a7a \u901a\u77e5\u5e95\u76d8\u4e0b\u8f7d\u5730\u56fe\u6587\u4ef6\u5931\u8d25 json\uff1a").append(p4).toString());
            return;
        }
    }

    public com.boat.support.slam.entity.floors.MapList getAllFloor()
    {
        return this.mapList;
    }

    public void getAndUploadBag()
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.getBagListService(new com.jlboat.phone.controller.JlNaviManager$8(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "getAndUploadBag: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 getAndUploadBag ");
            return;
        }
    }

    public void getAndUploadLog()
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.getLogService(new com.jlboat.phone.controller.JlNaviManager$7(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "getAndUploadLog: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 getAndUploadLog ");
            return;
        }
    }

    public void getBag(com.boat.support.slam.IResponseListener p3)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.getBagListService(new com.jlboat.phone.controller.JlNaviManager$9(this, p3));
            return;
        } else {
            android.util.Log.d(this.TAG, "getBag: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 getBag ");
            return;
        }
    }

    public int getBattery()
    {
        this.toast(new StringBuilder().append("currentBattery: ").append(this.currentBattery).toString());
        return this.currentBattery;
    }

    public void getCurrentPositionInfo(com.boat.support.slam.IPositionResult p1)
    {
        this.getLocation(p1);
        return;
    }

    public void getFloor(com.boat.support.slam.IResponseListener p3)
    {
        this.spiritServiceClient.getMapsService(new com.jlboat.phone.controller.JlNaviManager$12(this, p3));
        this.spiritServiceClient.getBuildPointsService(new com.jlboat.phone.controller.JlNaviManager$13(this));
        return;
    }

    public com.boat.support.slam.entity.floors.Floors getLocalFloors()
    {
        return this.floors;
    }

    public java.util.List getLocalMapPoints()
    {
        com.boat.support.slam.entity.floors.Maps v0 = this.getLocalMaps();
        if (v0 == null) {
            return 0;
        } else {
            return v0.getPoints();
        }
    }

    public com.boat.support.slam.entity.floors.Maps getLocalMaps()
    {
        if (this.floors != null) {
            int v0_4 = this.floors.getMaps().iterator();
            while (v0_4.hasNext()) {
                com.boat.support.slam.entity.floors.Maps v1_1 = ((com.boat.support.slam.entity.floors.Maps) v0_4.next());
                if (this.floors.getDefaultmap() == v1_1.getMapId()) {
                    return v1_1;
                }
            }
        }
        return 0;
    }

    public int getMapBuildStatus()
    {
        return this.mapBuildStatus;
    }

    public java.util.List getMapList()
    {
        if (this.floors == null) {
            return 0;
        } else {
            return this.floors.getMaps();
        }
    }

    public void getRosHostname()
    {
        android.util.Log.d(this.TAG, "getRosHostname: \u5f00\u59cb\u67e5\u627e\u7f51\u5361ip");
        try {
            boolean v6_1 = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces()).iterator();
        } catch (boolean v6_3) {
            v6_3.printStackTrace();
            if (!this.hasIP) {
                android.util.Log.d(this.TAG, "getRosHostname: \u672a\u67e5\u627e\u5230 \u4e09\u79d2\u540e\u91cd\u65b0\u67e5\u627e ");
                this.mHandler.sendEmptyMessageDelayed(1, 3000);
                return;
            } else {
                android.util.Log.d(this.TAG, "getRosHostname: \u67e5\u627e\u5230\u7f51\u5361ip");
                this.mHandler.sendEmptyMessage(2);
                return;
            }
        } catch (boolean v6_5) {
            if (!this.hasIP) {
                android.util.Log.d(this.TAG, "getRosHostname: \u672a\u67e5\u627e\u5230 \u4e09\u79d2\u540e\u91cd\u65b0\u67e5\u627e ");
                this.mHandler.sendEmptyMessageDelayed(1, 3000);
            } else {
                android.util.Log.d(this.TAG, "getRosHostname: \u67e5\u627e\u5230\u7f51\u5361ip");
                this.mHandler.sendEmptyMessage(2);
            }
            throw v6_5;
        }
        while (v6_1.hasNext()) {
            java.net.NetworkInterface v7_2 = ((java.net.NetworkInterface) v6_1.next());
            if ((v7_2.isUp()) && (!v7_2.isLoopback())) {
                try {
                    String v9 = com.jlboat.phone.controller.JlNaviManager.newNonLoopbackForNetworkInterface(java.net.NetworkInterface.getByName(v7_2.getName())).getHostAddress();
                } catch (boolean v10) {
                    android.util.Log.d(this.TAG, new StringBuilder().append("init: InetAddressFactoryException: ").append(v9).toString());
                }
                android.util.Log.d(this.TAG, new StringBuilder().append("init: hosthosthost: ").append(v9).toString());
                if (v9.contains(com.jlboat.phone.application.BoatSlamApplication.route_ip)) {
                    this.hasIP = 1;
                }
            }
        }
        if (!this.hasIP) {
        } else {
        }
    }

    public void getVersion(com.boat.support.slam.IResponseListener p3)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.getNaviInfoService(new com.jlboat.phone.controller.JlNaviManager$33(this, p3));
            return;
        } else {
            android.util.Log.d(this.TAG, "getVersion: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 getVersion");
            return;
        }
    }

    public boolean goCharging(com.boat.support.slam.IResponseListener p2)
    {
        this.changeresponseListener = p2;
        this.isInCharging = 1;
        this.setMoveMode(1);
        return 1;
    }

    public void initService()
    {
        this.initTopic();
        this.IssuedCocoNum();
        return;
    }

    public void initTopic()
    {
        this.toast("topic init: ");
        this.spiritTopicListener.getInitMsg(new com.jlboat.phone.controller.JlNaviManager$37(this));
        this.spiritTopicListener.getEMEMsg(new com.jlboat.phone.controller.JlNaviManager$38(this));
        this.spiritTopicListener.getMOROTMsg(new com.jlboat.phone.controller.JlNaviManager$39(this));
        this.spiritTopicListener.getChageMsg(new com.jlboat.phone.controller.JlNaviManager$40(this));
        this.spiritTopicListener.getBattry(new com.jlboat.phone.controller.JlNaviManager$41(this));
        this.spiritTopicListener.getChangeMotionMode(new com.jlboat.phone.controller.JlNaviManager$42(this));
        this.spiritTopicListener.getOutChangeStatus(new com.jlboat.phone.controller.JlNaviManager$43(this));
        this.spiritTopicListener.getOutMachineSignal(new com.jlboat.phone.controller.JlNaviManager$44(this));
        this.spiritTopicListener.getLocationMsg(new com.jlboat.phone.controller.JlNaviManager$45(this));
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.controller.JlNaviManager$46(this));
        this.spiritTopicListener.getNavigationMsg(new com.jlboat.phone.controller.JlNaviManager$47(this));
        this.spiritTopicListener.getNaviToPointName(new com.jlboat.phone.controller.JlNaviManager$48(this));
        this.spiritTopicListener.getNaviTargetGoal(new com.jlboat.phone.controller.JlNaviManager$49(this));
        this.spiritTopicListener.getNaviStopMsg(new com.jlboat.phone.controller.JlNaviManager$50(this));
        this.spiritTopicListener.getAutoChargeStatusMsg(new com.jlboat.phone.controller.JlNaviManager$51(this));
        this.spiritTopicListener.getVirtualMsg(new com.jlboat.phone.controller.JlNaviManager$52(this));
        this.spiritTopicListener.getMapStatus(new com.jlboat.phone.controller.JlNaviManager$53(this));
        this.spiritTopicListener.getMapStatusMsg(new com.jlboat.phone.controller.JlNaviManager$54(this));
        this.spiritTopicListener.getMapBuildStatusMsg(new com.jlboat.phone.controller.JlNaviManager$55(this));
        this.spiritTopicListener.getOutChargeMsg(new com.jlboat.phone.controller.JlNaviManager$56(this));
        this.spiritTopicListener.getLidarMsg(new com.jlboat.phone.controller.JlNaviManager$57(this));
        this.spiritTopicListener.getStm32Msg(new com.jlboat.phone.controller.JlNaviManager$58(this));
        this.spiritTopicListener.getOdomMsg(new com.jlboat.phone.controller.JlNaviManager$59(this));
        this.spiritTopicListener.getNaviNetworkMsg(new com.jlboat.phone.controller.JlNaviManager$60(this));
        this.spiritTopicListener.getImuMsg(new com.jlboat.phone.controller.JlNaviManager$61(this));
        this.spiritTopicListener.getSonarMsg(new com.jlboat.phone.controller.JlNaviManager$62(this));
        this.spiritTopicListener.getMotor1Msg(new com.jlboat.phone.controller.JlNaviManager$63(this));
        this.spiritTopicListener.getMotor2Msg(new com.jlboat.phone.controller.JlNaviManager$64(this));
        this.spiritTopicListener.getLeftMotorMsg(new com.jlboat.phone.controller.JlNaviManager$65(this));
        this.spiritTopicListener.getRightMotorMsg(new com.jlboat.phone.controller.JlNaviManager$66(this));
        this.spiritTopicListener.getCameraMsg(new com.jlboat.phone.controller.JlNaviManager$67(this));
        this.spiritTopicListener.getBatteryMsg(new com.jlboat.phone.controller.JlNaviManager$68(this));
        this.spiritTopicListener.slamDownMapStateMsg(new com.jlboat.phone.controller.JlNaviManager$69(this));
        return;
    }

    public boolean isCharged()
    {
        return this.isCharging;
    }

    public boolean isEmergencyStop()
    {
        return this.isEmergencyStop;
    }

    public boolean isInGoCharging()
    {
        return this.isInCharging;
    }

    public boolean isLocationLoss()
    {
        int v0_1;
        if (this.currentLocationStatus != 9) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public boolean isMotorEnabled()
    {
        return this.isMotorEnabled;
    }

    public boolean isNaviNetWork()
    {
        int v0_1;
        if (this.currentNaviNetWorkStatus != 22) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public boolean isNaviTaskFinished()
    {
        if (!this.mIsTaskFinished) {
            android.util.Log.v(this.TAG, "navigation not stopped");
        }
        if (this.isInCharging) {
            android.util.Log.v(this.TAG, "is in go charging");
        }
        if ((!this.mIsTaskFinished) || (this.isInCharging)) {
            int v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        return v0_3;
    }

    public boolean isNavigationInited()
    {
        if ((!this.connectStatus) || (!this.isNavigationInited)) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public void move(double p1, double p3)
    {
        this.cmd_vel(p1, p3);
        return;
    }

    public void naviTargetGoalPlan(long p17, long p19, long p21, int p23, com.boat.support.slam.IResponseListener p24)
    {
        this.navigationToResponseListener = p24;
        this.toast(new StringBuilder().append("ros\u5bfc\u822a\u4efb\u52a1 naviTargetGoalPlan: name = ").append(p17).append(" , mapid ").append(p19).append(" , pointId ").append(p21).toString());
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.setNaviGoalServiceResponseListener(p17, p19, p21, p23, new com.jlboat.phone.controller.JlNaviManager$15(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "goNavito: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 goNavito");
            if (this.navigationToResponseListener != null) {
                try {
                    this.navigationToResponseListener.onFailed("navigation RemoteException");
                } catch (android.os.RemoteException v0_15) {
                    v0_15.printStackTrace();
                }
            }
            return;
        }
    }

    public void navigationTo(int p5, String p6, String p7, com.boat.support.slam.IResponseListener p8)
    {
        this.navigationToResponseListener = p8;
        com.boat.support.slam.entity.floors.Maps v0 = this.getLocalMaps();
        if ((v0 != null) && (v0.getPoints() != null)) {
            android.os.RemoteException v1_0 = v0.getPoints().iterator();
            while (v1_0.hasNext()) {
                if (((com.boat.support.slam.entity.floors.Points) v1_0.next()).getPointName().equals(p7)) {
                    this.goNavito(p7);
                    this.mIsTaskFinished = 0;
                    this.updateHeadAndLight(1);
                    break;
                }
            }
            if ((this.mIsTaskFinished) && (p8 != null)) {
                try {
                    p8.onFailed("navigation not find positionName");
                } catch (android.os.RemoteException v1_5) {
                    v1_5.printStackTrace();
                }
            }
            return;
        } else {
            if (p8 != null) {
                try {
                    p8.onFailed("navigation not find Positions");
                } catch (android.os.RemoteException v1_7) {
                    v1_7.printStackTrace();
                }
            }
            return;
        }
    }

    public void navigationTo2(String p3)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            com.jlboat.phone.message.map_msgs.SetTargetGoal v0_4 = new com.jlboat.phone.message.map_msgs.SetTargetGoal();
            v0_4.setGoalName(p3);
            this.setTargetGoalPublish.publish(v0_4);
            return;
        } else {
            android.util.Log.d(this.TAG, "navigationTo2: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 navigationTo2");
            return;
        }
    }

    public void onDestroy()
    {
        android.util.Log.d(this.TAG, "onDestroy: ");
        this.getApp().unregisterReceiver(this.mReceiver);
        com.jlboat.phone.controller.JlNaviManager.mCallBack.kill();
        return;
    }

    public void onMapDataListener(int p13, android.graphics.Bitmap p14, double p15, double p17, float p19)
    {
        this.mapDatanItent = new android.content.Intent();
        this.mapDatanItent.setAction("SEND_MESSAGE_WEB_PUBLISH");
        this.mapDataBundle = new android.os.Bundle();
        this.mapDataBundle.putInt("code", p13);
        android.os.Bundle v10 = this.mapDataBundle;
        com.jlboat.phone.controller.JlNaviManager$11 v11 = new com.jlboat.phone.controller.JlNaviManager$11;
        v11(this, p14, p19, p15, p17);
        v10.putBinder("binder_data", v11);
        this.mapDatanItent.putExtras(this.mapDataBundle);
        this.getApp().sendBroadcast(this.mapDatanItent);
        return;
    }

    public void onPathLayerListener(String p5)
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 100;
        android.os.Bundle v1_2 = new android.os.Bundle();
        v1_2.putInt("code", 1004);
        v1_2.putString("data", p5);
        v0_1.setData(v1_2);
        this.mHandler.sendMessage(v0_1);
        return;
    }

    public void onRestart()
    {
        if (!this.mHandler.hasMessages(1000)) {
            this.mHandler.hasMessages(1001);
        }
        return;
    }

    public void onSubMapDataListener(String p5)
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 100;
        android.os.Bundle v1_2 = new android.os.Bundle();
        v1_2.putInt("code", 1001);
        v1_2.putString("data", p5);
        v0_1.setData(v1_2);
        this.mHandler.sendMessage(v0_1);
        return;
    }

    public void onTFDataListener(String p5)
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 100;
        android.os.Bundle v1_2 = new android.os.Bundle();
        v1_2.putInt("code", 1002);
        v1_2.putString("data", p5);
        v0_1.setData(v1_2);
        this.mHandler.sendMessage(v0_1);
        return;
    }

    public void reNameMap(String p3, String p4)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            return;
        } else {
            android.util.Log.d(this.TAG, "reNameMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 reNameMap");
            return;
        }
    }

    public void reachPointStatus(boolean p4)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            android.util.Log.d(this.TAG, new StringBuilder().append("reachPointStatus: isStart = ").append(p4).toString());
            com.boat.jrosbridge.message.std_msgs.Int16 v0_2 = new com.boat.jrosbridge.message.std_msgs.Int16();
            v0_2.setData(((short) p4));
            this.reachPointStatus.publish(v0_2);
            return;
        } else {
            android.util.Log.d(this.TAG, "reachPointStatus: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u53d1\u8d77\u5230\u70b9io");
            return;
        }
    }

    public void recordBag(int p5, String p6, java.util.List p7)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            switch (p5) {
                case 1:
                    this.pubRecordBagListener.setType(p5, p6, p7);
                    break;
                default:
                    this.pubRecordBagListener.setType(p5);
            }
            if (p5 == 4) {
                this.mHandler.postDelayed(new com.jlboat.phone.controller.JlNaviManager$10(this), 1000);
            }
            return;
        } else {
            android.util.Log.d(this.TAG, "recordBag: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 recordBag ");
            return;
        }
    }

    public void registerCallback(com.boat.support.slam.ISlamCallBack p3)
    {
        try {
            com.jlboat.phone.controller.JlNaviManager.mCallBack.register(p3);
            return;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }

    public void relocation(double p23, double p25, double p27)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            android.util.Log.d(this.TAG, new StringBuilder().append("relocation:  yaw = ").append(p27).toString());
            String v1_1 = new com.jlboat.phone.util.EulerAngles;
            v1_1(0, p27, 0);
            String v1_2 = v1_1.ToQuaternion();
            this.spiritServiceClient.relocation(p23, p25, v1_2.z, v1_2.w, new com.jlboat.phone.controller.JlNaviManager$31(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "relocation: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 relocation ");
            return;
        }
    }

    public void requestData1(int p3)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            switch (p3) {
                case 1000:
                    this.isAllMapData = 1;
                    if (!this.mHandler.hasMessages(1000)) {
                        this.mHandler.sendEmptyMessage(1000);
                    }
                    return;
                case 1001:
                    this.isMapData = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1002:
                    this.isPose = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1003:
                    this.isScan = 1;
                    break;
                case 1004:
                    this.isGPlan = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1011:
                    this.isInit = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1012:
                    this.isMapStatus = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1013:
                    this.isMapUpdate = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1015:
                    this.islocalPointUpdate = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1021:
                    this.isNaviStatus = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1022:
                    this.isNaviToPoint = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                case 1031:
                    this.isPower = 1;
                    if (this.mHandler.hasMessages(p3)) {
                    } else {
                        this.mHandler.sendEmptyMessage(p3);
                    }
                    break;
                default:
            }
            return;
        } else {
            android.util.Log.d(this.TAG, "requestData1: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 requestData1");
            return;
        }
    }

    public void requestString(String p4, String p5)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            com.boat.support.slam.entity.floors.NLine v0_5;
            android.util.Log.d(this.TAG, new StringBuilder().append("requestString: \u8bf7\u6c42\u7684\u5355\u6b21\u6570\u636e\u7c7b\u578b ").append(p4).toString());
            switch (p4.hashCode()) {
                case -1473136522:
                    if (!p4.equals("requestRobotNGlobalplansConfig")) {
                        v0_5 = -1;
                    } else {
                        v0_5 = 0;
                    }
                    break;
                case -1099079617:
                    if (!p4.equals("requestRobotNGlobalplan")) {
                    } else {
                        v0_5 = 2;
                    }
                    break;
                case -721558305:
                    if (!p4.equals("requestRobotUpdateNGlobalplansConfig")) {
                    } else {
                        v0_5 = 1;
                    }
                    break;
                default:
            }
            switch (v0_5) {
                case 0:
                    this.getDefDiyLineConfig();
                    break;
                case 1:
                    try {
                        com.boat.support.slam.entity.floors.NLine v0_12 = ((com.boat.support.slam.entity.floors.NLine) new com.google.gson.Gson().fromJson(p5, new com.jlboat.phone.controller.JlNaviManager$35(this).getType()));
                    } catch (Exception v1_13) {
                        v1_13.printStackTrace();
                    }
                    if (v0_12 == null) {
                    } else {
                        this.uodateDiyLineConfig(v0_12);
                    }
                    break;
                case 2:
                    try {
                        com.boat.support.slam.entity.floors.NLine v0_11 = ((com.boat.support.slam.entity.floors.NLine) new com.google.gson.Gson().fromJson(p5, new com.jlboat.phone.controller.JlNaviManager$36(this).getType()));
                    } catch (Exception v1_6) {
                        v1_6.printStackTrace();
                    }
                    if (v0_11 == null) {
                    } else {
                        this.addNGPointLine(v0_11);
                    }
                    break;
                default:
            }
            return;
        } else {
            android.util.Log.d(this.TAG, new StringBuilder().append("requestString: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42  requesType : ").append(p4).toString());
            return;
        }
    }

    public void robotSsh(String p3)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            android.util.Log.d(this.TAG, "onSuccess:reboot ");
            this.spiritServiceClient.robotSshService(p3, new com.jlboat.phone.controller.JlNaviManager$4(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "robotSsh: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 robotSsh");
            return;
        }
    }

    public void saveEraseMap()
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.saveEraseMapService(new com.jlboat.phone.controller.JlNaviManager$19(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "saveMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 saveEraseMap");
            return;
        }
    }

    public void saveMap(String p3)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            return;
        } else {
            android.util.Log.d(this.TAG, "saveMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 saveMap");
            return;
        }
    }

    public void setErase(double p3, double p5)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            com.jlboat.phone.message.map_msgs.ErasePose v0_4 = new com.jlboat.phone.message.map_msgs.ErasePose();
            v0_4.setX(p3);
            v0_4.setY(p5);
            this.erasePoseTopic.publish(v0_4);
            return;
        } else {
            android.util.Log.d(this.TAG, "clearMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 setErase");
            return;
        }
    }

    public void setEraseMode(int p3, com.boat.support.slam.IResponseListener p4)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.setEraseModeService(p3, new com.jlboat.phone.controller.JlNaviManager$18(this, p4));
            return;
        } else {
            android.util.Log.d(this.TAG, "clearMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 setEraseMode");
            return;
        }
    }

    public void setInCharging(boolean p1)
    {
        this.isInCharging = p1;
        return;
    }

    public void setLocationAuto()
    {
        this.spiritServiceClient.setScaleTestService(0, 3, new com.jlboat.phone.controller.JlNaviManager$70(this));
        return;
    }

    public void setLocationCorrect(int p5)
    {
        if (this.currentposeLocationmiss == null) {
            this.currentposeLocationmiss = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.CurrentposeLocationmiss, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
            this.currentposeLocationmiss.advertise();
        }
        com.boat.jrosbridge.message.std_msgs.Int16 v0_2 = new com.boat.jrosbridge.message.std_msgs.Int16();
        v0_2.setData(((short) p5));
        this.currentposeLocationmiss.publish(v0_2);
        return;
    }

    public void setMapReBuild()
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.rebuildMapService(new com.jlboat.phone.controller.JlNaviManager$17(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "clearMap: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 setMapReBuild");
            return;
        }
    }

    public void setNavicmd(int p7, int p8)
    {
        this.isInCharging = 0;
        this.mIsTaskFinished = 1;
        if (p8 < 0) {
            p8 = (- p8);
        }
        this.spiritServiceClient.setNavicmdListener(new StringBuilder().append(p7).append("").toString(), ((long) p8), new com.jlboat.phone.controller.JlNaviManager$24(this, p7, p8));
        return;
    }

    public void setOutofChange()
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            com.boat.jrosbridge.message.std_msgs.Int16 v0_4 = new com.boat.jrosbridge.message.std_msgs.Int16();
            v0_4.setData(1);
            this.outofChange.publish(v0_4);
            return;
        } else {
            android.util.Log.d(this.TAG, "setOutofChange: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u51fa\u6869");
            return;
        }
    }

    public void setShapArea(com.boat.support.slam.entity.floors.ShapeAreas p4, com.boat.support.slam.IResponseListener p5)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            if (p4 != null) {
                world_canvas_msgs18.SetShapeRequestEnty v0_4 = new world_canvas_msgs18.SetShapeRequestEnty();
                v0_4.setShapeId(p4.getShapeId());
                v0_4.setClosed(p4.getClosed());
                v0_4.setType(p4.getType());
                v0_4.setPoints(p4.getLines());
                v0_4.setRadius(((float) p4.getCircle().getRadius()));
                this.spiritServiceClient.addOrDelShapeServer(v0_4, new com.jlboat.phone.controller.JlNaviManager$21(this, p4, p5));
            }
            return;
        } else {
            android.util.Log.d(this.TAG, "setShapArea: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 setShapArea");
            return;
        }
    }

    public void setWarnLedStatus(boolean p3)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            com.boat.jrosbridge.message.std_msgs.Int16 v0_4 = new com.boat.jrosbridge.message.std_msgs.Int16();
            v0_4.setData(((short) p3));
            this.warnLedStatus.publish(v0_4);
            return;
        } else {
            android.util.Log.d(this.TAG, "setWarnLedStatus: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8bbe\u7f6e\u8702\u9e23\u5668");
            return;
        }
    }

    public void setWifiConfig(String p3, String p4)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            this.spiritServiceClient.setWifiServiceResponseListener(p3, p4, new com.jlboat.phone.controller.JlNaviManager$23(this));
            return;
        } else {
            android.util.Log.d(this.TAG, "setWifiConfig: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u80fd\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 setWifiConfig");
            return;
        }
    }

    public void startBootHTTPService(String p4)
    {
        this.toast("start service");
        android.content.Intent v0_2 = new android.content.Intent();
        v0_2.setClassName("com.boat.push", "com.boat.service.PushHttpService");
        v0_2.setAction("com.boat.push.action.map_config");
        v0_2.putExtra("com.boat.push.action.map_config_key", p4);
        this.getApp().startService(v0_2);
        return;
    }

    public void stopNavigation()
    {
        android.util.Log.d(this.TAG, "stopNavigation: ");
        if ((this.connectStatus) && (this.isNavigationInited)) {
            if (this.changeresponseListener != null) {
                try {
                    this.changeresponseListener.onSuccess("stop");
                    this.changeresponseListener = 0;
                } catch (android.os.RemoteException v0_2) {
                    v0_2.printStackTrace();
                }
            }
            this.setNavicmd(5, 0);
            return;
        } else {
            android.util.Log.d(this.TAG, "stopNavigation: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u80fd\u505c\u6b62\u547d\u4ee4 stopNavigation");
            return;
        }
    }

    public void stopRequestData(int p4)
    {
        if ((this.connectStatus) && (this.isNavigationInited)) {
            android.util.Log.d(this.TAG, new StringBuilder().append("stopRequestData: \u4e3b\u52a8\u505c\u6b62\u53d1\u5e03\u6570\u636e ").append(p4).toString());
            if (this.mHandler.hasMessages(p4)) {
                this.mHandler.removeMessages(p4);
            }
            switch (p4) {
                case 1000:
                    this.mapLisener.onStop();
                    this.isAllMapDataEnd = 1;
                    break;
                case 1001:
                    this.mapLisener.onStop();
                    this.isMapDataEnd = 1;
                    break;
                case 1002:
                    this.tfPoseListener.onStop();
                    this.isPoseEnd = 1;
                    break;
                case 1003:
                    this.isScanEnd = 1;
                    break;
                case 1004:
                    this.pathLayerLisener.onStop();
                    this.isGPlanEnd = 1;
                    break;
                case 1011:
                    this.isInitEnd = 1;
                    break;
                case 1012:
                    this.isMapStatusEnd = 1;
                    break;
                case 1013:
                    this.isMapUpdateEnd = 1;
                    break;
                case 1015:
                    this.islocalPointUpdateEnd = 1;
                    break;
                case 1021:
                    this.isNaviStatusUpdateEnd = 1;
                    break;
                case 1022:
                    this.isNaviToPointUpdateEnd = 1;
                    break;
                case 1031:
                    this.isPowerUpdateEnd = 1;
                    break;
                default:
            }
            return;
        } else {
            android.util.Log.d(this.TAG, "stopRequestData: \u521d\u59cb\u5316\u672a\u6210\u529f \u4e0d\u53ef\u4ee5\u8fdb\u884c\u6570\u636e\u8bf7\u6c42 stopRequestData");
            return;
        }
    }

    public void toast(int p2)
    {
        this.toast(this.getApp().getResources().getString(p2));
        return;
    }

    public void toast(String p4)
    {
        android.util.Log.d(this.TAG, new StringBuilder().append("toast: ").append(p4).toString());
        return;
    }

    public void unregisterCallback(com.boat.support.slam.ISlamCallBack p3)
    {
        try {
            com.jlboat.phone.controller.JlNaviManager.mCallBack.unregister(p3);
            return;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }

    public void updateMap(String p1, boolean p2)
    {
        this.changeMap(p1);
        return;
    }
}
