package com.jlboat.phone.activity;
public class MapEditMapActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapEditMapActivity";
    android.widget.Button bt_save_update_map;
    private com.boat.jrosbridge.Topic erasePoseTopic;
    android.widget.ImageView iv_rectangle;
    com.jlboat.phone.view.MapView mapView;
    com.jlboat.phone.view.MapView$MoveCallBackLines moveCallBackLines;
    android.widget.RadioButton rb_close_mode;
    android.widget.RadioButton rb_height_mode;
    android.widget.RadioButton rb_low_mode;
    android.widget.RadioButton rb_med_mode;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;

    public MapEditMapActivity()
    {
        this.moveCallBackLines = new com.jlboat.phone.activity.MapEditMapActivity$1(this);
        return;
    }

    static synthetic com.boat.jrosbridge.Topic access$000(com.jlboat.phone.activity.MapEditMapActivity p1)
    {
        return p1.erasePoseTopic;
    }

    private void init()
    {
        this.erasePoseTopic = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.ErasePose, com.jlboat.phone.message.map_msgs.ErasePose, com.jlboat.phone.application.BoatSlamApplication.client);
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        return;
    }

    private void setMode(int p3)
    {
        android.util.Log.d("MapEditMapActivity", new StringBuilder().append("setMode: ").append(p3).toString());
        this.spiritServiceClient.setEraseModeService(p3, new com.jlboat.phone.activity.MapEditMapActivity$3(this, p3));
        return;
    }

    public void onClick(android.view.View p3)
    {
        switch (p3.getId()) {
            case 2131230756:
                break;
            case 2131230823:
                if (this.spiritServiceClient == null) {
                } else {
                    this.spiritServiceClient.saveEraseMapService(new com.jlboat.phone.activity.MapEditMapActivity$2(this));
                }
                break;
            case 2131231118:
                this.mapView.setMoveCallBackLines(0);
                break;
            case 2131231129:
                this.setMode(3);
                break;
            case 2131231131:
                this.setMode(1);
                break;
            case 2131231139:
                this.setMode(2);
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361895, 2131492931);
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230984));
        this.bt_save_update_map = ((android.widget.Button) this.findViewById(2131230823));
        this.iv_rectangle = ((android.widget.ImageView) this.findViewById(2131230946));
        this.rb_low_mode = ((android.widget.RadioButton) this.findViewById(2131231131));
        this.rb_med_mode = ((android.widget.RadioButton) this.findViewById(2131231139));
        this.rb_height_mode = ((android.widget.RadioButton) this.findViewById(2131231129));
        this.rb_close_mode = ((android.widget.RadioButton) this.findViewById(2131231118));
        super.onCreate(p3);
        this.rb_low_mode.setOnClickListener(this);
        this.rb_med_mode.setOnClickListener(this);
        this.rb_height_mode.setOnClickListener(this);
        this.rb_close_mode.setOnClickListener(this);
        this.bt_save_update_map.setOnClickListener(this);
        this.init();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.mapView.onStop();
        this.erasePoseTopic.unadvertise();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.mapView.onStart(this.getMyApplication());
        this.erasePoseTopic.advertise();
        return;
    }
}
