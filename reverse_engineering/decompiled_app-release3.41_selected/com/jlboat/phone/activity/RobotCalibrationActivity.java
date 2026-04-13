package com.jlboat.phone.activity;
public class RobotCalibrationActivity extends com.jlboat.phone.base.BaseFullActivity {
    private String TAG;
    private android.widget.Button calibration_camera;
    private android.widget.Button calibration_imu;
    private android.widget.Button calibration_laser;
    private android.widget.Button calibration_odom;
    com.jlboat.phone.fragment.calibrationfragment.CameraFragment cameraFragment;
    com.jlboat.phone.fragment.calibrationfragment.ImuFragment imuFragment;
    com.jlboat.phone.fragment.calibrationfragment.LaserFragment laserFragment;
    private android.widget.RadioGroup mGroup;
    private android.support.v4.view.ViewPager mPager;
    com.jlboat.phone.fragment.calibrationfragment.OmodFragment omodFragment;

    public RobotCalibrationActivity()
    {
        this.TAG = "RobotCalibrationActivity";
        return;
    }

    static synthetic android.widget.RadioGroup access$200(com.jlboat.phone.activity.RobotCalibrationActivity p1)
    {
        return p1.mGroup;
    }

    static synthetic android.support.v4.view.ViewPager access$300(com.jlboat.phone.activity.RobotCalibrationActivity p1)
    {
        return p1.mPager;
    }

    public void onCreate(android.os.Bundle p5)
    {
        super.onCreate(p5);
        this.initTitleBar(2131361822, 2131493155);
        this.calibration_odom = ((android.widget.Button) this.findViewById(2131230837));
        this.calibration_camera = ((android.widget.Button) this.findViewById(2131230834));
        this.calibration_laser = ((android.widget.Button) this.findViewById(2131230836));
        this.calibration_imu = ((android.widget.Button) this.findViewById(2131230835));
        this.mPager = ((android.support.v4.view.ViewPager) this.findViewById(2131231358));
        this.mGroup = ((android.widget.RadioGroup) this.findViewById(2131231165));
        this.omodFragment = new com.jlboat.phone.fragment.calibrationfragment.OmodFragment();
        this.laserFragment = new com.jlboat.phone.fragment.calibrationfragment.LaserFragment();
        this.cameraFragment = new com.jlboat.phone.fragment.calibrationfragment.CameraFragment();
        this.imuFragment = new com.jlboat.phone.fragment.calibrationfragment.ImuFragment();
        java.util.ArrayList v0_25 = new java.util.ArrayList();
        v0_25.add(this.omodFragment);
        v0_25.add(this.laserFragment);
        v0_25.add(this.cameraFragment);
        v0_25.add(this.imuFragment);
        this.mPager.setAdapter(new com.jlboat.phone.adapter.MainFragmentPagerAdapter(this.getSupportFragmentManager(), v0_25));
        this.mPager.setCurrentItem(4);
        this.mPager.setOffscreenPageLimit(4);
        this.mPager.setOnPageChangeListener(new com.jlboat.phone.activity.RobotCalibrationActivity$myOnPageChangeListener(this, 0));
        this.mGroup.setOnCheckedChangeListener(new com.jlboat.phone.activity.RobotCalibrationActivity$myCheckChangeListener(this, 0));
        return;
    }
}
