package com.jlboat.phone.activity;
public class MapControlActivity extends com.jlboat.phone.base.BaseFullActivity {
    private static final String TAG = "MapControlActivity";
    com.jlboat.phone.view.MapView mapView;
    private com.jlboat.phone.view.JoystickView virtualJoystickView;

    public MapControlActivity()
    {
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361891, 2131493093);
        super.onCreate(p3);
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230984));
        this.virtualJoystickView = ((com.jlboat.phone.view.JoystickView) this.findViewById(2131231359));
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.mapView.onStop();
        this.virtualJoystickView.onStop();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.mapView.onStart(this.getMyApplication());
        this.virtualJoystickView.setDy(1);
        this.virtualJoystickView.onStart();
        return;
    }
}
