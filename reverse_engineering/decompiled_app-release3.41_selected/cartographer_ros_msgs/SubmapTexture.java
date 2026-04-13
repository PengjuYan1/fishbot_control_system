package cartographer_ros_msgs;
public class SubmapTexture extends com.boat.jrosbridge.message.Message {
    public byte[] cells;
    public int height;
    public double resolution;
    public com.boat.jrosbridge.message.geometry_msgs.Pose slice_pose;
    public int width;

    public SubmapTexture()
    {
        return;
    }

    public byte[] getCells()
    {
        return this.cells;
    }

    public int getHeight()
    {
        return this.height;
    }

    public double getResolution()
    {
        return this.resolution;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Pose getSlice_pose()
    {
        return this.slice_pose;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void setCells(byte[] p1)
    {
        this.cells = p1;
        return;
    }

    public void setHeight(int p1)
    {
        this.height = p1;
        return;
    }

    public void setResolution(double p1)
    {
        this.resolution = p1;
        return;
    }

    public void setSlice_pose(com.boat.jrosbridge.message.geometry_msgs.Pose p1)
    {
        this.slice_pose = p1;
        return;
    }

    public void setWidth(int p1)
    {
        this.width = p1;
        return;
    }
}
