package com.boat.support.slam;
 class ISlamService$Stub$Proxy implements com.boat.support.slam.ISlamService {
    private android.os.IBinder mRemote;

    ISlamService$Stub$Proxy(android.os.IBinder p1)
    {
        this.mRemote = p1;
        return;
    }

    public void addCurrentPosition(String p6, com.boat.support.slam.IResponseListener p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            v0.writeStrongInterface(p7);
            this.mRemote.transact(11, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void addPosition(String p17, double p18, double p20, double p22, double p24, double p26, double p28, com.boat.support.slam.IResponseListener p30)
    {
        android.os.Parcel v1 = android.os.Parcel.obtain();
        android.os.Parcel v2 = android.os.Parcel.obtain();
        try {
            v1.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v1.writeString(p17);
            v1.writeDouble(p18);
            try {
                v1.writeDouble(p20);
                try {
                    v1.writeDouble(p22);
                    try {
                        v1.writeDouble(p24);
                        try {
                            v1.writeDouble(p26);
                            try {
                                v1.writeDouble(p28);
                                v1.writeStrongInterface(p30);
                                this.mRemote.transact(59, v1, v2, 0);
                                v2.readException();
                                v2.recycle();
                                v1.recycle();
                                return;
                            } catch (Throwable v0_0) {
                                v2.recycle();
                                v1.recycle();
                                throw v0_0;
                            }
                        } catch (Throwable v0_0) {
                        }
                        v1.writeDouble(p28);
                        v1.writeStrongInterface(p30);
                        this.mRemote.transact(59, v1, v2, 0);
                        v2.readException();
                        v2.recycle();
                        v1.recycle();
                        return;
                    } catch (Throwable v0_0) {
                    }
                } catch (Throwable v0_0) {
                }
            } catch (Throwable v0_0) {
            }
        } catch (Throwable v0_0) {
        }
    }

    public android.os.IBinder asBinder()
    {
        return this.mRemote;
    }

    public void dance(int p6, com.boat.support.slam.IResponseListener p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeInt(p6);
            v0.writeStrongInterface(p7);
            this.mRemote.transact(57, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public boolean deleteMap(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            int v4 = 0;
            this.mRemote.transact(27, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public void deletePosition(String p6, com.boat.support.slam.IResponseListener p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            v0.writeStrongInterface(p7);
            this.mRemote.transact(12, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void downLoadMapData(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            this.mRemote.transact(60, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void downloadBag(com.boat.support.slam.IResponseListener p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(51, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public com.boat.support.slam.entity.floors.MapList getAllFloor()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(33, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = ((com.boat.support.slam.entity.floors.MapList) com.boat.support.slam.ISlamService$_Parcel.access$000(v1, com.boat.support.slam.entity.floors.MapList.CREATOR));
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public void getBagList(com.boat.support.slam.IResponseListener p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(41, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public int getBattery()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(46, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.readInt();
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public void getCurrentPositionInfo(com.boat.support.slam.IPositionResult p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(14, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public String getInterfaceDescriptor()
    {
        return "com.boat.support.slam.ISlamService";
    }

    public boolean getIsDebug()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(55, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public java.util.List getListMaps()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(35, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.createTypedArrayList(com.boat.support.slam.entity.floors.Maps.CREATOR);
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public com.boat.support.slam.entity.floors.Floors getLocalFloors()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(34, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = ((com.boat.support.slam.entity.floors.Floors) com.boat.support.slam.ISlamService$_Parcel.access$000(v1, com.boat.support.slam.entity.floors.Floors.CREATOR));
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public java.util.List getLocalMapPoints()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(37, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.createTypedArrayList(com.boat.support.slam.entity.floors.Points.CREATOR);
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public com.boat.support.slam.entity.floors.Maps getLocalMaps()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(36, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = ((com.boat.support.slam.entity.floors.Maps) com.boat.support.slam.ISlamService$_Parcel.access$000(v1, com.boat.support.slam.entity.floors.Maps.CREATOR));
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public void getMap(com.boat.support.slam.IResponseListener p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(30, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public int getMapStatus()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(19, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.readInt();
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public void getVersion(com.boat.support.slam.IResponseListener p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(53, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public boolean goCharging(com.boat.support.slam.IResponseListener p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            int v4 = 0;
            this.mRemote.transact(8, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public boolean isCharged()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(42, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public boolean isEmergencyStop()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(43, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public boolean isInGoCharging()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(9, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public boolean isInNavigation()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(7, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public boolean isLocationLoss()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(45, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public boolean isMotorEnabled()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(44, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public boolean isNaviNetWork()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(48, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public boolean isNavigationInited()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            int v4 = 0;
            this.mRemote.transact(47, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public void move(double p6, double p8)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeDouble(p6);
            v0.writeDouble(p8);
            this.mRemote.transact(15, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void moveAlways(double p6, double p8)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeDouble(p6);
            v0.writeDouble(p8);
            this.mRemote.transact(16, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void moveTo(double p6, double p8)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeDouble(p6);
            v0.writeDouble(p8);
            this.mRemote.transact(17, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void naviTargetGoalPlan(long p6, long p8, long p10, int p12, com.boat.support.slam.IResponseListener p13)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeLong(p6);
            v0.writeLong(p8);
            v0.writeLong(p10);
            v0.writeInt(p12);
            v0.writeStrongInterface(p13);
            this.mRemote.transact(5, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public void navigationTo(int p6, String p7, String p8, com.boat.support.slam.IResponseListener p9)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeInt(p6);
            v0.writeString(p7);
            v0.writeString(p8);
            v0.writeStrongInterface(p9);
            this.mRemote.transact(3, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public void navigationTo2(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            this.mRemote.transact(4, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public boolean reNameMap(String p6, String p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            v0.writeString(p7);
            int v4 = 0;
            this.mRemote.transact(28, v0, v1, 0);
            v1.readException();
        } catch (int v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (v1.readInt() != 0) {
            v4 = 1;
        }
        int v2_1 = v4;
        v1.recycle();
        v0.recycle();
        return v2_1;
    }

    public void reachPointStatus(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v3_1;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        v0.writeInt(v3_1);
        this.mRemote.transact(64, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void recordBag(int p6, String p7, java.util.List p8)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeInt(p6);
            v0.writeString(p7);
            v0.writeStringList(p8);
            this.mRemote.transact(40, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void registCallBack(com.boat.support.slam.ISlamCallBack p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(1, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void relocalization(String p6, com.boat.support.slam.IResponseListener p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            v0.writeStrongInterface(p7);
            this.mRemote.transact(56, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void relocation(double p17, double p19, double p21, double p23, double p25, double p27)
    {
        android.os.Parcel v1 = android.os.Parcel.obtain();
        android.os.Parcel v2 = android.os.Parcel.obtain();
        try {
            v1.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v1.writeDouble(p17);
            try {
                v1.writeDouble(p19);
                try {
                    v1.writeDouble(p21);
                    try {
                        v1.writeDouble(p23);
                        try {
                            v1.writeDouble(p25);
                            try {
                                v1.writeDouble(p27);
                                try {
                                    this.mRemote.transact(58, v1, v2, 0);
                                    v2.readException();
                                    v2.recycle();
                                    v1.recycle();
                                    return;
                                } catch (Throwable v0_0) {
                                    v2.recycle();
                                    v1.recycle();
                                    throw v0_0;
                                }
                            } catch (Throwable v0_0) {
                            }
                            this.mRemote.transact(58, v1, v2, 0);
                            v2.readException();
                            v2.recycle();
                            v1.recycle();
                            return;
                        } catch (Throwable v0_0) {
                        }
                    } catch (Throwable v0_0) {
                    }
                } catch (Throwable v0_0) {
                }
            } catch (Throwable v0_0) {
            }
        } catch (Throwable v0_0) {
            double v5 = p19;
        }
    }

    public void requestData(int p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeInt(p6);
            this.mRemote.transact(38, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void requestString(String p6, String p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            v0.writeString(p7);
            this.mRemote.transact(61, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void rotateTo(int p6, double p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeInt(p6);
            v0.writeDouble(p7);
            this.mRemote.transact(18, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void saveEraseMap()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(26, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void saveMap(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            this.mRemote.transact(25, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void setErase(double p6, double p8)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeDouble(p6);
            v0.writeDouble(p8);
            this.mRemote.transact(23, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void setEraseMode(int p6, com.boat.support.slam.IResponseListener p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeInt(p6);
            v0.writeStrongInterface(p7);
            this.mRemote.transact(22, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void setInGoCharging(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v3_1;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        v0.writeInt(v3_1);
        this.mRemote.transact(10, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void setIsDebug(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v3_1;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        v0.writeInt(v3_1);
        this.mRemote.transact(54, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void setMapReBuild()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(21, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void setMapStatusBuild()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(20, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void setOutofChange()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(62, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void setShapArea(com.boat.support.slam.entity.floors.ShapeAreas p6, com.boat.support.slam.IResponseListener p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            com.boat.support.slam.ISlamService$_Parcel.access$100(v0, p6, 0);
            v0.writeStrongInterface(p7);
            this.mRemote.transact(29, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void setWarnLedStatus(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v3_1;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        v0.writeInt(v3_1);
        this.mRemote.transact(63, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void setWifiConfig(String p6, String p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            v0.writeString(p7);
            this.mRemote.transact(31, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public String startRecordBag(com.boat.support.slam.IResponseListener p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(49, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.readString();
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public void stopNavigation()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(6, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public String stopRecordBag(com.boat.support.slam.IResponseListener p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(50, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.readString();
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public void stopRequestData(int p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeInt(p6);
            this.mRemote.transact(39, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void unregistCallBack(com.boat.support.slam.ISlamCallBack p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(2, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void updateHareware(com.boat.support.slam.IResponseListener p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeStrongInterface(p6);
            this.mRemote.transact(52, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void updateMap(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            this.mRemote.transact(24, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void updatePositionName(String p6, String p7, com.boat.support.slam.IResponseListener p8)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            v0.writeString(p6);
            v0.writeString(p7);
            v0.writeStrongInterface(p8);
            this.mRemote.transact(13, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void updateStatus()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamService");
            this.mRemote.transact(32, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }
}
