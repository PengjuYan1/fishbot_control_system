package com.jlboat.phone.fragment.statusfragment;
public class ImuFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "ImuFragment";
    com.jlboat.phone.adapter.AddDataAdapter addDataAdapter;
    java.util.List addViewed;
    private boolean flag;
    android.widget.TextView imu_no_tv;
    private android.content.Context mContext;
    private com.boat.jrosbridge.Topic odometrySubscriber;
    android.support.v7.widget.RecyclerView rvAddNewView;
    android.widget.TextView tv_fg_yaw;
    String yaw;

    public ImuFragment()
    {
        this.addViewed = new java.util.LinkedList();
        this.flag = 1;
        return;
    }

    static synthetic void access$000(com.jlboat.phone.fragment.statusfragment.ImuFragment p0)
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
        this.odometrySubscriber = new com.boat.jrosbridge.Topic("imu/data", com.boat.jrosbridge.message.sensor_msgs.Imu, com.jlboat.phone.application.BoatSlamApplication.client);
        this.odometrySubscriber.subscribe(new com.jlboat.phone.fragment.statusfragment.ImuFragment$1(this));
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
        android.view.View v0_1 = p5.inflate(2131361869, p6, 0);
        this.imu_no_tv = ((android.widget.TextView) v0_1.findViewById(2131230934));
        this.rvAddNewView = ((android.support.v7.widget.RecyclerView) v0_1.findViewById(2131231220));
        this.rvAddNewView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this.act));
        this.addDataAdapter = new com.jlboat.phone.adapter.AddDataAdapter(this.addViewed);
        this.rvAddNewView.setAdapter(this.addDataAdapter);
        return v0_1;
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

    public void onDestroyView()
    {
        super.onDestroyView();
        return;
    }

    public void onPause()
    {
        super.onPause();
        this.odometrySubscriber.unsubscribe();
        return;
    }

    public void onResume()
    {
        super.onResume();
        this.init();
        return;
    }
}
