package cartographer_ros_msgs;
public class StatusResponse extends com.boat.jrosbridge.message.Message {
    public byte code;
    public String message;

    public StatusResponse()
    {
        return;
    }

    public byte getCode()
    {
        return this.code;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setCode(byte p1)
    {
        this.code = p1;
        return;
    }

    public void setMessage(String p1)
    {
        this.message = p1;
        return;
    }
}
