package com.jlboat.phone.service;
public class ErrorMsgService extends android.app.Service {
    private static final int CHECK_CHARGING = 102;
    private static final int DISCONNECT = 103;
    private static final int DISCONNECT2 = 104;
    private static final int PING = 101;
    private final String TAG;
    private int count;
    private boolean hasConnected;
    private boolean isClosing;
    private boolean isConnect;
    boolean isrestar;
    android.content.Context mContext;
    private android.os.Handler mHandler;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private com.jlboat.phone.service.SpiritTopicListenerUtils spiritTopicListenerUtils;

    public ErrorMsgService()
    {
        this.isrestar = 0;
        this.TAG = "ErrorMsgService";
        this.count = 0;
        this.mHandler = new com.jlboat.phone.service.ErrorMsgService$1(this);
        return;
    }

    private void aboutRobot()
    {
        this.spiritServiceClient.getNaviInfoService(new com.jlboat.phone.service.ErrorMsgService$2(this));
        return;
    }

    static synthetic android.os.Handler access$000(com.jlboat.phone.service.ErrorMsgService p1)
    {
        return p1.mHandler;
    }

    static synthetic boolean access$100(com.jlboat.phone.service.ErrorMsgService p1)
    {
        return p1.isConnect;
    }

    static synthetic int access$200(com.jlboat.phone.service.ErrorMsgService p1)
    {
        return p1.count;
    }

    private void getWifiSSID()
    {
        String v2 = ((android.net.wifi.WifiManager) this.getApplication().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID();
        com.jlboat.phone.application.BoatSlamApplication.ssid = v2.substring(1, (v2.length() - 1));
        android.util.Log.d("ErrorMsgService", new StringBuilder().append("getWifiSSID: ").append(com.jlboat.phone.application.BoatSlamApplication.ssid).toString());
        android.content.Intent v3_9 = new android.content.Intent();
        v3_9.setAction("ssid");
        v3_9.putExtra("value", com.jlboat.phone.application.BoatSlamApplication.ssid);
        this.sendBroadcast(v3_9);
        return;
    }

    private void startRos()
    {
        boolean[] v0_1 = new boolean[1];
        v0_1[0] = 0;
        new Thread(new com.jlboat.phone.service.ErrorMsgService$3(this, v0_1)).start();
        return;
    }

    private void stopRos()
    {
        if (com.jlboat.phone.application.BoatSlamApplication.client.isConnect()) {
            com.jlboat.phone.application.BoatSlamApplication.client.disconnect();
        }
        return;
    }

    public void initService()
    {
        this.aboutRobot();
        return;
    }

    public void initTopic()
    {
        if (this.spiritTopicListenerUtils == null) {
            this.spiritTopicListenerUtils = new com.jlboat.phone.service.SpiritTopicListenerUtils(this.spiritTopicListener);
        }
        return;
    }

    public android.os.IBinder onBind(android.content.Intent p2)
    {
        return 0;
    }

    public void onCreate()
    {
        super.onCreate();
        this.mContext = this;
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.startRos();
        this.getWifiSSID();
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        android.util.Log.e("ErrorMsgService", "onDestroy: \u670d\u52a1\u505c\u6b62");
        if (this.mHandler.hasMessages(102)) {
            this.mHandler.removeMessages(102);
        }
        if (this.mHandler.hasMessages(101)) {
            this.mHandler.removeMessages(101);
        }
        this.stopRos();
        return;
    }

    public int onStartCommand(android.content.Intent p7, int p8, int p9)
    {
        if ((p7 == null) || ((p7.getAction() == null) || (!p7.getAction().equals("stop")))) {
            int v0_1 = new android.support.v4.app.NotificationCompat$Builder(this.getApplicationContext()).setAutoCancel(1);
            v0_1.setContentText("\u8fde\u63a5\u4e2d");
            v0_1.setContentTitle("\u7cbe\u7075");
            v0_1.setSmallIcon(2131427360);
            v0_1.setWhen(System.currentTimeMillis());
            v0_1.setPriority(0);
            v0_1.setOngoing(0);
            v0_1.setDefaults(-1);
            if (android.os.Build$VERSION.SDK_INT >= 26) {
                int v1_12 = ((android.app.NotificationManager) this.getSystemService("notification"));
                android.app.Notification v2_6 = new StringBuilder().append("channelId").append(System.currentTimeMillis()).toString();
                v1_12.createNotificationChannel(new android.app.NotificationChannel(v2_6, this.getResources().getString(2131492908), 4));
                v0_1.setChannelId(v2_6);
            }
            v0_1.setContentIntent(0);
            this.startForeground(222, v0_1.build());
            return super.onStartCommand(p7, p8, p9);
        } else {
            this.stopForeground(1);
            this.stopSelf();
            return super.onStartCommand(p7, p8, p9);
        }
    }
}
