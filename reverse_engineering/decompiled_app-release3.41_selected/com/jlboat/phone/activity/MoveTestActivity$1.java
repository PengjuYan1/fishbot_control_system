package com.jlboat.phone.activity;
 class MoveTestActivity$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.MoveTestActivity this$0;

    MoveTestActivity$1(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p5)
    {
        super.handleMessage(p5);
        switch (p5.what) {
            case 100:
                com.jlboat.phone.activity.MoveTestActivity.access$002(this.this$0, 1);
                com.jlboat.phone.activity.MoveTestActivity.access$100(this.this$0).clear();
                switch (com.jlboat.phone.activity.MoveTestActivity.access$200(this.this$0)) {
                    case 1:
                        com.jlboat.phone.activity.MoveTestActivity.access$300(this.this$0).setBackgroundResource(2131165274);
                        com.jlboat.phone.activity.MoveTestActivity.access$400(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$500(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$600(this.this$0).setBackgroundResource(2131165273);
                        break;
                    case 2:
                        com.jlboat.phone.activity.MoveTestActivity.access$300(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$400(this.this$0).setBackgroundResource(2131165274);
                        com.jlboat.phone.activity.MoveTestActivity.access$500(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$600(this.this$0).setBackgroundResource(2131165273);
                        break;
                    case 3:
                        com.jlboat.phone.activity.MoveTestActivity.access$300(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$400(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$500(this.this$0).setBackgroundResource(2131165274);
                        com.jlboat.phone.activity.MoveTestActivity.access$600(this.this$0).setBackgroundResource(2131165273);
                        break;
                    case 4:
                        com.jlboat.phone.activity.MoveTestActivity.access$300(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$400(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$500(this.this$0).setBackgroundResource(2131165273);
                        com.jlboat.phone.activity.MoveTestActivity.access$600(this.this$0).setBackgroundResource(2131165274);
                        break;
                    default:
                }
                com.jlboat.phone.activity.MoveTestActivity.access$300(this.this$0).setEnabled(0);
                com.jlboat.phone.activity.MoveTestActivity.access$400(this.this$0).setEnabled(0);
                com.jlboat.phone.activity.MoveTestActivity.access$500(this.this$0).setEnabled(0);
                com.jlboat.phone.activity.MoveTestActivity.access$600(this.this$0).setEnabled(0);
                break;
            case 101:
                com.jlboat.phone.activity.MoveTestActivity.access$800(this.this$0).setData(com.jlboat.phone.activity.MoveTestActivity.access$100(this.this$0), com.jlboat.phone.activity.MoveTestActivity.access$700(this.this$0));
                com.jlboat.phone.activity.MoveTestActivity.access$900(this.this$0).scrollToPosition((com.jlboat.phone.activity.MoveTestActivity.access$100(this.this$0).size() - 1));
                break;
            case 102:
                com.jlboat.phone.util.Utils.toast("\u6d4b\u8bd5\u5b8c\u6210");
                com.jlboat.phone.activity.MoveTestActivity.access$1000(this.this$0);
                break;
            case 103:
                com.jlboat.phone.util.Utils.toast("\u6d4b\u8bd5\u53d6\u6d88");
                com.jlboat.phone.activity.MoveTestActivity.access$1000(this.this$0);
                break;
            default:
        }
        return;
    }
}
