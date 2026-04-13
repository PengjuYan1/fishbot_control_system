package com.jlboat.phone.activity;
 class MapActivity$22 implements android.widget.RadioGroup$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic com.boat.support.slam.entity.floors.Points val$frd;

    MapActivity$22(com.jlboat.phone.activity.MapActivity p1, com.boat.support.slam.entity.floors.Points p2)
    {
        this.this$0 = p1;
        this.val$frd = p2;
        return;
    }

    public void onCheckedChanged(android.widget.RadioGroup p3, int p4)
    {
        android.util.Log.d("MapActivity", new StringBuilder().append("onCheckedChanged: i ").append(p4).toString());
        switch (p4) {
            case 2131230870:
                this.val$frd.setDeviceType(0);
                break;
            case 2131230871:
                this.val$frd.setDeviceType(11);
                break;
            case 2131230872:
                this.val$frd.setDeviceType(12);
                break;
            case 2131230873:
                this.val$frd.setDeviceType(21);
                break;
            case 2131230874:
                this.val$frd.setDeviceType(22);
                break;
            default:
        }
        return;
    }
}
