package com.jlboat.phone.fragment.statusfragment;
public class InfraredFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "InfraredFragment";
    private android.widget.Switch bt_infrared_open;
    private com.jlboat.phone.view.CustomProgress customProgress;
    private com.boat.jrosbridge.Topic irSubscriber;
    private boolean isOpen;
    private android.content.Context mContext;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    public InfraredFragment()
    {
        this.isOpen = 0;
        return;
    }

    static synthetic com.jlboat.phone.view.CustomProgress access$000(com.jlboat.phone.fragment.statusfragment.InfraredFragment p1)
    {
        return p1.customProgress;
    }

    static synthetic boolean access$100(com.jlboat.phone.fragment.statusfragment.InfraredFragment p1)
    {
        return p1.isOpen;
    }

    static synthetic boolean access$102(com.jlboat.phone.fragment.statusfragment.InfraredFragment p0, boolean p1)
    {
        p0.isOpen = p1;
        return p1;
    }

    static synthetic android.widget.Switch access$200(com.jlboat.phone.fragment.statusfragment.InfraredFragment p1)
    {
        return p1.bt_infrared_open;
    }

    static synthetic android.os.Handler access$300(com.jlboat.phone.fragment.statusfragment.InfraredFragment p1)
    {
        return p1.handler;
    }

    private void init()
    {
        this.irSubscriber = new com.boat.jrosbridge.Topic("dte_ircode", com.jlboat.phone.message.map_msgs.RobotIrCode, com.jlboat.phone.application.BoatSlamApplication.client);
        this.irSubscriber.subscribe(new com.jlboat.phone.fragment.statusfragment.InfraredFragment$1(this));
        return;
    }

    private void setInfraredStatus()
    {
        int v1_1;
        if (!this.isOpen) {
            v1_1 = 20;
        } else {
            v1_1 = 21;
        }
        this.statusServiceClient.setTestDriverService(v1_1, new com.jlboat.phone.fragment.statusfragment.InfraredFragment$2(this));
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

    protected android.view.View initView(android.view.LayoutInflater p3, android.view.ViewGroup p4)
    {
        android.view.View v0_1 = p3.inflate(2131361875, p4, 0);
        this.bt_infrared_open = ((android.widget.Switch) v0_1.findViewById(2131230812));
        this.customProgress = ((com.jlboat.phone.view.CustomProgress) v0_1.findViewById(2131230863));
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.bt_infrared_open.setOnClickListener(this);
        return v0_1;
    }

    public void onClick(android.view.View p2)
    {
        switch (p2.getId()) {
            case 2131230812:
                this.setInfraredStatus();
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
        this.irSubscriber.unsubscribe();
        this.isOpen = 1;
        this.setInfraredStatus();
        return;
    }

    public void onResume()
    {
        super.onResume();
        this.init();
        return;
    }

    public void onStart()
    {
        super.onStart();
        return;
    }
}
