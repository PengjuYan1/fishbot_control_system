package com.jlboat.phone.fragment.calibrationfragment;
 class OmodFragment$3 extends android.os.Handler {
    final synthetic com.jlboat.phone.fragment.calibrationfragment.OmodFragment this$0;

    OmodFragment$3(com.jlboat.phone.fragment.calibrationfragment.OmodFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p3)
    {
        super.handleMessage(p3);
        switch (p3.what) {
            case 1:
                com.jlboat.phone.fragment.calibrationfragment.OmodFragment.access$200(this.this$0).setMdata(com.jlboat.phone.fragment.calibrationfragment.OmodFragment.access$000(this.this$0));
                break;
            case 2:
                com.jlboat.phone.fragment.calibrationfragment.OmodFragment.access$300(this.this$0, "\u6d4b\u8bd5\u6210\u529f");
                break;
            default:
        }
        return;
    }
}
