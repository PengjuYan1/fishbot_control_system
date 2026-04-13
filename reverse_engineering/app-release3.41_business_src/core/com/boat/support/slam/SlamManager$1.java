package com.boat.support.slam;
 class SlamManager$1 implements android.content.ServiceConnection {
    final synthetic com.boat.support.slam.SlamManager this$0;

    SlamManager$1(com.boat.support.slam.SlamManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onServiceConnected(android.content.ComponentName p3, android.os.IBinder p4)
    {
        android.util.Log.v("SlamManager", " SlamManager onServiceConnected ");
        com.boat.support.slam.SlamManager.access$002(this.this$0, com.boat.support.slam.ISlamService$Stub.asInterface(p4));
        this.this$0.regist();
        if (com.boat.support.slam.SlamManager.access$100(this.this$0) != null) {
            com.boat.support.slam.SlamManager.access$100(this.this$0).onSuccess();
        }
        return;
    }

    public void onServiceDisconnected(android.content.ComponentName p2)
    {
        com.boat.support.slam.SlamManager.access$200(this.this$0);
        return;
    }
}
