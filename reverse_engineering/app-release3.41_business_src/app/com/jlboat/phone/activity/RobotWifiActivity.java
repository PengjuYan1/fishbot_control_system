package com.jlboat.phone.activity;
public class RobotWifiActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private String TAG;
    android.widget.EditText name;
    android.widget.EditText pass;
    android.widget.Button send;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;

    public RobotWifiActivity()
    {
        this.TAG = "RobotWifiActivity";
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        return;
    }

    static synthetic String access$000(com.jlboat.phone.activity.RobotWifiActivity p1)
    {
        return p1.TAG;
    }

    public void onClick(android.view.View p5)
    {
        switch (p5.getId()) {
            case 2131230824:
                String v0_3 = this.name.getText().toString();
                String v1_1 = this.pass.getText().toString();
                if (!v0_3.isEmpty()) {
                    this.send.setEnabled(0);
                    this.send.setText(this.getResString(2131492958));
                    this.spiritServiceClient.setWifiServiceResponseListener(v0_3, v1_1, new com.jlboat.phone.activity.RobotWifiActivity$1(this));
                } else {
                    this.toast("wifi \u8d26\u53f7 \u4e0d\u80fd\u4e3a\u7a7a");
                }
                break;
            default:
        }
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.initTitleBar(2131361827, 2131493170);
        this.name = ((android.widget.EditText) this.findViewById(2131230905));
        this.pass = ((android.widget.EditText) this.findViewById(2131230906));
        this.send = ((android.widget.Button) this.findViewById(2131230824));
        this.send.setOnClickListener(this);
        return;
    }

    public void toast(String p2)
    {
        this.runOnUiThread(new com.jlboat.phone.activity.RobotWifiActivity$2(this, p2));
        return;
    }
}
