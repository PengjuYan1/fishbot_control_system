package com.jlboat.phone.activity;
 class MapActivity$3 implements com.jlboat.phone.view.MapView$PathCallBack {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$3(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onPath(java.util.List p7)
    {
        this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapActivity$3$1(this, Double.parseDouble(new java.text.DecimalFormat("#.00").format(this.this$0.calculateTrajectoryLength(p7)))));
        return;
    }
}
