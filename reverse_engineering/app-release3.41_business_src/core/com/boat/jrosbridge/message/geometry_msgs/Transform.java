package com.boat.jrosbridge.message.geometry_msgs;
public class Transform extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.Quaternion rotation;
    public com.boat.jrosbridge.message.geometry_msgs.Vector3 translation;

    public Transform()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Quaternion getRotation()
    {
        return this.rotation;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Vector3 getTranslation()
    {
        return this.translation;
    }

    public void setRotation(com.boat.jrosbridge.message.geometry_msgs.Quaternion p1)
    {
        this.rotation = p1;
        return;
    }

    public void setTranslation(com.boat.jrosbridge.message.geometry_msgs.Vector3 p1)
    {
        this.translation = p1;
        return;
    }
}
