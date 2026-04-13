package com.boat.ros.geometry;
public class Quaternion {
    private final double w;
    private final double x;
    private final double y;
    private final double z;

    public Quaternion(double p1, double p3, double p5, double p7)
    {
        this.x = p1;
        this.y = p3;
        this.z = p5;
        this.w = p7;
        return;
    }

    public static com.boat.ros.geometry.Quaternion fromAxisAngle(com.boat.ros.geometry.Vector3 p15, double p16)
    {
        com.boat.ros.geometry.Vector3 v0 = p15.normalize();
        double v3_1 = Math.sin((p16 / 4611686018427387904));
        com.boat.ros.geometry.Quaternion v14 = new com.boat.ros.geometry.Quaternion;
        v14((v0.getX() * v3_1), (v0.getY() * v3_1), (v0.getZ() * v3_1), Math.cos((p16 / 4611686018427387904)));
        return v14;
    }

    public static com.boat.ros.geometry.Quaternion fromQuaternionMessage(com.boat.jrosbridge.message.geometry_msgs.Quaternion p10)
    {
        com.boat.ros.geometry.Quaternion v9 = new com.boat.ros.geometry.Quaternion;
        v9(p10.getX(), p10.getY(), p10.getZ(), p10.getW());
        return v9;
    }

    public static com.boat.ros.geometry.Quaternion identity()
    {
        com.boat.ros.geometry.Quaternion v9 = new com.boat.ros.geometry.Quaternion;
        v9(0, 0, 0, 4607182418800017408);
        return v9;
    }

    public static com.boat.ros.geometry.Quaternion rotationBetweenVectors(com.boat.ros.geometry.Vector3 p16, com.boat.ros.geometry.Vector3 p17)
    {
        if (!p16.normalize().equals(p17.normalize())) {
            double v0_2 = Math.acos((p16.dotProduct(p17) / (p16.getMagnitude() * p17.getMagnitude())));
            com.boat.ros.geometry.Vector3 v15 = new com.boat.ros.geometry.Vector3;
            v15(((p16.getY() * p17.getZ()) - (p16.getZ() * p17.getY())), ((p16.getZ() * p17.getX()) - (p16.getX() * p17.getZ())), ((p16.getX() * p17.getY()) - (p16.getY() * p17.getX())));
            return com.boat.ros.geometry.Quaternion.fromAxisAngle(v15, v0_2);
        } else {
            return com.boat.ros.geometry.Quaternion.identity();
        }
    }

    public boolean almostEquals(com.boat.ros.geometry.Quaternion p8, double p9)
    {
        java.util.LinkedList v0_1 = new java.util.LinkedList();
        v0_1.add(Double.valueOf((this.x - p8.x)));
        v0_1.add(Double.valueOf((this.y - p8.y)));
        v0_1.add(Double.valueOf((this.z - p8.z)));
        v0_1.add(Double.valueOf((this.w - p8.w)));
        java.util.Iterator v1_9 = v0_1.iterator();
        while (v1_9.hasNext()) {
            if (Math.abs(((Double) v1_9.next()).doubleValue()) > p9) {
                return 0;
            }
        }
        return 1;
    }

    public com.boat.ros.geometry.Quaternion conjugate()
    {
        com.boat.ros.geometry.Quaternion v9 = new com.boat.ros.geometry.Quaternion;
        v9((- this.x), (- this.y), (- this.z), this.w);
        return v9;
    }

    public boolean equals(Object p25)
    {
        if (this != p25) {
            if (p25 != null) {
                if (this.getClass() == p25.getClass()) {
                    double v5_1;
                    double v7 = 0;
                    if (this.w != 0) {
                        v5_1 = this.w;
                    } else {
                        v5_1 = 0;
                    }
                    double v9_2;
                    if (this.x != 0) {
                        v9_2 = this.x;
                    } else {
                        v9_2 = 0;
                    }
                    double v11_2;
                    if (this.y != 0) {
                        v11_2 = this.y;
                    } else {
                        v11_2 = 0;
                    }
                    int v13_2;
                    if (this.z != 0) {
                        v13_2 = this.z;
                    } else {
                        v13_2 = 0;
                    }
                    double v2_2;
                    if (((com.boat.ros.geometry.Quaternion) p25).w != 0) {
                        v2_2 = ((com.boat.ros.geometry.Quaternion) p25).w;
                    } else {
                        v2_2 = 0;
                    }
                    double v0_2;
                    if (((com.boat.ros.geometry.Quaternion) p25).x != 0) {
                        v0_2 = ((com.boat.ros.geometry.Quaternion) p25).x;
                    } else {
                        v0_2 = 0;
                    }
                    int v13_4;
                    if (((com.boat.ros.geometry.Quaternion) p25).y != 0) {
                        v13_4 = ((com.boat.ros.geometry.Quaternion) p25).y;
                    } else {
                        v13_4 = 0;
                    }
                    if (((com.boat.ros.geometry.Quaternion) p25).z != 0) {
                        v7 = ((com.boat.ros.geometry.Quaternion) p25).z;
                    }
                    if (Double.doubleToLongBits(v5_1) == Double.doubleToLongBits(v2_2)) {
                        if (Double.doubleToLongBits(v9_2) == Double.doubleToLongBits(v0_2)) {
                            if (Double.doubleToLongBits(v11_2) == Double.doubleToLongBits(v13_4)) {
                                int v15_1;
                                if (Double.doubleToLongBits(v13_2) != Double.doubleToLongBits(v7)) {
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
        return ((((this.x * this.x) + (this.y * this.y)) + (this.z * this.z)) + (this.w * this.w));
    }

    public double getW()
    {
        return this.w;
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

    public com.boat.ros.geometry.Quaternion invert()
    {
        return this.conjugate().scale((4607182418800017408 / this.getMagnitudeSquared()));
    }

    public boolean isAlmostNeutral(double p7)
    {
        int v0_6;
        if (Math.abs(((((4607182418800017408 - (this.x * this.x)) - (this.y * this.y)) - (this.z * this.z)) - (this.w * this.w))) >= p7) {
            v0_6 = 0;
        } else {
            v0_6 = 1;
        }
        return v0_6;
    }

    public com.boat.ros.geometry.Quaternion multiply(com.boat.ros.geometry.Quaternion p15)
    {
        com.boat.ros.geometry.Quaternion v9 = new com.boat.ros.geometry.Quaternion;
        v9(((((this.w * p15.x) + (this.x * p15.w)) + (this.y * p15.z)) - (this.z * p15.y)), ((((this.w * p15.y) + (this.y * p15.w)) + (this.z * p15.x)) - (this.x * p15.z)), ((((this.w * p15.z) + (this.z * p15.w)) + (this.x * p15.y)) - (this.y * p15.x)), ((((this.w * p15.w) - (this.x * p15.x)) - (this.y * p15.y)) - (this.z * p15.z)));
        return v9;
    }

    public com.boat.ros.geometry.Quaternion normalize()
    {
        return this.scale((4607182418800017408 / this.getMagnitude()));
    }

    public com.boat.ros.geometry.Vector3 rotateAndScaleVector(com.boat.ros.geometry.Vector3 p11)
    {
        com.boat.ros.geometry.Quaternion v1_2 = this.multiply(new com.boat.ros.geometry.Quaternion(p11.getX(), p11.getY(), p11.getZ(), 0).multiply(this.conjugate()));
        com.boat.ros.geometry.Vector3 v9_1 = new com.boat.ros.geometry.Vector3;
        v9_1(v1_2.getX(), v1_2.getY(), v1_2.getZ());
        return v9_1;
    }

    public com.boat.ros.geometry.Quaternion scale(double p11)
    {
        com.boat.ros.geometry.Quaternion v9 = new com.boat.ros.geometry.Quaternion;
        v9((this.x * p11), (this.y * p11), (this.z * p11), (this.w * p11));
        return v9;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Quaternion toQuaternionMessage(com.boat.jrosbridge.message.geometry_msgs.Quaternion p3)
    {
        p3.setX(this.x);
        p3.setY(this.y);
        p3.setZ(this.z);
        p3.setW(this.w);
        return p3;
    }

    public String toString()
    {
        String v0_3 = Double.valueOf(this.x);
        Double v1_1 = Double.valueOf(this.y);
        Double v2_1 = Double.valueOf(this.z);
        Double v3_0 = Double.valueOf(this.w);
        Object[] v4_1 = new Object[4];
        v4_1[0] = v0_3;
        v4_1[1] = v1_1;
        v4_1[2] = v2_1;
        v4_1[3] = v3_0;
        return String.format("Quaternion<x: %.4f, y: %.4f, z: %.4f, w: %.4f>", v4_1);
    }
}
