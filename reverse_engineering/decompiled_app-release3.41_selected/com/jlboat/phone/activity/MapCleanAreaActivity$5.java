package com.jlboat.phone.activity;
 class MapCleanAreaActivity$5 implements android.view.View$OnTouchListener {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity this$0;

    MapCleanAreaActivity$5(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public boolean onTouch(android.view.View p6, android.view.MotionEvent p7)
    {
        switch ((p7.getAction() & 255)) {
            case 0:
                com.jlboat.phone.activity.MapCleanAreaActivity.access$402(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapCleanAreaActivity.access$502(this.this$0, p7.getRawY());
                com.jlboat.phone.activity.MapCleanAreaActivity.access$602(this.this$0, ((android.widget.RelativeLayout$LayoutParams) this.this$0.ivCleanRectangle.getLayoutParams()));
                com.jlboat.phone.activity.MapCleanAreaActivity.access$702(this.this$0, ((float) p6.getWidth()));
                com.jlboat.phone.activity.MapCleanAreaActivity.access$802(this.this$0, ((float) p6.getHeight()));
                break;
            case 1:
            case 3:
            case 4:
            default:
                break;
            case 2:
                com.jlboat.phone.activity.MapCleanAreaActivity.access$1102(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapCleanAreaActivity.access$1202(this.this$0, p7.getRawY());
                com.jlboat.phone.activity.MapCleanAreaActivity.access$600(this.this$0).width = ((int) (com.jlboat.phone.activity.MapCleanAreaActivity.access$700(this.this$0) + ((com.jlboat.phone.activity.MapCleanAreaActivity.access$1100(this.this$0) - com.jlboat.phone.activity.MapCleanAreaActivity.access$400(this.this$0)) * 1073741824)));
                com.jlboat.phone.activity.MapCleanAreaActivity.access$600(this.this$0).height = ((int) (com.jlboat.phone.activity.MapCleanAreaActivity.access$800(this.this$0) + ((com.jlboat.phone.activity.MapCleanAreaActivity.access$1200(this.this$0) - com.jlboat.phone.activity.MapCleanAreaActivity.access$500(this.this$0)) * 1073741824)));
                this.this$0.ivCleanRectangle.setLayoutParams(com.jlboat.phone.activity.MapCleanAreaActivity.access$600(this.this$0));
                break;
            case 5:
                com.jlboat.phone.activity.MapCleanAreaActivity.access$902(this.this$0, p7.getRawX());
                com.jlboat.phone.activity.MapCleanAreaActivity.access$1002(this.this$0, p7.getRawY());
                break;
            case 6:
                break;
        }
        return 1;
    }
}
