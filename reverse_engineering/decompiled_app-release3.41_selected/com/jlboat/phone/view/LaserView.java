package com.jlboat.phone.view;
public class LaserView extends android.view.View {
    private com.jlboat.phone.view.LaserView$IHasData iHasData;
    private boolean isSend;
    private android.graphics.Paint lowScanPaint;
    int matrix;
    private final Object mutex;
    float[] scanFloats;
    private android.graphics.Paint scanPaint;
    android.graphics.Path scanPath;
    private int stride;
    private com.boat.jrosbridge.Topic subscriber;
    com.boat.ros.geometry.Vector3 vector30;
    private java.util.List vectorScan;

    public LaserView(android.content.Context p2)
    {
        super(p2);
        super.mutex = new Object();
        super.stride = 1;
        super.vectorScan = new java.util.concurrent.CopyOnWriteArrayList();
        super.matrix = 100;
        return;
    }

    public LaserView(android.content.Context p2, android.util.AttributeSet p3)
    {
        super(p2, p3);
        super.mutex = new Object();
        super.stride = 1;
        super.vectorScan = new java.util.concurrent.CopyOnWriteArrayList();
        super.matrix = 100;
        super.creatScanPaint();
        super.init();
        return;
    }

    static synthetic com.jlboat.phone.view.LaserView$IHasData access$000(com.jlboat.phone.view.LaserView p1)
    {
        return p1.iHasData;
    }

    static synthetic boolean access$100(com.jlboat.phone.view.LaserView p1)
    {
        return p1.isSend;
    }

    static synthetic boolean access$102(com.jlboat.phone.view.LaserView p0, boolean p1)
    {
        p0.isSend = p1;
        return p1;
    }

    static synthetic int access$200(com.jlboat.phone.view.LaserView p1)
    {
        return p1.stride;
    }

    static synthetic void access$300(com.jlboat.phone.view.LaserView p0, com.boat.jrosbridge.message.sensor_msgs.LaserScan p1, int p2)
    {
        p0.updateVertexBuffer(p1, p2);
        return;
    }

    private void creatScanPaint()
    {
        this.scanPaint = new android.graphics.Paint();
        this.lowScanPaint = new android.graphics.Paint();
        this.lowScanPaint.setColor(this.getResources().getColor(2131034187));
        this.scanPaint.setColor(this.getResources().getColor(2131034221));
        this.scanPaint.setAntiAlias(1);
        this.scanPaint.setStrokeWidth(1092616192);
        return;
    }

    private void init()
    {
        return;
    }

    private void updateVertexBuffer(com.boat.jrosbridge.message.sensor_msgs.LaserScan p22, int p23)
    {
        java.util.List v3_0 = p22.getRanges();
        com.boat.ros.geometry.Vector3 v4_0 = p22.getRangeMin();
        float v5 = p22.getRangeMax();
        float v6 = p22.getAngleMin();
        float v7 = p22.getAngleIncrement();
        try {
            this.vectorScan.clear();
            Throwable v0_1 = 0;
        } catch (Throwable v0_4) {
            float v20 = v4_0;
            throw v0_4;
        } catch (Throwable v0_4) {
        }
        while (v0_1 < v3_0.length) {
            double v19;
            float v9_1 = v3_0[v0_1];
            if ((v4_0 >= v9_1) || (v9_1 >= v5)) {
                v19 = v3_0;
                v20 = v4_0;
            } else {
                if (this.vectorScan.size() == 0) {
                    try {
                        com.boat.ros.geometry.Vector3 v10_4 = new com.boat.ros.geometry.Vector3;
                        v10_4(0, 0, 0);
                        this.vectorScan.add(v10_4);
                    } catch (Throwable v0_4) {
                        v20 = v4_0;
                    }
                }
                com.boat.ros.geometry.Vector3 v10_5 = new com.boat.ros.geometry.Vector3;
                v19 = v3_0;
                v20 = v4_0;
                v10_5(((double) (((float) (((double) v9_1) * Math.cos(((double) v6)))) * ((float) this.matrix))), ((double) (((float) (((double) v9_1) * Math.sin(((double) v6)))) * ((float) this.matrix))), 0);
                this.vector30 = v10_5;
                this.vectorScan.add(this.vector30);
            }
            v6 += (((float) p23) * v7);
            v0_1 += p23;
            v3_0 = v19;
            v4_0 = v20;
        }
        v20 = v4_0;
        this.post(new com.jlboat.phone.view.LaserView$2(this));
        return;
    }

    public int getMatrix1()
    {
        return this.matrix;
    }

    protected void onDraw(android.graphics.Canvas p7)
    {
        if ((this.vectorScan != null) && (this.vectorScan.size() > 0)) {
            try {
                int v1_1 = new float[(this.vectorScan.size() * 2)];
                this.scanFloats = v1_1;
                this.scanPath = new android.graphics.Path();
                int v1_4 = 0;
            } catch (int v1_8) {
                throw v1_8;
            }
            while (v1_4 < this.scanFloats.length) {
                android.graphics.Paint v2_7 = (((float) (this.getWidth() / 2)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan.get((v1_4 / 2))).getY()));
                float v3_8 = (((float) (this.getHeight() / 2)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan.get((v1_4 / 2))).getX()));
                this.scanFloats[v1_4] = v2_7;
                this.scanFloats[(v1_4 + 1)] = v3_8;
                if (v1_4 != 0) {
                    this.scanPath.lineTo(v2_7, v3_8);
                } else {
                    this.scanPath.moveTo(v2_7, v3_8);
                }
                v1_4 += 2;
            }
            this.scanPath.close();
            p7.drawPath(this.scanPath, this.lowScanPaint);
            p7.drawPoints(this.scanFloats, this.scanPaint);
        }
        super.onDraw(p7);
        return;
    }

    public void onStart()
    {
        this.subscriber = new com.boat.jrosbridge.Topic("/scan", com.boat.jrosbridge.message.sensor_msgs.LaserScan, com.jlboat.phone.application.BoatSlamApplication.client);
        this.subscriber.subscribe(new com.jlboat.phone.view.LaserView$1(this));
        return;
    }

    public void onStop()
    {
        this.subscriber.unsubscribe();
        return;
    }

    public void setHasData(com.jlboat.phone.view.LaserView$IHasData p2)
    {
        this.iHasData = p2;
        this.isSend = 0;
        return;
    }

    public void setMatrix1(int p3)
    {
        try {
            this.matrix = p3;
            return;
        } catch (Throwable v1) {
            throw v1;
        }
    }
}
