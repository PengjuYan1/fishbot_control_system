package com.jlboat.phone.util;
public class Utils {

    public Utils()
    {
        return;
    }

    public static String bytesToHex(byte[] p4)
    {
        StringBuilder v0_1 = new StringBuilder();
        int v1_0 = 0;
        while (v1_0 < p4.length) {
            int v2_2 = (p4[v1_0] & 255);
            if (v2_2 < 16) {
                v0_1.append("0");
            }
            v0_1.append(Integer.toHexString(v2_2).toUpperCase());
            v1_0++;
        }
        return v0_1.toString();
    }

    public static float cmToPx(android.content.Context p3, float p4)
    {
        return android.util.TypedValue.applyDimension(5, (1092616192 * p4), p3.getResources().getDisplayMetrics());
    }

    public static int degreesToNumber(String p2)
    {
        return Integer.parseInt(p2.substring(0, (p2.length() - 1)));
    }

    public static boolean doesObjectContainField(Object p7, String p8)
    {
        int v1_1 = p7.getClass().getFields();
        int v4 = 0;
        while (v4 < v1_1.length) {
            if (!v1_1[v4].getName().equals(p8)) {
                v4++;
            } else {
                return 1;
            }
        }
        return 0;
    }

    public static float dpToPx(android.content.Context p2, float p3)
    {
        return android.util.TypedValue.applyDimension(1, p3, p2.getResources().getDisplayMetrics());
    }

    public static String getCTFileName(java.util.Date p2)
    {
        return new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(p2);
    }

    public static String getCurrentTime(java.util.Date p2)
    {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(p2);
    }

    public static String getIPAddress(boolean p9)
    {
        try {
            int v1_2 = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces()).iterator();
        } catch (String v0) {
            return "";
        }
        while (v1_2.hasNext()) {
            String v4_0 = java.util.Collections.list(((java.net.NetworkInterface) v1_2.next()).getInetAddresses()).iterator();
            while (v4_0.hasNext()) {
                java.net.InetAddress v5_2 = ((java.net.InetAddress) v4_0.next());
                if (!v5_2.isLoopbackAddress()) {
                    int v7_2;
                    String v6_1 = v5_2.getHostAddress();
                    if (v6_1.indexOf(58) >= 0) {
                        v7_2 = 0;
                    } else {
                        v7_2 = 1;
                    }
                    if (!p9) {
                        if (v7_2 == 0) {
                            String v4_2;
                            int v1_1 = v6_1.indexOf(37);
                            if (v1_1 >= 0) {
                                v4_2 = v6_1.substring(0, v1_1).toUpperCase();
                            } else {
                                v4_2 = v6_1.toUpperCase();
                            }
                            return v4_2;
                        }
                    } else {
                        if (v7_2 != 0) {
                            return v6_1;
                        }
                    }
                }
            }
        }
        return "";
    }

    public static java.util.ArrayList getIPAddressList(boolean p11)
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        try {
            java.util.Iterator v2 = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces()).iterator();
        } catch (Exception v1) {
            return v0_1;
        }
        while (v2.hasNext()) {
            java.util.Iterator v5 = java.util.Collections.list(((java.net.NetworkInterface) v2.next()).getInetAddresses()).iterator();
            while (v5.hasNext()) {
                java.net.InetAddress v6_2 = ((java.net.InetAddress) v5.next());
                if (!v6_2.isLoopbackAddress()) {
                    int v8_2;
                    String v7_1 = v6_2.getHostAddress();
                    if (v7_1.indexOf(58) >= 0) {
                        v8_2 = 0;
                    } else {
                        v8_2 = 1;
                    }
                    if (!p11) {
                        if (v8_2 == 0) {
                            String v9_2;
                            int v10_1 = v7_1.indexOf(37);
                            if (v10_1 >= 0) {
                                v9_2 = v7_1.substring(0, v10_1).toUpperCase();
                            } else {
                                v9_2 = v7_1.toUpperCase();
                            }
                            v0_1.add(v9_2);
                        }
                    } else {
                        if (v8_2 != 0) {
                            v0_1.add(v7_1);
                        }
                    }
                }
            }
        }
        return v0_1;
    }

    public static String getMACAddress(String p12)
    {
        try {
            byte[] v2_1 = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces()).iterator();
        } catch (Exception v1) {
            return "";
        }
        while (v2_1.hasNext()) {
            java.net.NetworkInterface v3_1 = ((java.net.NetworkInterface) v2_1.next());
            if ((p12 == null) || (v3_1.getName().equalsIgnoreCase(p12))) {
                byte[] v2_0 = v3_1.getHardwareAddress();
                if (v2_0 != null) {
                    StringBuilder v4_3 = new StringBuilder();
                    int v5_0 = v2_0.length;
                    int v7 = 0;
                    while (v7 < v5_0) {
                        String v8_1 = new Object[1];
                        v8_1[0] = Byte.valueOf(v2_0[v7]);
                        v4_3.append(String.format("%02X:", v8_1));
                        v7++;
                    }
                    if (v4_3.length() > 0) {
                        v4_3.deleteCharAt((v4_3.length() - 1));
                    }
                    return v4_3.toString();
                } else {
                    return "";
                }
            } else {
            }
        }
        return "";
    }

    public static int getScreenHeight(android.content.Context p1)
    {
        return p1.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(android.content.Context p1)
    {
        return p1.getResources().getDisplayMetrics().widthPixels;
    }

    public static String getStringByName(android.content.Context p3, String p4)
    {
        return p3.getResources().getString(p3.getResources().getIdentifier(p4, "string", p3.getPackageName()));
    }

    public static byte[] getUTF8Bytes(String p2)
    {
        try {
            return p2.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        } catch (Exception v0) {
            return 0;
        }
    }

    public static String getWifiSSID(android.net.wifi.WifiManager p4)
    {
        if (p4 != null) {
            android.net.wifi.WifiInfo v1 = p4.getConnectionInfo();
            if (v1.getSupplicantState() != android.net.wifi.SupplicantState.COMPLETED) {
                return 0;
            } else {
                return v1.getSSID();
            }
        } else {
            return 0;
        }
    }

    public static boolean hasRosWifi()
    {
        try {
            String v1_0 = java.net.NetworkInterface.getNetworkInterfaces();
        } catch (String v1) {
            com.jlboat.phone.application.BoatSlamApplication.displayName = "";
            com.jlboat.phone.application.BoatSlamApplication.hostAddress = "";
            return 0;
        }
        if (v1_0 == null) {
            return 0;
        }
        while (v1_0.hasMoreElements()) {
            java.net.NetworkInterface v2_2 = ((java.net.NetworkInterface) v1_0.nextElement());
            if (v2_2.isUp()) {
                java.util.Enumeration v3_1 = v2_2.getInetAddresses();
                while (v3_1.hasMoreElements()) {
                    java.net.InetAddress v4_2 = ((java.net.InetAddress) v3_1.nextElement());
                    if (((v4_2 instanceof java.net.Inet4Address)) && ((!v4_2.isLoopbackAddress()) && (v4_2.getHostAddress().contains(com.jlboat.phone.application.BoatSlamApplication.route_ip)))) {
                        com.jlboat.phone.application.BoatSlamApplication.displayName = v2_2.getDisplayName();
                        com.jlboat.phone.application.BoatSlamApplication.hostAddress = v4_2.getHostAddress();
                        return 1;
                    }
                }
            } else {
            }
        }
        com.jlboat.phone.application.BoatSlamApplication.displayName = "";
        com.jlboat.phone.application.BoatSlamApplication.hostAddress = "";
        return 0;
    }

    public static void hideSoftKeyboard(android.view.View p3)
    {
        android.view.inputmethod.InputMethodManager v0_2 = ((android.view.inputmethod.InputMethodManager) p3.getContext().getSystemService("input_method"));
        if (v0_2 != null) {
            v0_2.hideSoftInputFromWindow(p3.getWindowToken(), 0);
        }
        return;
    }

    public static boolean isHostAvailable(String p4, int p5, int p6)
    {
        int v0_0 = "Connection";
        try {
            java.io.IOException v1_1 = new java.net.Socket();
            try {
                v1_1.connect(new java.net.InetSocketAddress(java.net.InetAddress.getByName(p4), p5), p6);
            } catch (Throwable v2_5) {
                try {
                    v1_1.close();
                } catch (Throwable v3_0) {
                    v2_5.addSuppressed(v3_0);
                }
                throw v2_5;
            }
            v1_1.close();
            v0_0 = 1;
            return 1;
        } catch (java.io.IOException v1) {
            android.util.Log.e(v0_0, "Failed do to unavailable network.");
            return 0;
        } catch (java.io.IOException v1) {
            android.util.Log.e(v0_0, "Failed do to reach host in time.");
        } catch (java.io.IOException v1) {
            android.util.Log.e(v0_0, "Unknown host.");
        } catch (java.io.IOException v1) {
            android.util.Log.e(v0_0, "IO Exception.");
            return 0;
        }
    }

    public static boolean isPing(String p4)
    {
        int v0 = 0;
        try {
            if (Runtime.getRuntime().exec(new StringBuilder().append("ping -c 3 -w 5 ").append(p4).toString()).waitFor() != 0) {
                v0 = 0;
            } else {
                v0 = 1;
            }
        } catch (InterruptedException v1_1) {
            v1_1.printStackTrace();
        } catch (InterruptedException v1_1) {
        }
        return v0;
    }

    public static boolean isServiceRunning(android.content.Context p6, String p7, int p8)
    {
        int v0 = 0;
        if ((!"".equals(p7)) && (p7 != null)) {
            Object vtmp2 = p6.getSystemService("activity");
            java.util.ArrayList v2_2 = ((java.util.ArrayList) ((android.app.ActivityManager) vtmp2).getRunningServices(30));
            int v3 = 0;
            while (v3 < v2_2.size()) {
                if (((android.app.ActivityManager$RunningServiceInfo) v2_2.get(v3)).service.getClassName().toString().equals(p7)) {
                    if (p8 != 1) {
                        return 1;
                    } else {
                        if (v0 != 0) {
                            p6.stopService(new android.content.Intent(p6, ((android.app.ActivityManager$RunningServiceInfo) v2_2.get(v3)).service.getClass()));
                        } else {
                            v0 = 1;
                        }
                    }
                }
                v3++;
            }
            return v0;
        } else {
            return 0;
        }
    }

    public static boolean isVisible(android.view.View p5)
    {
        if (p5 != null) {
            if (p5.isShown()) {
                android.graphics.Rect v1_2 = new android.graphics.Rect();
                p5.getGlobalVisibleRect(v1_2);
                return v1_2.intersect(new android.graphics.Rect(0, 0, android.content.res.Resources.getSystem().getDisplayMetrics().widthPixels, android.content.res.Resources.getSystem().getDisplayMetrics().heightPixels));
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static String loadFileAsString(String p10)
    {
        java.io.BufferedInputStream v1_1 = new java.io.BufferedInputStream(new java.io.FileInputStream(p10), 1024);
        try {
            Throwable v2_4 = new java.io.ByteArrayOutputStream(1024);
            Exception v3_1 = new byte[1024];
            int v4 = 0;
            int v5 = 0;
        } catch (Throwable v2_2) {
            try {
                v1_1.close();
            } catch (Exception v3) {
            }
            throw v2_2;
        }
        while(true) {
            int v6_0 = v1_1.read(v3_1);
            int v7 = v6_0;
            if (v6_0 == -1) {
                break;
            }
            if ((v5 != 0) || ((v3_1[0] != -17) || ((v3_1[1] != -69) || (v3_1[2] != -65)))) {
                v2_4.write(v3_1, 0, v7);
            } else {
                v4 = 1;
                v2_4.write(v3_1, 3, (v7 - 3));
            }
            v5 += v7;
        }
        int v6_2;
        if (v4 == 0) {
            v6_2 = new String(v2_4.toByteArray());
        } else {
            v6_2 = new String(v2_4.toByteArray(), java.nio.charset.StandardCharsets.UTF_8);
        }
        try {
            v1_1.close();
        } catch (int v8) {
        }
        return v6_2;
    }

    public static String numberToDegrees(int p2)
    {
        return new StringBuilder().append(new Integer(p2).toString()).append("\u00b0").toString();
    }

    public static float pxToCm(android.content.Context p3, float p4)
    {
        return (p4 / android.util.TypedValue.applyDimension(5, 1092616192, p3.getResources().getDisplayMetrics()));
    }

    public static com.jlboat.phone.view.loading.MyLoading showLoading(android.content.Context p4, int p5, String p6)
    {
        com.jlboat.phone.view.loading.MyLoading v0_1 = new com.jlboat.phone.view.loading.MyLoading(p4, p6);
        v0_1.showAtLocation(android.view.LayoutInflater.from(p4).inflate(p5, 0), 17, 0, 0);
        return v0_1;
    }

    public static void toast(String p2)
    {
        android.widget.Toast.makeText(com.jlboat.phone.application.BoatSlamApplication.mApplication, p2, 0).show();
        return;
    }
}
