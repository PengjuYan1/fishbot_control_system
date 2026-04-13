package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025lift$2 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift this$0;

    NavigationTestFragment2025lift$2(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(android.view.View p4)
    {
        android.util.Log.d(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$500(this.this$0), "\u70b9\u51fb\u6dfb\u52a0\u961f\u5217");
        if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$300(this.this$0).size() == 2) {
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$600(this.this$0);
            com.jlboat.phone.util.Utils.toast("\u6dfb\u52a0\u6210\u529f");
            android.util.Log.d(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$500(this.this$0), new StringBuilder().append("\u6dfb\u52a0\u540e\u961f\u5217\uff1a").append(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$700(this.this$0).toString()).toString());
            return;
        } else {
            com.jlboat.phone.util.Utils.toast("\u8bf7\u9009\u62e9\u4e24\u4e2a\u70b9\u4f4d");
            android.util.Log.e(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$500(this.this$0), "\u8bf7\u9009\u62e9\u4e24\u4e2a\u70b9\u4f4d");
            return;
        }
    }
}
