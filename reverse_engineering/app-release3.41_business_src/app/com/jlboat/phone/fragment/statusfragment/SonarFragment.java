package com.jlboat.phone.fragment.statusfragment;
public class SonarFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "InfraredFragment";
    private boolean flag;
    private java.util.List ints;
    private com.jlboat.phone.view.SonarView linerview;
    private android.content.Context mContext;

    public SonarFragment()
    {
        this.ints = new java.util.concurrent.CopyOnWriteArrayList();
        this.flag = 1;
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
        android.view.View v0_1 = p3.inflate(2131361830, p4, 0);
        this.linerview = ((com.jlboat.phone.view.SonarView) v0_1.findViewById(2131230962));
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

    public void onPause()
    {
        super.onPause();
        this.linerview.onStop();
        return;
    }

    public void onResume()
    {
        super.onResume();
        this.linerview.onStart();
        return;
    }

    public void onStart()
    {
        super.onStart();
        return;
    }
}
