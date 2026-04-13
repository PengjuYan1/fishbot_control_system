package com.jlboat.phone.activity;
public class GrabBagActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private String TAG;
    private com.jlboat.phone.view.BagListAdapter adapter;
    private android.widget.Switch back_start;
    private java.util.List bagNames;
    private android.os.Handler handler;
    private android.content.Context mContext;
    private com.jlboat.phone.view.MyPopupWindow popupWindow;
    private com.jlboat.phone.communication.PubRecordBag pubRecordBagListener;
    private android.support.v7.widget.RecyclerView rvBag;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;

    public GrabBagActivity()
    {
        this.TAG = "GrabBagActivity";
        this.pubRecordBagListener = new com.jlboat.phone.communication.PubRecordBag();
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.mContext = this;
        this.handler = new com.jlboat.phone.activity.GrabBagActivity$3(this);
        return;
    }

    static synthetic com.jlboat.phone.view.MyPopupWindow access$000(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        return p1.popupWindow;
    }

    static synthetic com.jlboat.phone.view.MyPopupWindow access$002(com.jlboat.phone.activity.GrabBagActivity p0, com.jlboat.phone.view.MyPopupWindow p1)
    {
        p0.popupWindow = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.communication.PubRecordBag access$100(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        return p1.pubRecordBagListener;
    }

    static synthetic android.os.Handler access$200(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        return p1.handler;
    }

    static synthetic android.widget.Switch access$300(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        return p1.back_start;
    }

    static synthetic void access$400(com.jlboat.phone.activity.GrabBagActivity p0)
    {
        p0.getBag();
        return;
    }

    static synthetic String access$500(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        return p1.TAG;
    }

    static synthetic java.util.List access$600(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        return p1.bagNames;
    }

    static synthetic java.util.List access$602(com.jlboat.phone.activity.GrabBagActivity p0, java.util.List p1)
    {
        p0.bagNames = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.view.BagListAdapter access$700(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        return p1.adapter;
    }

    private void getBag()
    {
        this.spiritServiceClient.getBagListService(new com.jlboat.phone.activity.GrabBagActivity$2(this));
        return;
    }

    private void switchchange()
    {
        this.back_start.setOnCheckedChangeListener(new com.jlboat.phone.activity.GrabBagActivity$1(this));
        return;
    }

    public void initService()
    {
        this.getBag();
        return;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (this.back_start.isChecked()) {
            this.pubRecordBagListener.setType(4);
            this.handler.removeMessages(1);
            this.toast(2131493209);
        }
        return;
    }

    public void onClick(android.view.View p1)
    {
        p1.getId();
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.initTitleBar(2131361824, 2131492912);
        this.back_start = ((android.widget.Switch) this.findViewById(2131230769));
        this.switchchange();
        this.rvBag = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231221));
        this.adapter = new com.jlboat.phone.view.BagListAdapter(this);
        this.rvBag.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.rvBag.setAdapter(this.adapter);
        return;
    }

    protected void onPause()
    {
        super.onPause();
        if (this.back_start.isChecked()) {
            this.pubRecordBagListener.setType(4);
            this.handler.removeMessages(1);
            this.toast(2131493209);
        }
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.back_start.setChecked(0);
        this.initService();
        return;
    }
}
