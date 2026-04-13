package com.jlboat.phone.view.loading;
public abstract class BaseLoading extends android.view.View {
    public android.animation.ValueAnimator valueAnimator;

    public BaseLoading(android.content.Context p2)
    {
        this(p2, 0);
        return;
    }

    public BaseLoading(android.content.Context p2, android.util.AttributeSet p3)
    {
        this(p2, p3, 0);
        return;
    }

    public BaseLoading(android.content.Context p1, android.util.AttributeSet p2, int p3)
    {
        super(p1, p2, p3);
        super.InitPaint();
        return;
    }

    private android.animation.ValueAnimator startViewAnim(float p5, float p6, long p7)
    {
        android.animation.ValueAnimator v1_0 = new float[2];
        v1_0[0] = p5;
        v1_0[1] = p6;
        this.valueAnimator = android.animation.ValueAnimator.ofFloat(v1_0);
        this.valueAnimator.setDuration(p7);
        this.valueAnimator.setInterpolator(new android.view.animation.LinearInterpolator());
        this.valueAnimator.setRepeatCount(this.SetAnimRepeatCount());
        if (1 != this.SetAnimRepeatMode()) {
            if (2 == this.SetAnimRepeatMode()) {
                this.valueAnimator.setRepeatMode(2);
            }
        } else {
            this.valueAnimator.setRepeatMode(1);
        }
        this.valueAnimator.addUpdateListener(new com.jlboat.phone.view.loading.BaseLoading$1(this));
        this.valueAnimator.addListener(new com.jlboat.phone.view.loading.BaseLoading$2(this));
        if (!this.valueAnimator.isRunning()) {
            this.AinmIsRunning();
            this.valueAnimator.start();
        }
        return this.valueAnimator;
    }

    protected abstract void AinmIsRunning();

    protected abstract void InitPaint();

    protected abstract void OnAnimationRepeat();

    protected abstract void OnAnimationUpdate();

    protected abstract int OnStopAnim();

    protected abstract int SetAnimRepeatCount();

    protected abstract int SetAnimRepeatMode();

    public int dip2px(float p4)
    {
        return ((int) ((p4 * this.getContext().getResources().getDisplayMetrics().density) + 1056964608));
    }

    public float getFontHeight(android.graphics.Paint p4)
    {
        android.graphics.Paint$FontMetrics v0 = p4.getFontMetrics();
        return (v0.descent - v0.ascent);
    }

    public float getFontHeight(android.graphics.Paint p4, String p5)
    {
        android.graphics.Rect v0_1 = new android.graphics.Rect();
        p4.getTextBounds(p5, 0, p5.length(), v0_1);
        return ((float) v0_1.height());
    }

    public float getFontlength(android.graphics.Paint p4, String p5)
    {
        android.graphics.Rect v0_1 = new android.graphics.Rect();
        p4.getTextBounds(p5, 0, p5.length(), v0_1);
        return ((float) v0_1.width());
    }

    public void startAnim()
    {
        this.stopAnim();
        this.startViewAnim(0, 1065353216, 500);
        return;
    }

    public void startAnim(int p5)
    {
        this.stopAnim();
        this.startViewAnim(0, 1065353216, ((long) p5));
        return;
    }

    public void stopAnim()
    {
        if (this.valueAnimator != null) {
            this.clearAnimation();
            this.valueAnimator.setRepeatCount(0);
            this.valueAnimator.cancel();
            this.valueAnimator.end();
            if (this.OnStopAnim() == 0) {
                this.valueAnimator.setRepeatCount(0);
                this.valueAnimator.cancel();
                this.valueAnimator.end();
            }
        }
        return;
    }
}
