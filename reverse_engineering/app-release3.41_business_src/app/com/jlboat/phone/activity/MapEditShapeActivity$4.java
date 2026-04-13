package com.jlboat.phone.activity;
 class MapEditShapeActivity$4 implements android.view.View$OnTouchListener {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity this$0;

    MapEditShapeActivity$4(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public boolean onTouch(android.view.View p6, android.view.MotionEvent p7)
    {
        switch ((p7.getAction() & 255)) {
            case 0:
                com.jlboat.phone.activity.MapEditShapeActivity.access$202(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapEditShapeActivity.access$302(this.this$0, p7.getRawY());
                com.jlboat.phone.activity.MapEditShapeActivity.access$402(this.this$0, ((android.widget.RelativeLayout$LayoutParams) this.this$0.ivRectangle.getLayoutParams()));
                com.jlboat.phone.activity.MapEditShapeActivity.access$502(this.this$0, ((float) p6.getWidth()));
                com.jlboat.phone.activity.MapEditShapeActivity.access$602(this.this$0, ((float) p6.getHeight()));
                break;
            case 1:
            case 3:
            case 4:
            default:
                break;
            case 2:
                com.jlboat.phone.activity.MapEditShapeActivity.access$902(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapEditShapeActivity.access$1002(this.this$0, p7.getRawY());
                com.jlboat.phone.activity.MapEditShapeActivity.access$400(this.this$0).width = ((int) (com.jlboat.phone.activity.MapEditShapeActivity.access$500(this.this$0) + ((com.jlboat.phone.activity.MapEditShapeActivity.access$900(this.this$0) - com.jlboat.phone.activity.MapEditShapeActivity.access$200(this.this$0)) * 1073741824)));
                com.jlboat.phone.activity.MapEditShapeActivity.access$400(this.this$0).height = ((int) (com.jlboat.phone.activity.MapEditShapeActivity.access$600(this.this$0) + ((com.jlboat.phone.activity.MapEditShapeActivity.access$1000(this.this$0) - com.jlboat.phone.activity.MapEditShapeActivity.access$300(this.this$0)) * 1073741824)));
                this.this$0.ivRectangle.setLayoutParams(com.jlboat.phone.activity.MapEditShapeActivity.access$400(this.this$0));
                break;
            case 5:
                com.jlboat.phone.activity.MapEditShapeActivity.access$702(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapEditShapeActivity.access$802(this.this$0, p7.getRawY());
                break;
            case 6:
                break;
        }
        return 1;
    }
}
