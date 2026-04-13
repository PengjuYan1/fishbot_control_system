package com.jlboat.phone.view;
public class LaserCamera03View extends android.view.View {
    private final String TAG;
    private com.jlboat.phone.view.LaserCamera03View$IHasData iHasData;
    private boolean isSend;
    private android.graphics.Paint lowScanPaint;
    int matrix;
    private final Object mutex03;
    float[] scanFloats;
    private android.graphics.Paint scanPaint;
    android.graphics.Path scanPath;
    private int stride;
    private com.boat.jrosbridge.Topic subscriber03;
    com.boat.ros.geometry.Vector3 vector03;
    private java.util.List vectorScan03;

    public LaserCamera03View(android.content.Context p2)
    {
        super(p2);
        super.TAG = "LaserCamera03View";
        super.mutex03 = new Object();
        super.stride = 1;
        super.vectorScan03 = new java.util.concurrent.CopyOnWriteArrayList();
        super.matrix = 100;
        return;
    }

    public LaserCamera03View(android.content.Context p2, android.util.AttributeSet p3)
    {
        super(p2, p3);
        super.TAG = "LaserCamera03View";
        super.mutex03 = new Object();
        super.stride = 1;
        super.vectorScan03 = new java.util.concurrent.CopyOnWriteArrayList();
        super.matrix = 100;
        super.creatScanPaint();
        super.init();
        return;
    }

    static synthetic com.jlboat.phone.view.LaserCamera03View$IHasData access$000(com.jlboat.phone.view.LaserCamera03View p1)
    {
        return p1.iHasData;
    }

    static synthetic boolean access$100(com.jlboat.phone.view.LaserCamera03View p1)
    {
        return p1.isSend;
    }

    static synthetic boolean access$102(com.jlboat.phone.view.LaserCamera03View p0, boolean p1)
    {
        p0.isSend = p1;
        return p1;
    }

    static synthetic int access$200(com.jlboat.phone.view.LaserCamera03View p1)
    {
        return p1.stride;
    }

    static synthetic void access$300(com.jlboat.phone.view.LaserCamera03View p0, com.boat.jrosbridge.message.sensor_msgs.LaserScan p1, int p2)
    {
        p0.updateVertexBuffer03(p1, p2);
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

    private void updateVertexBuffer03(com.boat.jrosbridge.message.sensor_msgs.LaserScan p22, int p23)
    {
        java.util.List v3_3 = p22.getRanges();
        com.boat.ros.geometry.Vector3 v4_3 = p22.getRangeMin();
        float v5 = p22.getRangeMax();
        float v6 = p22.getAngleMin();
        float v7 = p22.getAngleIncrement();
        try {
            this.vectorScan03.clear();
            Throwable v0_2 = 0;
        } catch (Throwable v0_0) {
            int v20 = v4_3;
            throw v0_0;
        } catch (Throwable v0_0) {
        }
        while (v0_2 < v3_3.length) {
            double v19;
            float v9_1 = v3_3[v0_2];
            if ((v4_3 >= v9_1) || (v9_1 >= v5)) {
                v19 = v3_3;
                v20 = v4_3;
            } else {
                if (this.vectorScan03.size() == 0) {
                    try {
                        com.boat.ros.geometry.Vector3 v10_4 = new com.boat.ros.geometry.Vector3;
                        v10_4(0, 0, 0);
                        this.vectorScan03.add(v10_4);
                    } catch (Throwable v0_0) {
                        v20 = v4_3;
                    }
                }
                com.boat.ros.geometry.Vector3 v10_5 = new com.boat.ros.geometry.Vector3;
                v19 = v3_3;
                v20 = v4_3;
                v10_5(((double) (((float) (((double) v9_1) * Math.cos(((double) v6)))) * ((float) this.matrix))), ((double) (((float) (((double) v9_1) * Math.sin(((double) v6)))) * ((float) this.matrix))), 0);
                this.vector03 = v10_5;
                this.vectorScan03.add(this.vector03);
            }
            v6 += (((float) p23) * v7);
            v0_2 += p23;
            v3_3 = v19;
            v4_3 = v20;
        }
        v20 = v4_3;
        android.util.Log.d("LaserCamera03View", new StringBuilder().append("updateVertexBuffer03: ").append(this.vectorScan03.size()).toString());
        this.post(new com.jlboat.phone.view.LaserCamera03View$2(com.jlboat.phone.view.LaserCamera03View v1));
        return;
    }

    public int getMatrix1()
    {
        return this.matrix;
    }

    protected void onDraw(android.graphics.Canvas p7)
    {
        if ((this.vectorScan03 != null) && (this.vectorScan03.size() > 0)) {
            try {
                int v1_1 = new float[(this.vectorScan03.size() * 2)];
                this.scanFloats = v1_1;
                this.scanPath = new android.graphics.Path();
                int v1_4 = 0;
            } catch (int v1_8) {
                throw v1_8;
            }
            while (v1_4 < this.scanFloats.length) {
                android.graphics.Paint v2_7 = (((float) (this.getWidth() / 2)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan03.get((v1_4 / 2))).getY()));
                float v3_8 = (((float) (this.getHeight() / 2)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan03.get((v1_4 / 2))).getX()));
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
        this.subscriber03 = new com.boat.jrosbridge.Topic("/camera_03/scan", com.boat.jrosbridge.message.sensor_msgs.LaserScan, com.jlboat.phone.application.BoatSlamApplication.client);
        this.subscriber03.subscribe(new com.jlboat.phone.view.LaserCamera03View$1(this));
        return;
    }

    public void onStop()
    {
        this.subscriber03.unsubscribe();
        return;
    }

    public com.boat.ros.geometry.Vector3 rotatePoint(com.boat.ros.geometry.Vector3 p17, double p18)
    {
        double v0 = Math.cos(p18);
        double v2 = Math.sin(p18);
        com.boat.ros.geometry.Vector3 v15 = new com.boat.ros.geometry.Vector3;
        v15(((p17.getX() * v0) - (p17.getY() * v2)), ((p17.getX() * v2) + (p17.getY() * v0)), 0);
        return v15;
    }

    public void setHasData(com.jlboat.phone.view.LaserCamera03View$IHasData p2)
    {
        this.iHasData = p2;
        this.isSend = 0;
        return;
    }

    public void setMatrix(int p3)
    {
        try {
            this.matrix = p3;
            return;
        } catch (Throwable v1) {
            throw v1;
        }
    }
}
