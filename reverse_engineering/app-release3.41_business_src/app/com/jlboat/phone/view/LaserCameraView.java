package com.jlboat.phone.view;
public class LaserCameraView extends android.view.View {
    private final String TAG;
    private com.jlboat.phone.view.LaserCameraView$IHasData iHasData;
    private boolean isSend;
    private android.graphics.Paint lowScanPaint;
    int matrix;
    private final Object mutex01;
    private final Object mutex02;
    private final Object mutex03;
    float[] scanFloats;
    private android.graphics.Paint scanPaint;
    android.graphics.Path scanPath;
    private int stride;
    private com.boat.jrosbridge.Topic subscriber01;
    private com.boat.jrosbridge.Topic subscriber02;
    private com.boat.jrosbridge.Topic subscriber03;
    com.boat.ros.geometry.Vector3 vector01;
    com.boat.ros.geometry.Vector3 vector02;
    com.boat.ros.geometry.Vector3 vector03;
    private java.util.List vectorScan01;
    private java.util.List vectorScan02;
    private java.util.List vectorScan03;

    public LaserCameraView(android.content.Context p2)
    {
        super(p2);
        super.TAG = "LaserCameraView";
        super.mutex01 = new Object();
        super.mutex02 = new Object();
        super.mutex03 = new Object();
        super.stride = 1;
        super.vectorScan01 = new java.util.concurrent.CopyOnWriteArrayList();
        super.vectorScan02 = new java.util.concurrent.CopyOnWriteArrayList();
        super.vectorScan03 = new java.util.concurrent.CopyOnWriteArrayList();
        super.matrix = 100;
        return;
    }

    public LaserCameraView(android.content.Context p2, android.util.AttributeSet p3)
    {
        super(p2, p3);
        super.TAG = "LaserCameraView";
        super.mutex01 = new Object();
        super.mutex02 = new Object();
        super.mutex03 = new Object();
        super.stride = 1;
        super.vectorScan01 = new java.util.concurrent.CopyOnWriteArrayList();
        super.vectorScan02 = new java.util.concurrent.CopyOnWriteArrayList();
        super.vectorScan03 = new java.util.concurrent.CopyOnWriteArrayList();
        super.matrix = 100;
        super.creatScanPaint();
        super.init();
        return;
    }

    static synthetic com.jlboat.phone.view.LaserCameraView$IHasData access$000(com.jlboat.phone.view.LaserCameraView p1)
    {
        return p1.iHasData;
    }

    static synthetic boolean access$100(com.jlboat.phone.view.LaserCameraView p1)
    {
        return p1.isSend;
    }

    static synthetic boolean access$102(com.jlboat.phone.view.LaserCameraView p0, boolean p1)
    {
        p0.isSend = p1;
        return p1;
    }

    static synthetic int access$200(com.jlboat.phone.view.LaserCameraView p1)
    {
        return p1.stride;
    }

    static synthetic void access$300(com.jlboat.phone.view.LaserCameraView p0, com.boat.jrosbridge.message.sensor_msgs.LaserScan p1, int p2)
    {
        p0.updateVertexBuffer01(p1, p2);
        return;
    }

    static synthetic void access$400(com.jlboat.phone.view.LaserCameraView p0, com.boat.jrosbridge.message.sensor_msgs.LaserScan p1, int p2)
    {
        p0.updateVertexBuffer02(p1, p2);
        return;
    }

    static synthetic void access$500(com.jlboat.phone.view.LaserCameraView p0, com.boat.jrosbridge.message.sensor_msgs.LaserScan p1, int p2)
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

    private void updateVertexBuffer01(com.boat.jrosbridge.message.sensor_msgs.LaserScan p22, int p23)
    {
        java.util.List v3_0 = p22.getRanges();
        com.boat.ros.geometry.Vector3 v4_0 = p22.getRangeMin();
        float v5 = p22.getRangeMax();
        float v6 = p22.getAngleMin();
        float v7 = p22.getAngleIncrement();
        try {
            this.vectorScan01.clear();
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
                if (this.vectorScan01.size() == 0) {
                    try {
                        long v10_4 = new com.boat.ros.geometry.Vector3;
                        v10_4(0, 0, 0);
                        this.vectorScan01.add(v10_4);
                    } catch (Throwable v0_4) {
                        v20 = v4_0;
                    }
                }
                long v10_5 = new com.boat.ros.geometry.Vector3;
                v19 = v3_0;
                v20 = v4_0;
                v10_5(((double) (((float) (((double) v9_1) * Math.cos(((double) v6)))) * ((float) this.matrix))), ((double) (((float) (((double) v9_1) * Math.sin(((double) v6)))) * ((float) this.matrix))), 0);
                this.vector01 = v10_5;
                this.vector01 = this.rotatePoint(this.vector01, 4602768891165194322);
                this.vectorScan01.add(this.vector01);
            }
            v6 += (((float) p23) * v7);
            v0_1 += p23;
            v3_0 = v19;
            v4_0 = v20;
        }
        v20 = v4_0;
        this.post(new com.jlboat.phone.view.LaserCameraView$4(this));
        return;
    }

    private void updateVertexBuffer02(com.boat.jrosbridge.message.sensor_msgs.LaserScan p22, int p23)
    {
        java.util.List v3_0 = p22.getRanges();
        com.boat.ros.geometry.Vector3 v4_0 = p22.getRangeMin();
        float v5 = p22.getRangeMax();
        float v6 = p22.getAngleMin();
        float v7 = p22.getAngleIncrement();
        try {
            this.vectorScan02.clear();
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
                if (this.vectorScan02.size() == 0) {
                    try {
                        long v10_4 = new com.boat.ros.geometry.Vector3;
                        v10_4(0, 0, 0);
                        this.vectorScan02.add(v10_4);
                    } catch (Throwable v0_4) {
                        v20 = v4_0;
                    }
                }
                long v10_5 = new com.boat.ros.geometry.Vector3;
                v19 = v3_0;
                v20 = v4_0;
                v10_5(((double) (((float) (((double) v9_1) * Math.cos(((double) v6)))) * ((float) this.matrix))), ((double) (((float) (((double) v9_1) * Math.sin(((double) v6)))) * ((float) this.matrix))), 0);
                this.vector02 = v10_5;
                this.vector02 = this.rotatePoint(this.vector02, -4620603145689581486);
                this.vectorScan02.add(this.vector02);
            }
            v6 += (((float) p23) * v7);
            v0_1 += p23;
            v3_0 = v19;
            v4_0 = v20;
        }
        v20 = v4_0;
        this.post(new com.jlboat.phone.view.LaserCameraView$5(this));
        return;
    }

    private void updateVertexBuffer03(com.boat.jrosbridge.message.sensor_msgs.LaserScan p22, int p23)
    {
        java.util.List v3_0 = p22.getRanges();
        com.boat.ros.geometry.Vector3 v4_0 = p22.getRangeMin();
        float v5 = p22.getRangeMax();
        float v6 = p22.getAngleMin();
        float v7 = p22.getAngleIncrement();
        try {
            this.vectorScan03.clear();
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
                if (this.vectorScan03.size() == 0) {
                    try {
                        com.boat.ros.geometry.Vector3 v10_4 = new com.boat.ros.geometry.Vector3;
                        v10_4(0, 0, 0);
                        this.vectorScan03.add(v10_4);
                    } catch (Throwable v0_4) {
                        v20 = v4_0;
                    }
                }
                com.boat.ros.geometry.Vector3 v10_5 = new com.boat.ros.geometry.Vector3;
                v19 = v3_0;
                v20 = v4_0;
                v10_5(((double) (((float) (((double) v9_1) * Math.cos(((double) v6)))) * ((float) this.matrix))), ((double) (((float) (((double) v9_1) * Math.sin(((double) v6)))) * ((float) this.matrix))), 0);
                this.vector03 = v10_5;
                this.vectorScan03.add(this.vector03);
            }
            v6 += (((float) p23) * v7);
            v0_1 += p23;
            v3_0 = v19;
            v4_0 = v20;
        }
        v20 = v4_0;
        this.post(new com.jlboat.phone.view.LaserCameraView$6(this));
        return;
    }

    public int getMatrix1()
    {
        return this.matrix;
    }

    protected void onDraw(android.graphics.Canvas p7)
    {
        if ((this.vectorScan01 != null) && (this.vectorScan01.size() > 0)) {
            try {
                int v1_1 = new float[(this.vectorScan01.size() * 2)];
                this.scanFloats = v1_1;
                this.scanPath = new android.graphics.Path();
                int v1_6 = 0;
            } catch (int v1_10) {
                throw v1_10;
            }
            while (v1_6 < this.scanFloats.length) {
                android.graphics.Paint v2_10 = (((float) ((this.getWidth() / 2) - 50)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan01.get((v1_6 / 2))).getY()));
                float v3_21 = (((float) (this.getHeight() / 2)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan01.get((v1_6 / 2))).getX()));
                this.scanFloats[v1_6] = v2_10;
                this.scanFloats[(v1_6 + 1)] = v3_21;
                if (v1_6 != 0) {
                    this.scanPath.lineTo(v2_10, v3_21);
                } else {
                    this.scanPath.moveTo(v2_10, v3_21);
                }
                v1_6 += 2;
            }
            this.scanPath.close();
            p7.drawPath(this.scanPath, this.lowScanPaint);
            p7.drawPoints(this.scanFloats, this.scanPaint);
        }
        if ((this.vectorScan02 != null) && (this.vectorScan02.size() > 0)) {
            try {
                int v1_16 = new float[(this.vectorScan02.size() * 2)];
                this.scanFloats = v1_16;
                this.scanPath = new android.graphics.Path();
                int v1_7 = 0;
            } catch (int v1_8) {
                throw v1_8;
            }
            while (v1_7 < this.scanFloats.length) {
                android.graphics.Paint v2_4 = (((float) ((this.getWidth() / 2) + 50)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan02.get((v1_7 / 2))).getY()));
                float v3_12 = (((float) (this.getHeight() / 2)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan02.get((v1_7 / 2))).getX()));
                this.scanFloats[v1_7] = v2_4;
                this.scanFloats[(v1_7 + 1)] = v3_12;
                if (v1_7 != 0) {
                    this.scanPath.lineTo(v2_4, v3_12);
                } else {
                    this.scanPath.moveTo(v2_4, v3_12);
                }
                v1_7 += 2;
            }
            this.scanPath.close();
            p7.drawPath(this.scanPath, this.lowScanPaint);
            p7.drawPoints(this.scanFloats, this.scanPaint);
        }
        if ((this.vectorScan03 != null) && (this.vectorScan03.size() > 0)) {
            try {
                int v1_25 = new float[(this.vectorScan03.size() * 2)];
                this.scanFloats = v1_25;
                this.scanPath = new android.graphics.Path();
                int v1_2 = 0;
            } catch (int v1_3) {
                throw v1_3;
            }
            while (v1_2 < this.scanFloats.length) {
                android.graphics.Paint v2_25 = (((float) (this.getWidth() / 2)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan03.get((v1_2 / 2))).getY()));
                float v3_3 = (((float) (this.getHeight() / 2)) - ((float) ((com.boat.ros.geometry.Vector3) this.vectorScan03.get((v1_2 / 2))).getX()));
                this.scanFloats[v1_2] = v2_25;
                this.scanFloats[(v1_2 + 1)] = v3_3;
                if (v1_2 != 0) {
                    this.scanPath.lineTo(v2_25, v3_3);
                } else {
                    this.scanPath.moveTo(v2_25, v3_3);
                }
                v1_2 += 2;
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
        this.subscriber01 = new com.boat.jrosbridge.Topic("/camera_01/scan", com.boat.jrosbridge.message.sensor_msgs.LaserScan, com.jlboat.phone.application.BoatSlamApplication.client);
        this.subscriber01.subscribe(new com.jlboat.phone.view.LaserCameraView$1(this));
        this.subscriber02 = new com.boat.jrosbridge.Topic("/camera_02/scan", com.boat.jrosbridge.message.sensor_msgs.LaserScan, com.jlboat.phone.application.BoatSlamApplication.client);
        this.subscriber02.subscribe(new com.jlboat.phone.view.LaserCameraView$2(this));
        this.subscriber03 = new com.boat.jrosbridge.Topic("/camera_03/scan", com.boat.jrosbridge.message.sensor_msgs.LaserScan, com.jlboat.phone.application.BoatSlamApplication.client);
        this.subscriber03.subscribe(new com.jlboat.phone.view.LaserCameraView$3(this));
        return;
    }

    public void onStop()
    {
        this.subscriber01.unsubscribe();
        this.subscriber02.unsubscribe();
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

    public void setHasData(com.jlboat.phone.view.LaserCameraView$IHasData p2)
    {
        this.iHasData = p2;
        this.isSend = 0;
        return;
    }

    public void setMatrix1(int p5)
    {
        try {
        } catch (Throwable v1) {
            throw v1;
        }
        this.matrix = p5;
        return;
    }
}
