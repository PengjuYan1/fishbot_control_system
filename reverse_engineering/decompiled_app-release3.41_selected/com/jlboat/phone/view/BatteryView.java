package com.jlboat.phone.view;
public class BatteryView extends android.view.View {
    private android.graphics.Paint mBatteryPaint;
    private android.graphics.RectF mBatteryRect;
    private float mBatteryStroke;
    private float mCapHeight;
    private android.graphics.Paint mCapPaint;
    private android.graphics.RectF mCapRect;
    private float mCapWidth;
    private float mPower;
    private float mPowerPadding;
    private android.graphics.Paint mPowerPaint;
    private android.graphics.RectF mPowerRect;
    private float mRound;

    public BatteryView(android.content.Context p2)
    {
        super(p2);
        super.mBatteryStroke = 1082130432;
        super.mCapHeight = 1041865114;
        super.mCapWidth = 1036831949;
        super.mRound = 1028443341;
        super.mPowerPadding = 1022739087;
        super.mPower = 0;
        super.initView(p2);
        return;
    }

    public BatteryView(android.content.Context p2, android.util.AttributeSet p3)
    {
        super(p2, p3);
        super.mBatteryStroke = 1082130432;
        super.mCapHeight = 1041865114;
        super.mCapWidth = 1036831949;
        super.mRound = 1028443341;
        super.mPowerPadding = 1022739087;
        super.mPower = 0;
        super.initView(p2);
        return;
    }

    public BatteryView(android.content.Context p2, android.util.AttributeSet p3, int p4)
    {
        super(p2, p3, p4);
        super.mBatteryStroke = 1082130432;
        super.mCapHeight = 1041865114;
        super.mCapWidth = 1036831949;
        super.mRound = 1028443341;
        super.mPowerPadding = 1022739087;
        super.mPower = 0;
        super.initView(p2);
        return;
    }

    private void initView(android.content.Context p5)
    {
        this.mBatteryPaint = new android.graphics.Paint();
        this.mBatteryPaint.setColor(-1);
        this.mBatteryPaint.setAntiAlias(1);
        this.mBatteryPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.mBatteryPaint.setStrokeWidth(this.mBatteryStroke);
        this.mPowerPaint = new android.graphics.Paint();
        this.mPowerPaint.setColor(-16711936);
        this.mPowerPaint.setAntiAlias(1);
        this.mPowerPaint.setStyle(android.graphics.Paint$Style.FILL);
        this.mCapPaint = new android.graphics.Paint();
        this.mCapPaint.setColor(-1);
        this.mCapPaint.setAntiAlias(1);
        this.mCapPaint.setStyle(android.graphics.Paint$Style.FILL);
        this.mCapPaint.setStrokeWidth(this.mBatteryStroke);
        return;
    }

    protected void onDraw(android.graphics.Canvas p5)
    {
        super.onDraw(p5);
        p5.save();
        p5.drawRoundRect(this.mBatteryRect, (this.mRound * ((float) this.getWidth())), (this.mRound * ((float) this.getHeight())), this.mBatteryPaint);
        p5.drawRoundRect(this.mCapRect, (this.mRound * ((float) this.getWidth())), (this.mRound * ((float) this.getHeight())), this.mCapPaint);
        if (this.mPower <= 1101004800) {
            this.mPowerPaint.setColor(-65536);
        } else {
            this.mPowerPaint.setColor(-16711936);
        }
        if (this.mPower > 1082130432) {
            p5.drawRect(this.mPowerRect, this.mPowerPaint);
        }
        p5.restore();
        return;
    }

    protected void onMeasure(int p12, int p13)
    {
        float v7_9;
        int v0 = android.view.View$MeasureSpec.getSize(p12);
        int v1 = android.view.View$MeasureSpec.getSize(p13);
        this.mBatteryRect = new android.graphics.RectF((this.mBatteryStroke / 1073741824), (this.mBatteryStroke / 1073741824), (((float) v0) - (((float) v0) * this.mCapWidth)), (((float) v1) - (this.mBatteryStroke / 1073741824)));
        float v2_5 = ((((((float) v0) - (((float) v0) * this.mCapWidth)) - (this.mBatteryStroke / 1073741824)) - (this.mPowerPadding * ((float) v0))) * (this.mPower / 1120403456));
        if (v2_5 > 0) {
            v7_9 = v2_5;
        } else {
            v7_9 = (this.mBatteryStroke + (this.mPowerPadding * ((float) v0)));
        }
        this.mPowerRect = new android.graphics.RectF((this.mBatteryStroke + (this.mPowerPadding * ((float) v0))), (this.mBatteryStroke + (this.mPowerPadding * ((float) v1))), v7_9, ((((float) v1) - this.mBatteryStroke) - (this.mPowerPadding * ((float) v1))));
        this.mCapRect = new android.graphics.RectF((((float) v0) - (((float) v0) * this.mCapWidth)), (((float) (v1 / 2)) - (((float) v1) * this.mCapHeight)), (((float) v0) - (this.mBatteryStroke / 1073741824)), (((float) (v1 / 2)) + (((float) v1) * this.mCapHeight)));
        this.setMeasuredDimension(v0, v1);
        return;
    }

    public void setPower(float p3)
    {
        float v0 = 0;
        if (p3 >= 0) {
            v0 = 1120403456;
            if (p3 <= 1120403456) {
                v0 = p3;
            }
        }
        this.mPower = v0;
        this.invalidate();
        return;
    }
}
