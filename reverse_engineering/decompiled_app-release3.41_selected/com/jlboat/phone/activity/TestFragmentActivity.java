package com.jlboat.phone.activity;
public class TestFragmentActivity extends com.jlboat.phone.base.BaseFullActivity {

    public TestFragmentActivity()
    {
        return;
    }

    private void initData()
    {
        int v0_1 = this.getIntent().getIntExtra("type", -1);
        if (v0_1 != -1) {
            this.initTitleBar(2131361831, v0_1);
            if (com.jlboat.phone.application.BoatSlamApplication.classis_version_code <= 452) {
                if (com.jlboat.phone.application.BoatSlamApplication.classis_version_code <= 448) {
                    com.jlboat.phone.util.Utils.toast(this.getString(2131493307));
                    switch (v0_1) {
                        case 2131493310:
                            this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.newInstance(1)).commit();
                            break;
                        case 2131493323:
                            this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.newInstance(2)).commit();
                            break;
                        case 2131493342:
                            this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.newInstance(0)).commit();
                            break;
                        default:
                    }
                } else {
                    com.jlboat.phone.util.Utils.toast(this.getString(2131493307));
                    switch (v0_1) {
                        case 2131493310:
                            this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.newInstance(1)).commit();
                            break;
                        case 2131493323:
                            this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.newInstance(2)).commit();
                            break;
                        case 2131493342:
                            this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.newInstance(0)).commit();
                            break;
                        default:
                    }
                }
            } else {
                switch (v0_1) {
                    case 2131493310:
                        this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.newInstance(1)).commit();
                        break;
                    case 2131493323:
                        this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.newInstance(2)).commit();
                        break;
                    case 2131493342:
                        this.getSupportFragmentManager().beginTransaction().replace(2131231182, com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.newInstance(0)).commit();
                        break;
                    default:
                }
            }
            return;
        } else {
            this.finish();
            return;
        }
    }

    protected void onCreate(android.os.Bundle p2)
    {
        super.onCreate(p2);
        this.setContentView(2131361831);
        this.initData();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        return;
    }
}
