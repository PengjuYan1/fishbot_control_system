package com.jlboat.phone.adapter;
 class ConfigListAdapter$3 extends android.os.Handler {
    final synthetic com.jlboat.phone.adapter.ConfigListAdapter this$0;

    ConfigListAdapter$3(com.jlboat.phone.adapter.ConfigListAdapter p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p6)
    {
        switch (p6.what) {
            case 1:
                if (com.jlboat.phone.adapter.ConfigListAdapter.access$700(this.this$0) != 0) {
                    com.jlboat.phone.adapter.ConfigListAdapter.showToast(com.jlboat.phone.adapter.ConfigListAdapter.access$300(this.this$0), com.jlboat.phone.adapter.ConfigListAdapter.access$300(this.this$0).getResources().getString(2131493305));
                } else {
                    com.jlboat.phone.adapter.ConfigListAdapter.access$900(this.this$0).getConfigs(0);
                    com.jlboat.phone.adapter.ConfigListAdapter.showToast(com.jlboat.phone.adapter.ConfigListAdapter.access$300(this.this$0), com.jlboat.phone.adapter.ConfigListAdapter.access$300(this.this$0).getResources().getString(2131493306));
                }
                break;
            default:
        }
        return;
    }
}
