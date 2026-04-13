package com.jlboat.phone.activity;
 class SettingActivity$1 implements android.text.TextWatcher {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$1(com.jlboat.phone.activity.SettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void afterTextChanged(android.text.Editable p6)
    {
        android.util.Log.e(com.jlboat.phone.activity.SettingActivity.access$000(this.this$0), "robotAutoChangePowerBt");
        if (p6.length() > 2) {
            p6.delete(2, p6.length());
        }
        String v0_2 = p6.toString();
        if (v0_2.isEmpty()) {
            v0_2 = "10";
            this.this$0.getConfigs(9);
        }
        ((com.jlboat.phone.message.map_msgs.Config) com.jlboat.phone.activity.SettingActivity.access$100(this.this$0).get(0)).setConfigValue(v0_2);
        this.this$0.statusServiceClient.setOrDelConfigsService(com.jlboat.phone.activity.SettingActivity.access$100(this.this$0), 9, new com.jlboat.phone.activity.SettingActivity$1$1(this));
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
