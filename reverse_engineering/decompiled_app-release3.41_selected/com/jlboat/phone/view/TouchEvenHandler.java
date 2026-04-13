package com.jlboat.phone.view;
public class TouchEvenHandler {
    public static final int DEFAULT_BITMAP = 0;
    private static final int MPERSP_0 = 6;
    private static final int MPERSP_1 = 7;
    private static final int MPERSP_2 = 8;
    private static final int MSCALE_X = 0;
    private static final int MSCALE_Y = 4;
    private static final int MSKEW_X = 1;
    private static final int MSKEW_Y = 3;
    private static final int MTRANS_X = 2;
    private static final int MTRANS_Y = 5;
    public static final int NONE_BITMAP = 4;
    public static final int ROTATION_BITMAP = 3;
    public static final int SCALE_BITMAP = 1;
    public static final int SCALE_BITMAP_IN = 6;
    public static final int SCALE_BITMAP_OUT = 5;
    public static final int TRANSLATE_BITMAP = 2;
    private boolean canRotate;
    public int currentStatus;
    private int heightScreen;
    private float initRatio;
    private boolean isAutoRefresh;
    private android.graphics.Matrix matrix;
    private android.graphics.Matrix matrix1;
    boolean matrixCheck;
    private android.graphics.PointF mid;
    private float oldDist;
    private float oldRotation;
    private float rotation;
    private android.graphics.Matrix savedMatrix;
    private android.graphics.Bitmap sourceBitmap;
    private android.graphics.PointF start;
    private float[] values;
    private android.view.View view;
    private int widthScreen;
    private float x_down;
    private float y_down;

    public TouchEvenHandler(android.view.View p3, android.graphics.Bitmap p4, boolean p5)
    {
        int v0_4 = new float[9];
        this.values = v0_4;
        this.x_down = 0;
        this.y_down = 0;
        this.start = new android.graphics.PointF();
        this.mid = new android.graphics.PointF();
        this.oldDist = 1065353216;
        this.oldRotation = 0;
        this.matrix = new android.graphics.Matrix();
        this.matrix1 = new android.graphics.Matrix();
        this.savedMatrix = new android.graphics.Matrix();
        this.matrixCheck = 0;
        this.isAutoRefresh = 0;
        this.canRotate = 1;
        this.view = p3;
        this.isAutoRefresh = p5;
        this.widthScreen = p3.getWidth();
        this.heightScreen = p3.getHeight();
        this.sourceBitmap = p4;
        this.initBitmap();
        if (!p5) {
            p3.invalidate();
        }
        return;
    }

    private void initBitmap()
    {
        if (this.sourceBitmap != null) {
            this.matrix.reset();
            this.savedMatrix.set(this.matrix);
            this.matrix1.set(this.savedMatrix);
            int v0_2 = this.sourceBitmap.getWidth();
            int v1_1 = this.sourceBitmap.getHeight();
            if ((v0_2 <= this.widthScreen) && (v1_1 <= this.heightScreen)) {
                this.matrix1.postTranslate((((float) (this.widthScreen - v0_2)) / 1073741824), (((float) (this.heightScreen - v1_1)) / 1073741824));
                this.initRatio = 1065353216;
            } else {
                if (v0_2 <= this.widthScreen) {
                    if (v1_1 <= this.heightScreen) {
                        float v2_13 = Math.max(((((float) v0_2) * 1065353216) / ((float) this.widthScreen)), ((((float) v1_1) * 1065353216) / ((float) this.heightScreen)));
                        this.matrix1.postScale(v2_13, v2_13);
                        this.matrix1.postTranslate(((((float) this.widthScreen) - (((float) v0_2) * v2_13)) / 1073741824), ((((float) this.heightScreen) - (((float) v1_1) * v2_13)) / 1073741824));
                        this.initRatio = v2_13;
                    } else {
                        float v2_16 = (((float) this.heightScreen) / (((float) v1_1) * 1065353216));
                        this.matrix1.postScale(v2_16, v2_16);
                        this.matrix1.postTranslate(((((float) this.widthScreen) - (((float) v0_2) * v2_16)) / 1073741824), 0);
                        this.initRatio = v2_16;
                    }
                } else {
                    float v2_19 = (((float) this.widthScreen) / (((float) v0_2) * 1065353216));
                    float v3_18 = ((((float) this.heightScreen) - (((float) v1_1) * v2_19)) / 1073741824);
                    this.matrix1.postScale(v2_19, v2_19);
                    this.matrix1.postTranslate(0, v3_18);
                    this.initRatio = v2_19;
                }
            }
            this.matrix.set(this.matrix1);
            this.matrix.getValues(this.values);
        }
        return;
    }

    private boolean matrixCheck()
    {
        float[] v1_1 = new float[9];
        this.matrix1.getValues(v1_1);
        float v3_1 = (((v1_1[0] * 0) + (v1_1[1] * 0)) + v1_1[2]);
        float v8_3 = (((v1_1[3] * 0) + (v1_1[4] * 0)) + v1_1[5]);
        float v11_4 = (((v1_1[0] * ((float) this.sourceBitmap.getWidth())) + (v1_1[1] * 0)) + v1_1[2]);
        float v12_9 = (((v1_1[3] * ((float) this.sourceBitmap.getWidth())) + (v1_1[4] * 0)) + v1_1[5]);
        float v13_9 = (((v1_1[0] * 0) + (v1_1[1] * ((float) this.sourceBitmap.getHeight()))) + v1_1[2]);
        float v14_6 = (((v1_1[3] * 0) + (v1_1[4] * ((float) this.sourceBitmap.getHeight()))) + v1_1[5]);
        float v4_7 = (((v1_1[0] * ((float) this.sourceBitmap.getWidth())) + (v1_1[1] * ((float) this.sourceBitmap.getHeight()))) + v1_1[2]);
        float v2_9 = (((v1_1[3] * ((float) this.sourceBitmap.getWidth())) + (v1_1[4] * ((float) this.sourceBitmap.getHeight()))) + v1_1[5]);
        double v9_4 = Math.sqrt(((double) (((v3_1 - v11_4) * (v3_1 - v11_4)) + ((v8_3 - v12_9) * (v8_3 - v12_9)))));
        if ((v9_4 >= ((double) ((((float) this.sourceBitmap.getWidth()) * this.initRatio) * 1036831949))) && (v9_4 <= ((double) (((float) this.widthScreen) * 1092616192)))) {
            if (((v3_1 >= ((float) (this.widthScreen / 3))) || ((v11_4 >= ((float) (this.widthScreen / 3))) || ((v13_9 >= ((float) (this.widthScreen / 3))) || (v4_7 >= ((float) (this.widthScreen / 3)))))) && (((v3_1 <= ((float) ((this.widthScreen * 2) / 3))) || ((v11_4 <= ((float) ((this.widthScreen * 2) / 3))) || ((v13_9 <= ((float) ((this.widthScreen * 2) / 3))) || (v4_7 <= ((float) ((this.widthScreen * 2) / 3)))))) && (((v8_3 >= ((float) (this.heightScreen / 3))) || ((v12_9 >= ((float) (this.heightScreen / 3))) || ((v14_6 >= ((float) (this.heightScreen / 3))) || (v2_9 >= ((float) (this.heightScreen / 3)))))) && ((v8_3 <= ((float) ((this.heightScreen * 2) / 3))) || ((v12_9 <= ((float) ((this.heightScreen * 2) / 3))) || ((v14_6 <= ((float) ((this.heightScreen * 2) / 3))) || (v2_9 <= ((float) ((this.heightScreen * 2) / 3))))))))) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    private void midPoint(android.graphics.PointF p5, android.view.MotionEvent p6)
    {
        p5.set(((p6.getX(0) + p6.getX(1)) / 1073741824), ((p6.getY(0) + p6.getY(1)) / 1073741824));
        return;
    }

    private float rotation(android.view.MotionEvent p10)
    {
        return ((float) Math.toDegrees(Math.atan2(((double) (p10.getY(0) - p10.getY(1))), ((double) (p10.getX(0) - p10.getX(1))))));
    }

    private float spacing(android.view.MotionEvent p5)
    {
        return ((float) Math.sqrt(((double) ((Math.abs((p5.getX(0) - p5.getX(1))) * Math.abs((p5.getX(0) - p5.getX(1)))) + (Math.abs((p5.getY(0) - p5.getY(1))) * Math.abs((p5.getY(0) - p5.getY(1))))))));
    }

    public android.graphics.PointF coordinatesToCanvas(float p24, float p25)
    {
        double v1_1 = Math.atan2(((double) this.values[3]), ((double) this.values[4]));
        double v3_0 = Math.cos(v1_1);
        float v5_0 = Math.sin(v1_1);
        double v8_1 = (((double) p24) * this.getZoomX());
        double v11_1 = (((double) p25) * this.getZoomY());
        return new android.graphics.PointF(((float) (((double) this.getTranslateX()) + ((v8_1 * v3_0) - (v11_1 * v5_0)))), ((float) (((double) this.getTranslateY()) + ((v8_1 * v5_0) + (v11_1 * v3_0)))));
    }

    public android.graphics.PointF coordinatesToImage(float p19, float p20)
    {
        float v0_0 = this.getCosA();
        double v2 = this.getSinA();
        float v4_1 = (p19 - this.getTranslateX());
        float v5_1 = (p20 - this.getTranslateY());
        return new android.graphics.PointF(((float) (((((double) v4_1) / v0_0) + ((v2 / ((v0_0 * v0_0) + (v2 * v2))) * (((double) v5_1) - ((((double) v4_1) * v2) / v0_0)))) / this.getZoomX())), ((float) ((((((double) v5_1) - ((((double) v4_1) * v2) / v0_0)) * v0_0) / ((v0_0 * v0_0) + (v2 * v2))) / this.getZoomY())));
    }

    public double getCosA()
    {
        return Math.cos(this.getRadians());
    }

    public android.graphics.Matrix getMatrix()
    {
        return this.matrix;
    }

    public double getRadians()
    {
        return Math.atan2(((double) this.values[3]), ((double) this.values[4]));
    }

    public double getSinA()
    {
        return Math.sin(this.getRadians());
    }

    public float getTranslateX()
    {
        return this.values[2];
    }

    public float getTranslateY()
    {
        return this.values[5];
    }

    public String getValuesToString()
    {
        return java.util.Arrays.toString(this.values);
    }

    public double getZoomX()
    {
        return (((double) this.values[0]) / this.getCosA());
    }

    public double getZoomY()
    {
        return (((double) this.values[4]) / this.getCosA());
    }

    public void setCanRotate(boolean p1)
    {
        this.canRotate = p1;
        return;
    }

    public void touchEvent(android.view.MotionEvent p8)
    {
        switch ((p8.getAction() & 255)) {
            case 0:
                this.currentStatus = 2;
                this.x_down = p8.getX();
                this.y_down = p8.getY();
                this.savedMatrix.set(this.matrix);
                break;
            case 1:
            case 6:
                this.currentStatus = 4;
                this.view.invalidate();
                break;
            case 2:
                if (this.currentStatus != 1) {
                    if (this.currentStatus != 2) {
                    } else {
                        this.matrix1.set(this.savedMatrix);
                        this.matrix1.postTranslate((p8.getX() - this.x_down), (p8.getY() - this.y_down));
                        this.matrixCheck = this.matrixCheck();
                        if (this.matrixCheck) {
                        } else {
                            this.currentStatus = 2;
                            this.matrix1.getValues(this.values);
                            this.matrix.set(this.matrix1);
                            if (this.isAutoRefresh) {
                            } else {
                                this.view.invalidate();
                            }
                        }
                    }
                } else {
                    this.matrix1.set(this.savedMatrix);
                    this.rotation = (this.rotation(p8) - this.oldRotation);
                    android.view.View v0_23 = this.spacing(p8);
                    if (v0_23 <= this.oldDist) {
                        this.currentStatus = 6;
                    } else {
                        this.currentStatus = 5;
                    }
                    this.matrix1.postScale((v0_23 / this.oldDist), (v0_23 / this.oldDist), this.mid.x, this.mid.y);
                    if (this.canRotate) {
                        this.matrix1.postRotate(this.rotation, this.mid.x, this.mid.y);
                    }
                    this.matrixCheck = this.matrixCheck();
                    if (this.matrixCheck) {
                    } else {
                        this.currentStatus = 1;
                        this.matrix1.getValues(this.values);
                        this.matrix.set(this.matrix1);
                        if (this.isAutoRefresh) {
                        } else {
                            this.view.invalidate();
                        }
                    }
                }
                break;
            case 3:
            case 4:
            default:
                break;
            case 5:
                this.currentStatus = 1;
                this.oldDist = this.spacing(p8);
                this.oldRotation = this.rotation(p8);
                this.savedMatrix.set(this.matrix);
                this.midPoint(this.mid, p8);
                break;
        }
        return;
    }

    public void updatemap(android.graphics.Bitmap p2, boolean p3)
    {
        this.sourceBitmap = p2;
        this.initBitmap();
        if (!p3) {
            this.view.invalidate();
        }
        return;
    }
}
