package com.jlboat.phone.view.loading;
public class LoadingView extends com.jlboat.phone.view.loading.BaseLoading {
    private boolean isSmile;
    float mAnimatedValue;
    private float mEyeWidth;
    private float mPadding;
    private android.graphics.Paint mPaint;
    private float mWidth;
    android.graphics.RectF rectF;
    private float startAngle;

    public LoadingView(android.content.Context p3)
    {
        super(p3);
        super.mWidth = 0;
        super.mEyeWidth = 0;
        super.mPadding = 0;
        super.startAngle = 0;
        super.isSmile = 0;
        super.rectF = new android.graphics.RectF();
        super.mAnimatedValue = 0;
        return;
    }

    public LoadingView(android.content.Context p3, android.util.AttributeSet p4)
    {
        super(p3, p4);
        super.mWidth = 0;
        super.mEyeWidth = 0;
        super.mPadding = 0;
        super.startAngle = 0;
        super.isSmile = 0;
        super.rectF = new android.graphics.RectF();
        super.mAnimatedValue = 0;
        return;
    }

    public LoadingView(android.content.Context p3, android.util.AttributeSet p4, int p5)
    {
        super(p3, p4, p5);
        super.mWidth = 0;
        super.mEyeWidth = 0;
        super.mPadding = 0;
        super.startAngle = 0;
        super.isSmile = 0;
        super.rectF = new android.graphics.RectF();
        super.mAnimatedValue = 0;
        return;
    }

    private void initPaint()
    {
        this.mPaint = new android.graphics.Paint();
        this.mPaint.setAntiAlias(1);
        this.mPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.mPaint.setColor(android.graphics.Color.parseColor("#FF4081"));
        this.mPaint.setStrokeWidth(((float) this.dip2px(1073741824)));
        return;
    }

    protected void AinmIsRunning()
    {
        return;
    }

    protected void InitPaint()
    {
        this.initPaint();
        return;
    }

    protected void OnAnimationRepeat(android.animation.Animator p1)
    {
        return;
    }

    protected void OnAnimationUpdate(android.animation.ValueAnimator p7)
    {
        this.mAnimatedValue = ((Float) p7.getAnimatedValue()).floatValue();
        if (((double) this.mAnimatedValue) >= 4602678819172646912) {
            this.startAngle = 1144258560;
            this.isSmile = 1;
        } else {
            this.isSmile = 0;
            this.startAngle = (this.mAnimatedValue * 1144258560);
        }
        this.invalidate();
        return;
    }

    protected int OnStopAnim()
    {
        this.isSmile = 0;
        this.mAnimatedValue = 0;
        this.startAngle = 0;
        return 0;
    }

    protected int SetAnimRepeatCount()
    {
        return -1;
    }

    protected int SetAnimRepeatMode()
    {
        return 1;
    }

    protected void onDraw(android.graphics.Canvas p9)
    {
        super.onDraw(p9);
        this.rectF = new android.graphics.RectF(this.mPadding, this.mPadding, (this.mWidth - this.mPadding), (this.mWidth - this.mPadding));
        this.mPaint.setStyle(android.graphics.Paint$Style.STROKE);
        p9.drawArc(this.rectF, this.startAngle, 1127481344, 0, this.mPaint);
        this.mPaint.setStyle(android.graphics.Paint$Style.FILL);
        if (this.isSmile) {
            p9.drawCircle(((this.mPadding + this.mEyeWidth) + (this.mEyeWidth / 1073741824)), (this.mWidth / 1077936128), this.mEyeWidth, this.mPaint);
            p9.drawCircle((((this.mWidth - this.mPadding) - this.mEyeWidth) - (this.mEyeWidth / 1073741824)), (this.mWidth / 1077936128), this.mEyeWidth, this.mPaint);
        }
        return;
    }

    protected void onMeasure(int p3, int p4)
    {
        super.onMeasure(p3, p4);
        if (this.getMeasuredWidth() <= this.getHeight()) {
            this.mWidth = ((float) this.getMeasuredWidth());
        } else {
            this.mWidth = ((float) this.getMeasuredHeight());
        }
        this.mPadding = ((float) this.dip2px(1092616192));
        this.mEyeWidth = ((float) this.dip2px(1077936128));
        return;
    }

    public void setViewColor(int p2)
    {
        this.mPaint.setColor(p2);
        this.postInvalidate();
        return;
    }
}
