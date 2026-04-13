package com.jlboat.phone.activity;
 class PointBindPathActivity$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity this$0;

    PointBindPathActivity$1(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p6)
    {
        super.handleMessage(p6);
        switch (p6.what) {
            case 1001:
                if (com.jlboat.phone.activity.PointBindPathActivity.access$000(this.this$0) != null) {
                } else {
                    com.jlboat.phone.activity.PointBindPathActivity.access$002(this.this$0, com.jlboat.phone.util.Utils.showLoading(this.this$0, 2131361892, this.this$0.getResString(2131493126)));
                }
                break;
            case 1002:
                if (com.jlboat.phone.activity.PointBindPathActivity.access$000(this.this$0) == null) {
                } else {
                    com.jlboat.phone.activity.PointBindPathActivity.access$000(this.this$0).dismiss();
                    com.jlboat.phone.activity.PointBindPathActivity.access$002(this.this$0, 0);
                }
                break;
            case 1003:
                com.jlboat.phone.activity.PointBindPathActivity.access$100(this.this$0).setData(this.this$0.newAddPos);
                if (com.jlboat.phone.activity.PointBindPathActivity.access$200(this.this$0) == null) {
                } else {
                    com.jlboat.phone.activity.PointBindPathActivity.access$300(this.this$0).setVisibility(0);
                    com.jlboat.phone.activity.PointBindPathActivity.access$500(this.this$0).setData(com.jlboat.phone.activity.PointBindPathActivity.access$400(this.this$0));
                    com.jlboat.phone.activity.PointBindPathActivity.access$602(this.this$0, com.jlboat.phone.activity.PointBindPathActivity.access$200(this.this$0).getAddPoints());
                    com.jlboat.phone.activity.PointBindPathActivity.access$700(this.this$0).setText(new StringBuilder().append("\u8def\u7ebf:").append(com.jlboat.phone.activity.PointBindPathActivity.access$200(this.this$0).getGlobalplanName()).toString());
                    if ((com.jlboat.phone.activity.PointBindPathActivity.access$600(this.this$0) == null) || (com.jlboat.phone.activity.PointBindPathActivity.access$600(this.this$0).size() <= 0)) {
                        com.jlboat.phone.activity.PointBindPathActivity.access$800(this.this$0).setVisibility(8);
                    } else {
                        com.jlboat.phone.activity.PointBindPathActivity.access$800(this.this$0).setVisibility(0);
                        com.jlboat.phone.activity.PointBindPathActivity.access$900(this.this$0).setData(com.jlboat.phone.activity.PointBindPathActivity.access$600(this.this$0), com.jlboat.phone.activity.PointBindPathActivity.access$400(this.this$0));
                        com.jlboat.phone.activity.PointBindPathActivity.access$900(this.this$0).setOnItemClickListener(new com.jlboat.phone.activity.PointBindPathActivity$BindPointItemCL(this.this$0, 0));
                    }
                }
                break;
            default:
        }
        return;
    }
}
