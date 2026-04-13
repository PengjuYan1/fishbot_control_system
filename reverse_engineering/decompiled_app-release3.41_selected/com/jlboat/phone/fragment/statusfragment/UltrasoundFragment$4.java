package com.jlboat.phone.fragment.statusfragment;
 class UltrasoundFragment$4 extends android.os.Handler {
    final synthetic com.jlboat.phone.fragment.statusfragment.UltrasoundFragment this$0;

    UltrasoundFragment$4(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p9)
    {
        super.handleMessage(p9);
        switch (p9.what) {
            case 3:
                if ((com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$900(this.this$0) != null) && (!com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$900(this.this$0).isEmpty())) {
                    com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$000(this.this$0).setChecked(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1000(this.this$0));
                    com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$000(this.this$0).setEnabled(1);
                    java.util.Iterator v0_10 = com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$900(this.this$0).iterator();
                    while (v0_10.hasNext()) {
                        com.jlboat.phone.message.map_msgs.RobotSonarEntry v1_6 = ((com.jlboat.phone.message.map_msgs.RobotSonarEntry) v0_10.next());
                        int v2 = 0;
                        if (v1_6.getSonarSwitch() == 1) {
                            v2 = 1;
                        }
                        String v3_2 = com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1500(this.this$0, v1_6.getMinRange());
                        String v4_2 = com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1500(this.this$0, v1_6.getMaxRange());
                        if (!"front".equals(v1_6.getName())) {
                            if (!"back".equals(v1_6.getName())) {
                                if (!"left".equals(v1_6.getName())) {
                                    if (!"leftmiddle".equals(v1_6.getName())) {
                                        if (!"right".equals(v1_6.getName())) {
                                            if (!"rightmiddle".equals(v1_6.getName())) {
                                                if ("up".equals(v1_6.getName())) {
                                                    com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$200(this.this$0).setChecked(v2);
                                                    com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2800(this.this$0).setText(v3_2);
                                                    com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2900(this.this$0).setText(v4_2);
                                                }
                                            } else {
                                                com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$600(this.this$0).setChecked(v2);
                                                com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2600(this.this$0).setText(v3_2);
                                                com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2700(this.this$0).setText(v4_2);
                                            }
                                        } else {
                                            com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$500(this.this$0).setChecked(v2);
                                            com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2400(this.this$0).setText(v3_2);
                                            com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2500(this.this$0).setText(v4_2);
                                        }
                                    } else {
                                        com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$400(this.this$0).setChecked(v2);
                                        com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2200(this.this$0).setText(v3_2);
                                        com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2300(this.this$0).setText(v4_2);
                                    }
                                } else {
                                    com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$300(this.this$0).setChecked(v2);
                                    com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2000(this.this$0).setText(v3_2);
                                    com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$2100(this.this$0).setText(v4_2);
                                }
                            } else {
                                com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$100(this.this$0).setChecked(v2);
                                com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1800(this.this$0).setText(v3_2);
                                com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1900(this.this$0).setText(v4_2);
                            }
                        } else {
                            com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$700(this.this$0).setChecked(v2);
                            com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1600(this.this$0).setText(v3_2);
                            com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1700(this.this$0).setText(v4_2);
                        }
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1100(this.this$0), "handlerReflashSonal: =null");
                }
                break;
            default:
        }
        return;
    }
}
