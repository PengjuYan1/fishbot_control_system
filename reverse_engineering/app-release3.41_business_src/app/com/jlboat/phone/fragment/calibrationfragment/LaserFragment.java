package com.jlboat.phone.fragment.calibrationfragment;
public class LaserFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "LaserFragment";
    private boolean flag;

    public LaserFragment()
    {
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
        return p3.inflate(2131361883, p4, 0);
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
