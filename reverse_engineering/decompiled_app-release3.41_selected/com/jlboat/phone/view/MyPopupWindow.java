package com.jlboat.phone.view;
public class MyPopupWindow extends android.widget.PopupWindow {
    private String mBtnStr;
    private boolean mCancelBtn;
    private android.view.View$OnClickListener mCancleListener;
    private String mContent;
    private android.content.Context mContext;
    private android.view.View$OnClickListener mListener;
    private String mTitle;
    private android.view.View mView;
    private boolean touchWinDismiss;

    public MyPopupWindow(android.content.Context p2, String p3, String p4, String p5, boolean p6, android.view.View$OnClickListener p7)
    {
        super(p2);
        super.mCancelBtn = 0;
        super.touchWinDismiss = 1;
        super.mContext = p2;
        super.mTitle = p3;
        super.mContent = p4;
        super.mBtnStr = p5;
        super.mListener = p7;
        super.mCancelBtn = p6;
        super.init();
        return;
    }

    public MyPopupWindow(android.content.Context p2, String p3, String p4, String p5, boolean p6, android.view.View$OnClickListener p7, android.view.View$OnClickListener p8)
    {
        super(p2);
        super.mCancelBtn = 0;
        super.touchWinDismiss = 1;
        super.mContext = p2;
        super.mTitle = p3;
        super.mContent = p4;
        super.mBtnStr = p5;
        super.mListener = p7;
        super.mCancelBtn = p6;
        super.mCancleListener = p8;
        super.init();
        return;
    }

    static synthetic boolean access$000(com.jlboat.phone.view.MyPopupWindow p1)
    {
        return p1.touchWinDismiss;
    }

    static synthetic android.view.View access$100(com.jlboat.phone.view.MyPopupWindow p1)
    {
        return p1.mView;
    }

    private void init()
    {
        this.mView = ((android.view.LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2131361930, 0);
        ((android.widget.TextView) this.mView.findViewById(2131231105)).setText(this.mTitle);
        ((android.widget.TextView) this.mView.findViewById(2131231104)).setText(this.mContent);
        android.widget.Button v3_4 = ((android.widget.Button) this.mView.findViewById(2131231103));
        v3_4.setText(this.mBtnStr);
        android.widget.Button v4_4 = ((android.widget.Button) this.mView.findViewById(2131231102));
        if (!this.mCancelBtn) {
            v4_4.setVisibility(8);
            v4_4.setOnClickListener(new com.jlboat.phone.view.MyPopupWindow$1(this));
        } else {
            v4_4.setVisibility(0);
            v4_4.setOnClickListener(this.mCancleListener);
        }
        v3_4.setOnClickListener(this.mListener);
        this.setContentView(this.mView);
        this.setAnimationStyle(2131558756);
        this.setWidth(-1);
        this.setHeight(-1);
        this.setFocusable(this.touchWinDismiss);
        this.setClippingEnabled(0);
        this.mView.setOnTouchListener(new com.jlboat.phone.view.MyPopupWindow$2(this));
        return;
    }
}
