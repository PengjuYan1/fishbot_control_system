package com.jlboat.phone.fragment.statusfragment;
 class LoraFragment$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.LoraFragment this$0;

    LoraFragment$1(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetInt64Response) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetInt64Response p4)
    {
        android.util.Log.d("LoraFragment", new StringBuilder().append("message:").append(p4.isSuccess()).toString());
        if (!p4.isSuccess()) {
            com.jlboat.phone.fragment.statusfragment.LoraFragment.access$000(this.this$0).setText(this.this$0.getString(2131493354));
        } else {
            com.jlboat.phone.fragment.statusfragment.LoraFragment.access$000(this.this$0).setTextColor(this.this$0.getResources().getColor(2131034237));
            com.jlboat.phone.fragment.statusfragment.LoraFragment.access$000(this.this$0).setText(this.this$0.getString(2131493358));
        }
        return;
    }
}
