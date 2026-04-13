package com.jlboat.phone.view;
public class DrawMapView extends android.view.View {
    private static final long MIN_REFRESH_INTERVAL = 16;
    private static final String TAG = "DrawMapView";
    private android.graphics.Paint bitmapPaint;
    android.graphics.DrawFilter drawFilter;
    private android.graphics.Paint eraserIndicatorPaint;
    private android.graphics.Paint eraserPaint;
    private float eraserRadius;
    private boolean isChange;
    private long lastRefreshTime;
    private com.jlboat.phone.view.DrawMapView$MapDataChangeCallBack mapDataChangeCallBack;
    private boolean map_ready;
    private android.graphics.Bitmap mutableBitmap;
    private float physicalEraserRadius;
    private android.graphics.Bitmap sourceBitmap;
    private boolean start;
    private com.jlboat.phone.view.TouchEvenHandler touchEvenHandler;

    public DrawMapView(android.content.Context p4)
    {
        super(p4);
        super.drawFilter = new android.graphics.PaintFlagsDrawFilter(0, 3);
        super.eraserRadius = 1101004800;
        super.physicalEraserRadius = 1101004800;
        super.lastRefreshTime = 0;
        super.init(p4);
        return;
    }

    public DrawMapView(android.content.Context p4, android.util.AttributeSet p5)
    {
        super(p4, p5);
        super.drawFilter = new android.graphics.PaintFlagsDrawFilter(0, 3);
        super.eraserRadius = 1101004800;
        super.physicalEraserRadius = 1101004800;
        super.lastRefreshTime = 0;
        super.init(p4);
        return;
    }

    public DrawMapView(android.content.Context p4, android.util.AttributeSet p5, int p6)
    {
        super(p4, p5, p6);
        super.drawFilter = new android.graphics.PaintFlagsDrawFilter(0, 3);
        super.eraserRadius = 1101004800;
        super.physicalEraserRadius = 1101004800;
        super.lastRefreshTime = 0;
        super.init(p4);
        return;
    }

    private void drawEraserIndicator(android.graphics.Canvas p5)
    {
        p5.drawCircle((((float) this.getWidth()) / 1073741824), (((float) this.getHeight()) / 1073741824), this.physicalEraserRadius, this.eraserIndicatorPaint);
        return;
    }

    private void eraseAt(float p9, float p10)
    {
        if ((p9 >= 0) && ((p10 >= 0) && ((p9 < ((float) this.mutableBitmap.getWidth())) && (p10 < ((float) this.mutableBitmap.getHeight()))))) {
            float v1_2 = (this.physicalEraserRadius / ((float) this.touchEvenHandler.getZoomX()));
            new android.graphics.Canvas(this.mutableBitmap).drawCircle(p9, p10, v1_2, this.eraserPaint);
            this.invalidate(new android.graphics.Rect(((int) (p9 - v1_2)), ((int) (p10 - v1_2)), ((int) (p9 + v1_2)), ((int) (p10 + v1_2))));
            return;
        } else {
            return;
        }
    }

    private void init(android.content.Context p4)
    {
        if (this.sourceBitmap != null) {
            if (this.sourceBitmap.isRecycled()) {
                this.sourceBitmap = android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap$Config.RGB_565);
            }
        } else {
            this.sourceBitmap = android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap$Config.RGB_565);
        }
        this.eraserPaint = new android.graphics.Paint();
        this.eraserPaint.setColor(-1);
        this.eraserPaint.setStyle(android.graphics.Paint$Style.FILL);
        this.eraserPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff$Mode.SRC));
        this.eraserIndicatorPaint = new android.graphics.Paint();
        this.eraserIndicatorPaint.setColor(-65536);
        this.eraserIndicatorPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.eraserIndicatorPaint.setStrokeWidth(1073741824);
        return;
    }

    public String getMapData()
    {
        java.io.ByteArrayOutputStream v1_1 = new java.io.ByteArrayOutputStream();
        this.mutableBitmap.compress(android.graphics.Bitmap$CompressFormat.PNG, 100, v1_1);
        return android.util.Base64.encodeToString(v1_1.toByteArray(), 2);
    }

    public float getPhysicalEraserRadius()
    {
        return this.physicalEraserRadius;
    }

    public void invalidate(android.graphics.Rect p8)
    {
        long v0 = System.currentTimeMillis();
        if ((v0 - this.lastRefreshTime) > 16) {
            super.invalidate();
            this.lastRefreshTime = v0;
        }
        return;
    }

    public void isClear(boolean p1)
    {
        this.start = p1;
        return;
    }

    protected void onDraw(android.graphics.Canvas p4)
    {
        if (this.map_ready) {
            if (this.touchEvenHandler != null) {
                p4.setDrawFilter(this.drawFilter);
                p4.drawBitmap(this.mutableBitmap, this.touchEvenHandler.getMatrix(), this.bitmapPaint);
                this.drawEraserIndicator(p4);
            }
            return;
        } else {
            return;
        }
    }

    protected void onLayout(boolean p1, int p2, int p3, int p4, int p5)
    {
        super.onLayout(p1, p2, p3, p4, p5);
        return;
    }

    public void onStop()
    {
        if (this.sourceBitmap != null) {
            this.sourceBitmap.recycle();
        }
        return;
    }

    public boolean onTouchEvent(android.view.MotionEvent p7)
    {
        if (this.touchEvenHandler != null) {
            this.touchEvenHandler.touchEvent(p7);
            if (this.start) {
                android.graphics.PointF v2_2 = this.touchEvenHandler.coordinatesToImage((((float) this.getWidth()) / 1073741824), (((float) this.getHeight()) / 1073741824));
                this.eraseAt(v2_2.x, v2_2.y);
                if (!this.isChange) {
                    this.isChange = 1;
                    this.mapDataChangeCallBack.onChange(1);
                }
            }
            return 1;
        } else {
            return 1;
        }
    }

    public void setMapChangeCallBack(com.jlboat.phone.view.DrawMapView$MapDataChangeCallBack p1)
    {
        this.mapDataChangeCallBack = p1;
        return;
    }

    public void setPhysicalEraserRadius(float p1)
    {
        this.physicalEraserRadius = p1;
        this.invalidate();
        return;
    }

    public void updateMap(String p6)
    {
        this.isChange = 0;
        this.mapDataChangeCallBack.onChange(0);
        android.util.Log.d("DrawMapView", "updateMap: ");
        byte[] v1_2 = android.util.Base64.decode(p6, 0);
        this.sourceBitmap = android.graphics.BitmapFactory.decodeByteArray(v1_2, 0, v1_2.length);
        this.mutableBitmap = this.sourceBitmap.copy(android.graphics.Bitmap$Config.ARGB_8888, 1);
        this.map_ready = 1;
        this.touchEvenHandler = new com.jlboat.phone.view.TouchEvenHandler(this, this.sourceBitmap, 0);
        this.post(new com.jlboat.phone.view.DrawMapView$1(this));
        return;
    }
}
