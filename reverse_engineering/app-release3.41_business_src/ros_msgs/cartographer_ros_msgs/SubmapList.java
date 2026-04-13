package cartographer_ros_msgs;
public class SubmapList extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public cartographer_ros_msgs.SubmapEntry[] submap;

    public SubmapList()
    {
        return;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public java.util.List getSubmap()
    {
        return java.util.Arrays.asList(this.submap);
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setSubmap(java.util.List p2)
    {
        cartographer_ros_msgs.SubmapEntry[] v0_1 = new cartographer_ros_msgs.SubmapEntry[0];
        this.submap = ((cartographer_ros_msgs.SubmapEntry[]) p2.toArray(v0_1));
        return;
    }
}
