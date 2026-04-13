package com.jlboat.phone.fragment.statusfragment;
 class LiftFragment$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.LiftFragment this$0;

    LiftFragment$1(com.jlboat.phone.fragment.statusfragment.LiftFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic void lambda$onNewMessage$0$com-jlboat-phone-fragment-statusfragment-LiftFragment$1(short p5)
    {
        if ((this.this$0.isAdded()) && (this.this$0.lift_no_tv != null)) {
            switch (p5) {
                case 0:
                    this.this$0.lift_no_tv.setText(this.this$0.getString(2131493365));
                    break;
                case 1:
                    this.this$0.lift_no_tv.setText(this.this$0.getString(2131493362));
                    break;
                case 2:
                    this.this$0.lift_no_tv.setText(this.this$0.getString(2131493353));
                    break;
                case 3:
                case 4:
                default:
                    this.this$0.lift_no_tv.setText("\u672a\u8fde\u63a5");
                    this.this$0.jacking_tv.setVisibility(8);
                    this.this$0.drop_tv.setVisibility(8);
                    break;
                case 5:
                    this.this$0.lift_no_tv.setText(this.this$0.getString(2131493354));
                    this.this$0.jacking_tv.setVisibility(8);
                    this.this$0.drop_tv.setVisibility(8);
                    break;
            }
        }
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p4)
    {
        com.jlboat.phone.fragment.statusfragment.LiftFragment.access$000(this.this$0).post(new com.jlboat.phone.fragment.statusfragment.LiftFragment$1$$ExternalSyntheticLambda0(this, p4.getData()));
        return;
    }
}
