package com.boat.utils;
public class ReportExceptionInformationUtils {
    private static com.jlboat.phone.view.Err err;

    public ReportExceptionInformationUtils()
    {
        return;
    }

    public static void deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication p2, int p3)
    {
        int v0_0 = 0;
        while (v0_0 < com.jlboat.phone.application.BoatSlamApplication.errList.size()) {
            if (((com.jlboat.phone.view.Err) com.jlboat.phone.application.BoatSlamApplication.errList.get(v0_0)).getFlag() != p3) {
                v0_0++;
            } else {
                com.jlboat.phone.application.BoatSlamApplication.errList.remove(v0_0);
                break;
            }
        }
        int v0_2 = new android.content.Intent();
        v0_2.setAction("ERRMSG_UPDATE");
        p2.sendBroadcast(v0_2);
        return;
    }

    public static void showWarnMsg(android.content.Context p2, int p3, int p4, String p5)
    {
        android.util.Log.e("showWarn", new StringBuilder().append("msg:").append(p5).toString());
        if ((p3 % 2) != 0) {
            com.boat.utils.ReportExceptionInformationUtils.err = new com.jlboat.phone.view.Err();
            com.boat.utils.ReportExceptionInformationUtils.err.setMsg(p5);
            com.boat.utils.ReportExceptionInformationUtils.err.setDa(new java.util.Date());
            com.boat.utils.ReportExceptionInformationUtils.err.setType(p3);
            com.boat.utils.ReportExceptionInformationUtils.err.setFlag(p4);
            com.jlboat.phone.application.BoatSlamApplication.errList.add(com.boat.utils.ReportExceptionInformationUtils.err);
            android.content.Intent v0_11 = new android.content.Intent();
            v0_11.setAction("ERRMSG_UPDATE");
            p2.sendBroadcast(v0_11);
        }
        return;
    }

    public static void upload(android.content.Context p0, int p1, String p2)
    {
        return;
    }

    public static void uploadCharge(android.content.Context p0, int p1, String p2)
    {
        return;
    }

    public static void uploadPower(android.content.Context p0, boolean p1, int p2, String p3)
    {
        return;
    }

    public static void uploadWarn(android.content.Context p2, int p3, String p4)
    {
        android.util.Log.e("uploadWarn", new StringBuilder().append("msg:").append(p4).toString());
        return;
    }
}
