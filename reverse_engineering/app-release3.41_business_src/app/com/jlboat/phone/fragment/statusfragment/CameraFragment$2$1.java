package com.jlboat.phone.fragment.statusfragment;
 class CameraFragment$2$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.statusfragment.CameraFragment$2 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.Config val$config;

    CameraFragment$2$1(com.jlboat.phone.fragment.statusfragment.CameraFragment$2 p1, com.jlboat.phone.message.map_msgs.Config p2)
    {
        this.this$1 = p1;
        this.val$config = p2;
        return;
    }

    public void run()
    {
        if (!this.val$config.getConfigValue().equals("True")) {
            this.this$1.this$0.cameraOpen.setText(this.this$1.this$0.getString(2131492939));
        } else {
            this.this$1.this$0.cameraOpen.setText(this.this$1.this$0.getString(2131492938));
        }
        this.this$1.this$0.cameraOpen.setVisibility(0);
        return;
    }
}
