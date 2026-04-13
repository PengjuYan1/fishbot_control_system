package com.jlboat.phone.view;
public class PathItemSettingPopup extends android.widget.PopupWindow {
    private android.widget.Button addPathPointBtn;
    private android.widget.Button changePathNameBtn;
    private android.widget.Button delPathBtn;
    private android.view.View$OnClickListener mAddPathPointClickListener;
    private android.view.View$OnClickListener mChangePathNameClickListener;
    private android.content.Context mContext;
    private android.view.View$OnClickListener mDelPathClickListener;
    private android.view.View$OnClickListener mTestPathClickListener;
    private android.view.View mView;
    private android.widget.Button testDiyPathBbtn;
    private boolean touchWinDismiss;

    public PathItemSettingPopup(android.content.Context p2, android.view.View$OnClickListener p3, android.view.View$OnClickListener p4, android.view.View$OnClickListener p5, android.view.View$OnClickListener p6)
    {
        super(p2);
        super.touchWinDismiss = 1;
        super.mContext = p2;
        super.mTestPathClickListener = p3;
        super.mChangePathNameClickListener = p4;
        super.mAddPathPointClickListener = p5;
        super.mDelPathClickListener = p6;
        super.init();
        return;
    }

    static synthetic boolean access$000(com.jlboat.phone.view.PathItemSettingPopup p1)
    {
        return p1.touchWinDismiss;
    }

    static synthetic android.view.View access$100(com.jlboat.phone.view.PathItemSettingPopup p1)
    {
        return p1.mView;
    }

    private void init()
    {
        this.mView = ((android.view.LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2131361927, 0);
        this.testDiyPathBbtn = ((android.widget.Button) this.mView.findViewById(2131231286));
        this.testDiyPathBbtn.setOnClickListener(this.mTestPathClickListener);
        this.changePathNameBtn = ((android.widget.Button) this.mView.findViewById(2131230846));
        this.changePathNameBtn.setOnClickListener(this.mChangePathNameClickListener);
        this.addPathPointBtn = ((android.widget.Button) this.mView.findViewById(2131230750));
        this.addPathPointBtn.setOnClickListener(this.mAddPathPointClickListener);
        this.delPathBtn = ((android.widget.Button) this.mView.findViewById(2131230868));
        this.delPathBtn.setOnClickListener(this.mDelPathClickListener);
        this.setContentView(this.mView);
        this.setAnimationStyle(2131558756);
        this.setWidth(-1);
        this.setHeight(-1);
        this.setFocusable(this.touchWinDismiss);
        this.setClippingEnabled(0);
        this.mView.setOnTouchListener(new com.jlboat.phone.view.PathItemSettingPopup$1(this));
        this.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(17170445));
        return;
    }
}
