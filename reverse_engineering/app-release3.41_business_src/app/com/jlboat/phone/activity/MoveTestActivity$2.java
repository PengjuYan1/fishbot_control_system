package com.jlboat.phone.activity;
 class MoveTestActivity$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MoveTestActivity this$0;

    MoveTestActivity$2(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Float32) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Float32 p3)
    {
        com.jlboat.phone.activity.MoveTestActivity.access$1102(this.this$0, p3.getData());
        com.jlboat.phone.activity.MoveTestActivity.access$1202(this.this$0, new com.jlboat.phone.bean.MoveRes());
        com.jlboat.phone.activity.MoveTestActivity.access$1200(this.this$0).setType(com.jlboat.phone.activity.MoveTestActivity.access$700(this.this$0));
        com.jlboat.phone.activity.MoveTestActivity.access$1200(this.this$0).setValue(com.jlboat.phone.activity.MoveTestActivity.access$1100(this.this$0));
        com.jlboat.phone.activity.MoveTestActivity.access$1200(this.this$0).setTime(com.jlboat.phone.util.Utils.getCurrentTime(new java.util.Date()));
        com.jlboat.phone.activity.MoveTestActivity.access$100(this.this$0).add(com.jlboat.phone.activity.MoveTestActivity.access$1200(this.this$0));
        com.jlboat.phone.activity.MoveTestActivity.access$1300(this.this$0).sendEmptyMessage(101);
        if (com.jlboat.phone.activity.MoveTestActivity.access$1100(this.this$0) != 1176255488) {
            if (com.jlboat.phone.activity.MoveTestActivity.access$1100(this.this$0) == 1176256512) {
                com.jlboat.phone.activity.MoveTestActivity.access$1300(this.this$0).sendEmptyMessage(103);
            }
        } else {
            com.jlboat.phone.activity.MoveTestActivity.access$1300(this.this$0).sendEmptyMessage(102);
        }
        return;
    }
}
