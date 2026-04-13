package com.jlboat.phone.view;
public class PathItemchangeNamePopup extends android.widget.PopupWindow {
    private android.widget.Button cancle;
    private android.widget.EditText et;
    private android.content.Context mContext;
    private android.view.View mView;
    private android.view.View$OnClickListener msubClickListener;
    public String newName;
    public String oldName;
    private android.widget.Button sub;
    private boolean touchWinDismiss;

    public PathItemchangeNamePopup(android.content.Context p2, String p3, android.view.View$OnClickListener p4)
    {
        super(p2);
        super.touchWinDismiss = 0;
        super.mContext = p2;
        super.oldName = p3;
        super.msubClickListener = p4;
        super.init();
        return;
    }

    static synthetic boolean access$000(com.jlboat.phone.view.PathItemchangeNamePopup p1)
    {
        return p1.touchWinDismiss;
    }

    static synthetic android.view.View access$100(com.jlboat.phone.view.PathItemchangeNamePopup p1)
    {
        return p1.mView;
    }

    private void init()
    {
        this.mView = ((android.view.LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2131361926, 0);
        this.et = ((android.widget.EditText) this.mView.findViewById(2131231082));
        this.et.setText(this.oldName);
        this.et.addTextChangedListener(new com.jlboat.phone.view.PathItemchangeNamePopup$1(this));
        this.sub = ((android.widget.Button) this.mView.findViewById(2131231081));
        if (this.msubClickListener != null) {
            this.sub.setOnClickListener(this.msubClickListener);
        }
        this.cancle = ((android.widget.Button) this.mView.findViewById(2131231080));
        this.cancle.setOnClickListener(new com.jlboat.phone.view.PathItemchangeNamePopup$2(this));
        this.setContentView(this.mView);
        this.setAnimationStyle(2131558756);
        this.setWidth(-1);
        this.setHeight(-1);
        this.setFocusable(this.touchWinDismiss);
        this.setClippingEnabled(0);
        this.mView.setOnTouchListener(new com.jlboat.phone.view.PathItemchangeNamePopup$3(this));
        return;
    }
}
