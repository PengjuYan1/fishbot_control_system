package cartographer_ros_msgs;
public class SubmapQueryRequest extends com.boat.jrosbridge.message.Message {
    public int submap_index;
    public int trajectory_id;

    public SubmapQueryRequest()
    {
        return;
    }

    public int getSubmapIndex()
    {
        return this.submap_index;
    }

    public int getTrajectoryId()
    {
        return this.trajectory_id;
    }

    public void setSubmapIndex(int p1)
    {
        this.submap_index = p1;
        return;
    }

    public void setTrajectoryId(int p1)
    {
        this.trajectory_id = p1;
        return;
    }
}
