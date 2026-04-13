package com.jlboat.phone.activity;
 class GrabBagActivity$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.GrabBagActivity this$0;

    GrabBagActivity$2(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.BagListResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.BagListResponse p4)
    {
        android.util.Log.d(com.jlboat.phone.activity.GrabBagActivity.access$500(this.this$0), new StringBuilder().append("getBag  onSuccess: ").append(p4.getBagNames()).toString());
        com.jlboat.phone.activity.GrabBagActivity.access$602(this.this$0, p4.getBagNames());
        com.jlboat.phone.activity.GrabBagActivity.access$200(this.this$0).sendEmptyMessage(2);
        return;
    }
}
