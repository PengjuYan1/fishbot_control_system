package com.jlboat.phone.activity;
 class MapActivity$54 implements android.content.DialogInterface$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$54(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(android.content.DialogInterface p3, int p4)
    {
        p3.dismiss();
        if (com.jlboat.phone.activity.MapActivity.access$4500(this.this$0) != null) {
            com.jlboat.phone.activity.MapActivity.access$4500(this.this$0).setVisibility(8);
        }
        this.this$0.deleteAllMap();
        return;
    }
}
