package com.jlboat.phone;
public class MainActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final int LOCATION_PERM = 101;
    private static final String TAG = "MainActivity";
    private android.widget.TextView advanced_configuration;
    private android.widget.TextView errorMessage;
    private android.widget.TextView menu_showControl;
    private android.widget.TextView menu_showMap;
    private android.widget.TextView menu_showMulti;
    private android.widget.TextView menu_showSetting;
    private android.widget.TextView menu_showStatus;
    private String ssid;

    public MainActivity()
    {
        return;
    }

    private void init()
    {
        this.initTitleBar(2131361888, 2131493076);
        this.menu_showMap = ((android.widget.TextView) this.findViewById(2131231002));
        this.errorMessage = ((android.widget.TextView) this.findViewById(2131230890));
        this.menu_showSetting = ((android.widget.TextView) this.findViewById(2131231004));
        this.menu_showControl = ((android.widget.TextView) this.findViewById(2131231001));
        this.menu_showStatus = ((android.widget.TextView) this.findViewById(2131231005));
        this.menu_showMulti = ((android.widget.TextView) this.findViewById(2131231003));
        this.advanced_configuration = ((android.widget.TextView) this.findViewById(2131230758));
        this.menu_showMap.setOnClickListener(this);
        this.errorMessage.setOnClickListener(this);
        this.menu_showSetting.setOnClickListener(this);
        this.menu_showControl.setOnClickListener(this);
        this.menu_showStatus.setOnClickListener(this);
        this.advanced_configuration.setOnClickListener(this);
        this.menu_showMulti.setOnClickListener(this);
        return;
    }

    public void onBackPressed()
    {
        android.content.Intent v0_1 = new android.content.Intent(this, com.jlboat.phone.service.ErrorMsgService);
        v0_1.setAction("stop");
        this.startService(v0_1);
        super.onBackPressed();
        this.finish();
        return;
    }

    public void onClick(android.view.View p5)
    {
        int v0 = p5.getId();
        if (v0 != 2131231002) {
            if (v0 != 2131230890) {
                if (v0 != 2131231001) {
                    if (v0 != 2131231003) {
                        if (v0 != 2131231005) {
                            if (v0 != 2131230758) {
                                if (v0 == 2131231004) {
                                    this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.SettingActivity));
                                }
                            } else {
                                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.AdvancedConfigurationActivity));
                            }
                        } else {
                            this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.StatusActivity));
                        }
                    } else {
                        this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MultiMachineSchedulingActivity));
                    }
                } else {
                    this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapControlActivity));
                }
            } else {
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.ErrorMessageActivity));
            }
        } else {
            this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapActivity).putExtra("isMeu", 1));
        }
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.init();
        android.util.Log.d("MainActivity", "onCreate: ");
        return;
    }

    public boolean onCreateOptionsMenu(android.view.Menu p3)
    {
        p3.add(0, 0, 0, 2131493206);
        return super.onCreateOptionsMenu(p3);
    }

    public boolean onOptionsItemSelected(android.view.MenuItem p2)
    {
        super.onOptionsItemSelected(p2);
        switch (p2.getItemId()) {
            case 0:
                this.onDestroy();
                break;
            default:
        }
        return 1;
    }
}
