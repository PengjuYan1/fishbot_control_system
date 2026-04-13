package com.jlboat.phone.activity;
 class MoveTestActivity$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MoveTestActivity this$0;

    MoveTestActivity$3(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ScaleTestResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ScaleTestResponse p3)
    {
        com.jlboat.phone.activity.MoveTestActivity.access$1300(this.this$0).sendEmptyMessage(100);
        android.util.Log.d("MoveTestActivity", new StringBuilder().append("onSuccess \u79fb\u52a8\u6d4b\u8bd5\u6307\u4ee4\u6210\u529f: ").append(p3.getStatus()).toString());
        return;
    }
}
