package com.jlboat.phone.message.map_msgs;
public class RobotSshRequest extends com.boat.jrosbridge.message.Message {
    public String instruction;

    public RobotSshRequest()
    {
        return;
    }

    public String getInstruction()
    {
        return this.instruction;
    }

    public void setInstruction(String p1)
    {
        this.instruction = p1;
        return;
    }
}
