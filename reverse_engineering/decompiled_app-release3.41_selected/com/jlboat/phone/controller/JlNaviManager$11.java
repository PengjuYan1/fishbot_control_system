package com.jlboat.phone.controller;
 class JlNaviManager$11 extends com.boat.support.slam.IBitmapService$Stub {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic android.graphics.Bitmap val$data;
    final synthetic double val$originX;
    final synthetic double val$originY;
    final synthetic float val$resolution;

    JlNaviManager$11(com.jlboat.phone.controller.JlNaviManager p1, android.graphics.Bitmap p2, float p3, double p4, double p6)
    {
        this.this$0 = p1;
        this.val$data = p2;
        this.val$resolution = p3;
        this.val$originX = p4;
        this.val$originY = p6;
        return;
    }

    public android.graphics.Bitmap getIntentBitmap()
    {
        return this.val$data;
    }

    public double getOriginX()
    {
        return this.val$originX;
    }

    public double getOriginY()
    {
        return this.val$originY;
    }

    public float getResolution()
    {
        return this.val$resolution;
    }
}
