package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 this$0;

    NavigationTestFragment2025$1(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p4)
    {
        super.handleMessage(p4);
        switch (p4.what) {
            case 101:
                if (!com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$000(this.this$0).trim().equals("")) {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$100(this.this$0).setText(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$000(this.this$0));
                } else {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$100(this.this$0).setText("\u672a\u547d\u540d\u5730\u56fe");
                }
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$400(this.this$0).setData(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$200(this.this$0), com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$300(this.this$0));
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$500(this.this$0).setData(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$300(this.this$0));
                if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$600(this.this$0).size() <= 0) {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$800(this.this$0).setVisibility(0);
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$700(this.this$0).setVisibility(8);
                } else {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$700(this.this$0).setVisibility(0);
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$800(this.this$0).setVisibility(8);
                }
                break;
            default:
        }
        return;
    }
}
