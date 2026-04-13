package com.jlboat.phone.fragment.statusfragment;
 class Camera03Fragment$1 implements com.jlboat.phone.view.LaserCamera03View$IHasData {
    final synthetic com.jlboat.phone.fragment.statusfragment.Camera03Fragment this$0;

    Camera03Fragment$1(com.jlboat.phone.fragment.statusfragment.Camera03Fragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onData()
    {
        this.this$0.scan_no_tv.setTextColor(this.this$0.getResources().getColor(2131034237));
        this.this$0.scan_no_tv.setText(this.this$0.getString(2131493358));
        return;
    }
}
