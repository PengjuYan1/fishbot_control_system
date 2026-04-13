package com.boat.ros.geometry;
public class Transform {
    private com.boat.ros.geometry.Quaternion rotationAndScale;
    private com.boat.ros.geometry.Vector3 translation;

    public Transform(com.boat.ros.geometry.Vector3 p1, com.boat.ros.geometry.Quaternion p2)
    {
        this.translation = p1;
        this.rotationAndScale = p2;
        return;
    }

    public static com.boat.ros.geometry.Transform fromPoseMessage(com.boat.jrosbridge.message.geometry_msgs.Pose p3)
    {
        return new com.boat.ros.geometry.Transform(com.boat.ros.geometry.Vector3.fromPointMessage(p3.getPosition()), com.boat.ros.geometry.Quaternion.fromQuaternionMessage(p3.getOrientation()));
    }

    public static com.boat.ros.geometry.Transform fromTransformMessage(com.boat.jrosbridge.message.geometry_msgs.Transform p3)
    {
        return new com.boat.ros.geometry.Transform(com.boat.ros.geometry.Vector3.fromVector3Message(p3.getTranslation()), com.boat.ros.geometry.Quaternion.fromQuaternionMessage(p3.getRotation()));
    }

    public static com.boat.ros.geometry.Transform identity()
    {
        return new com.boat.ros.geometry.Transform(com.boat.ros.geometry.Vector3.zero(), com.boat.ros.geometry.Quaternion.identity());
    }

    public static com.boat.ros.geometry.Transform translation(double p9, double p11, double p13)
    {
        com.boat.ros.geometry.Vector3 v8 = new com.boat.ros.geometry.Vector3;
        v8(p9, p11, p13);
        return new com.boat.ros.geometry.Transform(v8, com.boat.ros.geometry.Quaternion.identity());
    }

    public static com.boat.ros.geometry.Transform translation(com.boat.ros.geometry.Vector3 p2)
    {
        return new com.boat.ros.geometry.Transform(p2, com.boat.ros.geometry.Quaternion.identity());
    }

    public static com.boat.ros.geometry.Transform xRotation(double p3)
    {
        return new com.boat.ros.geometry.Transform(com.boat.ros.geometry.Vector3.zero(), com.boat.ros.geometry.Quaternion.fromAxisAngle(com.boat.ros.geometry.Vector3.xAxis(), p3));
    }

    public static com.boat.ros.geometry.Transform yRotation(double p3)
    {
        return new com.boat.ros.geometry.Transform(com.boat.ros.geometry.Vector3.zero(), com.boat.ros.geometry.Quaternion.fromAxisAngle(com.boat.ros.geometry.Vector3.yAxis(), p3));
    }

    public static com.boat.ros.geometry.Transform zRotation(double p3)
    {
        return new com.boat.ros.geometry.Transform(com.boat.ros.geometry.Vector3.zero(), com.boat.ros.geometry.Quaternion.fromAxisAngle(com.boat.ros.geometry.Vector3.zAxis(), p3));
    }

    public boolean almostEquals(com.boat.ros.geometry.Transform p3, double p4)
    {
        if ((!this.translation.almostEquals(p3.translation, p4)) || (!this.rotationAndScale.almostEquals(p3.rotationAndScale, p4))) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public com.boat.ros.geometry.Quaternion apply(com.boat.ros.geometry.Quaternion p2)
    {
        return this.rotationAndScale.multiply(p2);
    }

    public com.boat.ros.geometry.Vector3 apply(com.boat.ros.geometry.Vector3 p3)
    {
        return this.rotationAndScale.rotateAndScaleVector(p3).add(this.translation);
    }

    public boolean equals(Object p6)
    {
        if (this != p6) {
            if (p6 != null) {
                if (this.getClass() == p6.getClass()) {
                    if (this.rotationAndScale != null) {
                        if (!this.rotationAndScale.equals(((com.boat.ros.geometry.Transform) p6).rotationAndScale)) {
                            return 0;
                        }
                    } else {
                        if (((com.boat.ros.geometry.Transform) p6).rotationAndScale != null) {
                            return 0;
                        }
                    }
                    if (this.translation != null) {
                        if (!this.translation.equals(((com.boat.ros.geometry.Transform) p6).translation)) {
                            return 0;
                        }
                    } else {
                        if (((com.boat.ros.geometry.Transform) p6).translation != null) {
                            return 0;
                        }
                    }
                    return 1;
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

    public com.boat.ros.geometry.Quaternion getRotationAndScale()
    {
        return this.rotationAndScale;
    }

    public double getScale()
    {
        return this.rotationAndScale.getMagnitudeSquared();
    }

    public com.boat.ros.geometry.Vector3 getTranslation()
    {
        return this.translation;
    }

    public com.boat.ros.geometry.Transform invert()
    {
        com.boat.ros.geometry.Quaternion v0_1 = this.rotationAndScale.invert();
        return new com.boat.ros.geometry.Transform(v0_1.rotateAndScaleVector(this.translation.invert()), v0_1);
    }

    public com.boat.ros.geometry.Transform multiply(com.boat.ros.geometry.Transform p4)
    {
        return new com.boat.ros.geometry.Transform(this.apply(p4.translation), this.apply(p4.rotationAndScale));
    }

    public com.boat.ros.geometry.Transform scale(double p6)
    {
        return new com.boat.ros.geometry.Transform(this.translation, this.rotationAndScale.scale(Math.sqrt(p6)));
    }

    public double[] toMatrix()
    {
        long v1_3 = this.rotationAndScale.getX();
        int v3_2 = this.rotationAndScale.getY();
        double v5_1 = this.rotationAndScale.getZ();
        double v7_1 = this.rotationAndScale.getW();
        double v9_1 = this.rotationAndScale.getMagnitudeSquared();
        int v13_5 = ((v9_1 - ((v3_2 * 4611686018427387904) * v3_2)) - ((v5_1 * 4611686018427387904) * v5_1));
        double v15_4 = (((v1_3 * 4611686018427387904) * v3_2) + ((v5_1 * 4611686018427387904) * v7_1));
        double v17_4 = (((v1_3 * 4611686018427387904) * v5_1) - ((v3_2 * 4611686018427387904) * v7_1));
        double v19_4 = (((v1_3 * 4611686018427387904) * v3_2) - ((v5_1 * 4611686018427387904) * v7_1));
        double v21_5 = ((v9_1 - ((v1_3 * 4611686018427387904) * v1_3)) - ((v5_1 * 4611686018427387904) * v5_1));
        double v23_4 = (((v3_2 * 4611686018427387904) * v5_1) + ((v1_3 * 4611686018427387904) * v7_1));
        double v25_4 = (((v1_3 * 4611686018427387904) * v5_1) + ((v3_2 * 4611686018427387904) * v7_1));
        double v27_4 = (((v3_2 * 4611686018427387904) * v5_1) - ((v1_3 * 4611686018427387904) * v7_1));
        double v29_5 = ((v9_1 - ((v1_3 * 4611686018427387904) * v1_3)) - ((4611686018427387904 * v3_2) * v3_2));
        int v11_5 = this.translation.getX();
        long v1_5 = this.translation.getY();
        int v3_4 = this.translation.getZ();
        double[] v0_2 = new double[16];
        v0_2[0] = v13_5;
        v0_2[1] = v15_4;
        v0_2[2] = v17_4;
        v0_2[3] = 0;
        v0_2[4] = v19_4;
        v0_2[5] = v21_5;
        v0_2[6] = v23_4;
        v0_2[7] = 0;
        v0_2[8] = v25_4;
        v0_2[9] = v27_4;
        v0_2[10] = v29_5;
        v0_2[11] = 0;
        v0_2[12] = v11_5;
        v0_2[13] = v1_5;
        v0_2[14] = v3_4;
        v0_2[15] = 4607182418800017408;
        return v0_2;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Pose toPoseMessage(com.boat.jrosbridge.message.geometry_msgs.Pose p3)
    {
        p3.setPosition(this.translation.toPointMessage(p3.getPosition()));
        p3.setOrientation(this.rotationAndScale.toQuaternionMessage(p3.getOrientation()));
        return p3;
    }

    public com.boat.jrosbridge.message.geometry_msgs.PoseStamped toPoseStampedMessage(org.ros.namespace.GraphName p3, com.boat.jrosbridge.message.Time p4, com.boat.jrosbridge.message.geometry_msgs.PoseStamped p5)
    {
        p5.getHeader().setFrameId(p3.toString());
        p5.getHeader().setStamp(p4);
        p5.setPose(this.toPoseMessage(p5.getPose()));
        return p5;
    }

    public String toString()
    {
        com.boat.ros.geometry.Quaternion v1 = this.rotationAndScale;
        Object[] v2_1 = new Object[2];
        v2_1[0] = this.translation;
        v2_1[1] = v1;
        return String.format("Transform<%s, %s>", v2_1);
    }

    public com.boat.jrosbridge.message.geometry_msgs.Transform toTransformMessage(com.boat.jrosbridge.message.geometry_msgs.Transform p3)
    {
        p3.setTranslation(this.translation.toVector3Message(p3.getTranslation()));
        p3.setRotation(this.rotationAndScale.toQuaternionMessage(p3.getRotation()));
        return p3;
    }
}
