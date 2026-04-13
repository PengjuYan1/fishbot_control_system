package com.jlboat.phone.fragment.statusfragment;
public class Camera03Fragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "CameraFragment";
    android.widget.Button add_tv;
    android.widget.Button cameraOpen;
    private java.util.List configList;
    private boolean flag;
    com.jlboat.phone.view.LaserCamera03View laserView;
    private android.content.Context mContext;
    android.widget.Button reduce_tv;
    android.widget.TextView scan_no_tv;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    public Camera03Fragment()
    {
        this.flag = 1;
        this.configList = new java.util.LinkedList();
        return;
    }

    static synthetic void access$000(com.jlboat.phone.fragment.statusfragment.Camera03Fragment p0, CharSequence p1)
    {
        p0.showToast(p1);
        return;
    }

    static synthetic void access$100(com.jlboat.phone.fragment.statusfragment.Camera03Fragment p0, String p1)
    {
        p0.robotSsh(p1);
        return;
    }

    static synthetic android.os.Handler access$200(com.jlboat.phone.fragment.statusfragment.Camera03Fragment p1)
    {
        return p1.handler;
    }

    private void robotSsh(String p3)
    {
        this.spiritServiceClient.robotSshService(p3, new com.jlboat.phone.fragment.statusfragment.Camera03Fragment$3(this));
        return;
    }

    private void setConfig(java.util.List p3, int p4)
    {
        this.statusServiceClient.setOrDelConfigsService(p3, p4, new com.jlboat.phone.fragment.statusfragment.Camera03Fragment$2(this));
        return;
    }

    public void getConfigs(int p1)
    {
        return;
    }

    protected void init()
    {
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        return;
    }

    protected void initData()
    {
        return;
    }

    protected void initListener()
    {
        return;
    }

    protected android.view.View initView(android.view.LayoutInflater p4, android.view.ViewGroup p5)
    {
        android.view.View v0_1 = p4.inflate(2131361867, p5, 0);
        this.scan_no_tv = ((android.widget.TextView) v0_1.findViewById(2131231226));
        this.cameraOpen = ((android.widget.Button) v0_1.findViewById(2131230794));
        this.add_tv = ((android.widget.Button) v0_1.findViewById(2131230752));
        this.reduce_tv = ((android.widget.Button) v0_1.findViewById(2131231145));
        this.laserView = ((com.jlboat.phone.view.LaserCamera03View) v0_1.findViewById(2131230951));
        this.cameraOpen.setOnClickListener(this);
        this.add_tv.setOnClickListener(this);
        this.reduce_tv.setOnClickListener(this);
        this.laserView.setHasData(new com.jlboat.phone.fragment.statusfragment.Camera03Fragment$1(this));
        this.init();
        return v0_1;
    }

    public void onClick(android.view.View p5)
    {
        int v0_2 = this.laserView.getMatrix1();
        switch (p5.getId()) {
            case 2131230752:
                this.reduce_tv.setEnabled(1);
                int v0_3 = (v0_2 + 40);
                if (v0_3 >= 300) {
                    this.add_tv.setEnabled(0);
                }
                this.laserView.setMatrix(v0_3);
                break;
            case 2131230794:
                ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigName("startcamera");
                if (!this.cameraOpen.getText().equals(this.getString(2131492939))) {
                    ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigValue("False");
                } else {
                    ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigValue("True");
                }
                this.setConfig(this.configList, 9);
                break;
            case 2131231145:
                this.add_tv.setEnabled(1);
                int v0_1 = (v0_2 - 40);
                if (v0_1 <= 20) {
                    this.reduce_tv.setEnabled(0);
                }
                this.laserView.setMatrix(v0_1);
                break;
            default:
        }
        return;
    }

    public android.view.View onCreateView(android.view.LayoutInflater p2, android.view.ViewGroup p3, android.os.Bundle p4)
    {
        this.mContext = this.getActivity();
        return super.onCreateView(p2, p3, p4);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        return;
    }

    public void onPause()
    {
        super.onPause();
        this.laserView.onStop();
        return;
    }

    public void onResume()
    {
        super.onResume();
        this.laserView.onStart();
        this.cameraOpen.setVisibility(8);
        this.getConfigs(9);
        return;
    }
}
