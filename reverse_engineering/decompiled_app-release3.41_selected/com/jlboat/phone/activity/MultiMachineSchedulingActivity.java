package com.jlboat.phone.activity;
public class MultiMachineSchedulingActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MultiMachineSchedulingActivity";
    private int anInt;
    private java.util.List configList;
    private java.util.List configList2;
    private android.os.Handler handler;
    private double initDistance;
    private int initLevel;
    private android.widget.EditText robotMultiDistanceBt;
    private android.widget.EditText robotMultiLevelBt;
    private android.widget.Switch robotMultiOpenSw;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    public MultiMachineSchedulingActivity()
    {
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.configList = new java.util.LinkedList();
        this.configList2 = new java.util.LinkedList();
        this.anInt = 0;
        this.handler = new com.jlboat.phone.activity.MultiMachineSchedulingActivity$5(this);
        return;
    }

    static synthetic java.util.List access$000(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        return p1.configList2;
    }

    static synthetic com.jlboat.phone.communication.StatusServiceClient access$100(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        return p1.statusServiceClient;
    }

    static synthetic int access$204(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        int v0_1 = (p1.anInt + 1);
        p1.anInt = v0_1;
        return v0_1;
    }

    static synthetic java.util.List access$300(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        return p1.configList;
    }

    static synthetic android.widget.Switch access$400(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        return p1.robotMultiOpenSw;
    }

    static synthetic android.os.Handler access$500(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        return p1.handler;
    }

    static synthetic double access$602(com.jlboat.phone.activity.MultiMachineSchedulingActivity p0, double p1)
    {
        p0.initDistance = p1;
        return p1;
    }

    static synthetic android.widget.EditText access$700(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        return p1.robotMultiDistanceBt;
    }

    static synthetic int access$800(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        return p1.initLevel;
    }

    static synthetic int access$802(com.jlboat.phone.activity.MultiMachineSchedulingActivity p0, int p1)
    {
        p0.initLevel = p1;
        return p1;
    }

    static synthetic android.widget.EditText access$900(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        return p1.robotMultiLevelBt;
    }

    private void setConfig(java.util.List p3, int p4)
    {
        this.statusServiceClient.setOrDelConfigsService(p3, p4, new com.jlboat.phone.activity.MultiMachineSchedulingActivity$4(this, p4));
        return;
    }

    public void getConfigs(int p3)
    {
        this.statusServiceClient.getConfigsService(p3, new com.jlboat.phone.activity.MultiMachineSchedulingActivity$3(this, p3));
        return;
    }

    synthetic void lambda$onResume$0$com-jlboat-phone-activity-MultiMachineSchedulingActivity()
    {
        this.getConfigs(1);
        return;
    }

    public void onClick(android.view.View p5)
    {
        if ((p5.getId() == 2131231204) && (this.configList.size() > 0)) {
            ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigName("startRobotOA");
            android.util.Log.d("MultiMachineSchedulingActivity", new StringBuilder().append("robotMultiOpenSw.isChecked():").append(this.robotMultiOpenSw.isChecked()).toString());
            if (!this.robotMultiOpenSw.isChecked()) {
                ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigValue("0");
            } else {
                ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigValue("1");
            }
            this.setConfig(this.configList, 9);
        }
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.initTitleBar(2131361902, 2131493094);
        this.robotMultiOpenSw = ((android.widget.Switch) this.findViewById(2131231204));
        this.robotMultiDistanceBt = ((android.widget.EditText) this.findViewById(2131231202));
        this.robotMultiLevelBt = ((android.widget.EditText) this.findViewById(2131231203));
        this.robotMultiDistanceBt.setImeOptions(6);
        this.robotMultiLevelBt.setImeOptions(6);
        this.robotMultiDistanceBt.setOnClickListener(this);
        this.robotMultiLevelBt.setOnClickListener(this);
        this.robotMultiOpenSw.setOnClickListener(this);
        this.robotMultiDistanceBt.addTextChangedListener(new com.jlboat.phone.activity.MultiMachineSchedulingActivity$1(this));
        this.robotMultiLevelBt.addTextChangedListener(new com.jlboat.phone.activity.MultiMachineSchedulingActivity$2(this));
        android.util.Log.d("MultiMachineSchedulingActivity", "onCreate: ");
        return;
    }

    public void onPointerCaptureChanged(boolean p1)
    {
        super.onPointerCaptureChanged(p1);
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.robotMultiOpenSw.setEnabled(0);
        this.getConfigs(9);
        new android.os.Handler().postDelayed(new com.jlboat.phone.activity.MultiMachineSchedulingActivity$$ExternalSyntheticLambda0(this), 100);
        return;
    }
}
