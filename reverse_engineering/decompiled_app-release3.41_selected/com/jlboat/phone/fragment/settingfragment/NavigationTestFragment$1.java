package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment this$0;

    NavigationTestFragment$1(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p4)
    {
        super.handleMessage(p4);
        switch (p4.what) {
            case 101:
                if (!com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$000(this.this$0).trim().equals("")) {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$100(this.this$0).setText(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$000(this.this$0));
                } else {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$100(this.this$0).setText("\u672a\u547d\u540d\u5730\u56fe");
                }
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$400(this.this$0).setData(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$200(this.this$0), com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$300(this.this$0));
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$500(this.this$0).setData(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$300(this.this$0));
                if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$300(this.this$0).size() <= 0) {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$700(this.this$0).setVisibility(0);
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$600(this.this$0).setVisibility(8);
                } else {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$600(this.this$0).setVisibility(0);
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$700(this.this$0).setVisibility(8);
                }
                break;
            default:
        }
        return;
    }
}
