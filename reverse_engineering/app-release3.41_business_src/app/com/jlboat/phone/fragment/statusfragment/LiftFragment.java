package com.jlboat.phone.fragment.statusfragment;
public class LiftFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "LiftFragment";
    android.widget.Button cameraOpen;
    private java.util.List configList;
    android.widget.Button drop_tv;
    private boolean flag;
    com.boat.jrosbridge.message.std_msgs.Int16 int16;
    private com.boat.jrosbridge.Topic jackingStatus;
    private com.boat.jrosbridge.Topic jackingStatusSubscriber;
    android.widget.Button jacking_tv;
    android.widget.TextView lift_no_tv;
    private android.content.Context mContext;
    private android.os.Handler mainHandler;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    public LiftFragment()
    {
        this.flag = 0;
        this.configList = new java.util.LinkedList();
        this.int16 = new com.boat.jrosbridge.message.std_msgs.Int16();
        return;
    }

    static synthetic android.os.Handler access$000(com.jlboat.phone.fragment.statusfragment.LiftFragment p1)
    {
        return p1.mainHandler;
    }

    private void handleDropButtonClick()
    {
        if (this.jackingStatus == null) {
            com.boat.jrosbridge.message.Log.d("LiftFragment", "Topic\u672a\u521d\u59cb\u5316\u6210\u529f");
        } else {
            this.int16.setData(2);
            this.jackingStatus.publish(this.int16);
            com.boat.jrosbridge.message.Log.d("LiftFragment", "Topic\u843d\u4e0b\u547d\u4ee4\u5df2\u53d1\u9001");
        }
        return;
    }

    private void handleJackingButtonClick()
    {
        if (this.jackingStatus == null) {
            com.boat.jrosbridge.message.Log.d("LiftFragment", "Topic\u672a\u521d\u59cb\u5316\u6210\u529f");
        } else {
            this.int16.setData(1);
            this.jackingStatus.publish(this.int16);
            com.boat.jrosbridge.message.Log.d("LiftFragment", "Topic\u9876\u8d77\u547d\u4ee4\u5df2\u53d1\u9001");
        }
        return;
    }

    protected void init()
    {
        this.jackingStatus = new com.boat.jrosbridge.Topic("jacking_status", com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.jackingStatus.advertise();
        this.jackingStatusSubscriber = new com.boat.jrosbridge.Topic("current_jacking_status", com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.jackingStatusSubscriber.subscribe(new com.jlboat.phone.fragment.statusfragment.LiftFragment$1(this));
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
        com.boat.jrosbridge.message.Log.d("LiftFragment", "initView called");
        android.view.View v0_2 = p3.inflate(2131361871, p4, 0);
        this.lift_no_tv = ((android.widget.TextView) v0_2.findViewById(2131230956));
        this.jacking_tv = ((android.widget.Button) v0_2.findViewById(2131230949));
        this.drop_tv = ((android.widget.Button) v0_2.findViewById(2131230880));
        if (this.jacking_tv != null) {
            this.jacking_tv.setOnClickListener(this);
        }
        if (this.drop_tv != null) {
            this.drop_tv.setOnClickListener(this);
        }
        return v0_2;
    }

    public void onClick(android.view.View p2)
    {
        switch (p2.getId()) {
            case 2131230880:
                this.handleDropButtonClick();
                break;
            case 2131230949:
                this.handleJackingButtonClick();
                break;
            default:
        }
        return;
    }

    public android.view.View onCreateView(android.view.LayoutInflater p3, android.view.ViewGroup p4, android.os.Bundle p5)
    {
        this.mContext = this.getActivity();
        com.boat.jrosbridge.message.Log.d("LiftFragment", "onCreateView called");
        this.mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.init();
        return super.onCreateView(p3, p4, p5);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (this.jackingStatus != null) {
            this.jackingStatus.unadvertise();
            this.jackingStatus = 0;
        }
        return;
    }
}
