package com.jlboat.phone.view;
 class BagListAdapter$2 extends android.os.Handler {
    final synthetic com.jlboat.phone.view.BagListAdapter this$0;

    BagListAdapter$2(com.jlboat.phone.view.BagListAdapter p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p3)
    {
        switch (p3.what) {
            case 1:
                if (com.jlboat.phone.view.BagListAdapter.access$200(this.this$0) != 0) {
                    if (com.jlboat.phone.view.BagListAdapter.access$200(this.this$0) != 1) {
                        com.jlboat.phone.view.BagListAdapter.showToast(com.jlboat.phone.view.BagListAdapter.access$300(this.this$0), "\u4e0a\u4f20\u51fa\u9519");
                    } else {
                        com.jlboat.phone.view.BagListAdapter.showToast(com.jlboat.phone.view.BagListAdapter.access$300(this.this$0), "bag\u5305\u540d\u5b57\u4e0d\u5b58\u5728");
                    }
                } else {
                    com.jlboat.phone.view.BagListAdapter.showToast(com.jlboat.phone.view.BagListAdapter.access$300(this.this$0), "\u4e0a\u4f20\u6210\u529f");
                }
                break;
            default:
        }
        return;
    }
}
