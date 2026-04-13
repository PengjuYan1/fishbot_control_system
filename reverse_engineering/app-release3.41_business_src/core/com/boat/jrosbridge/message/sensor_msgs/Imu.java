package com.boat.jrosbridge.message.sensor_msgs;
public class Imu extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.Vector3 angular_velocity;
    public double[] angular_velocity_covariance;
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public com.boat.jrosbridge.message.geometry_msgs.Vector3 linear_acceleration;
    public double[] linear_acceleration_covariance;
    public com.boat.jrosbridge.message.geometry_msgs.Quaternion orientation;
    public double[] orientation_covariance;

    public Imu()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Vector3 getAngularVelocity()
    {
        return this.angular_velocity;
    }

    public double[] getAngularVelocityCovariance()
    {
        return this.angular_velocity_covariance;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Vector3 getLinearAcceleration()
    {
        return this.linear_acceleration;
    }

    public double[] getLinearAccelerationCovariance()
    {
        return this.linear_acceleration_covariance;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Quaternion getOrientation()
    {
        return this.orientation;
    }

    public double[] getOrientationCovariance()
    {
        return this.orientation_covariance;
    }

    public void setAngularVelocity(com.boat.jrosbridge.message.geometry_msgs.Vector3 p1)
    {
        this.angular_velocity = p1;
        return;
    }

    public void setAngularVelocityCovariance(double[] p1)
    {
        this.angular_velocity_covariance = p1;
        return;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setLinearAcceleration(com.boat.jrosbridge.message.geometry_msgs.Vector3 p1)
    {
        this.linear_acceleration = p1;
        return;
    }

    public void setLinearAccelerationCovariance(double[] p1)
    {
        this.linear_acceleration_covariance = p1;
        return;
    }

    public void setOrientation(com.boat.jrosbridge.message.geometry_msgs.Quaternion p1)
    {
        this.orientation = p1;
        return;
    }

    public void setOrientationCovariance(double[] p1)
    {
        this.orientation_covariance = p1;
        return;
    }
}
