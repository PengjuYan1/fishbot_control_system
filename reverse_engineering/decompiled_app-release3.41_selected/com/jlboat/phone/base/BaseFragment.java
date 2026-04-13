package com.jlboat.phone.base;
public abstract class BaseFragment extends android.support.v4.app.Fragment {
    protected android.support.v4.app.FragmentActivity act;
    protected android.os.Handler handler;

    public BaseFragment()
    {
        this.handler = new android.os.Handler();
        return;
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract android.view.View initView();

    public android.view.View onCreateView(android.view.LayoutInflater p2, android.view.ViewGroup p3, android.os.Bundle p4)
    {
        this.act = this.getActivity();
        android.view.View v0_1 = this.initView(p2, p3);
        this.initData();
        this.initListener();
        return v0_1;
    }

    public void onDestroy()
    {
        this.handler.removeCallbacksAndMessages(0);
        super.onDestroy();
        return;
    }

    protected void showToast(CharSequence p3)
    {
        this.handler.post(new com.jlboat.phone.base.BaseFragment$1(this, p3));
        return;
    }
}
