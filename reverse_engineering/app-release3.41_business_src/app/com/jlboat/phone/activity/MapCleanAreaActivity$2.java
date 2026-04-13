package com.jlboat.phone.activity;
 class MapCleanAreaActivity$2 implements com.jlboat.phone.adapter.CleanAreaRvAdapter$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity this$0;

    MapCleanAreaActivity$2(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(long p3, boolean p5)
    {
        if (com.jlboat.phone.activity.MapCleanAreaActivity.access$000(this.this$0) != null) {
            if (!com.jlboat.phone.activity.MapCleanAreaActivity.access$100(this.this$0).contains(Long.valueOf(p3))) {
                com.jlboat.phone.activity.MapCleanAreaActivity.access$100(this.this$0).add(Long.valueOf(p3));
            } else {
                com.jlboat.phone.activity.MapCleanAreaActivity.access$100(this.this$0).remove(Long.valueOf(p3));
            }
            android.util.Log.d("MapCleanAreaActivity", new StringBuilder().append("onCheckedChanged: longs .size ").append(com.jlboat.phone.activity.MapCleanAreaActivity.access$100(this.this$0).toString()).toString());
            this.this$0.bt_start_clean_area.setVisibility(8);
            if ((com.jlboat.phone.activity.MapCleanAreaActivity.access$100(this.this$0) != null) && (com.jlboat.phone.activity.MapCleanAreaActivity.access$100(this.this$0).size() > 0)) {
                this.this$0.bt_start_clean_area.setVisibility(0);
            }
        }
        return;
    }
}
