package com.jlboat.phone.activity;
 class GrabBagActivity$1 implements android.widget.CompoundButton$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.GrabBagActivity this$0;

    GrabBagActivity$1(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(android.widget.CompoundButton p12, boolean p13)
    {
        if (!p13) {
            com.jlboat.phone.activity.GrabBagActivity.access$100(this.this$0).setType(4);
            com.jlboat.phone.activity.GrabBagActivity.access$200(this.this$0).removeMessages(1);
            com.jlboat.phone.activity.GrabBagActivity.access$300(this.this$0).setChecked(0);
            com.jlboat.phone.activity.GrabBagActivity.access$400(this.this$0);
        } else {
            android.widget.Switch v1_2 = this.this$0;
            com.jlboat.phone.view.MyPopupWindow v10 = new com.jlboat.phone.view.MyPopupWindow;
            v10(this.this$0, this.this$0.getResString(2131493085), this.this$0.getResString(2131493084), this.this$0.getResString(2131493079), 1, new com.jlboat.phone.activity.GrabBagActivity$1$1(this), new com.jlboat.phone.activity.GrabBagActivity$1$2(this));
            com.jlboat.phone.activity.GrabBagActivity.access$002(v1_2, v10);
            com.jlboat.phone.activity.GrabBagActivity.access$000(this.this$0).showAtLocation(android.view.LayoutInflater.from(this.this$0).inflate(2131361824, 0), 17, 0, 0);
        }
        return;
    }
}
