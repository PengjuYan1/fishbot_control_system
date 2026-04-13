package com.boat.jrosbridge.message.visualization_msgs;
public class Marker extends com.boat.jrosbridge.message.Message {
    public byte ADD;
    public byte ARROW;
    public byte CUBE;
    public byte CUBE_LIST;
    public byte CYLINDER;
    public byte DELETE;
    public byte DELETEALL;
    public byte LINE_LIST;
    public byte LINE_STRIP;
    public byte MESH_RESOURCE;
    public byte MODIFY;
    public byte POINTS;
    public byte SPHERE;
    public byte SPHERE_LIST;
    public byte TEXT_VIEW_FACING;
    public byte TRIANGLE_LIST;
    public int action;
    public com.boat.jrosbridge.message.std_msgs.ColorRGBA color;
    public com.boat.jrosbridge.message.std_msgs.ColorRGBA[] colors;
    public boolean frame_locked;
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public int id;
    public com.boat.jrosbridge.message.std_msgs.Duration lifetime;
    public String mesh_resource;
    public boolean mesh_use_embedded_materials;
    public String ns;
    public com.boat.jrosbridge.message.geometry_msgs.Point[] points;
    public com.boat.jrosbridge.message.geometry_msgs.Pose pose;
    public com.boat.jrosbridge.message.geometry_msgs.Vector3 scale;
    public String text;
    public int type;

    public Marker()
    {
        this.ARROW = 0;
        this.CUBE = 1;
        this.SPHERE = 2;
        this.CYLINDER = 3;
        this.LINE_STRIP = 4;
        this.LINE_LIST = 5;
        this.CUBE_LIST = 6;
        this.SPHERE_LIST = 7;
        this.POINTS = 8;
        this.TEXT_VIEW_FACING = 9;
        this.MESH_RESOURCE = 10;
        this.TRIANGLE_LIST = 11;
        this.ADD = 0;
        this.MODIFY = 0;
        this.DELETE = 2;
        this.DELETEALL = 3;
        return;
    }

    public byte getADD()
    {
        return this.ADD;
    }

    public byte getARROW()
    {
        return this.ARROW;
    }

    public int getAction()
    {
        return this.action;
    }

    public byte getCUBE()
    {
        return this.CUBE;
    }

    public byte getCUBE_LIST()
    {
        return this.CUBE_LIST;
    }

    public byte getCYLINDER()
    {
        return this.CYLINDER;
    }

    public com.boat.jrosbridge.message.std_msgs.ColorRGBA getColor()
    {
        return this.color;
    }

    public com.boat.jrosbridge.message.std_msgs.ColorRGBA[] getColors()
    {
        return this.colors;
    }

    public byte getDELETE()
    {
        return this.DELETE;
    }

    public byte getDELETEALL()
    {
        return this.DELETEALL;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public int getId()
    {
        return this.id;
    }

    public byte getLINE_LIST()
    {
        return this.LINE_LIST;
    }

    public byte getLINE_STRIP()
    {
        return this.LINE_STRIP;
    }

    public com.boat.jrosbridge.message.std_msgs.Duration getLifetime()
    {
        return this.lifetime;
    }

    public byte getMESH_RESOURCE()
    {
        return this.MESH_RESOURCE;
    }

    public byte getMODIFY()
    {
        return this.MODIFY;
    }

    public String getMeshResource()
    {
        return this.mesh_resource;
    }

    public String getNs()
    {
        return this.ns;
    }

    public byte getPOINTS()
    {
        return this.POINTS;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point[] getPoints()
    {
        return this.points;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Pose getPose()
    {
        return this.pose;
    }

    public byte getSPHERE()
    {
        return this.SPHERE;
    }

    public byte getSPHERE_LIST()
    {
        return this.SPHERE_LIST;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Vector3 getScale()
    {
        return this.scale;
    }

    public byte getTEXT_VIEW_FACING()
    {
        return this.TEXT_VIEW_FACING;
    }

    public byte getTRIANGLE_LIST()
    {
        return this.TRIANGLE_LIST;
    }

    public String getText()
    {
        return this.text;
    }

    public int getType()
    {
        return this.type;
    }

    public boolean isFrameLocked()
    {
        return this.frame_locked;
    }

    public boolean isMeshUseEmbeddedMaterials()
    {
        return this.mesh_use_embedded_materials;
    }

    public void setADD(byte p1)
    {
        this.ADD = p1;
        return;
    }

    public void setARROW(byte p1)
    {
        this.ARROW = p1;
        return;
    }

    public void setAction(int p1)
    {
        this.action = p1;
        return;
    }

    public void setCUBE(byte p1)
    {
        this.CUBE = p1;
        return;
    }

    public void setCUBE_LIST(byte p1)
    {
        this.CUBE_LIST = p1;
        return;
    }

    public void setCYLINDER(byte p1)
    {
        this.CYLINDER = p1;
        return;
    }

    public void setColor(com.boat.jrosbridge.message.std_msgs.ColorRGBA p1)
    {
        this.color = p1;
        return;
    }

    public void setColors(com.boat.jrosbridge.message.std_msgs.ColorRGBA[] p1)
    {
        this.colors = p1;
        return;
    }

    public void setDELETE(byte p1)
    {
        this.DELETE = p1;
        return;
    }

    public void setDELETEALL(byte p1)
    {
        this.DELETEALL = p1;
        return;
    }

    public void setFrameLocked(boolean p1)
    {
        this.frame_locked = p1;
        return;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setId(int p1)
    {
        this.id = p1;
        return;
    }

    public void setLINE_LIST(byte p1)
    {
        this.LINE_LIST = p1;
        return;
    }

    public void setLINE_STRIP(byte p1)
    {
        this.LINE_STRIP = p1;
        return;
    }

    public void setLifetime(com.boat.jrosbridge.message.std_msgs.Duration p1)
    {
        this.lifetime = p1;
        return;
    }

    public void setMESH_RESOURCE(byte p1)
    {
        this.MESH_RESOURCE = p1;
        return;
    }

    public void setMODIFY(byte p1)
    {
        this.MODIFY = p1;
        return;
    }

    public void setMeshResource(String p1)
    {
        this.mesh_resource = p1;
        return;
    }

    public void setMeshUseEmbeddedMaterials(boolean p1)
    {
        this.mesh_use_embedded_materials = p1;
        return;
    }

    public void setNs(String p1)
    {
        this.ns = p1;
        return;
    }

    public void setPOINTS(byte p1)
    {
        this.POINTS = p1;
        return;
    }

    public void setPoints(com.boat.jrosbridge.message.geometry_msgs.Point[] p1)
    {
        this.points = p1;
        return;
    }

    public void setPose(com.boat.jrosbridge.message.geometry_msgs.Pose p1)
    {
        this.pose = p1;
        return;
    }

    public void setSPHERE(byte p1)
    {
        this.SPHERE = p1;
        return;
    }

    public void setSPHERE_LIST(byte p1)
    {
        this.SPHERE_LIST = p1;
        return;
    }

    public void setScale(com.boat.jrosbridge.message.geometry_msgs.Vector3 p1)
    {
        this.scale = p1;
        return;
    }

    public void setTEXT_VIEW_FACING(byte p1)
    {
        this.TEXT_VIEW_FACING = p1;
        return;
    }

    public void setTRIANGLE_LIST(byte p1)
    {
        this.TRIANGLE_LIST = p1;
        return;
    }

    public void setText(String p1)
    {
        this.text = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }
}
