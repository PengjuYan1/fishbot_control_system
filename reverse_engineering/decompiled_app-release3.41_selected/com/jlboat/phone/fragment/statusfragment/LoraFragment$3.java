package com.jlboat.phone.fragment.statusfragment;
 class LoraFragment$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.LoraFragment this$0;

    LoraFragment$3(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetConfigsResponse p5)
    {
        com.jlboat.phone.fragment.statusfragment.LoraFragment.access$300(this.this$0).clear();
        android.util.Log.d("LoraFragment", new StringBuilder().append("onNewMessage: aaa ").append(p5.getConfigs()).toString());
        android.os.Handler v0_5 = p5.getConfigs().iterator();
        while (v0_5.hasNext()) {
            com.jlboat.phone.message.map_msgs.Config v1_4 = ((com.jlboat.phone.message.map_msgs.Config) v0_5.next());
            if (v1_4.getConfigName().equals("startLora")) {
                com.jlboat.phone.fragment.statusfragment.LoraFragment.access$300(this.this$0).add(v1_4);
                com.jlboat.phone.fragment.statusfragment.LoraFragment.access$600(this.this$0).post(new com.jlboat.phone.fragment.statusfragment.LoraFragment$3$1(this, v1_4));
                break;
            }
        }
        return;
    }
}
