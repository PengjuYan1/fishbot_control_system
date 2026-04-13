package com.jlboat.phone.fragment.settingfragment;
public class NavFnRosFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private java.util.List aaa;
    private com.jlboat.phone.adapter.ConfigListAdapter adapter;
    private android.content.Context mContext;
    private android.support.v7.widget.RecyclerView rv3;

    public NavFnRosFragment()
    {
        return;
    }

    public void date(java.util.List p4)
    {
        this.aaa = p4;
        this.adapter = new com.jlboat.phone.adapter.ConfigListAdapter(this.mContext);
        this.rv3.setBackgroundColor(2131165277);
        this.rv3.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this.mContext));
        this.rv3.setAdapter(this.adapter);
        this.adapter.setMdata(this.aaa, 3);
        android.util.Log.d(com.jlboat.phone.view.WidgetView.TAG, new StringBuilder().append("time: ").append(this.aaa).toString());
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
        android.view.View v0_1 = p3.inflate(2131361859, p4, 0);
        this.rv3 = ((android.support.v7.widget.RecyclerView) v0_1.findViewById(2131231215));
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
