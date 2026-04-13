package com.jlboat.phone.fragment.statusfragment;
public class AvoidFillFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "AvoidFillFragment";
    com.jlboat.phone.adapter.AddDataAdapter addDataAdapter;
    java.util.List addViewed;
    private com.boat.jrosbridge.Topic fillStatusSubscriber;
    android.widget.TextView fill_no_tv;
    private com.boat.jrosbridge.Topic fillingStatus;
    private boolean flag;
    com.boat.jrosbridge.message.std_msgs.Int16 int16;
    private android.content.Context mContext;
    private android.os.Handler mainHandler;
    android.support.v7.widget.RecyclerView rvAddNewView;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    public AvoidFillFragment()
    {
        this.int16 = new com.boat.jrosbridge.message.std_msgs.Int16();
        this.addViewed = new java.util.LinkedList();
        this.flag = 0;
        return;
    }

    static synthetic boolean access$000(com.jlboat.phone.fragment.statusfragment.AvoidFillFragment p1)
    {
        return p1.flag;
    }

    static synthetic boolean access$002(com.jlboat.phone.fragment.statusfragment.AvoidFillFragment p0, boolean p1)
    {
        p0.flag = p1;
        return p1;
    }

    static synthetic void access$100(com.jlboat.phone.fragment.statusfragment.AvoidFillFragment p0)
    {
        p0.update();
        return;
    }

    private declared_synchronized void update()
    {
        try {
            this.addDataAdapter.notifyDataSetChanged();
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    protected void init()
    {
        this.fillStatusSubscriber = new com.boat.jrosbridge.Topic("InfraredRangeSensor_Distance", com.boat.jrosbridge.message.std_msgs.Int16MultiArray, com.jlboat.phone.application.BoatSlamApplication.client);
        this.fillStatusSubscriber.subscribe(new com.jlboat.phone.fragment.statusfragment.AvoidFillFragment$1(this));
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

    protected android.view.View initView(android.view.LayoutInflater p5, android.view.ViewGroup p6)
    {
        com.boat.jrosbridge.message.Log.d("AvoidFillFragment", "initView called");
        android.view.View v0_2 = p5.inflate(2131361868, p6, 0);
        this.fill_no_tv = ((android.widget.TextView) v0_2.findViewById(2131230917));
        this.rvAddNewView = ((android.support.v7.widget.RecyclerView) v0_2.findViewById(2131231220));
        this.rvAddNewView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this.act));
        this.addDataAdapter = new com.jlboat.phone.adapter.AddDataAdapter(this.addViewed);
        this.rvAddNewView.setAdapter(this.addDataAdapter);
        return v0_2;
    }

    public void onClick(android.view.View p1)
    {
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
        this.fillStatusSubscriber.unsubscribe();
        return;
    }

    public void onResume()
    {
        super.onResume();
        this.init();
        return;
    }
}
