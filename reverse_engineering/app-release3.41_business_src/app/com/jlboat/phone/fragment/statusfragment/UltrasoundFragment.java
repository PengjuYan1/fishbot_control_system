package com.jlboat.phone.fragment.statusfragment;
public class UltrasoundFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private String TAG;
    private android.widget.Switch all_sw;
    private android.widget.Switch back_sw;
    private android.widget.Switch front_sw;
    public final int handlerReflashSonal;
    private android.widget.Switch left_sw;
    private android.widget.Switch leftm_sw;
    private android.widget.LinearLayout ll_con;
    private android.widget.EditText max_back_et;
    private android.widget.EditText max_front_et;
    private android.widget.EditText max_left_et;
    private android.widget.EditText max_leftm_et;
    private android.widget.EditText max_right_et;
    private android.widget.EditText max_rightm_et;
    private android.widget.EditText max_up_et;
    private android.os.Handler mhandler;
    private android.widget.EditText min_back_et;
    private android.widget.EditText min_front_et;
    private android.widget.EditText min_left_et;
    private android.widget.EditText min_leftm_et;
    private android.widget.EditText min_right_et;
    private android.widget.EditText min_rightm_et;
    private android.widget.EditText min_up_et;
    private android.widget.Switch right_sw;
    private android.widget.Switch rightm_sw;
    private android.widget.Button set_sonar;
    private java.util.List sonarEntryList;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    private android.widget.Switch up_sw;
    private boolean userSonar;

    public UltrasoundFragment()
    {
        this.TAG = "UltrasoundActivity";
        this.handlerReflashSonal = 3;
        this.sonarEntryList = new java.util.ArrayList();
        this.mhandler = new com.jlboat.phone.fragment.statusfragment.UltrasoundFragment$4(this);
        return;
    }

    static synthetic android.widget.Switch access$000(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.all_sw;
    }

    static synthetic android.widget.Switch access$100(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.back_sw;
    }

    static synthetic boolean access$1000(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.userSonar;
    }

    static synthetic boolean access$1002(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p0, boolean p1)
    {
        p0.userSonar = p1;
        return p1;
    }

    static synthetic String access$1100(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.TAG;
    }

    static synthetic android.os.Handler access$1200(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.mhandler;
    }

    static synthetic void access$1300(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p0, CharSequence p1)
    {
        p0.showToast(p1);
        return;
    }

    static synthetic void access$1400(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p0, CharSequence p1)
    {
        p0.showToast(p1);
        return;
    }

    static synthetic String access$1500(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1, float p2)
    {
        return p1.floatToString(p2);
    }

    static synthetic android.widget.EditText access$1600(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.min_front_et;
    }

    static synthetic android.widget.EditText access$1700(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.max_front_et;
    }

    static synthetic android.widget.EditText access$1800(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.min_back_et;
    }

    static synthetic android.widget.EditText access$1900(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.max_back_et;
    }

    static synthetic android.widget.Switch access$200(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.up_sw;
    }

    static synthetic android.widget.EditText access$2000(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.min_left_et;
    }

    static synthetic android.widget.EditText access$2100(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.max_left_et;
    }

    static synthetic android.widget.EditText access$2200(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.min_leftm_et;
    }

    static synthetic android.widget.EditText access$2300(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.max_leftm_et;
    }

    static synthetic android.widget.EditText access$2400(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.min_right_et;
    }

    static synthetic android.widget.EditText access$2500(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.max_right_et;
    }

    static synthetic android.widget.EditText access$2600(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.min_rightm_et;
    }

    static synthetic android.widget.EditText access$2700(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.max_rightm_et;
    }

    static synthetic android.widget.EditText access$2800(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.min_up_et;
    }

    static synthetic android.widget.EditText access$2900(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.max_up_et;
    }

    static synthetic android.widget.Switch access$300(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.left_sw;
    }

    static synthetic android.widget.Switch access$400(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.leftm_sw;
    }

    static synthetic android.widget.Switch access$500(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.right_sw;
    }

    static synthetic android.widget.Switch access$600(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.rightm_sw;
    }

    static synthetic android.widget.Switch access$700(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.front_sw;
    }

    static synthetic android.widget.LinearLayout access$800(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.ll_con;
    }

    static synthetic java.util.List access$900(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        return p1.sonarEntryList;
    }

    static synthetic java.util.List access$902(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p0, java.util.List p1)
    {
        p0.sonarEntryList = p1;
        return p1;
    }

    private String floatToString(float p5)
    {
        try {
            String v0 = new java.text.DecimalFormat("0.00").format(((double) p5));
        } catch (Exception v1) {
        }
        return v0;
    }

    private void getSonar()
    {
        this.statusServiceClient.getSonarService(new com.jlboat.phone.fragment.statusfragment.UltrasoundFragment$2(this));
        return;
    }

    private void saveSonar()
    {
        int v0_0 = 0;
        while (v0_0 < this.sonarEntryList.size()) {
            float v2_8 = 1;
            if (!"front".equals(((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).getName())) {
                if (!"back".equals(((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).getName())) {
                    if (!"left".equals(((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).getName())) {
                        if (!"leftmiddle".equals(((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).getName())) {
                            if (!"right".equals(((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).getName())) {
                                if (!"rightmiddle".equals(((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).getName())) {
                                    if ("up".equals(((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).getName())) {
                                        if (!this.up_sw.isChecked()) {
                                            v2_8 = 0;
                                        }
                                        ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setSonarSwitch(v2_8);
                                        ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMinRange(Float.parseFloat(this.min_up_et.getText().toString()));
                                        ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMaxRange(Float.parseFloat(this.max_up_et.getText().toString()));
                                    }
                                } else {
                                    if (!this.rightm_sw.isChecked()) {
                                        v2_8 = 0;
                                    }
                                    ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setSonarSwitch(v2_8);
                                    ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMinRange(Float.parseFloat(this.min_rightm_et.getText().toString()));
                                    ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMaxRange(Float.parseFloat(this.max_rightm_et.getText().toString()));
                                }
                            } else {
                                if (!this.right_sw.isChecked()) {
                                    v2_8 = 0;
                                }
                                ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setSonarSwitch(v2_8);
                                ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMinRange(Float.parseFloat(this.min_right_et.getText().toString()));
                                ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMaxRange(Float.parseFloat(this.max_right_et.getText().toString()));
                            }
                        } else {
                            if (!this.leftm_sw.isChecked()) {
                                v2_8 = 0;
                            }
                            ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setSonarSwitch(v2_8);
                            ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMinRange(Float.parseFloat(this.min_leftm_et.getText().toString()));
                            ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMaxRange(Float.parseFloat(this.max_leftm_et.getText().toString()));
                        }
                    } else {
                        if (!this.left_sw.isChecked()) {
                            v2_8 = 0;
                        }
                        ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setSonarSwitch(v2_8);
                        ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMinRange(Float.parseFloat(this.min_left_et.getText().toString()));
                        ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMaxRange(Float.parseFloat(this.max_left_et.getText().toString()));
                    }
                } else {
                    if (!this.back_sw.isChecked()) {
                        v2_8 = 0;
                    }
                    ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setSonarSwitch(v2_8);
                    ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMinRange(Float.parseFloat(this.min_back_et.getText().toString()));
                    ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMaxRange(Float.parseFloat(this.max_back_et.getText().toString()));
                }
            } else {
                if (!this.front_sw.isChecked()) {
                    v2_8 = 0;
                }
                ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setSonarSwitch(v2_8);
                ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMinRange(Float.parseFloat(this.min_front_et.getText().toString()));
                ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) this.sonarEntryList.get(v0_0)).setMaxRange(Float.parseFloat(this.max_front_et.getText().toString()));
            }
            v0_0++;
        }
        this.statusServiceClient.setSonarService(this.sonarEntryList, this.all_sw.isChecked(), new com.jlboat.phone.fragment.statusfragment.UltrasoundFragment$3(this));
        return;
    }

    protected void initData()
    {
        return;
    }

    protected void initListener()
    {
        return;
    }

    protected android.view.View initView(android.view.LayoutInflater p4, android.view.ViewGroup p5)
    {
        android.view.View v0_1 = p4.inflate(2131361834, p5, 0);
        this.set_sonar = ((android.widget.Button) v0_1.findViewById(2131231249));
        this.ll_con = ((android.widget.LinearLayout) v0_1.findViewById(2131230968));
        this.min_front_et = ((android.widget.EditText) v0_1.findViewById(2131231010));
        this.max_front_et = ((android.widget.EditText) v0_1.findViewById(2131230994));
        this.min_back_et = ((android.widget.EditText) v0_1.findViewById(2131231009));
        this.max_back_et = ((android.widget.EditText) v0_1.findViewById(2131230993));
        this.min_left_et = ((android.widget.EditText) v0_1.findViewById(2131231011));
        this.max_left_et = ((android.widget.EditText) v0_1.findViewById(2131230995));
        this.min_leftm_et = ((android.widget.EditText) v0_1.findViewById(2131231012));
        this.max_leftm_et = ((android.widget.EditText) v0_1.findViewById(2131230996));
        this.min_right_et = ((android.widget.EditText) v0_1.findViewById(2131231013));
        this.max_right_et = ((android.widget.EditText) v0_1.findViewById(2131230997));
        this.min_rightm_et = ((android.widget.EditText) v0_1.findViewById(2131231014));
        this.max_rightm_et = ((android.widget.EditText) v0_1.findViewById(2131230998));
        this.min_up_et = ((android.widget.EditText) v0_1.findViewById(2131231015));
        this.max_up_et = ((android.widget.EditText) v0_1.findViewById(2131230999));
        this.front_sw = ((android.widget.Switch) v0_1.findViewById(2131230921));
        this.left_sw = ((android.widget.Switch) v0_1.findViewById(2131230953));
        this.leftm_sw = ((android.widget.Switch) v0_1.findViewById(2131230955));
        this.right_sw = ((android.widget.Switch) v0_1.findViewById(2131231175));
        this.rightm_sw = ((android.widget.Switch) v0_1.findViewById(2131231177));
        this.back_sw = ((android.widget.Switch) v0_1.findViewById(2131230771));
        this.up_sw = ((android.widget.Switch) v0_1.findViewById(2131231346));
        this.all_sw = ((android.widget.Switch) v0_1.findViewById(2131230765));
        this.all_sw.setOnClickListener(this);
        this.all_sw.setOnCheckedChangeListener(new com.jlboat.phone.fragment.statusfragment.UltrasoundFragment$1(this));
        this.set_sonar.setOnClickListener(this);
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        return v0_1;
    }

    public void onClick(android.view.View p4)
    {
        int v0 = p4.getId();
        if (v0 != 2131231249) {
            if (v0 == 2131230765) {
                this.back_sw.setEnabled(this.all_sw.isChecked());
                this.up_sw.setEnabled(this.all_sw.isChecked());
                this.left_sw.setEnabled(this.all_sw.isChecked());
                this.leftm_sw.setEnabled(this.all_sw.isChecked());
                this.right_sw.setEnabled(this.all_sw.isChecked());
                this.rightm_sw.setEnabled(this.all_sw.isChecked());
                this.front_sw.setEnabled(this.all_sw.isChecked());
            }
        } else {
            this.saveSonar();
        }
        return;
    }

    public android.view.View onCreateView(android.view.LayoutInflater p2, android.view.ViewGroup p3, android.os.Bundle p4)
    {
        return super.onCreateView(p2, p3, p4);
    }

    public void onResume()
    {
        super.onResume();
        this.all_sw.setEnabled(0);
        this.ll_con.setVisibility(8);
        this.getSonar();
        return;
    }
}
