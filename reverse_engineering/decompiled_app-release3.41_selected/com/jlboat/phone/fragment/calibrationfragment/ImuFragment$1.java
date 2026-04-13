package com.jlboat.phone.fragment.calibrationfragment;
 class ImuFragment$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.calibrationfragment.ImuFragment this$0;
    final synthetic int val$date;

    ImuFragment$1(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p1, int p2)
    {
        this.this$0 = p1;
        this.val$date = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.CalculateOdomResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.CalculateOdomResponse p10)
    {
        if (p10.getStatus() != 0) {
            if ((((double) p10.getDiff_distance()) == 0) && ((this.val$date == 301) && ((com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0) instanceof android.app.Activity)))) {
                ((android.app.Activity) com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0)).runOnUiThread(new com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1$1(this, p10));
            }
            if ((((double) p10.getRightmotor_ratio()) >= 4606281698874543309) && ((((double) p10.getRightmotor_ratio()) <= 4607632778762754458) && ((((double) p10.getLeftmotor_ratio()) >= 4606281698874543309) && ((((double) p10.getLeftmotor_ratio()) <= 4607632778762754458) && ((this.val$date == 301) && ((com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0) instanceof android.app.Activity))))))) {
                ((android.app.Activity) com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0)).runOnUiThread(new com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1$2(this, p10));
            }
            if ((com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0) instanceof android.app.Activity)) {
                ((android.app.Activity) com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0)).runOnUiThread(new com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1$3(this));
            }
        }
        if ((this.val$date == 301) && (p10.getStatus() == 0)) {
            com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$0).set((com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$0).size() - 1), p10);
        }
        if ((this.val$date == 300) && (p10.getStatus() == 0)) {
            com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$0).add(p10);
        }
        if ((this.val$date == 302) && ((p10.getStatus() == 0) && ((com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0) instanceof android.app.Activity)))) {
            ((android.app.Activity) com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0)).runOnUiThread(new com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1$4(this, p10));
        }
        if ((com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0) instanceof android.app.Activity)) {
            ((android.app.Activity) com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$0)).runOnUiThread(new com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1$5(this, p10));
        }
        return;
    }
}
