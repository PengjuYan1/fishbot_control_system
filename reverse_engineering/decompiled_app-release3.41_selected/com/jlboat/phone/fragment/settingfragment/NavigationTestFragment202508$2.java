package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment202508$2 implements android.text.TextWatcher {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 this$0;

    NavigationTestFragment202508$2(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void afterTextChanged(android.text.Editable p7)
    {
        String v0 = p7.toString();
        if (p7.length() > 4) {
            p7.delete(4, p7.length());
        }
        if (v0.isEmpty()) {
            v0 = "0";
            this.this$0.getConfigs(9);
        }
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$902(this.this$0, v0.replace("\'", ""));
        ((com.jlboat.phone.message.map_msgs.Config) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$1000(this.this$0).get(0)).setConfigValue(v0.replace("\'", ""));
        this.this$0.statusServiceClient.setOrDelConfigsService(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$1000(this.this$0), 9, new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508$2$1(this));
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
