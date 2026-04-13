package com.jlboat.phone.activity;
 class MapCleanAreaActivity$3 implements com.jlboat.phone.adapter.CleanAreaRvAdapter$OnLongClick {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity this$0;

    MapCleanAreaActivity$3(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void longclick(long p5, String p7)
    {
        android.app.AlertDialog$Builder v0_1 = new android.app.AlertDialog$Builder(this.this$0);
        v0_1.setTitle(new StringBuilder().append(this.this$0.getResString(2131492982)).append(p7).append("?").toString());
        v0_1.setPositiveButton(2131493023, new com.jlboat.phone.activity.MapCleanAreaActivity$3$1(this, p5));
        v0_1.setNegativeButton(2131493007, new com.jlboat.phone.activity.MapCleanAreaActivity$3$2(this));
        v0_1.show();
        return;
    }
}
