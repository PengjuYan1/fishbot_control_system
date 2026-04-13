package com.jlboat.phone.activity;
 class BasicSettingActivity$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.BasicSettingActivity this$0;

    BasicSettingActivity$1(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetConfigsResponse p4)
    {
        com.jlboat.phone.activity.BasicSettingActivity.access$400(this.this$0);
        if ((p4 != null) && (p4.getConfigs() != null)) {
            com.jlboat.phone.activity.BasicSettingActivity.access$500(this.this$0).clear();
            com.jlboat.phone.activity.BasicSettingActivity.access$600(this.this$0).clear();
            com.jlboat.phone.activity.BasicSettingActivity.access$700(this.this$0).clear();
            com.jlboat.phone.activity.BasicSettingActivity.access$800(this.this$0).clear();
            com.jlboat.phone.activity.BasicSettingActivity.access$900(this.this$0).clear();
            com.jlboat.phone.activity.BasicSettingActivity.access$1000(this.this$0).clear();
            com.jlboat.phone.activity.BasicSettingActivity.access$1100(this.this$0).clear();
            String v0_14 = p4.getConfigs().iterator();
            while (v0_14.hasNext()) {
                String v1_8 = ((com.jlboat.phone.message.map_msgs.Config) v0_14.next());
                switch (v1_8.getType()) {
                    case 1:
                        com.jlboat.phone.activity.BasicSettingActivity.access$500(this.this$0).add(v1_8);
                        break;
                    case 2:
                        com.jlboat.phone.activity.BasicSettingActivity.access$600(this.this$0).add(v1_8);
                        break;
                    case 3:
                        com.jlboat.phone.activity.BasicSettingActivity.access$700(this.this$0).add(v1_8);
                        break;
                    case 4:
                        com.jlboat.phone.activity.BasicSettingActivity.access$800(this.this$0).add(v1_8);
                        break;
                    case 5:
                        com.jlboat.phone.activity.BasicSettingActivity.access$900(this.this$0).add(v1_8);
                        break;
                    case 6:
                        com.jlboat.phone.activity.BasicSettingActivity.access$1000(this.this$0).add(v1_8);
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        com.jlboat.phone.activity.BasicSettingActivity.access$1100(this.this$0).add(v1_8);
                        break;
                    default:
                }
            }
            com.jlboat.phone.activity.BasicSettingActivity.access$1200(this.this$0).sendEmptyMessage(1);
            android.util.Log.d(com.jlboat.phone.activity.BasicSettingActivity.access$1300(this.this$0), new StringBuilder().append("onSuccess: map_server.size: ").append(com.jlboat.phone.activity.BasicSettingActivity.access$1100(this.this$0).size()).toString());
            return;
        } else {
            return;
        }
    }
}
