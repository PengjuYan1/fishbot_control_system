package com.jlboat.phone.view;
public class CustomProgress extends android.view.View {
    private int mCircleWidth;
    private android.graphics.drawable.Drawable mIcon0;
    private android.graphics.drawable.Drawable mIcon1;
    private android.graphics.drawable.Drawable mIcon2;
    private android.graphics.drawable.Drawable mIcon3;
    private android.graphics.drawable.Drawable mIcon4;
    private android.graphics.drawable.Drawable mIcon5;
    private android.graphics.drawable.Drawable mIcon6;
    private android.graphics.drawable.Drawable mIcon7;
    private android.graphics.drawable.Drawable mIcon8;
    private android.graphics.Paint mPaint;
    private android.graphics.Paint mtextPaint;
    private android.graphics.RectF oval;
    private android.graphics.Rect rect0;
    private android.graphics.Rect rect1;
    private android.graphics.Rect rect2;
    private android.graphics.Rect rect3;
    private android.graphics.Rect rect4;
    private android.graphics.Rect rect5;
    private android.graphics.Rect rect6;
    private android.graphics.Rect rect7;
    private android.graphics.Rect rect8;
    private boolean reui;
    private float x;
    private float y;

    public CustomProgress(android.content.Context p2)
    {
        this(p2, 0);
        return;
    }

    public CustomProgress(android.content.Context p2, android.util.AttributeSet p3)
    {
        this(p2, p3, 0);
        return;
    }

    public CustomProgress(android.content.Context p3, android.util.AttributeSet p4, int p5)
    {
        super(p3, p4, p5);
        super.reui = 0;
        super.mCircleWidth = 3;
        super.mPaint = new android.graphics.Paint();
        super.mtextPaint = new android.graphics.Paint(1);
        super.mIcon0 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        super.mIcon1 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        super.mIcon2 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        super.mIcon3 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        super.mIcon4 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        super.mIcon5 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        super.mIcon6 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        super.mIcon7 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        super.mIcon8 = android.support.v4.content.ContextCompat.getDrawable(super.getContext(), 2131427349);
        return;
    }

    protected void onDraw(android.graphics.Canvas p7)
    {
        p7.drawArc(this.oval, 0, -1020002304, 0, this.mPaint);
        p7.drawText(this.getResources().getString(2131492971), 1128923136, ((float) (this.getHeight() + -140)), this.mtextPaint);
        p7.drawText(this.getResources().getString(2131492970), ((float) ((this.getWidth() / 2) - 15)), ((float) (((this.getHeight() / 4) * 3) - 50)), this.mtextPaint);
        p7.drawText(this.getResources().getString(2131492972), ((float) ((this.getWidth() + -202) - 30)), ((float) (this.getHeight() + -140)), this.mtextPaint);
        if (!this.reui) {
            this.mIcon0.draw(p7);
            this.mIcon1.draw(p7);
            this.mIcon2.draw(p7);
            this.mIcon3.draw(p7);
            this.mIcon4.draw(p7);
            this.mIcon5.draw(p7);
            this.mIcon6.draw(p7);
            this.mIcon7.draw(p7);
            this.mIcon8.draw(p7);
        }
        return;
    }

    protected void onLayout(boolean p15, int p16, int p17, int p18, int p19)
    {
        com.jlboat.phone.view.CustomProgress v0 = this;
        void v14_1 = super.onLayout(p15, p16, p17, p18, p19);
        this.mPaint.setAntiAlias(1);
        this.mPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.mPaint.setStrokeWidth(((float) this.mCircleWidth));
        this.mPaint.setColor(-16711681);
        this.mtextPaint.setColor(v14_1.getResources().getColor(2131034165));
        this.mtextPaint.setStrokeWidth(1077936128);
        this.mtextPaint.setTextSize(1106247680);
        this.x = ((float) (v14_1.getWidth() / 2));
        this.y = ((float) (v14_1.getHeight() / 2));
        this.oval = new android.graphics.RectF(((- this.x) / 1090519040), ((float) ((v14_1.getHeight() / 4) * 3)), (((float) v14_1.getWidth()) + (this.x / 1090519040)), (((float) v14_1.getHeight()) + this.y));
        this.rect0 = new android.graphics.Rect(50, (v14_1.getHeight() - 100), 100, (v14_1.getHeight() - 50));
        this.rect1 = new android.graphics.Rect(102, (v14_1.getHeight() - 120), 152, (v14_1.getHeight() - 70));
        this.rect2 = new android.graphics.Rect(152, (v14_1.getHeight() + -140), 202, (v14_1.getHeight() - 90));
        this.rect3 = new android.graphics.Rect(((int) (((this.x - 1103626240) - 1112014848) - 1073741824)), (((v14_1.getHeight() / 4) * 3) - 50), ((int) (((this.x + 1103626240) - 1112014848) - 1073741824)), ((v14_1.getHeight() / 4) * 3));
        this.rect4 = new android.graphics.Rect(((int) (this.x - 1103626240)), (((v14_1.getHeight() / 4) * 3) - 50), ((int) (this.x + 1103626240)), ((v14_1.getHeight() / 4) * 3));
        this.rect5 = new android.graphics.Rect(((int) (((this.x - 1103626240) + 1112014848) + 1073741824)), (((v14_1.getHeight() / 4) * 3) - 50), ((int) (((this.x + 1103626240) + 1112014848) + 1073741824)), ((v14_1.getHeight() / 4) * 3));
        this.rect6 = new android.graphics.Rect((v14_1.getWidth() - 202), (v14_1.getHeight() + -140), (v14_1.getWidth() - 152), (v14_1.getHeight() - 90));
        this.rect7 = new android.graphics.Rect((v14_1.getWidth() - 152), (v14_1.getHeight() - 120), (v14_1.getWidth() - 102), (v14_1.getHeight() - 70));
        this.rect8 = new android.graphics.Rect((v14_1.getWidth() - 100), (v14_1.getHeight() - 100), (v14_1.getWidth() - 50), (v14_1.getHeight() - 50));
        this.mIcon0.setBounds(this.rect0);
        v0.mIcon1.setBounds(v0.rect1);
        v0.mIcon2.setBounds(v0.rect2);
        v0.mIcon3.setBounds(v0.rect3);
        v0.mIcon4.setBounds(v0.rect4);
        v0.mIcon5.setBounds(v0.rect5);
        v0.mIcon6.setBounds(v0.rect6);
        v0.mIcon7.setBounds(v0.rect7);
        v0.mIcon8.setBounds(v0.rect8);
        return;
    }

    public void setColors(boolean p7, boolean p8, boolean p9, boolean p10, boolean p11, boolean p12, boolean p13, boolean p14, boolean p15)
    {
        int v3_1;
        this.reui = 1;
        int v0_7 = this.getContext();
        android.graphics.Rect v1_1 = 2131427372;
        int v2 = 2131427349;
        if (!p7) {
            v3_1 = 2131427349;
        } else {
            v3_1 = 2131427372;
        }
        int v4;
        this.mIcon0 = android.support.v4.content.ContextCompat.getDrawable(v0_7, v3_1);
        int v0_3 = this.getContext();
        int v3_0 = 2131427350;
        if (!p8) {
            v4 = 2131427349;
        } else {
            v4 = 2131427350;
        }
        int v5_0;
        this.mIcon1 = android.support.v4.content.ContextCompat.getDrawable(v0_3, v4);
        int v0_5 = this.getContext();
        if (!p9) {
            v5_0 = 2131427349;
        } else {
            v5_0 = 2131427336;
        }
        int v5_1;
        this.mIcon2 = android.support.v4.content.ContextCompat.getDrawable(v0_5, v5_0);
        int v0_8 = this.getContext();
        if (!p10) {
            v5_1 = 2131427349;
        } else {
            v5_1 = 2131427372;
        }
        int v5_2;
        this.mIcon3 = android.support.v4.content.ContextCompat.getDrawable(v0_8, v5_1);
        int v0_10 = this.getContext();
        if (!p11) {
            v5_2 = 2131427349;
        } else {
            v5_2 = 2131427350;
        }
        int v5_3;
        this.mIcon4 = android.support.v4.content.ContextCompat.getDrawable(v0_10, v5_2);
        int v0_12 = this.getContext();
        if (!p12) {
            v5_3 = 2131427349;
        } else {
            v5_3 = 2131427336;
        }
        this.mIcon5 = android.support.v4.content.ContextCompat.getDrawable(v0_12, v5_3);
        int v0_14 = this.getContext();
        if (!p13) {
            v1_1 = 2131427349;
        }
        this.mIcon6 = android.support.v4.content.ContextCompat.getDrawable(v0_14, v1_1);
        int v0_16 = this.getContext();
        if (!p14) {
            v3_0 = 2131427349;
        }
        this.mIcon7 = android.support.v4.content.ContextCompat.getDrawable(v0_16, v3_0);
        int v0_18 = this.getContext();
        if (p15) {
            v2 = 2131427336;
        }
        this.mIcon8 = android.support.v4.content.ContextCompat.getDrawable(v0_18, v2);
        this.mIcon0.setBounds(this.rect0);
        this.mIcon1.setBounds(this.rect1);
        this.mIcon2.setBounds(this.rect2);
        this.mIcon3.setBounds(this.rect3);
        this.mIcon4.setBounds(this.rect4);
        this.mIcon5.setBounds(this.rect5);
        this.mIcon6.setBounds(this.rect6);
        this.mIcon7.setBounds(this.rect7);
        this.mIcon8.setBounds(this.rect8);
        this.reui = 0;
        this.invalidate();
        return;
    }
}
