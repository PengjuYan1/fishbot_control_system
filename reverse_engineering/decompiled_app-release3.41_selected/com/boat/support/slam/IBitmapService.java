package com.boat.support.slam;
public interface IBitmapService implements android.os.IInterface {
    public static final String DESCRIPTOR = "com.boat.support.slam.IBitmapService";

    public abstract android.graphics.Bitmap getIntentBitmap();

    public abstract double getOriginX();

    public abstract double getOriginY();

    public abstract float getResolution();
}
