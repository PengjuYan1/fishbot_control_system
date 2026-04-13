package com.jlboat.phone.activity;
 class MapEditMapActivity$3$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity$3 this$1;

    MapEditMapActivity$3$1(com.jlboat.phone.activity.MapEditMapActivity$3 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void run()
    {
        if (this.this$1.val$mode == 1) {
            this.this$1.this$0.rb_low_mode.setChecked(1);
        }
        if (this.this$1.val$mode == 2) {
            this.this$1.this$0.rb_med_mode.setChecked(1);
        }
        if (this.this$1.val$mode == 3) {
            this.this$1.this$0.rb_height_mode.setChecked(1);
        }
        this.this$1.this$0.mapView.setMoveCallBackLines(this.this$1.this$0.moveCallBackLines);
        return;
    }
}
