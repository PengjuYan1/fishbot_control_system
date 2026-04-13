package cartographer_ros_msgs;
public class SubmapEntry extends com.boat.jrosbridge.message.Message {
    public boolean is_frozen;
    public com.boat.jrosbridge.message.geometry_msgs.Pose pose;
    public int submap_index;
    public int submap_version;
    public int trajectory_id;

    public SubmapEntry()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Pose getPose()
    {
        return this.pose;
    }

    public int getSubmapIndex()
    {
        return this.submap_index;
    }

    public int getSubmapVersion()
    {
        return this.submap_version;
    }

    public int getTrajectoryId()
    {
        return this.trajectory_id;
    }

    public boolean isIsFrozen()
    {
        return this.is_frozen;
    }

    public void setIsFrozen(boolean p1)
    {
        this.is_frozen = p1;
        return;
    }

    public void setPose(com.boat.jrosbridge.message.geometry_msgs.Pose p1)
    {
        this.pose = p1;
        return;
    }

    public void setSubmapIndex(int p1)
    {
        this.submap_index = p1;
        return;
    }

    public void setSubmapVersion(int p1)
    {
        this.submap_version = p1;
        return;
    }

    public void setTrajectoryId(int p1)
    {
        this.trajectory_id = p1;
        return;
    }
}
