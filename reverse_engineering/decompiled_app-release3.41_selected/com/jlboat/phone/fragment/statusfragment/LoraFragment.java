package com.jlboat.phone.fragment.statusfragment;
public class LoraFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "LoraFragment";
    private android.widget.Button LoraBt;
    private android.widget.LinearLayout LoraLL;
    private java.util.List configList;
    private java.util.List loraInfo;
    private android.support.v7.widget.RecyclerView loraRv;
    private com.jlboat.phone.adapter.LoraStatusAdapter loraStatusAdapter;
    private android.widget.TextView loraTv;
    private android.content.Context mContext;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    public LoraFragment()
    {
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.configList = new java.util.concurrent.CopyOnWriteArrayList();
        this.loraInfo = new java.util.LinkedList();
        return;
    }

    static synthetic android.widget.TextView access$000(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        return p1.loraTv;
    }

    static synthetic java.util.List access$100(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        return p1.loraInfo;
    }

    static synthetic com.jlboat.phone.adapter.LoraStatusAdapter access$200(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        return p1.loraStatusAdapter;
    }

    static synthetic java.util.List access$300(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        return p1.configList;
    }

    static synthetic android.widget.Button access$400(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        return p1.LoraBt;
    }

    static synthetic android.widget.LinearLayout access$500(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        return p1.LoraLL;
    }

    static synthetic android.os.Handler access$600(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        return p1.handler;
    }

    static synthetic void access$700(com.jlboat.phone.fragment.statusfragment.LoraFragment p0, CharSequence p1)
    {
        p0.showToast(p1);
        return;
    }

    private void setConfig(java.util.List p3, int p4)
    {
        this.statusServiceClient.setOrDelConfigsService(p3, p4, new com.jlboat.phone.fragment.statusfragment.LoraFragment$4(this));
        return;
    }

    public void getConfigs(int p3)
    {
        this.statusServiceClient.getConfigsService(p3, new com.jlboat.phone.fragment.statusfragment.LoraFragment$3(this));
        return;
    }

    protected void init()
    {
        android.util.Log.d("LoraFragment", "init:");
        this.statusServiceClient.getLoraStatusService(new com.jlboat.phone.fragment.statusfragment.LoraFragment$1(this));
        this.spiritServiceClient.getMapsService(new com.jlboat.phone.fragment.statusfragment.LoraFragment$2(this));
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
        android.view.View v0_1 = p5.inflate(2131361872, p6, 0);
        this.LoraLL = ((android.widget.LinearLayout) v0_1.findViewById(2131230723));
        this.LoraBt = ((android.widget.Button) v0_1.findViewById(2131230813));
        this.loraTv = ((android.widget.TextView) v0_1.findViewById(2131230978));
        this.loraRv = ((android.support.v7.widget.RecyclerView) v0_1.findViewById(2131230980));
        this.loraRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this.mContext));
        this.loraStatusAdapter = new com.jlboat.phone.adapter.LoraStatusAdapter(this.mContext);
        this.loraRv.setAdapter(this.loraStatusAdapter);
        this.LoraBt.setOnClickListener(this);
        return v0_1;
    }

    synthetic void lambda$onResume$0$com-jlboat-phone-fragment-statusfragment-LoraFragment()
    {
        this.getConfigs(9);
        return;
    }

    public void onClick(android.view.View p5)
    {
        switch (p5.getId()) {
            case 2131230813:
                this.getConfigs(9);
                android.util.Log.d("LoraFragment", "onNewMessage: aaa ");
                ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigName("startLora");
                if (!this.LoraBt.getText().equals(this.getString(2131492939))) {
                    ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigValue("False");
                    this.LoraLL.setVisibility(4);
                } else {
                    ((com.jlboat.phone.message.map_msgs.Config) this.configList.get(0)).setConfigValue("True");
                    this.LoraLL.setVisibility(0);
                }
                this.setConfig(this.configList, 9);
                break;
            default:
        }
        return;
    }

    public android.view.View onCreateView(android.view.LayoutInflater p3, android.view.ViewGroup p4, android.os.Bundle p5)
    {
        this.mContext = this.getActivity();
        android.util.Log.d("LoraFragment", "onCreateView called");
        this.init();
        return super.onCreateView(p3, p4, p5);
    }

    public void onResume()
    {
        super.onResume();
        this.LoraLL.setVisibility(4);
        this.LoraBt.setVisibility(8);
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.jlboat.phone.fragment.statusfragment.LoraFragment$$ExternalSyntheticLambda0(this), 1500);
        return;
    }
}
