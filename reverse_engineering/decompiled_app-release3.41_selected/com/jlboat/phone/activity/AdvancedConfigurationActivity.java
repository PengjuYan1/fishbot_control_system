package com.jlboat.phone.activity;
public class AdvancedConfigurationActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private String TAG;
    private android.widget.RelativeLayout chargeRl;
    private android.widget.Button go_one_meter;
    private android.widget.Button go_two_meter;
    private android.widget.Button gra;
    private android.widget.RelativeLayout liftingRl;
    private android.content.Context mContext;
    private android.widget.RelativeLayout navigationRl;
    private android.widget.Button spins;
    private android.widget.Button spins90;

    public AdvancedConfigurationActivity()
    {
        this.TAG = "AdvancedConfigurationActivity";
        this.mContext = this;
        return;
    }

    public void onClick(android.view.View p4)
    {
        switch (p4.getId()) {
            case 2131230848:
                android.content.Intent v0_10 = new android.content.Intent(this, com.jlboat.phone.activity.TestFragmentActivity);
                v0_10.putExtra("type", 2131493310);
                this.startActivity(v0_10);
                break;
            case 2131230922:
                android.content.Intent v0_8 = new android.content.Intent(this, com.jlboat.phone.activity.MoveTestActivity);
                v0_8.putExtra("type", 0);
                this.startActivity(v0_8);
                break;
            case 2131230923:
                android.content.Intent v0_6 = new android.content.Intent(this, com.jlboat.phone.activity.MoveTestActivity);
                v0_6.putExtra("type", 1);
                this.startActivity(v0_6);
                break;
            case 2131230924:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.GrabBagActivity));
                break;
            case 2131230958:
                android.content.Intent v0_2 = new android.content.Intent(this, com.jlboat.phone.activity.TestFragmentActivity);
                v0_2.putExtra("type", 2131493323);
                this.startActivity(v0_2);
                break;
            case 2131231040:
                android.content.Intent v0_12 = new android.content.Intent(this, com.jlboat.phone.activity.TestFragmentActivity);
                v0_12.putExtra("type", 2131493342);
                this.startActivity(v0_12);
                break;
            default:
        }
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.initTitleBar(2131361820, 2131493043);
        this.go_one_meter = ((android.widget.Button) this.findViewById(2131230922));
        this.go_two_meter = ((android.widget.Button) this.findViewById(2131230923));
        this.navigationRl = ((android.widget.RelativeLayout) this.findViewById(2131231040));
        this.chargeRl = ((android.widget.RelativeLayout) this.findViewById(2131230848));
        this.liftingRl = ((android.widget.RelativeLayout) this.findViewById(2131230958));
        this.navigationRl.setOnClickListener(this);
        this.chargeRl.setOnClickListener(this);
        this.liftingRl.setOnClickListener(this);
        this.go_one_meter.setOnClickListener(this);
        this.go_two_meter.setOnClickListener(this);
        this.gra = ((android.widget.Button) this.findViewById(2131230924));
        this.gra.setOnClickListener(this);
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
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
        return;
    }

    public void toast(String p2)
    {
        this.runOnUiThread(new com.jlboat.phone.activity.AdvancedConfigurationActivity$1(this, p2));
        return;
    }
}
