package com.jlboat.phone.activity;
 class MapEditRegionActivity$6 implements android.view.View$OnTouchListener {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity this$0;

    MapEditRegionActivity$6(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public boolean onTouch(android.view.View p6, android.view.MotionEvent p7)
    {
        switch ((p7.getAction() & 255)) {
            case 0:
                com.jlboat.phone.activity.MapEditRegionActivity.access$1202(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapEditRegionActivity.access$1302(this.this$0, p7.getRawY());
                com.jlboat.phone.activity.MapEditRegionActivity.access$1402(this.this$0, ((android.widget.RelativeLayout$LayoutParams) this.this$0.ivRectangle.getLayoutParams()));
                com.jlboat.phone.activity.MapEditRegionActivity.access$1502(this.this$0, ((float) p6.getWidth()));
                com.jlboat.phone.activity.MapEditRegionActivity.access$1602(this.this$0, ((float) p6.getHeight()));
                break;
            case 1:
            case 3:
            case 4:
            default:
                break;
            case 2:
                com.jlboat.phone.activity.MapEditRegionActivity.access$1902(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapEditRegionActivity.access$2002(this.this$0, p7.getRawY());
                com.jlboat.phone.activity.MapEditRegionActivity.access$1400(this.this$0).width = ((int) (com.jlboat.phone.activity.MapEditRegionActivity.access$1500(this.this$0) + ((com.jlboat.phone.activity.MapEditRegionActivity.access$1900(this.this$0) - com.jlboat.phone.activity.MapEditRegionActivity.access$1200(this.this$0)) * 1073741824)));
                com.jlboat.phone.activity.MapEditRegionActivity.access$1400(this.this$0).height = ((int) (com.jlboat.phone.activity.MapEditRegionActivity.access$1600(this.this$0) + ((com.jlboat.phone.activity.MapEditRegionActivity.access$2000(this.this$0) - com.jlboat.phone.activity.MapEditRegionActivity.access$1300(this.this$0)) * 1073741824)));
                this.this$0.ivRectangle.setLayoutParams(com.jlboat.phone.activity.MapEditRegionActivity.access$1400(this.this$0));
                break;
            case 5:
                com.jlboat.phone.activity.MapEditRegionActivity.access$1702(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapEditRegionActivity.access$1802(this.this$0, p7.getRawY());
                break;
            case 6:
                break;
        }
        return 1;
    }
}
