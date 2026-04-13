package com.jlboat.phone.fragment.calibrationfragment;
public class ImuFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "ImuFragment";
    private com.jlboat.phone.adapter.ImuResultAdapter adapter;
    private java.util.List cList;
    private android.widget.Button endCalibration;
    private android.widget.TextView leftTv;
    private android.content.Context mContext;
    private int num;
    private android.widget.TextView rightTv;
    private android.widget.Button startCalibration;
    private android.widget.LinearLayout startLL;
    private android.widget.LinearLayout statusLL;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    private android.widget.Button stopCalibration;
    private android.widget.LinearLayout stopLL;
    private android.support.v7.widget.RecyclerView testResRv;

    public ImuFragment()
    {
        this.cList = new java.util.ArrayList();
        this.num = 0;
        return;
    }

    static synthetic android.content.Context access$000(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p1)
    {
        return p1.mContext;
    }

    static synthetic java.util.List access$100(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p1)
    {
        return p1.cList;
    }

    static synthetic int access$200(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p1)
    {
        return p1.num;
    }

    static synthetic int access$202(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p0, int p1)
    {
        p0.num = p1;
        return p1;
    }

    static synthetic int access$210(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p2)
    {
        int v0 = p2.num;
        p2.num = (v0 - 1);
        return v0;
    }

    static synthetic android.widget.TextView access$300(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p1)
    {
        return p1.rightTv;
    }

    static synthetic android.widget.TextView access$400(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p1)
    {
        return p1.leftTv;
    }

    static synthetic android.widget.LinearLayout access$500(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p1)
    {
        return p1.statusLL;
    }

    static synthetic com.jlboat.phone.adapter.ImuResultAdapter access$600(com.jlboat.phone.fragment.calibrationfragment.ImuFragment p1)
    {
        return p1.adapter;
    }

    private void setDates(int p3)
    {
        android.util.Log.d("ImuFragment", new StringBuilder().append("set date:").append(p3).toString());
        if (this.statusServiceClient != null) {
            this.statusServiceClient.setCalculateOdomService(p3, new com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1(this, p3));
            return;
        } else {
            android.util.Log.d("ImuFragment", "setDates: statusServiceClient\u4e3anull\uff0c\u65e0\u6cd5\u8c03\u7528setCalculateOdomService");
            return;
        }
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
        android.view.View v0_1 = p5.inflate(2131361874, p6, 0);
        android.util.Log.d("ImuFragment", "set initView:22");
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.startCalibration = ((android.widget.Button) v0_1.findViewById(2131231268));
        this.endCalibration = ((android.widget.Button) v0_1.findViewById(2131230886));
        this.stopCalibration = ((android.widget.Button) v0_1.findViewById(2131231275));
        this.stopLL = ((android.widget.LinearLayout) v0_1.findViewById(2131231276));
        this.startLL = ((android.widget.LinearLayout) v0_1.findViewById(2131231269));
        this.statusLL = ((android.widget.LinearLayout) v0_1.findViewById(2131231272));
        this.leftTv = ((android.widget.TextView) v0_1.findViewById(2131230954));
        this.rightTv = ((android.widget.TextView) v0_1.findViewById(2131231176));
        this.testResRv = ((android.support.v7.widget.RecyclerView) v0_1.findViewById(2131230838));
        this.testResRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this.mContext));
        this.adapter = new com.jlboat.phone.adapter.ImuResultAdapter();
        this.testResRv.setAdapter(this.adapter);
        this.startCalibration.setOnClickListener(this);
        this.endCalibration.setOnClickListener(this);
        this.stopCalibration.setOnClickListener(this);
        this.startLL.setOnClickListener(this);
        this.stopLL.setOnClickListener(this);
        return v0_1;
    }

    public void onClick(android.view.View p5)
    {
        switch (p5.getId()) {
            case 2131230886:
                if (this.num >= 2) {
                    if (this.startCalibration.getVisibility() != 8) {
                        this.setDates(302);
                    } else {
                        com.jlboat.phone.util.Utils.toast("\u8bf7\u505c\u6b62\u5f53\u524d\u6821\u6b63");
                    }
                } else {
                    com.jlboat.phone.util.Utils.toast("\u8bf7\u6821\u6b63\u4e24\u6b21\u4ee5\u4e0a");
                }
                break;
            case 2131231268:
                android.util.Log.d("ImuFragment", "set onClick:300");
                this.setDates(300);
                this.num = (this.num + 1);
                this.startLL.setVisibility(8);
                this.stopLL.setVisibility(0);
                break;
            case 2131231275:
                this.setDates(301);
                this.stopLL.setVisibility(8);
                this.startLL.setVisibility(0);
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
}
