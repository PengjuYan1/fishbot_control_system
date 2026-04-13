package com.jlboat.phone.view;
public abstract class WidgetView extends android.view.ViewGroup {
    public static String TAG;
    protected boolean editMode;
    protected android.view.GestureDetector editModeGestureDetector;
    protected android.view.ScaleGestureDetector editModeScaleGestureDetector;
    private android.graphics.Paint highlightPaint;
    private boolean shouldHighlight;
    private float tileWidth;

    static WidgetView()
    {
        com.jlboat.phone.view.WidgetView.TAG = com.jlboat.phone.view.WidgetView.getSimpleName();
        return;
    }

    public WidgetView(android.content.Context p2)
    {
        super(p2);
        super.editMode = 0;
        super.shouldHighlight = 0;
        super.baseInit();
        return;
    }

    public WidgetView(android.content.Context p2, android.util.AttributeSet p3)
    {
        super(p2, p3);
        super.editMode = 0;
        super.shouldHighlight = 0;
        super.baseInit();
        return;
    }

    private void baseInit()
    {
        this.setWillNotDraw(0);
        this.highlightPaint = new android.graphics.Paint();
        this.highlightPaint.setColor(this.getResources().getColor(2131034165));
        this.highlightPaint.setStyle(android.graphics.Paint$Style.FILL_AND_STROKE);
        this.highlightPaint.setAlpha(100);
        return;
    }

    public void onDraw(android.graphics.Canvas p8)
    {
        super.onDraw(p8);
        if ((this.editMode) && (this.shouldHighlight)) {
            p8.drawRect(0, 0, ((float) this.getWidth()), ((float) this.getHeight()), this.highlightPaint);
        }
        return;
    }

    protected void onLayout(boolean p1, int p2, int p3, int p4, int p5)
    {
        return;
    }

    public boolean onTouchEvent(android.view.MotionEvent p3)
    {
        android.util.Log.d(com.jlboat.phone.view.WidgetView.TAG, "onTouchEvent: ");
        if (!this.editMode) {
            return super.onTouchEvent(p3);
        } else {
            if (p3.getAction() == 1) {
                this.shouldHighlight = 0;
                this.invalidate();
            }
            this.editModeGestureDetector.onTouchEvent(p3);
            this.editModeScaleGestureDetector.onTouchEvent(p3);
            return 1;
        }
    }
}
