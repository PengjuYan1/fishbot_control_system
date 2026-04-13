package com.boat.ros.geometry;
public class Vector3 {
    private static final com.boat.ros.geometry.Vector3 X_AXIS;
    private static final com.boat.ros.geometry.Vector3 Y_AXIS;
    private static final com.boat.ros.geometry.Vector3 ZERO;
    private static final com.boat.ros.geometry.Vector3 Z_AXIS;
    private final double x;
    private final double y;
    private final double z;

    static Vector3()
    {
        com.boat.ros.geometry.Vector3 v7 = new com.boat.ros.geometry.Vector3;
        v7(0, 0, 0);
        com.boat.ros.geometry.Vector3.ZERO = v7;
        com.boat.ros.geometry.Vector3 v0_3 = new com.boat.ros.geometry.Vector3;
        v0_3(4607182418800017408, 0, 0);
        com.boat.ros.geometry.Vector3.X_AXIS = v0_3;
        com.boat.ros.geometry.Vector3 v0_0 = new com.boat.ros.geometry.Vector3;
        v0_0(0, 4607182418800017408, 0);
        com.boat.ros.geometry.Vector3.Y_AXIS = v0_0;
        com.boat.ros.geometry.Vector3 v0_1 = new com.boat.ros.geometry.Vector3;
        v0_1(0, 0, 4607182418800017408);
        com.boat.ros.geometry.Vector3.Z_AXIS = v0_1;
        return;
    }

    public Vector3(double p1, double p3, double p5)
    {
        this.x = p1;
        this.y = p3;
        this.z = p5;
        return;
    }

    public static com.boat.ros.geometry.Vector3 fromPointMessage(com.boat.jrosbridge.message.geometry_msgs.Point p8)
    {
        com.boat.ros.geometry.Vector3 v7 = new com.boat.ros.geometry.Vector3;
        v7(p8.getX(), p8.getY(), p8.getZ());
        return v7;
    }

    public static com.boat.ros.geometry.Vector3 fromVector3Message(com.boat.jrosbridge.message.geometry_msgs.Vector3 p8)
    {
        com.boat.ros.geometry.Vector3 v7 = new com.boat.ros.geometry.Vector3;
        v7(p8.getX(), p8.getY(), p8.getZ());
        return v7;
    }

    public static com.boat.ros.geometry.Vector3 xAxis()
    {
        return com.boat.ros.geometry.Vector3.X_AXIS;
    }

    public static com.boat.ros.geometry.Vector3 yAxis()
    {
        return com.boat.ros.geometry.Vector3.Y_AXIS;
    }

    public static com.boat.ros.geometry.Vector3 zAxis()
    {
        return com.boat.ros.geometry.Vector3.Z_AXIS;
    }

    public static com.boat.ros.geometry.Vector3 zero()
    {
        return com.boat.ros.geometry.Vector3.ZERO;
    }

    public com.boat.ros.geometry.Vector3 add(com.boat.ros.geometry.Vector3 p11)
    {
        com.boat.ros.geometry.Vector3 v7 = new com.boat.ros.geometry.Vector3;
        v7((this.x + p11.x), (this.y + p11.y), (this.z + p11.z));
        return v7;
    }

    public boolean almostEquals(com.boat.ros.geometry.Vector3 p8, double p9)
    {
        java.util.LinkedList v0_1 = new java.util.LinkedList();
        v0_1.add(Double.valueOf((this.x - p8.x)));
        v0_1.add(Double.valueOf((this.y - p8.y)));
        v0_1.add(Double.valueOf((this.z - p8.z)));
        java.util.Iterator v1_6 = v0_1.iterator();
        while (v1_6.hasNext()) {
            if (Math.abs(((Double) v1_6.next()).doubleValue()) > p9) {
                return 0;
            }
        }
        return 1;
    }

    public double dotProduct(com.boat.ros.geometry.Vector3 p7)
    {
        return (((this.x * p7.x) + (this.y * p7.y)) + (this.z * p7.z));
    }

    public boolean equals(Object p21)
    {
        if (this != p21) {
            if (p21 != null) {
                if (this.getClass() == p21.getClass()) {
                    double v5_1;
                    int v7_0 = 0;
                    if (this.x != 0) {
                        v5_1 = this.x;
                    } else {
                        v5_1 = 0;
                    }
                    double v9_2;
                    if (this.y != 0) {
                        v9_2 = this.y;
                    } else {
                        v9_2 = 0;
                    }
                    double v11_2;
                    if (this.z != 0) {
                        v11_2 = this.z;
                    } else {
                        v11_2 = 0;
                    }
                    double v13_2;
                    if (((com.boat.ros.geometry.Vector3) p21).x != 0) {
                        v13_2 = ((com.boat.ros.geometry.Vector3) p21).x;
                    } else {
                        v13_2 = 0;
                    }
                    double v2_2;
                    if (((com.boat.ros.geometry.Vector3) p21).y != 0) {
                        v2_2 = ((com.boat.ros.geometry.Vector3) p21).y;
                    } else {
                        v2_2 = 0;
                    }
                    if (((com.boat.ros.geometry.Vector3) p21).z != 0) {
                        v7_0 = ((com.boat.ros.geometry.Vector3) p21).z;
                    }
                    if (Double.doubleToLongBits(v5_1) == Double.doubleToLongBits(v13_2)) {
                        if (Double.doubleToLongBits(v9_2) == Double.doubleToLongBits(v2_2)) {
                            int v15_1;
                            if (Double.doubleToLongBits(v11_2) != Double.doubleToLongBits(v7_0)) {
                                v15_1 = 0;
                            } else {
                                v15_1 = 1;
                            }
                            return v15_1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public double getMagnitude()
    {
        return Math.sqrt(this.getMagnitudeSquared());
    }

    public double getMagnitudeSquared()
    {
        return (((this.x * this.x) + (this.y * this.y)) + (this.z * this.z));
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double getZ()
    {
        return this.z;
    }

    public com.boat.ros.geometry.Vector3 invert()
    {
        com.boat.ros.geometry.Vector3 v7 = new com.boat.ros.geometry.Vector3;
        v7((- this.x), (- this.y), (- this.z));
        return v7;
    }

    public com.boat.ros.geometry.Vector3 normalize()
    {
        com.boat.ros.geometry.Vector3 v7 = new com.boat.ros.geometry.Vector3;
        v7((this.x / this.getMagnitude()), (this.y / this.getMagnitude()), (this.z / this.getMagnitude()));
        return v7;
    }

    public com.boat.ros.geometry.Vector3 scale(double p9)
    {
        com.boat.ros.geometry.Vector3 v7 = new com.boat.ros.geometry.Vector3;
        v7((this.x * p9), (this.y * p9), (this.z * p9));
        return v7;
    }

    public com.boat.ros.geometry.Vector3 subtract(com.boat.ros.geometry.Vector3 p11)
    {
        com.boat.ros.geometry.Vector3 v7 = new com.boat.ros.geometry.Vector3;
        v7((this.x - p11.x), (this.y - p11.y), (this.z - p11.z));
        return v7;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point toPointMessage(com.boat.jrosbridge.message.geometry_msgs.Point p3)
    {
        p3.setX(this.x);
        p3.setY(this.y);
        p3.setZ(this.z);
        return p3;
    }

    public String toString()
    {
        String v0_5 = Double.valueOf(this.x);
        Double v1_1 = Double.valueOf(this.y);
        Double v2_1 = Double.valueOf(this.z);
        Object[] v3_0 = new Object[3];
        v3_0[0] = v0_5;
        v3_0[1] = v1_1;
        v3_0[2] = v2_1;
        return String.format("Vector3<x: %.4f, y: %.4f, z: %.4f>", v3_0);
    }

    public com.boat.jrosbridge.message.geometry_msgs.Vector3 toVector3Message(com.boat.jrosbridge.message.geometry_msgs.Vector3 p3)
    {
        p3.setX(this.x);
        p3.setY(this.y);
        p3.setZ(this.z);
        return p3;
    }
}
