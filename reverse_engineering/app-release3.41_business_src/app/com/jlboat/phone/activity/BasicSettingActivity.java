package com.jlboat.phone.activity;
public class BasicSettingActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private String TAG;
    private com.jlboat.phone.fragment.settingfragment.DwaPlannerFragment dwaPlannerFragment;
    private java.util.List dwa_planner;
    private com.jlboat.phone.fragment.settingfragment.GlobalCostFragment globalCostFragment;
    private java.util.List global_cost;
    private android.os.Handler handler;
    private final int handlerDismissWaitingDialog;
    private final int handlerReflashSonal;
    private final int handlerReflashSpeed;
    private final int handlerShowWaitingDialog;
    private com.jlboat.phone.fragment.settingfragment.LocalCostFragment localCostFragment;
    private java.util.List local_cost;
    private android.widget.RadioGroup mGroup;
    private android.support.v4.view.ViewPager mPager;
    private com.jlboat.phone.fragment.settingfragment.MapServerFragment mapServerFragment;
    private java.util.List map_server;
    private com.jlboat.phone.fragment.settingfragment.MoveBaseFragment moveBaseFragment;
    private java.util.List move_base;
    private com.jlboat.phone.fragment.settingfragment.NavFnRosFragment navFnRosFragment;
    private java.util.List navfn_ros;
    private com.jlboat.phone.fragment.settingfragment.RobotDriverFragment robotDriverFragment;
    private java.util.List robot_driver;
    public com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    private android.app.ProgressDialog waitingDialog;

    public BasicSettingActivity()
    {
        this.TAG = "SettingActivity";
        this.handlerDismissWaitingDialog = 0;
        this.handlerShowWaitingDialog = 4;
        this.handlerReflashSpeed = 2;
        this.handlerReflashSonal = 3;
        this.move_base = new java.util.LinkedList();
        this.global_cost = new java.util.LinkedList();
        this.navfn_ros = new java.util.LinkedList();
        this.local_cost = new java.util.LinkedList();
        this.dwa_planner = new java.util.LinkedList();
        this.robot_driver = new java.util.LinkedList();
        this.map_server = new java.util.LinkedList();
        this.handler = new com.jlboat.phone.activity.BasicSettingActivity$2(this);
        return;
    }

    static synthetic java.util.List access$1000(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.robot_driver;
    }

    static synthetic java.util.List access$1100(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.map_server;
    }

    static synthetic android.os.Handler access$1200(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.handler;
    }

    static synthetic String access$1300(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.TAG;
    }

    static synthetic com.jlboat.phone.fragment.settingfragment.MoveBaseFragment access$1400(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.moveBaseFragment;
    }

    static synthetic com.jlboat.phone.fragment.settingfragment.GlobalCostFragment access$1500(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.globalCostFragment;
    }

    static synthetic com.jlboat.phone.fragment.settingfragment.NavFnRosFragment access$1600(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.navFnRosFragment;
    }

    static synthetic com.jlboat.phone.fragment.settingfragment.LocalCostFragment access$1700(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.localCostFragment;
    }

    static synthetic com.jlboat.phone.fragment.settingfragment.DwaPlannerFragment access$1800(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.dwaPlannerFragment;
    }

    static synthetic com.jlboat.phone.fragment.settingfragment.RobotDriverFragment access$1900(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.robotDriverFragment;
    }

    static synthetic android.widget.RadioGroup access$200(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.mGroup;
    }

    static synthetic com.jlboat.phone.fragment.settingfragment.MapServerFragment access$2000(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.mapServerFragment;
    }

    static synthetic void access$2100(com.jlboat.phone.activity.BasicSettingActivity p0, CharSequence p1, CharSequence p2)
    {
        p0.showWaitingDialog(p1, p2);
        return;
    }

    static synthetic void access$2200(com.jlboat.phone.activity.BasicSettingActivity p0)
    {
        p0.dismissWaitingDialog();
        return;
    }

    static synthetic android.support.v4.view.ViewPager access$300(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.mPager;
    }

    static synthetic void access$400(com.jlboat.phone.activity.BasicSettingActivity p0)
    {
        p0.safeDismissWaitingDialog();
        return;
    }

    static synthetic java.util.List access$500(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.move_base;
    }

    static synthetic java.util.List access$600(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.global_cost;
    }

    static synthetic java.util.List access$700(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.navfn_ros;
    }

    static synthetic java.util.List access$800(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.local_cost;
    }

    static synthetic java.util.List access$900(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        return p1.dwa_planner;
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
        this.getConfigs(0);
        return;
    }

    private void safeDismissWaitingDialog()
    {
        this.handler.sendEmptyMessage(0);
        return;
    }

    private void safeShowWaitingDialog(CharSequence p4, CharSequence p5)
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 4;
        android.os.Handler v1_3 = new Object[2];
        v1_3[0] = p4;
        v1_3[1] = p5;
        v0_1.obj = v1_3;
        this.handler.sendMessage(v0_1);
        return;
    }

    private void showWaitingDialog(CharSequence p3, CharSequence p4)
    {
        this.waitingDialog = android.app.ProgressDialog.show(this, p3, p4, 1);
        this.waitingDialog.setProgressStyle(0);
        return;
    }

    public void getConfigs(int p3)
    {
        this.statusServiceClient.getConfigsService(p3, new com.jlboat.phone.activity.BasicSettingActivity$1(this));
        return;
    }

    public void onClick(android.view.View p1)
    {
        return;
    }

    public void onCreate(android.os.Bundle p5)
    {
        super.onCreate(p5);
        this.initTitleBar(2131361821, 2131493156);
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.mPager = ((android.support.v4.view.ViewPager) this.findViewById(2131231358));
        this.mGroup = ((android.widget.RadioGroup) this.findViewById(2131231165));
        this.moveBaseFragment = new com.jlboat.phone.fragment.settingfragment.MoveBaseFragment();
        this.globalCostFragment = new com.jlboat.phone.fragment.settingfragment.GlobalCostFragment();
        this.navFnRosFragment = new com.jlboat.phone.fragment.settingfragment.NavFnRosFragment();
        this.localCostFragment = new com.jlboat.phone.fragment.settingfragment.LocalCostFragment();
        this.dwaPlannerFragment = new com.jlboat.phone.fragment.settingfragment.DwaPlannerFragment();
        this.robotDriverFragment = new com.jlboat.phone.fragment.settingfragment.RobotDriverFragment();
        this.mapServerFragment = new com.jlboat.phone.fragment.settingfragment.MapServerFragment();
        java.util.ArrayList v0_20 = new java.util.ArrayList();
        v0_20.add(this.moveBaseFragment);
        v0_20.add(this.globalCostFragment);
        v0_20.add(this.navFnRosFragment);
        v0_20.add(this.localCostFragment);
        v0_20.add(this.dwaPlannerFragment);
        v0_20.add(this.robotDriverFragment);
        v0_20.add(this.mapServerFragment);
        this.mPager.setAdapter(new com.jlboat.phone.adapter.MainFragmentPagerAdapter(this.getSupportFragmentManager(), v0_20));
        this.mPager.setCurrentItem(0);
        this.mPager.setOffscreenPageLimit(7);
        this.mPager.setOnPageChangeListener(new com.jlboat.phone.activity.BasicSettingActivity$myOnPageChangeListener(this, 0));
        this.mGroup.setOnCheckedChangeListener(new com.jlboat.phone.activity.BasicSettingActivity$myCheckChangeListener(this, 0));
        this.init();
        return;
    }

    public void toast(String p2)
    {
        this.runOnUiThread(new com.jlboat.phone.activity.BasicSettingActivity$3(this, p2));
        return;
    }
}
