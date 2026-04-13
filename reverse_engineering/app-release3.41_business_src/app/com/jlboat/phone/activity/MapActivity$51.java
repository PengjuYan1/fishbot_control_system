package com.jlboat.phone.activity;
 class MapActivity$51 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$51(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        if (com.jlboat.phone.activity.MapActivity.access$800(this.this$0) != 0) {
            if (com.jlboat.phone.activity.MapActivity.access$800(this.this$0) != 1) {
                if (com.jlboat.phone.activity.MapActivity.access$800(this.this$0) == 2) {
                    com.jlboat.phone.activity.MapActivity.access$4600(this.this$0).setVisibility(0);
                    this.this$0.startActivity(new android.content.Intent(this.this$0, com.jlboat.phone.activity.MapExpansionActivity));
                    this.this$0.toast(2131493282);
                    if (com.jlboat.phone.activity.MapActivity.access$4700(this.this$0) != null) {
                        com.jlboat.phone.activity.MapActivity.access$4700(this.this$0).unsubscribe();
                    }
                }
            } else {
                com.jlboat.phone.activity.MapActivity.access$4500(this.this$0).setVisibility(0);
                com.jlboat.phone.activity.MapActivity.access$4500(this.this$0).setText(this.this$0.getResString(2131492952));
                com.jlboat.phone.activity.MapActivity.access$4600(this.this$0).setVisibility(8);
                com.jlboat.phone.activity.MapActivity.access$4900(this.this$0).setVisibility(8);
                if (com.jlboat.phone.activity.MapActivity.access$4700(this.this$0) != null) {
                    com.jlboat.phone.activity.MapActivity.access$4700(this.this$0).unsubscribe();
                }
            }
        } else {
            com.jlboat.phone.activity.MapActivity.access$4500(this.this$0).setVisibility(8);
            com.jlboat.phone.activity.MapActivity.access$4500(this.this$0).setText(this.this$0.getResString(2131492946));
            com.jlboat.phone.activity.MapActivity.access$4600(this.this$0).setVisibility(0);
            com.jlboat.phone.activity.MapActivity.access$4702(this.this$0, new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.LocationStatus, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client));
            com.jlboat.phone.activity.MapActivity.access$4700(this.this$0).subscribe(new com.jlboat.phone.activity.MapActivity$51$1(this));
        }
        return;
    }
}
