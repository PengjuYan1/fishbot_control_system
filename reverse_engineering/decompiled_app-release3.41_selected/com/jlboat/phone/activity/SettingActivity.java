package com.jlboat.phone.activity;
public class SettingActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private String TAG;
    private android.widget.TextView appVersion;
    private android.widget.RadioButton bt_higcream;
    private android.widget.RadioButton bt_higpoint;
    private android.widget.RadioButton bt_higsafe;
    private android.widget.RadioButton bt_higspeed;
    private android.widget.RadioButton bt_lowcream;
    private android.widget.RadioButton bt_lowpoint;
    private android.widget.RadioButton bt_lowsafe;
    private android.widget.RadioButton bt_lowspeed;
    private android.widget.RadioButton bt_medsafe;
    private android.widget.RadioButton bt_medspeed;
    private java.util.List configList;
    private java.util.List configList2;
    private int coulomb;
    int count;
    private android.os.Handler handler;
    private final int handlerAboutRobot;
    private final int handlerDismissWaitingDialog;
    private final int handlerReflashCream;
    private final int handlerReflashSafe;
    private final int handlerReflashSonal;
    private final int handlerReflashSpeed;
    private final int handlerShowWaitingDialog;
    private int initPower;
    private android.widget.RadioButton qs_higspeed;
    private android.widget.RadioButton qs_lowspeed;
    private android.widget.RadioButton qs_medspeed;
    private com.boat.jrosbridge.Topic resetParamsPublish;
    private android.widget.RelativeLayout rl_robotVersionName;
    private android.widget.EditText robotAutoChangePowerBt;
    private android.widget.EditText robotAutoWorkPowerBt;
    private android.widget.TextView robotCocoNum;
    private long robotCream;
    private android.widget.TextView robotDriverName;
    private android.widget.EditText robotLedWarnTimeBt;
    private long robotSafe;
    private android.widget.TextView robotSlam;
    private long robotSpeed;
    private android.widget.Switch robotUpdateSw;
    private android.widget.TextView robotVersionName;
    private android.widget.TextView robotVersionNum;
    private android.widget.Button robot_calibration;
    private android.widget.Button robot_config_bt;
    private android.widget.Button robot_wifi_bt;
    private android.widget.TextView robotchann;
    private android.widget.Button set_sonar;
    private java.util.List sonarEntryList;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    long time;
    private android.app.ProgressDialog waitingDialog;

    public SettingActivity()
    {
        this.TAG = "SettingActivity";
        this.count = 0;
        this.time = 0;
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.sonarEntryList = new java.util.ArrayList();
        this.robotSpeed = 0;
        this.robotSafe = -1;
        this.robotCream = 2;
        this.coulomb = 0;
        this.handlerDismissWaitingDialog = 0;
        this.handlerShowWaitingDialog = 1;
        this.handlerReflashSpeed = 2;
        this.handlerReflashSafe = 3;
        this.handlerReflashSonal = 4;
        this.handlerAboutRobot = 5;
        this.handlerReflashCream = 6;
        this.configList = new java.util.LinkedList();
        this.configList2 = new java.util.LinkedList();
        this.handler = new com.jlboat.phone.activity.SettingActivity$11(this);
        return;
    }

    static synthetic String access$000(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.TAG;
    }

    static synthetic java.util.List access$100(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.configList;
    }

    static synthetic android.widget.EditText access$1000(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.robotAutoWorkPowerBt;
    }

    static synthetic android.widget.RadioButton access$1100(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.bt_lowspeed;
    }

    static synthetic android.widget.RadioButton access$1200(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.bt_medspeed;
    }

    static synthetic android.widget.RadioButton access$1300(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.bt_higspeed;
    }

    static synthetic android.widget.RadioButton access$1400(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.qs_lowspeed;
    }

    static synthetic android.widget.RadioButton access$1500(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.qs_medspeed;
    }

    static synthetic android.widget.RadioButton access$1600(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.qs_higspeed;
    }

    static synthetic void access$1700(com.jlboat.phone.activity.SettingActivity p0)
    {
        p0.updateSpeed();
        return;
    }

    static synthetic android.widget.RadioButton access$1800(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.bt_lowcream;
    }

    static synthetic android.widget.RadioButton access$1900(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.bt_higcream;
    }

    static synthetic void access$200(com.jlboat.phone.activity.SettingActivity p0)
    {
        p0.safeDismissWaitingDialog();
        return;
    }

    static synthetic void access$2000(com.jlboat.phone.activity.SettingActivity p0)
    {
        p0.updateCream();
        return;
    }

    static synthetic android.widget.RadioButton access$2100(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.bt_lowsafe;
    }

    static synthetic android.widget.RadioButton access$2200(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.bt_higsafe;
    }

    static synthetic void access$2300(com.jlboat.phone.activity.SettingActivity p0)
    {
        p0.updateSafe();
        return;
    }

    static synthetic android.widget.RadioButton access$2400(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.bt_medsafe;
    }

    static synthetic void access$2500(com.jlboat.phone.activity.SettingActivity p0, CharSequence p1, CharSequence p2)
    {
        p0.showWaitingDialog(p1, p2);
        return;
    }

    static synthetic com.boat.jrosbridge.Topic access$2600(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.resetParamsPublish;
    }

    static synthetic long access$300(com.jlboat.phone.activity.SettingActivity p2)
    {
        return p2.robotSpeed;
    }

    static synthetic long access$302(com.jlboat.phone.activity.SettingActivity p0, long p1)
    {
        p0.robotSpeed = p1;
        return p1;
    }

    static synthetic android.os.Handler access$400(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.handler;
    }

    static synthetic long access$500(com.jlboat.phone.activity.SettingActivity p2)
    {
        return p2.robotCream;
    }

    static synthetic long access$502(com.jlboat.phone.activity.SettingActivity p0, long p1)
    {
        p0.robotCream = p1;
        return p1;
    }

    static synthetic long access$600(com.jlboat.phone.activity.SettingActivity p2)
    {
        return p2.robotSafe;
    }

    static synthetic long access$602(com.jlboat.phone.activity.SettingActivity p0, long p1)
    {
        p0.robotSafe = p1;
        return p1;
    }

    static synthetic android.widget.Switch access$700(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.robotUpdateSw;
    }

    static synthetic int access$802(com.jlboat.phone.activity.SettingActivity p0, int p1)
    {
        p0.initPower = p1;
        return p1;
    }

    static synthetic android.widget.EditText access$900(com.jlboat.phone.activity.SettingActivity p1)
    {
        return p1.robotAutoChangePowerBt;
    }

    private void dismissWaitingDialog()
    {
        if (this.waitingDialog != null) {
            this.waitingDialog.dismiss();
            this.waitingDialog = 0;
        }
        return;
    }

    private String floatToString(float p5)
    {
        try {
            String v0 = new java.text.DecimalFormat("0.00").format(((double) p5));
        } catch (Exception v1) {
        }
        return v0;
    }

    private void init()
    {
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        try {
            this.appVersion.setText(new StringBuilder().append("v").append(this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName).toString());
        } catch (android.content.pm.PackageManager$NameNotFoundException v0_2) {
            v0_2.printStackTrace();
        }
        return;
    }

    private void robotSsh(String p3)
    {
        android.util.Log.d(this.TAG, "onSuccess:reboot ");
        this.spiritServiceClient.robotSshService(p3, new com.jlboat.phone.activity.SettingActivity$15(this));
        return;
    }

    private void safeDismissWaitingDialog()
    {
        this.handler.sendEmptyMessage(0);
        return;
    }

    private void safeShowWaitingDialog(CharSequence p5, CharSequence p6)
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 1;
        Object[] v2_1 = new Object[2];
        v2_1[0] = p5;
        v2_1[1] = p6;
        v0_1.obj = v2_1;
        this.handler.sendMessage(v0_1);
        return;
    }

    private void setConfig(java.util.List p3, int p4)
    {
        this.statusServiceClient.setOrDelConfigsService(p3, p4, new com.jlboat.phone.activity.SettingActivity$7(this));
        return;
    }

    private void setCream(long p4)
    {
        android.util.Log.e(this.TAG, new StringBuilder().append("setCream").append(p4).toString());
        this.statusServiceClient.setCreamService(p4, new com.jlboat.phone.activity.SettingActivity$9(this, p4));
        return;
    }

    private void setSafe(long p3)
    {
        this.statusServiceClient.setSfaeService(p3, new com.jlboat.phone.activity.SettingActivity$10(this));
        return;
    }

    private void setSpeed(long p3)
    {
        this.statusServiceClient.setSpeedService(p3, new com.jlboat.phone.activity.SettingActivity$8(this));
        return;
    }

    private void setText()
    {
        if (com.jlboat.phone.application.BoatSlamApplication.has_nav_info) {
            this.robotVersionName.setText(com.jlboat.phone.application.BoatSlamApplication.classis_version_name);
            this.robotDriverName.setText(com.jlboat.phone.application.BoatSlamApplication.classis_driver_version_name);
            this.robotSlam.setText(com.jlboat.phone.application.BoatSlamApplication.classis_carto_version_name);
            this.robotCocoNum.setText(new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.coco_num_pc).append("").toString());
            this.robotVersionNum.setText(new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.classis_numero).append("").toString());
            this.robotchann.setText(com.jlboat.phone.application.BoatSlamApplication.classis_channel);
        }
        return;
    }

    private void showWaitingDialog(CharSequence p3, CharSequence p4)
    {
        this.waitingDialog = android.app.ProgressDialog.show(this, p3, p4, 1);
        this.waitingDialog.setProgressStyle(0);
        return;
    }

    private void updateCream()
    {
        this.statusServiceClient.getCreamService(new com.jlboat.phone.activity.SettingActivity$4(this));
        return;
    }

    private void updateSafe()
    {
        this.statusServiceClient.getSfaeService(new com.jlboat.phone.activity.SettingActivity$5(this));
        return;
    }

    private void updateSpeed()
    {
        this.statusServiceClient.getSpeedService(new com.jlboat.phone.activity.SettingActivity$3(this));
        return;
    }

    public void getConfigs(int p3)
    {
        android.util.Log.e(this.TAG, "getConfigs");
        this.statusServiceClient.getConfigsService(p3, new com.jlboat.phone.activity.SettingActivity$6(this));
        return;
    }

    public void onClick(android.view.View p10)
    {
        int v0 = p10.getId();
        if (v0 != 2131230817) {
            if (v0 != 2131230819) {
                if (v0 != 2131230811) {
                    if (v0 != 2131231112) {
                        if (v0 != 2131231113) {
                            if (v0 != 2131231111) {
                                if (v0 != 2131230816) {
                                    if (v0 != 2131230818) {
                                        if (v0 != 2131230810) {
                                            if (v0 != 2131230814) {
                                                if (v0 != 2131230808) {
                                                    if (v0 != 2131231196) {
                                                        if (v0 == 2131231211) {
                                                            this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.RobotWifiActivity));
                                                        }
                                                    } else {
                                                        this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.RobotCalibrationActivity));
                                                    }
                                                } else {
                                                    this.setCream(1);
                                                }
                                            } else {
                                                this.setCream(0);
                                            }
                                        } else {
                                            this.setSafe(2);
                                        }
                                    } else {
                                        this.setSafe(1);
                                    }
                                } else {
                                    this.setSafe(0);
                                }
                            } else {
                                this.setSpeed(6);
                            }
                        } else {
                            this.setSpeed(5);
                        }
                    } else {
                        this.setSpeed(4);
                    }
                } else {
                    this.setSpeed(3);
                }
            } else {
                this.setSpeed(2);
            }
        } else {
            this.setSpeed(1);
        }
        if (v0 == 2131231205) {
            android.content.Intent v1_26 = new android.app.AlertDialog$Builder(this);
            v1_26.setTitle(new StringBuilder().append(this.getResString(2131493006)).append(" ").append(this.getResString(2131493016)).toString());
            v1_26.setPositiveButton(2131493023, new com.jlboat.phone.activity.SettingActivity$12(this));
            v1_26.setNegativeButton(2131493007, new com.jlboat.phone.activity.SettingActivity$13(this));
            v1_26.show();
        }
        if (v0 == 2131231183) {
            android.content.Intent v1_29 = System.currentTimeMillis();
            if ((v1_29 - this.time) >= 800) {
                this.count = 1;
            } else {
                this.count = (this.count + 1);
            }
            this.time = v1_29;
            if (this.count >= 3) {
                this.count = 0;
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.BasicSettingActivity));
            }
        }
        if (v0 == 2131231210) {
            android.content.Intent v1_3 = this.configList.iterator();
            while (v1_3.hasNext()) {
                Class v2_3 = ((com.jlboat.phone.message.map_msgs.Config) v1_3.next());
                if (v2_3.getConfigName().equals("startAutoupgrade")) {
                    if (!this.robotUpdateSw.isChecked()) {
                        v2_3.setConfigValue("False");
                    } else {
                        v2_3.setConfigValue("True");
                    }
                }
            }
            this.setConfig(this.configList, 9);
        }
        return;
    }

    public void onCreate(android.os.Bundle p4)
    {
        super.onCreate(p4);
        this.initTitleBar(2131361828, 2131493347);
        this.set_sonar = ((android.widget.Button) this.findViewById(2131231249));
        this.robot_config_bt = ((android.widget.Button) this.findViewById(2131231205));
        this.robot_wifi_bt = ((android.widget.Button) this.findViewById(2131231211));
        this.robot_calibration = ((android.widget.Button) this.findViewById(2131231196));
        this.bt_lowspeed = ((android.widget.RadioButton) this.findViewById(2131230817));
        this.bt_medspeed = ((android.widget.RadioButton) this.findViewById(2131230819));
        this.bt_higspeed = ((android.widget.RadioButton) this.findViewById(2131230811));
        this.bt_lowsafe = ((android.widget.RadioButton) this.findViewById(2131230816));
        this.bt_medsafe = ((android.widget.RadioButton) this.findViewById(2131230818));
        this.bt_higsafe = ((android.widget.RadioButton) this.findViewById(2131230810));
        this.bt_lowcream = ((android.widget.RadioButton) this.findViewById(2131230814));
        this.bt_higcream = ((android.widget.RadioButton) this.findViewById(2131230808));
        this.bt_lowpoint = ((android.widget.RadioButton) this.findViewById(2131230815));
        this.bt_higpoint = ((android.widget.RadioButton) this.findViewById(2131230809));
        this.qs_lowspeed = ((android.widget.RadioButton) this.findViewById(2131231112));
        this.qs_medspeed = ((android.widget.RadioButton) this.findViewById(2131231113));
        this.qs_higspeed = ((android.widget.RadioButton) this.findViewById(2131231111));
        this.robotUpdateSw = ((android.widget.Switch) this.findViewById(2131231210));
        this.robotDriverName = ((android.widget.TextView) this.findViewById(2131231197));
        this.appVersion = ((android.widget.TextView) this.findViewById(2131230767));
        this.robotSlam = ((android.widget.TextView) this.findViewById(2131231207));
        this.rl_robotVersionName = ((android.widget.RelativeLayout) this.findViewById(2131231183));
        this.robotCocoNum = ((android.widget.TextView) this.findViewById(2131231188));
        this.robotVersionNum = ((android.widget.TextView) this.findViewById(2131231190));
        this.robotVersionName = ((android.widget.TextView) this.findViewById(2131231189));
        this.robotchann = ((android.widget.TextView) this.findViewById(2131231212));
        this.robotAutoChangePowerBt = ((android.widget.EditText) this.findViewById(2131231192));
        this.robotAutoWorkPowerBt = ((android.widget.EditText) this.findViewById(2131231193));
        this.robotLedWarnTimeBt = ((android.widget.EditText) this.findViewById(2131231199));
        this.robotAutoChangePowerBt.setImeOptions(6);
        this.robotAutoChangePowerBt.addTextChangedListener(new com.jlboat.phone.activity.SettingActivity$1(this));
        this.robotAutoWorkPowerBt.setImeOptions(6);
        this.robotAutoWorkPowerBt.addTextChangedListener(new com.jlboat.phone.activity.SettingActivity$2(this));
        this.rl_robotVersionName.setOnClickListener(this);
        this.robotUpdateSw.setOnClickListener(this);
        this.bt_lowspeed.setOnClickListener(this);
        this.bt_medspeed.setOnClickListener(this);
        this.bt_higspeed.setOnClickListener(this);
        this.bt_lowsafe.setOnClickListener(this);
        this.bt_medsafe.setOnClickListener(this);
        this.bt_higsafe.setOnClickListener(this);
        this.bt_lowcream.setOnClickListener(this);
        this.bt_higcream.setOnClickListener(this);
        this.bt_lowpoint.setOnClickListener(this);
        this.bt_higpoint.setOnClickListener(this);
        this.robot_config_bt.setOnClickListener(this);
        this.robot_wifi_bt.setOnClickListener(this);
        this.robot_calibration.setOnClickListener(this);
        this.qs_lowspeed.setOnClickListener(this);
        this.qs_medspeed.setOnClickListener(this);
        this.qs_higspeed.setOnClickListener(this);
        this.init();
        this.setText();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.resetParamsPublish.unadvertise();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.robotUpdateSw.setEnabled(0);
        this.getConfigs(9);
        this.updateSpeed();
        this.updateSafe();
        this.updateCream();
        this.resetParamsPublish = new com.boat.jrosbridge.Topic("reset_params", com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.resetParamsPublish.advertise();
        return;
    }

    public void toast(String p2)
    {
        this.runOnUiThread(new com.jlboat.phone.activity.SettingActivity$14(this, p2));
        return;
    }
}
