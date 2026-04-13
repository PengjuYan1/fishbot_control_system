package com.jlboat.phone.util;
public class EulerAngles {
    public double pitch;
    public double roll;
    public double yaw;

    public EulerAngles(double p1, double p3, double p5)
    {
        this.pitch = p1;
        this.yaw = p3;
        this.roll = p5;
        return;
    }

    public EulerAngles(double p18, double p20, double p22, double p24)
    {
        this.roll = ((double) ((float) Math.atan2((((p18 * p20) + (p22 * p24)) * 4611686018427387904), (4607182418800017408 - (((p20 * p20) + (p22 * p22)) * 4611686018427387904)))));
        double v9_5 = (((p18 * p22) - (p24 * p20)) * 4611686018427387904);
        if (Math.abs(v9_5) < 4607182418800017408) {
            this.pitch = ((double) ((float) Math.asin(v9_5)));
        } else {
            this.pitch = Math.copySign(4609752848278749184, v9_5);
        }
        this.yaw = ((double) ((float) Math.atan2((((p18 * p24) + (p20 * p22)) * 4611686018427387904), (4607182418800017408 - (((p22 * p22) + (p24 * p24)) * 4611686018427387904)))));
        return;
    }

    public com.jlboat.phone.util.Quaternion ToQuaternion()
    {
        float v0_3 = ((float) Math.cos((this.yaw * 4602678819172646912)));
        float v1 = ((float) Math.sin((this.yaw * 4602678819172646912)));
        float v4_3 = ((float) Math.cos((this.pitch * 4602678819172646912)));
        float v5_3 = ((float) Math.sin((this.pitch * 4602678819172646912)));
        float v6_3 = ((float) Math.cos((this.roll * 4602678819172646912)));
        float v2_2 = ((float) Math.sin((this.roll * 4602678819172646912)));
        com.jlboat.phone.util.Quaternion v3_1 = new com.jlboat.phone.util.Quaternion();
        v3_1.w = ((double) (((v0_3 * v4_3) * v6_3) + ((v1 * v5_3) * v2_2)));
        v3_1.x = ((double) (((v0_3 * v4_3) * v2_2) - ((v1 * v5_3) * v6_3)));
        v3_1.y = ((double) (((v1 * v4_3) * v2_2) + ((v0_3 * v5_3) * v6_3)));
        v3_1.z = ((double) (((v1 * v4_3) * v6_3) - ((v0_3 * v5_3) * v2_2)));
        return v3_1;
    }
}
