package com.jlboat.phone.fragment.settingfragment;
public class MoveBaseFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private com.jlboat.phone.adapter.ConfigListAdapter adapter;
    private android.content.Context mContext;
    private android.support.v7.widget.RecyclerView rvMoveBase;

    public MoveBaseFragment()
    {
        return;
    }

    public void data(java.util.List p3)
    {
        this.adapter.setMdata(p3, 1);
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

    protected android.view.View initView(android.view.LayoutInflater p5, android.view.ViewGroup p6)
    {
        android.view.View v0_1 = p5.inflate(2131361857, p6, 0);
        this.rvMoveBase = ((android.support.v7.widget.RecyclerView) v0_1.findViewById(2131231222));
        this.adapter = new com.jlboat.phone.adapter.ConfigListAdapter(this.mContext);
        this.rvMoveBase.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this.mContext));
        this.rvMoveBase.setAdapter(this.adapter);
        return v0_1;
    }

    public void onClick(android.view.View p2)
    {
        switch (p2.getId()) {
            case 1:
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

    public void onStart()
    {
        super.onStart();
        return;
    }
}
