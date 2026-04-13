package com.jlboat.phone.activity;
public class MapEditMapActivity2025 extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapEditMapActivity2025";
    android.widget.Button bt_save_update_map;
    private android.widget.CheckBox cb_is_clear;
    private long firstTime;
    private android.os.Handler handler;
    private final int handlerDismissWaitingDialog;
    private final int handlerDismissWaitingDialogTimeOut;
    private final int handlerShowWaitingDialog;
    android.widget.ImageView iv_rectangle;
    private boolean mapChange;
    com.jlboat.phone.view.DrawMapView mapView;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private android.app.ProgressDialog waitingDialog;

    public MapEditMapActivity2025()
    {
        this.handlerShowWaitingDialog = 2;
        this.handlerDismissWaitingDialog = 3;
        this.handlerDismissWaitingDialogTimeOut = 31;
        this.handler = new com.jlboat.phone.activity.MapEditMapActivity2025$1(this);
        this.firstTime = 0;
        return;
    }

    static synthetic void access$000(com.jlboat.phone.activity.MapEditMapActivity2025 p0, CharSequence p1, CharSequence p2)
    {
        p0.showWaitingDialog(p1, p2);
        return;
    }

    static synthetic android.os.Handler access$100(com.jlboat.phone.activity.MapEditMapActivity2025 p1)
    {
        return p1.handler;
    }

    static synthetic void access$200(com.jlboat.phone.activity.MapEditMapActivity2025 p0)
    {
        p0.dismissWaitingDialog();
        return;
    }

    static synthetic boolean access$302(com.jlboat.phone.activity.MapEditMapActivity2025 p0, boolean p1)
    {
        p0.mapChange = p1;
        return p1;
    }

    static synthetic android.widget.CheckBox access$400(com.jlboat.phone.activity.MapEditMapActivity2025 p1)
    {
        return p1.cb_is_clear;
    }

    static synthetic void access$500(com.jlboat.phone.activity.MapEditMapActivity2025 p0)
    {
        p0.getMap();
        return;
    }

    private void dismissWaitingDialog()
    {
        if (this.waitingDialog != null) {
            this.waitingDialog.dismiss();
            this.waitingDialog = 0;
        }
        if (this.handler.hasMessages(31)) {
            this.handler.removeMessages(31);
        }
        return;
    }

    private void getMap()
    {
        this.getMyApplication().getAppManager().getNetWorkManager().get(this.getMyApplication(), com.jlboat.phone.application.BoatSlamApplication.mapApiGetMap, com.boat.jrosbridge.message.nav_msgs.OccupancyGrid, new com.jlboat.phone.activity.MapEditMapActivity2025$5(this));
        return;
    }

    private void init()
    {
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.mapView.setMapChangeCallBack(new com.jlboat.phone.activity.MapEditMapActivity2025$3(this));
        return;
    }

    private void safeDismissWaitingDialog()
    {
        this.handler.sendEmptyMessage(3);
        return;
    }

    private void safeShowWaitingDialog(CharSequence p4, CharSequence p5)
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 2;
        android.os.Handler v1_2 = new Object[2];
        v1_2[0] = p4;
        v1_2[1] = p5;
        v0_1.obj = v1_2;
        this.handler.sendMessage(v0_1);
        return;
    }

    private void showWaitingDialog(CharSequence p3, CharSequence p4)
    {
        this.waitingDialog = android.app.ProgressDialog.show(this, p3, p4, 1);
        this.waitingDialog.setProgressStyle(0);
        return;
    }

    public void onBackPressed()
    {
        long v0 = System.currentTimeMillis();
        if (!this.mapChange) {
            super.onBackPressed();
        } else {
            if ((v0 - this.firstTime) <= 2000) {
                super.onBackPressed();
            } else {
                this.toast(2131493279);
                this.firstTime = v0;
            }
        }
        return;
    }

    public void onClick(android.view.View p4)
    {
        switch (p4.getId()) {
            case 2131230823:
                this.safeShowWaitingDialog(this.getResString(2131493126), this.getResString(2131493125));
                if (this.spiritServiceClient == null) {
                } else {
                    this.spiritServiceClient.saveMapEXTService(this.mapView.getMapData(), new com.jlboat.phone.activity.MapEditMapActivity2025$4(this));
                }
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361896, 2131492931);
        this.mapView = ((com.jlboat.phone.view.DrawMapView) this.findViewById(2131230984));
        this.cb_is_clear = ((android.widget.CheckBox) this.findViewById(2131230842));
        this.bt_save_update_map = ((android.widget.Button) this.findViewById(2131230823));
        this.iv_rectangle = ((android.widget.ImageView) this.findViewById(2131230946));
        super.onCreate(p3);
        this.bt_save_update_map.setOnClickListener(this);
        this.cb_is_clear.setOnCheckedChangeListener(new com.jlboat.phone.activity.MapEditMapActivity2025$2(this));
        this.init();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.getMap();
        return;
    }
}
