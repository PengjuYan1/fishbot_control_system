package com.jlboat.phone.fragment.statusfragment;
 class Camera03Fragment$2$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.statusfragment.Camera03Fragment$2 this$1;

    Camera03Fragment$2$1(com.jlboat.phone.fragment.statusfragment.Camera03Fragment$2 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void run()
    {
        android.app.AlertDialog$Builder v0_1 = new android.app.AlertDialog$Builder(this.this$1.this$0.getContext());
        v0_1.setTitle(new StringBuilder().append("\u91cd\u542f\u624d\u80fd\u751f\u6548").append(this.this$1.this$0.getResources().getString(2131493015)).toString());
        v0_1.setPositiveButton(2131493023, new com.jlboat.phone.fragment.statusfragment.Camera03Fragment$2$1$1(this));
        v0_1.setNegativeButton(2131493007, new com.jlboat.phone.fragment.statusfragment.Camera03Fragment$2$1$2(this));
        v0_1.show();
        return;
    }
}
