package com.jlboat.phone.fragment.statusfragment;
public class LaserFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "LaserFragment";
    android.widget.Button add_tv;
    private boolean flag;
    com.jlboat.phone.view.LaserView laserView;
    private android.content.Context mContext;
    android.widget.Button reduce_tv;
    android.widget.TextView scan_no_tv;

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

    protected android.view.View initView(android.view.LayoutInflater p4, android.view.ViewGroup p5)
    {
        android.view.View v0_1 = p4.inflate(2131361870, p5, 0);
        this.scan_no_tv = ((android.widget.TextView) v0_1.findViewById(2131231226));
        this.add_tv = ((android.widget.Button) v0_1.findViewById(2131230752));
        this.reduce_tv = ((android.widget.Button) v0_1.findViewById(2131231145));
        this.laserView = ((com.jlboat.phone.view.LaserView) v0_1.findViewById(2131230951));
        this.add_tv.setOnClickListener(this);
        this.reduce_tv.setOnClickListener(this);
        this.laserView.setHasData(new com.jlboat.phone.fragment.statusfragment.LaserFragment$1(this));
        return v0_1;
    }

    public void onClick(android.view.View p5)
    {
        int v0_3 = this.laserView.getMatrix1();
        switch (p5.getId()) {
            case 2131230752:
                this.reduce_tv.setEnabled(1);
                int v0_2 = (v0_3 + 40);
                if (v0_2 >= 180) {
                    this.add_tv.setEnabled(0);
                }
                this.laserView.setMatrix1(v0_2);
                break;
            case 2131231145:
                this.add_tv.setEnabled(1);
                int v0_1 = (v0_3 - 40);
                if (v0_1 <= 20) {
                    this.reduce_tv.setEnabled(0);
                }
                this.laserView.setMatrix1(v0_1);
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
        this.laserView.onStop();
        return;
    }

    public void onResume()
    {
        super.onResume();
        this.laserView.onStart();
        return;
    }
}
