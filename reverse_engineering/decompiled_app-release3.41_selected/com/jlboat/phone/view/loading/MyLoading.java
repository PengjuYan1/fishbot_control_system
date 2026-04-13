package com.jlboat.phone.view.loading;
public class MyLoading extends android.widget.PopupWindow {
    private com.jlboat.phone.view.loading.LoadingView loading;
    private android.content.Context mContext;
    private String mText;
    private android.view.View mView;
    private android.widget.TextView tipText;

    public MyLoading(android.content.Context p2)
    {
        this.mText = "\u52a0\u8f7d\u4e2d";
        this.mContext = p2;
        this.init();
        return;
    }

    public MyLoading(android.content.Context p2, String p3)
    {
        this.mText = "\u52a0\u8f7d\u4e2d";
        this.mContext = p2;
        this.mText = p3;
        this.init();
        return;
    }

    private void init()
    {
        this.mView = ((android.view.LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2131361885, 0);
        this.loading = ((com.jlboat.phone.view.loading.LoadingView) this.mView.findViewById(2131230975));
        this.loading.startAnim();
        this.tipText = ((android.widget.TextView) this.mView.findViewById(2131231310));
        this.tipText.setText(this.mText);
        this.setContentView(this.mView);
        this.setAnimationStyle(2131558756);
        this.setWidth(-1);
        this.setHeight(-1);
        this.setFocusable(0);
        this.setClippingEnabled(0);
        return;
    }

    public void setOnDismissListener(android.widget.PopupWindow$OnDismissListener p2)
    {
        super.setOnDismissListener(p2);
        this.loading.stopAnim();
        return;
    }
}
