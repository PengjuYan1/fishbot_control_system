package com.jlboat.phone.fragment.settingfragment;
public class GlobalCostFragment extends com.jlboat.phone.base.BaseFragment {
    private com.jlboat.phone.adapter.ConfigListAdapter adapter;
    private android.content.Context mContext;
    private android.support.v7.widget.RecyclerView rvq;

    public GlobalCostFragment()
    {
        return;
    }

    public void data(java.util.List p4)
    {
        this.adapter = new com.jlboat.phone.adapter.ConfigListAdapter(this.mContext);
        this.rvq.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this.mContext));
        this.rvq.setAdapter(this.adapter);
        this.adapter.setMdata(p4, 2);
        this.adapter.notifyDataSetChanged();
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
        android.view.View v0_1 = p3.inflate(2131361858, p4, 0);
        this.rvq = ((android.support.v7.widget.RecyclerView) v0_1.findViewById(2131231225));
        return v0_1;
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
}
