package com.jlboat.phone.activity;
 class MapActivity$20 implements android.widget.AdapterView$OnItemSelectedListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic String[] val$bind_point;
    final synthetic android.widget.Spinner val$point_bind;
    final synthetic int[] val$selectIndex2;

    MapActivity$20(com.jlboat.phone.activity.MapActivity p1, int[] p2, String[] p3, android.widget.Spinner p4)
    {
        this.this$0 = p1;
        this.val$selectIndex2 = p2;
        this.val$bind_point = p3;
        this.val$point_bind = p4;
        return;
    }

    public void onItemSelected(android.widget.AdapterView p4, android.view.View p5, int p6, long p7)
    {
        android.util.Log.d("MapActivity", new StringBuilder().append("point_bind onItemClick: ").append(p6).toString());
        this.val$selectIndex2[0] = p6;
        this.val$bind_point[0] = this.val$point_bind.getSelectedItem().toString();
        return;
    }

    public void onNothingSelected(android.widget.AdapterView p3)
    {
        android.util.Log.d("MapActivity", "point_bind onItemClick: noth");
        return;
    }
}
