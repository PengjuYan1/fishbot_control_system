package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025$2 implements android.text.TextWatcher {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 this$0;

    NavigationTestFragment2025$2(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void afterTextChanged(android.text.Editable p6)
    {
        String v0 = p6.toString();
        if (p6.length() > 4) {
            p6.delete(4, p6.length());
        }
        if (v0.isEmpty()) {
            v0 = "0";
            this.this$0.getConfigs(9);
        }
        ((com.jlboat.phone.message.map_msgs.Config) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$900(this.this$0).get(0)).setConfigValue(v0);
        this.this$0.statusServiceClient.setOrDelConfigsService(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$900(this.this$0), 9, new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$2$1(this));
        return;
    }

    public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }

    public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }
}
