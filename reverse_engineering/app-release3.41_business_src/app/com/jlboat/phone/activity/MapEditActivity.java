package com.jlboat.phone.activity;
public class MapEditActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapEditActivity";
    android.widget.Button diy_charging_piles_bt;
    android.widget.Button diy_path_bt;
    android.widget.Button diy_pointpath_bt;
    android.widget.Button edit_map_bt;
    android.widget.Button edit_region_bt;
    android.widget.Button edit_wall_bt;
    android.widget.Button expansion_map_bt;
    android.widget.Button new_map_bt;
    android.widget.Button reloc_map_bt;

    public MapEditActivity()
    {
        return;
    }

    public void onClick(android.view.View p4)
    {
        switch (p4.getId()) {
            case 2131230877:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapEditChargeActivity));
                break;
            case 2131230878:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.DiyPathActivity));
                break;
            case 2131230879:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.DiyPointPathActivity));
                break;
            case 2131230881:
                android.util.Log.d("MapEditActivity", new StringBuilder().append("onClick: aaaaa ").append(com.jlboat.phone.application.BoatSlamApplication.classis_version_code).toString());
                if (com.jlboat.phone.application.BoatSlamApplication.classis_version_code <= 428) {
                    this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapEditMapActivity));
                } else {
                    this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapEditMapActivity2025));
                }
                break;
            case 2131230883:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapEditRegionActivity));
                break;
            case 2131230884:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapEditShapeActivity));
                break;
            case 2131230914:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapExpansionActivity));
                break;
            case 2131231042:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapActivity).putExtra("isCreate", 1));
                break;
            case 2131231146:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapRepositionActivity));
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361894, 2131492954);
        super.onCreate(p3);
        this.edit_map_bt = ((android.widget.Button) this.findViewById(2131230881));
        this.edit_wall_bt = ((android.widget.Button) this.findViewById(2131230884));
        this.edit_region_bt = ((android.widget.Button) this.findViewById(2131230883));
        this.new_map_bt = ((android.widget.Button) this.findViewById(2131231042));
        this.expansion_map_bt = ((android.widget.Button) this.findViewById(2131230914));
        this.reloc_map_bt = ((android.widget.Button) this.findViewById(2131231146));
        this.diy_path_bt = ((android.widget.Button) this.findViewById(2131230878));
        this.diy_pointpath_bt = ((android.widget.Button) this.findViewById(2131230879));
        this.diy_charging_piles_bt = ((android.widget.Button) this.findViewById(2131230877));
        this.edit_map_bt.setOnClickListener(this);
        this.edit_wall_bt.setOnClickListener(this);
        this.edit_region_bt.setOnClickListener(this);
        this.new_map_bt.setOnClickListener(this);
        this.expansion_map_bt.setOnClickListener(this);
        this.reloc_map_bt.setOnClickListener(this);
        this.diy_path_bt.setOnClickListener(this);
        this.diy_pointpath_bt.setOnClickListener(this);
        this.diy_charging_piles_bt.setOnClickListener(this);
        return;
    }
}
