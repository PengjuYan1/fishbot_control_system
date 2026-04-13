package com.jlboat.phone.activity;
public class StatusActivity extends com.jlboat.phone.base.BaseFullActivity {
    private String TAG;
    private com.jlboat.phone.fragment.statusfragment.AvoidFillFragment avoidFillFragment;
    private android.widget.Button bt_sonar;
    private com.jlboat.phone.fragment.statusfragment.CameraFragment cameraFragment;
    private com.jlboat.phone.fragment.statusfragment.ImuFragment imuFragment;
    private com.jlboat.phone.fragment.statusfragment.LaserFragment laserFragment;
    private com.jlboat.phone.fragment.statusfragment.LiftFragment liftFragment;
    private com.jlboat.phone.fragment.statusfragment.LoraFragment loraFragment;
    private android.widget.RadioGroup mGroup;
    private android.support.v4.view.ViewPager mPager;
    private com.jlboat.phone.fragment.statusfragment.OdomFragment odomFragment;
    private com.jlboat.phone.fragment.statusfragment.SonarFragment sonarFragment;
    private com.jlboat.phone.fragment.statusfragment.UltrasoundFragment ultrasoundFragment;
    private android.widget.Button update_laser;
    private android.widget.Button update_ultrasound;

    public StatusActivity()
    {
        this.TAG = "StatusActivity";
        return;
    }

    static synthetic android.widget.RadioGroup access$200(com.jlboat.phone.activity.StatusActivity p1)
    {
        return p1.mGroup;
    }

    static synthetic android.support.v4.view.ViewPager access$300(com.jlboat.phone.activity.StatusActivity p1)
    {
        return p1.mPager;
    }

    public void onCreate(android.os.Bundle p6)
    {
        super.onCreate(p6);
        this.initTitleBar(2131361829, 2131493331);
        this.bt_sonar = ((android.widget.Button) this.findViewById(2131230825));
        this.update_ultrasound = ((android.widget.Button) this.findViewById(2131231354));
        this.update_laser = ((android.widget.Button) this.findViewById(2131231350));
        this.mPager = ((android.support.v4.view.ViewPager) this.findViewById(2131231358));
        this.mGroup = ((android.widget.RadioGroup) this.findViewById(2131231165));
        this.laserFragment = new com.jlboat.phone.fragment.statusfragment.LaserFragment();
        this.cameraFragment = new com.jlboat.phone.fragment.statusfragment.CameraFragment();
        this.odomFragment = new com.jlboat.phone.fragment.statusfragment.OdomFragment();
        this.imuFragment = new com.jlboat.phone.fragment.statusfragment.ImuFragment();
        this.sonarFragment = new com.jlboat.phone.fragment.statusfragment.SonarFragment();
        this.ultrasoundFragment = new com.jlboat.phone.fragment.statusfragment.UltrasoundFragment();
        this.liftFragment = new com.jlboat.phone.fragment.statusfragment.LiftFragment();
        this.avoidFillFragment = new com.jlboat.phone.fragment.statusfragment.AvoidFillFragment();
        this.loraFragment = new com.jlboat.phone.fragment.statusfragment.LoraFragment();
        java.util.ArrayList v1_28 = new java.util.ArrayList();
        v1_28.add(this.laserFragment);
        v1_28.add(this.cameraFragment);
        v1_28.add(this.odomFragment);
        v1_28.add(this.imuFragment);
        v1_28.add(this.liftFragment);
        v1_28.add(this.avoidFillFragment);
        v1_28.add(this.loraFragment);
        v1_28.add(this.sonarFragment);
        v1_28.add(this.ultrasoundFragment);
        this.mPager.setAdapter(new com.jlboat.phone.adapter.MainFragmentPagerAdapter(this.getSupportFragmentManager(), v1_28));
        this.mPager.setCurrentItem(0, 1);
        this.mPager.setOffscreenPageLimit(v1_28.size());
        this.mPager.setOnPageChangeListener(new com.jlboat.phone.activity.StatusActivity$myOnPageChangeListener(this, 0));
        this.mGroup.setOnCheckedChangeListener(new com.jlboat.phone.activity.StatusActivity$myCheckChangeListener(this, 0));
        this.mGroup.check(2131231350);
        return;
    }
}
