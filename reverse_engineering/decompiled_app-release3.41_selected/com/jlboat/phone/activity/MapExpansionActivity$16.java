package com.jlboat.phone.activity;
 class MapExpansionActivity$16 implements android.widget.AdapterView$OnItemSelectedListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;
    final synthetic int[] val$selectFloorIndex;

    MapExpansionActivity$16(com.jlboat.phone.activity.MapExpansionActivity p1, int[] p2)
    {
        this.this$0 = p1;
        this.val$selectFloorIndex = p2;
        return;
    }

    public void onItemSelected(android.widget.AdapterView p3, android.view.View p4, int p5, long p6)
    {
        android.util.Log.d("MapExpansionActivity", new StringBuilder().append("spinner_floors onItemClick: ").append(p5).toString());
        this.val$selectFloorIndex[0] = p5;
        return;
    }

    public void onNothingSelected(android.widget.AdapterView p3)
    {
        android.util.Log.d("MapExpansionActivity", "spinner_floors onItemClick: noth");
        return;
    }
}
