package com.jlboat.phone.base;
public abstract class BaseFullActivity extends android.support.v7.app.AppCompatActivity {
    private static final int ERRIMG_STATE = 100;
    private boolean IS_SHOW_ERR_IMG;
    private com.jlboat.phone.view.BatteryView batteryView;
    private android.widget.ImageView errImg;
    private boolean isShowBattery;
    private android.widget.ImageView iv_battery_eating;
    private android.os.Handler mHandler;
    private int mLayout;
    public android.content.BroadcastReceiver mReceiver;
    private boolean mState;
    private android.view.ViewGroup rl_context_context;
    private android.view.ViewGroup rl_title_context;
    private android.widget.TextView robo_phow_text;
    private android.widget.TextView ss;
    private android.widget.ImageView titleBack;
    private android.widget.TextView titleText;
    public android.content.BroadcastReceiver voiceReceiver;
    private android.widget.LinearLayout wifi;

    public BaseFullActivity()
    {
        this.mState = 1;
        this.IS_SHOW_ERR_IMG = 1;
        this.isShowBattery = 1;
        this.mHandler = new com.jlboat.phone.base.BaseFullActivity$1(this);
        this.mReceiver = new com.jlboat.phone.base.BaseFullActivity$2(this);
        this.voiceReceiver = new com.jlboat.phone.base.BaseFullActivity$3(this);
        return;
    }

    static synthetic boolean access$000(com.jlboat.phone.base.BaseFullActivity p1)
    {
        return p1.IS_SHOW_ERR_IMG;
    }

    static synthetic boolean access$002(com.jlboat.phone.base.BaseFullActivity p0, boolean p1)
    {
        p0.IS_SHOW_ERR_IMG = p1;
        return p1;
    }

    static synthetic android.widget.ImageView access$100(com.jlboat.phone.base.BaseFullActivity p1)
    {
        return p1.errImg;
    }

    static synthetic void access$200(com.jlboat.phone.base.BaseFullActivity p0)
    {
        p0.checkTitle();
        return;
    }

    static synthetic void access$300(com.jlboat.phone.base.BaseFullActivity p0)
    {
        p0.updateTitleBar();
        return;
    }

    private void checkTitle()
    {
        if (this.batteryView != null) {
            this.batteryView.setPower(((float) com.jlboat.phone.application.BoatSlamApplication.power));
        }
        if (this.robo_phow_text != null) {
            this.robo_phow_text.setText(new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.power).append("%").toString());
        }
        if ((this.isShowBattery) && (this.iv_battery_eating != null)) {
            if (com.jlboat.phone.application.BoatSlamApplication.change != 0) {
                this.iv_battery_eating.setVisibility(0);
            } else {
                this.iv_battery_eating.setVisibility(4);
            }
        }
        return;
    }

    private void updateTitleBar()
    {
        if (!com.jlboat.phone.application.BoatSlamApplication.errList.isEmpty()) {
            this.mHandler.sendEmptyMessageDelayed(100, 2000);
        } else {
            this.mHandler.removeMessages(100);
            this.errImg.setVisibility(8);
            this.IS_SHOW_ERR_IMG = 1;
        }
        return;
    }

    public com.boat.base.BaseApplication getMyApplication()
    {
        return ((com.boat.base.BaseApplication) this.getApplication());
    }

    public String getResString(int p3)
    {
        new StringBuilder().append(p3).append("").toString();
        try {
            String v0_2 = this.getResources().getString(p3);
            return v0_2;
        } catch (Exception v1) {
            return v0_2;
        }
    }

    public int getStatusBarHeight(android.content.Context p6)
    {
        int v0 = 0;
        int v1_1 = p6.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (v1_1 > 0) {
            v0 = p6.getResources().getDimensionPixelSize(v1_1);
        }
        return v0;
    }

    protected void initTitleBar(int p5, int p6)
    {
        this.mLayout = p5;
        this.setContentView(p5);
        this.errImg = ((android.widget.ImageView) this.findViewById(2131231198));
        this.errImg.setOnClickListener(new com.jlboat.phone.base.BaseFullActivity$5(this));
        this.batteryView = ((com.jlboat.phone.view.BatteryView) this.findViewById(2131231213));
        this.iv_battery_eating = ((android.widget.ImageView) this.findViewById(2131230941));
        this.robo_phow_text = ((android.widget.TextView) this.findViewById(2131231187));
        this.rl_title_context = ((android.view.ViewGroup) this.findViewById(2131231186));
        this.rl_context_context = ((android.view.ViewGroup) this.findViewById(2131231182));
        if (this.rl_title_context != null) {
            this.rl_title_context.setPadding(this.getStatusBarHeight(this), 0, this.getStatusBarHeight(this), 0);
        }
        if (this.rl_context_context != null) {
            this.rl_context_context.setPadding(this.getStatusBarHeight(this), 0, this.getStatusBarHeight(this), 0);
        }
        this.titleBack = ((android.widget.ImageView) this.findViewById(2131231313));
        this.titleBack.setOnClickListener(new com.jlboat.phone.base.BaseFullActivity$6(this));
        this.titleText = ((android.widget.TextView) this.findViewById(2131231317));
        this.ss = ((android.widget.TextView) this.findViewById(2131231266));
        this.wifi = ((android.widget.LinearLayout) this.findViewById(2131231388));
        this.titleText.setText(p6);
        if (!com.jlboat.phone.application.BoatSlamApplication.ssid.equals("unknown ssid")) {
            this.wifi.setVisibility(0);
            this.ss.setText(com.jlboat.phone.application.BoatSlamApplication.ssid);
        }
        return;
    }

    protected void onCreate(android.os.Bundle p5)
    {
        this.getWindow().setFlags(1024, 1024);
        this.getWindow().addFlags(128);
        if (android.os.Build$VERSION.SDK_INT >= 28) {
            int v0_2 = this.getWindow().getAttributes();
            v0_2.layoutInDisplayCutoutMode = 1;
            this.getWindow().setAttributes(v0_2);
        }
        this.getWindow().getDecorView().setSystemUiVisibility((this.getWindow().getDecorView().getSystemUiVisibility() | 1028));
        super.onCreate(p5);
        android.content.IntentFilter v2_3 = new android.content.IntentFilter();
        v2_3.addAction("Finish");
        this.registerReceiver(this.mReceiver, v2_3);
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        this.unregisterReceiver(this.mReceiver);
        return;
    }

    protected void onPause()
    {
        super.onPause();
        if (this.voiceReceiver != null) {
            this.unregisterReceiver(this.voiceReceiver);
        }
        return;
    }

    protected void onResume()
    {
        super.onResume();
        android.content.IntentFilter v0_1 = new android.content.IntentFilter();
        v0_1.addAction("power");
        v0_1.addAction("change");
        v0_1.addAction("ssid");
        v0_1.addAction("WIFICONNECTED_STATE");
        v0_1.addAction("ERRMSG_UPDATE");
        this.registerReceiver(this.voiceReceiver, v0_1);
        this.checkTitle();
        return;
    }

    public void setVisableBattery(boolean p3)
    {
        this.isShowBattery = p3;
        if (!p3) {
            this.batteryView.setVisibility(8);
            this.robo_phow_text.setVisibility(8);
            this.iv_battery_eating.setVisibility(8);
        } else {
            this.batteryView.setVisibility(0);
            this.robo_phow_text.setVisibility(0);
            this.iv_battery_eating.setVisibility(0);
        }
        return;
    }

    public void toast(int p4)
    {
        String v0 = String.valueOf(p4);
        if (v0.length() > 5) {
            v0 = this.getResString(p4);
        }
        this.toast(v0);
        return;
    }

    public void toast(CharSequence p2)
    {
        this.runOnUiThread(new com.jlboat.phone.base.BaseFullActivity$4(this, p2));
        return;
    }
}
