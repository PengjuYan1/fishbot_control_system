package cartographer_ros_msgs;
public class SubmapQueryResponse extends com.boat.jrosbridge.message.Message {
    public cartographer_ros_msgs.StatusResponse status;
    public int submap_version;
    public cartographer_ros_msgs.SubmapTexture[] textures;

    public SubmapQueryResponse()
    {
        return;
    }

    public cartographer_ros_msgs.StatusResponse getStatus()
    {
        return this.status;
    }

    public int getSubmapVersion()
    {
        return this.submap_version;
    }

    public java.util.List getTextures()
    {
        return java.util.Arrays.asList(this.textures);
    }

    public void setStatus(cartographer_ros_msgs.StatusResponse p1)
    {
        this.status = p1;
        return;
    }

    public void setSubmapVersion(int p1)
    {
        this.submap_version = p1;
        return;
    }

    public void setTextures(java.util.List p2)
    {
        cartographer_ros_msgs.SubmapTexture[] v0_1 = new cartographer_ros_msgs.SubmapTexture[0];
        this.textures = ((cartographer_ros_msgs.SubmapTexture[]) p2.toArray(v0_1));
        return;
    }
}
