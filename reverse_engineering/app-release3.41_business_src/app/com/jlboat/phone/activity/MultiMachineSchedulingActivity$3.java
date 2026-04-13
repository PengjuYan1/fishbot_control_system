package com.jlboat.phone.activity;
 class MultiMachineSchedulingActivity$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MultiMachineSchedulingActivity this$0;
    final synthetic int val$type;

    MultiMachineSchedulingActivity$3(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1, int p2)
    {
        this.this$0 = p1;
        this.val$type = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetConfigsResponse p6)
    {
        android.util.Log.e("MultiMachineSchedulingActivity", new StringBuilder().append("\u8fd0\u884c\u6b21\u6570\uff1a").append(com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$204(this.this$0)).append("  type:").append(this.val$type).toString());
        if (p6 != null) {
            if (this.val$type != 9) {
                com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$000(this.this$0).clear();
                android.os.Handler v0_24 = p6.getConfigs().iterator();
                while (v0_24.hasNext()) {
                    com.jlboat.phone.message.map_msgs.Config v2_8 = ((com.jlboat.phone.message.map_msgs.Config) v0_24.next());
                    if (!v2_8.getConfigName().equals("meeting_distance")) {
                        if (v2_8.getConfigName().equals("priority_level")) {
                            com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$000(this.this$0).add(v2_8);
                            android.util.Log.d("MultiMachineSchedulingActivity", new StringBuilder().append("priority_level:").append(v2_8.toString()).toString());
                            com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$500(this.this$0).post(new com.jlboat.phone.activity.MultiMachineSchedulingActivity$3$3(this, v2_8));
                            break;
                        }
                    } else {
                        com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$000(this.this$0).add(v2_8);
                        android.util.Log.d("MultiMachineSchedulingActivity", new StringBuilder().append("meeting_distance:").append(v2_8.toString()).toString());
                        com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$500(this.this$0).post(new com.jlboat.phone.activity.MultiMachineSchedulingActivity$3$2(this, v2_8));
                    }
                }
            } else {
                com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$300(this.this$0).clear();
                android.os.Handler v0_2 = p6.getConfigs().iterator();
                while (v0_2.hasNext()) {
                    com.jlboat.phone.message.map_msgs.Config v2_2 = ((com.jlboat.phone.message.map_msgs.Config) v0_2.next());
                    if (v2_2.getConfigName().equals("startRobotOA")) {
                        com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$300(this.this$0).add(v2_2);
                        android.util.Log.d("MultiMachineSchedulingActivity", new StringBuilder().append("startRobotOA:").append(v2_2.toString()).toString());
                        com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$500(this.this$0).post(new com.jlboat.phone.activity.MultiMachineSchedulingActivity$3$1(this, v2_2));
                        break;
                    }
                }
            }
            return;
        } else {
            android.util.Log.e("MultiMachineSchedulingActivity", new StringBuilder().append("Response is null for type: ").append(this.val$type).toString());
            return;
        }
    }
}
