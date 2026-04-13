package com.jlboat.phone.fragment.statusfragment;
 class CameraFragment$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.CameraFragment this$0;

    CameraFragment$2(com.jlboat.phone.fragment.statusfragment.CameraFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetConfigsResponse p7)
    {
        android.util.Log.d("CameraFragment", new StringBuilder().append("onNewMessage: aaa ").append(p7.getConfigs()).toString());
        com.jlboat.phone.fragment.statusfragment.CameraFragment.access$000(this.this$0).clear();
        android.util.Log.d("CameraFragment", new StringBuilder().append("onNewMessage: aaa ").append(p7.getConfigs()).toString());
        android.os.Handler v0_11 = p7.getConfigs().iterator();
        while (v0_11.hasNext()) {
            com.jlboat.phone.message.map_msgs.Config v3_3 = ((com.jlboat.phone.message.map_msgs.Config) v0_11.next());
            android.util.Log.d("CameraFragment", new StringBuilder().append("onNewMessage: aaa ").append(p7.getConfigs()).toString());
            if (v3_3.getConfigName().equals("startcamera")) {
                com.jlboat.phone.fragment.statusfragment.CameraFragment.access$000(this.this$0).add(v3_3);
                android.util.Log.d("CameraFragment", new StringBuilder().append("onNewMessage: aaa ").append(v3_3.getConfigName()).toString());
                com.jlboat.phone.fragment.statusfragment.CameraFragment.access$100(this.this$0).post(new com.jlboat.phone.fragment.statusfragment.CameraFragment$2$1(this, v3_3));
                break;
            }
        }
        return;
    }
}
