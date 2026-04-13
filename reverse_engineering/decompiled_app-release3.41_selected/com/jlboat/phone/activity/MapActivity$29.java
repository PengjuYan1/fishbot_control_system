package com.jlboat.phone.activity;
 class MapActivity$29 implements android.widget.AdapterView$OnItemSelectedListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic int[] val$selectFloorIndex;

    MapActivity$29(com.jlboat.phone.activity.MapActivity p1, int[] p2)
    {
        this.this$0 = p1;
        this.val$selectFloorIndex = p2;
        return;
    }

    public void onItemSelected(android.widget.AdapterView p3, android.view.View p4, int p5, long p6)
    {
        android.util.Log.d("MapActivity", new StringBuilder().append("spinner_floors onItemClick: ").append(p5).toString());
        this.val$selectFloorIndex[0] = p5;
        return;
    }

    public void onNothingSelected(android.widget.AdapterView p3)
    {
        android.util.Log.d("MapActivity", "spinner_floors onItemClick: noth");
        return;
    }
}
