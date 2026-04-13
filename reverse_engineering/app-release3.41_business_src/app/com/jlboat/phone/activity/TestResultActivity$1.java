package com.jlboat.phone.activity;
 class TestResultActivity$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.TestResultActivity this$0;

    TestResultActivity$1(com.jlboat.phone.activity.TestResultActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.NaviTestResultEntrys) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.NaviTestResultEntrys p11)
    {
        android.util.Log.d("TestResultActivity", new StringBuilder().append("time: ").append(p11.getTestTime()).append(", resultEntry \u6d4b\u8bd5: ").append(p11.getTestresults().toString()).toString());
        com.jlboat.phone.activity.TestResultActivity.access$002(this.this$0, p11.getTestTime());
        java.util.List v0_6 = p11.getTestresults();
        com.jlboat.phone.activity.TestResultActivity.access$300(this.this$0).getMapsService(new com.jlboat.phone.activity.TestResultActivity$1$1(this, v0_6));
        android.util.Log.d("TestResultActivity", new StringBuilder().append("tttt: ").append(v0_6).toString());
        android.util.Log.d("TestResultActivity", new StringBuilder().append("tttt2222: ").append(com.jlboat.phone.activity.TestResultActivity.access$100(this.this$0)).toString());
        com.jlboat.phone.activity.TestResultActivity.access$402(this.this$0, 1);
        com.jlboat.phone.activity.TestResultActivity v1_9 = v0_6.iterator();
        while (v1_9.hasNext()) {
            com.jlboat.phone.activity.TestResultActivity$1$2 v3_10 = ((com.jlboat.phone.message.map_msgs.NaviTestResultEntry) v1_9.next());
            if (((int) v3_10.getTestType()) != 2) {
                if ((((int) v3_10.getGoalResult()) != 2) && (((int) v3_10.getChargeResult()) != 2)) {
                    if ((((int) v3_10.getGoalResult()) == 3) || (((int) v3_10.getChargeResult()) == 3)) {
                        com.jlboat.phone.activity.TestResultActivity.access$402(this.this$0, 0);
                        break;
                    }
                } else {
                    com.jlboat.phone.activity.TestResultActivity.access$402(this.this$0, 1);
                    break;
                }
            } else {
                if (v3_10.getGoalResult() != 2) {
                    com.jlboat.phone.activity.TestResultActivity.access$402(this.this$0, 0);
                } else {
                    com.jlboat.phone.activity.TestResultActivity.access$402(this.this$0, 1);
                    break;
                }
            }
        }
        com.jlboat.phone.activity.TestResultActivity.access$800(this.this$0).post(new com.jlboat.phone.activity.TestResultActivity$1$2(this, v0_6, com.jlboat.phone.activity.TestResultActivity.access$400(this.this$0)));
        return;
    }
}
