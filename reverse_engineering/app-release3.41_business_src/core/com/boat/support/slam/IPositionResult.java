package com.boat.support.slam;
public interface IPositionResult implements android.os.IInterface {
    public static final String DESCRIPTOR = "com.boat.support.slam.IPositionResult";

    public abstract void onPosition();
}
