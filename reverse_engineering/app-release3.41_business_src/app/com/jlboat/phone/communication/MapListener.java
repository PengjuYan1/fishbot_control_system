package com.jlboat.phone.communication;
public class MapListener {
    private static final int COLOR_UNKNOWN = 8947848;
    String TAG;
    private android.graphics.Bitmap bitmapBack;
    private byte[] channelBuffer;
    private int[] colorMap;
    private int height;
    private int index;
    boolean isUpdate;
    private com.boat.jrosbridge.Topic mapSubscriber;
    com.jlboat.phone.communication.MapListener$onDataCallBack onCallBack;
    private double originX;
    private double originY;
    private double originZ;
    private int[] pixelBuffer;
    private int[] pixels;
    private float resolution;
    private int width;

    public MapListener()
    {
        this.TAG = "MapListener";
        this.isUpdate = 0;
        this.bitmapBack = android.graphics.Bitmap.createBitmap(5000, 5000, android.graphics.Bitmap$Config.RGB_565);
        android.util.Log.d(this.TAG, new StringBuilder().append("MapListener: getAllocationByteCount ").append(this.bitmapBack.getAllocationByteCount()).toString());
        android.util.Log.d(this.TAG, new StringBuilder().append("MapListener: getByteCount ").append(this.bitmapBack.getByteCount()).toString());
        com.jlboat.phone.util.ROSColor v0_5 = new com.jlboat.phone.util.ROSColor(1065353216, 1065353216, 1065353216, 1065353216);
        int v3_1 = new int[101];
        this.colorMap = v3_1;
        int v3_2 = 0;
        while (v3_2 < 101) {
            this.colorMap[v3_2] = v0_5.interpolate(new com.jlboat.phone.util.ROSColor(0, 0, 0, 1065353216), (((float) v3_2) / 1120534528)).toInt();
            v3_2++;
        }
        return;
    }

    static synthetic void access$000(com.jlboat.phone.communication.MapListener p0, com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p1)
    {
        p0.updateMap(p1);
        return;
    }

    private void updateMap(com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p11)
    {
        this.resolution = p11.getInfo().getResolution();
        this.width = p11.getInfo().getWidth();
        this.height = p11.getInfo().getHeight();
        this.originX = p11.getInfo().getOrigin().getPosition().getX();
        this.originY = p11.getInfo().getOrigin().getPosition().getY();
        this.originZ = p11.getInfo().getOrigin().getPosition().getZ();
        this.channelBuffer = p11.getData();
        Exception v0_21 = new int[(this.width * this.height)];
        this.pixelBuffer = v0_21;
        this.index = 0;
        com.jlboat.phone.communication.MapListener$onDataCallBack v1_3 = this.channelBuffer;
        int v2_2 = v1_3.length;
        int v3_2 = 0;
        while (v3_2 < v2_2) {
            int[] v4_7 = v1_3[v3_2];
            if (v4_7 != -1) {
                this.pixelBuffer[this.index] = this.colorMap[v4_7];
            } else {
                this.pixelBuffer[this.index] = -7829368;
            }
            this.index = (this.index + 1);
            v3_2++;
        }
        com.jlboat.phone.communication.MapListener$onDataCallBack v1_6 = new int[(this.width * this.height)];
        this.pixels = v1_6;
        com.jlboat.phone.communication.MapListener$onDataCallBack v1_1 = 0;
        int v2_1 = 0;
        while (v1_1 < this.height) {
            int v3_1 = 0;
            while (v3_1 < this.width) {
                if (v2_1 >= this.pixelBuffer.length) {
                    this.pixels[((((this.height - 1) - v1_1) * this.width) + v3_1)] = 0;
                } else {
                    this.pixels[((((this.height - 1) - v1_1) * this.width) + v3_1)] = this.pixelBuffer[v2_1];
                }
                v3_1++;
                v2_1++;
            }
            v1_1++;
        }
        android.util.Log.d(this.TAG, new StringBuilder().append("updateMap: \u6536\u5230\u5e95\u76d8\u5730\u56fe\u5927\u5c0f ").append(this.pixels.length).append(" , \u5bbd = ").append(this.width).append(" , \u9ad8 = ").append(this.height).toString());
        try {
            this.bitmapBack.setWidth(this.width);
            this.bitmapBack.setHeight(this.height);
            this.bitmapBack.setPixels(this.pixels, 0, this.width, 0, 0, this.width, this.height);
        } catch (Exception v0_2) {
            v0_2.printStackTrace();
            return;
        }
        if (this.onCallBack != null) {
            this.onCallBack.onMapDataListener(1001, this.bitmapBack, this.originX, this.originY, this.resolution);
        }
        return;
    }

    public void onStart()
    {
        this.mapSubscriber = new com.boat.jrosbridge.Topic("/map", com.boat.jrosbridge.message.nav_msgs.OccupancyGrid, com.jlboat.phone.application.BoatSlamApplication.client);
        this.mapSubscriber.subscribe(new com.jlboat.phone.communication.MapListener$1(this));
        return;
    }

    public void onStop()
    {
        if (this.mapSubscriber != null) {
            this.mapSubscriber.unsubscribe();
        }
        return;
    }

    public void recycle()
    {
        this.bitmapBack.recycle();
        return;
    }

    public void setOnCallBack(com.jlboat.phone.communication.MapListener$onDataCallBack p1)
    {
        this.onCallBack = p1;
        return;
    }
}
