package com.jlboat.phone.fragment.calibrationfragment;
public class CameraFragment extends com.jlboat.phone.base.BaseFragment {
    private String TAG;
    private android.content.Context mContext;

    public CameraFragment()
    {
        this.TAG = "CameraFragment";
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
        return p3.inflate(2131361837, p4, 0);
    }

    public android.view.View onCreateView(android.view.LayoutInflater p2, android.view.ViewGroup p3, android.os.Bundle p4)
    {
        this.mContext = this.getActivity();
        return super.onCreateView(p2, p3, p4);
    }
}
