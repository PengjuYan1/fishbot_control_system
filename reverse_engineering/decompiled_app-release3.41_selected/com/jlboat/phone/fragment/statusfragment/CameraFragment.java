package com.jlboat.phone.fragment.statusfragment;
public class CameraFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "CameraFragment";
    android.widget.Button add_tv;
    android.widget.Button cameraOpen;
    android.widget.Button cameraSet;
    private java.util.List configList;
    private boolean flag;
    com.jlboat.phone.view.LaserCameraView laserView;
    private android.content.Context mContext;
    android.widget.Button reduce_tv;
    android.widget.TextView scan_no_tv;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    public CameraFragment()
    {
        this.flag = 1;
        this.configList = new java.util.concurrent.CopyOnWriteArrayList();
        return;
    }

    static synthetic java.util.List access$000(com.jlboat.phone.fragment.statusfragment.CameraFragment p1)
    {
        return p1.configList;
    }

    static synthetic android.os.Handler access$100(com.jlboat.phone.fragment.statusfragment.CameraFragment p1)
    {
        return p1.handler;
    }

    static synthetic void access$200(com.jlboat.phone.fragment.statusfragment.CameraFragment p0, CharSequence p1)
    {
        p0.showToast(p1);
        return;
    }

    static synthetic void access$300(com.jlboat.phone.fragment.statusfragment.CameraFragment p0, String p1)
    {
        p0.robotSsh(p1);
        return;
    }

    static synthetic android.os.Handler access$400(com.jlboat.phone.fragment.statusfragment.CameraFragment p1)
    {
        return p1.handler;
    }

    private void robotSsh(String p3)
    {
        this.spiritServiceClient.robotSshService(p3, new com.jlboat.phone.fragment.statusfragment.CameraFragment$4(this));
        return;
    }

    private void setConfig(java.util.List p3, int p4)
    {
        this.statusServiceClient.setOrDelConfigsService(p3, p4, new com.jlboat.phone.fragment.statusfragment.CameraFragment$3(this));
        return;
    }

    public void getConfigs(int p3)
    {
        android.util.Log.d("CameraFragment", new StringBuilder().append("onNewMessage: aaa333 ").append(p3).toString());
        if (this.statusServiceClient != null) {
            this.statusServiceClient.getConfigsService(p3, new com.jlboat.phone.fragment.statusfragment.CameraFragment$2(this));
            return;
        } else {
            android.util.Log.e("CameraFragment", "getConfigs: \u8c03\u7528\u5931\u8d25\uff01statusServiceClient \u4e3a null");
            return;
        }
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
        android.view.View v0_1 = p4.inflate(2131361866, p5, 0);
        this.scan_no_tv = ((android.widget.TextView) v0_1.findViewById(2131231226));
        this.cameraOpen = ((android.widget.Button) v0_1.findViewById(2131230794));
        this.add_tv = ((android.widget.Button) v0_1.findViewById(2131230752));
        this.reduce_tv = ((android.widget.Button) v0_1.findViewById(2131231145));
        this.laserView = ((com.jlboat.phone.view.LaserCameraView) v0_1.findViewById(2131230951));
        this.cameraOpen.setOnClickListener(this);
        this.add_tv.setOnClickListener(this);
        this.reduce_tv.setOnClickListener(this);
        this.laserView.setHasData(new com.jlboat.phone.fragment.statusfragment.CameraFragment$1(this));
        this.init();
        return v0_1;
    }

    public void onClick(android.view.View p6)
    {
        int v0_2 = this.laserView.getMatrix1();
        switch (p6.getId()) {
            case 2131230752:
                this.reduce_tv.setEnabled(1);
                int v0_3 = (v0_2 + 40);
                if (v0_3 >= 300) {
                    this.add_tv.setEnabled(0);
                }
                this.laserView.setMatrix1(v0_3);
                break;
            case 2131230794:
                this.getConfigs(9);
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
                this.laserView.setMatrix1(v0_1);
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
        android.util.Log.d("CameraFragment", "getConfigs:91");
        this.getConfigs(9);
        android.util.Log.d("CameraFragment", "getConfigs:92");
        return;
    }
}
