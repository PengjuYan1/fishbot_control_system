package com.jlboat.phone.activity;
public class MapRepositionActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapRepositionActivity";
    private android.widget.ImageView iv_arrow;
    private com.jlboat.phone.view.MapView mapView;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private android.widget.Button status_bt;

    public MapRepositionActivity()
    {
        return;
    }

    static synthetic android.widget.Button access$000(com.jlboat.phone.activity.MapRepositionActivity p1)
    {
        return p1.status_bt;
    }

    private void setPose()
    {
        com.boat.support.slam.entity.floors.Lines v1_1 = this.mapView.getRosMapPoint();
        com.boat.support.slam.entity.floors.Lines v2_0 = this.mapView.getRosMapPoint((this.iv_arrow.getLeft() + (this.iv_arrow.getWidth() / 2)), this.iv_arrow.getTop());
        if ((v1_1 != null) && (v2_0 != null)) {
            com.jlboat.phone.communication.SpiritServiceClient v16_0 = new com.jlboat.phone.util.EulerAngles;
            v16_0(0, Math.atan2((v2_0.getY() - v1_1.getY()), (v2_0.getX() - v1_1.getX())), 0);
            com.jlboat.phone.util.Quaternion v7_2 = v16_0.ToQuaternion();
            this.spiritServiceClient.relocation(v1_1.getX(), v1_1.getY(), v7_2.z, v7_2.w, new com.jlboat.phone.activity.MapRepositionActivity$2(this));
            return;
        } else {
            return;
        }
    }

    public void initService()
    {
        this.runOnUiThread(new com.jlboat.phone.activity.MapRepositionActivity$1(this));
        return;
    }

    public void onClick(android.view.View p2)
    {
        switch (p2.getId()) {
            case 2131231274:
                this.setPose();
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361900, 2131492955);
        super.onCreate(p3);
        this.iv_arrow = ((android.widget.ImageView) this.findViewById(2131230940));
        this.status_bt = ((android.widget.Button) this.findViewById(2131231274));
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230984));
        this.status_bt.setOnClickListener(this);
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.mapView.onStop();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.status_bt.setVisibility(8);
        this.initService();
        this.mapView.onStart(this.getMyApplication());
        return;
    }
}
