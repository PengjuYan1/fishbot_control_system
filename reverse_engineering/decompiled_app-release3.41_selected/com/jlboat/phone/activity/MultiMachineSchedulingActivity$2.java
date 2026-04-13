package com.jlboat.phone.activity;
 class MultiMachineSchedulingActivity$2 implements android.text.TextWatcher {
    final synthetic com.jlboat.phone.activity.MultiMachineSchedulingActivity this$0;

    MultiMachineSchedulingActivity$2(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void afterTextChanged(android.text.Editable p6)
    {
        String v0 = p6.toString();
        if (p6.length() > 2) {
            p6.delete(2, p6.length());
        }
        if (v0.isEmpty()) {
            v0 = "5";
            this.this$0.getConfigs(1);
        }
        android.util.Log.d("MultiMachineSchedulingActivity", new StringBuilder().append("configList2:").append(com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$000(this.this$0)).toString());
        if (com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$000(this.this$0).size() > 1) {
            ((com.jlboat.phone.message.map_msgs.Config) com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$000(this.this$0).get(1)).setConfigValue(v0);
            com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$100(this.this$0).setOrDelConfigsService(com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$000(this.this$0), 1, new com.jlboat.phone.activity.MultiMachineSchedulingActivity$2$1(this));
        }
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
