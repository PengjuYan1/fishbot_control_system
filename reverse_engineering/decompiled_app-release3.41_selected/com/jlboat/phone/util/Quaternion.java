package com.jlboat.phone.util;
public class Quaternion {
    public double w;
    public double x;
    public double y;
    public double z;

    public Quaternion()
    {
        return;
    }

    public Quaternion(double p1, double p3, double p5, double p7)
    {
        this.w = p1;
        this.x = p3;
        this.y = p5;
        this.z = p7;
        return;
    }

    static com.jlboat.phone.util.Quaternion Multiplication(com.jlboat.phone.util.Quaternion p7, com.jlboat.phone.util.Quaternion p8)
    {
        com.jlboat.phone.util.Quaternion v0_1 = new com.jlboat.phone.util.Quaternion();
        v0_1.w = ((((p7.w * p8.w) - (p7.x * p8.x)) - (p7.y * p8.y)) - (p7.z * p8.z));
        v0_1.x = ((((p7.w * p8.x) + (p7.x * p8.w)) + (p7.y * p8.z)) - (p7.z * p8.y));
        v0_1.y = ((((p7.w * p8.y) + (p7.y * p8.w)) + (p7.z * p8.x)) - (p7.x * p8.z));
        v0_1.z = ((((p7.w * p8.z) + (p7.z * p8.w)) + (p7.x * p8.y)) - (p7.y * p8.x));
        return v0_1;
    }

    static void VectorRotation(double[] p13, com.jlboat.phone.util.Quaternion p14)
    {
        com.jlboat.phone.util.Quaternion v0_0 = com.jlboat.phone.util.Quaternion.Multiplication(com.jlboat.phone.util.Quaternion.Multiplication(p14, new com.jlboat.phone.util.Quaternion(0, p13[0], p13[1], p13[2])), p14.Inverse());
        p13[0] = v0_0.x;
        p13[1] = v0_0.y;
        p13[2] = v0_0.z;
        return;
    }

    public com.jlboat.phone.util.Quaternion Inverse()
    {
        this.x = (this.x * -4616189618054758400);
        this.y = (this.y * -4616189618054758400);
        this.z = (this.z * -4616189618054758400);
        return this;
    }

    public com.jlboat.phone.util.EulerAngles ToEulerAngles()
    {
        com.jlboat.phone.util.EulerAngles v9 = new com.jlboat.phone.util.EulerAngles;
        v9(this.w, this.x, this.y, this.z);
        return v9;
    }
}
