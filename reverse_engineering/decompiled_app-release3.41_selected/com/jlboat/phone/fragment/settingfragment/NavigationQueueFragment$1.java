package com.jlboat.phone.fragment.settingfragment;
 class NavigationQueueFragment$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment this$0;

    NavigationQueueFragment$1(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p4)
    {
        super.handleMessage(p4);
        switch (p4.what) {
            case 101:
                if (!com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$000(this.this$0).trim().equals("")) {
                    com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$100(this.this$0).setText(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$000(this.this$0));
                } else {
                    com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$100(this.this$0).setText("\u672a\u547d\u540d\u5730\u56fe");
                }
                com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$400(this.this$0).setData(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$200(this.this$0), com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$300(this.this$0));
                break;
            default:
        }
        return;
    }
}
