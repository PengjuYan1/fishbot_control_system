package com.jlboat.phone.view;
public class SavaPathPopup extends android.widget.PopupWindow {
    private android.widget.RadioButton bidirectionalPathRb;
    public int directional;
    private android.content.Context mContext;
    private android.view.View$OnClickListener mListener;
    private android.view.View mView;
    public String pathName;
    public android.widget.EditText pathNameEt;
    private android.widget.RadioButton pathSaveRb;
    public int pathType;
    private android.widget.RadioGroup pathUnidirectionalRg;
    private android.widget.RadioButton pathVerSaveExecuteRb;
    private android.widget.RadioButton pathVerificationRb;
    private android.widget.RadioGroup rgType;
    private boolean touchWinDismiss;
    private android.widget.RadioButton unidirectionalPathRb;

    public SavaPathPopup(android.content.Context p2, android.view.View$OnClickListener p3)
    {
        super(p2);
        super.touchWinDismiss = 1;
        super.pathType = -1;
        super.directional = 0;
        super.pathName = "";
        super.mContext = p2;
        super.mListener = p3;
        super.init();
        return;
    }

    static synthetic boolean access$000(com.jlboat.phone.view.SavaPathPopup p1)
    {
        return p1.touchWinDismiss;
    }

    static synthetic android.view.View access$100(com.jlboat.phone.view.SavaPathPopup p1)
    {
        return p1.mView;
    }

    private void init()
    {
        this.mView = ((android.view.LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2131361932, 0);
        this.pathNameEt = ((android.widget.EditText) this.mView.findViewById(2131231086));
        this.pathNameEt.addTextChangedListener(new com.jlboat.phone.view.SavaPathPopup$1(this));
        this.rgType = ((android.widget.RadioGroup) this.mView.findViewById(2131231090));
        this.pathSaveRb = ((android.widget.RadioButton) this.mView.findViewById(2131231089));
        this.pathVerificationRb = ((android.widget.RadioButton) this.mView.findViewById(2131231094));
        this.pathVerSaveExecuteRb = ((android.widget.RadioButton) this.mView.findViewById(2131231093));
        com.jlboat.phone.view.SavaPathPopup$typeRgChangeListener v1_18 = new com.jlboat.phone.view.SavaPathPopup$typeRgChangeListener(this);
        this.rgType.setOnCheckedChangeListener(v1_18);
        this.pathUnidirectionalRg = ((android.widget.RadioGroup) this.mView.findViewById(2131231092));
        this.unidirectionalPathRb = ((android.widget.RadioButton) this.mView.findViewById(2131231343));
        this.bidirectionalPathRb = ((android.widget.RadioButton) this.mView.findViewById(2131230775));
        this.pathUnidirectionalRg.setOnCheckedChangeListener(v1_18);
        this.bidirectionalPathRb.setChecked(1);
        android.widget.Button v2_22 = ((android.widget.Button) this.mView.findViewById(2131231079));
        ((android.widget.Button) this.mView.findViewById(2131231078)).setOnClickListener(new com.jlboat.phone.view.SavaPathPopup$2(this));
        v2_22.setOnClickListener(this.mListener);
        this.setContentView(this.mView);
        this.setAnimationStyle(2131558756);
        this.setWidth(-1);
        this.setHeight(-1);
        this.setFocusable(this.touchWinDismiss);
        this.setClippingEnabled(0);
        this.mView.setOnTouchListener(new com.jlboat.phone.view.SavaPathPopup$3(this));
        return;
    }
}
