package com.jlboat.phone.activity;
public class ErrorMessageActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private com.jlboat.phone.view.ErrorMsgAdapter adapter;
    private final android.content.BroadcastReceiver receiver;
    private android.support.v7.widget.RecyclerView rv;
    private android.widget.TextView wasj;

    public ErrorMessageActivity()
    {
        this.receiver = new com.jlboat.phone.activity.ErrorMessageActivity$1(this);
        return;
    }

    static synthetic void access$000(com.jlboat.phone.activity.ErrorMessageActivity p0)
    {
        p0.sj();
        return;
    }

    private void sj()
    {
        if ((com.jlboat.phone.application.BoatSlamApplication.errList != null) && (com.jlboat.phone.application.BoatSlamApplication.errList.size() != 0)) {
            this.adapter.setMdata(com.jlboat.phone.application.BoatSlamApplication.errList);
            this.wasj.setVisibility(8);
        } else {
            this.wasj.setVisibility(0);
            this.wasj.setText(this.getResString(2131493343));
        }
        return;
    }

    public void onClick(android.view.View p1)
    {
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.initTitleBar(2131361823, 2131493037);
        this.wasj = ((android.widget.TextView) this.findViewById(2131231363));
        this.rv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231214));
        this.adapter = new com.jlboat.phone.view.ErrorMsgAdapter(this);
        this.rv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.rv.setAdapter(this.adapter);
        this.sj();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.unregisterReceiver(this.receiver);
        return;
    }

    protected void onResume()
    {
        super.onResume();
        android.content.IntentFilter v0_1 = new android.content.IntentFilter();
        v0_1.addAction("ERRMSG_UPDATE");
        this.registerReceiver(this.receiver, v0_1);
        return;
    }

    public void toast(String p2)
    {
        this.runOnUiThread(new com.jlboat.phone.activity.ErrorMessageActivity$2(this, p2));
        return;
    }
}
