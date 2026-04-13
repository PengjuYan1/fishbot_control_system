package com.jlboat.phone.activity;
 class RobotCalibrationActivity$myCheckChangeListener implements android.widget.RadioGroup$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.RobotCalibrationActivity this$0;

    private RobotCalibrationActivity$myCheckChangeListener(com.jlboat.phone.activity.RobotCalibrationActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic RobotCalibrationActivity$myCheckChangeListener(com.jlboat.phone.activity.RobotCalibrationActivity p1, com.jlboat.phone.activity.RobotCalibrationActivity$1 p2)
    {
        this(p1);
        return;
    }

    public void onCheckedChanged(android.widget.RadioGroup p4, int p5)
    {
        switch (p5) {
            case 2131230834:
                com.jlboat.phone.activity.RobotCalibrationActivity.access$300(this.this$0).setCurrentItem(2, 0);
                break;
            case 2131230835:
                com.jlboat.phone.activity.RobotCalibrationActivity.access$300(this.this$0).setCurrentItem(3, 0);
                break;
            case 2131230836:
                com.jlboat.phone.activity.RobotCalibrationActivity.access$300(this.this$0).setCurrentItem(1, 0);
                break;
            case 2131230837:
                com.jlboat.phone.activity.RobotCalibrationActivity.access$300(this.this$0).setCurrentItem(0, 0);
                break;
            default:
        }
        return;
    }
}
