package com.jlboat.phone.activity;
 class DiyPathActivity$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    DiyPathActivity$5(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ExecutePathResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ExecutePathResponse p6)
    {
        if (p6.getResult() != 0) {
            this.this$0.toast(2131493258);
        } else {
            com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1005);
            this.this$0.toast(2131493259);
        }
        return;
    }
}
