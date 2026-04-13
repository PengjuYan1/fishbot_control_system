package com.jlboat.phone.message.map_msgs;
public class RobotSonarListResponse extends com.boat.jrosbridge.message.Message {
    public com.jlboat.phone.message.map_msgs.RobotSonarEntry[] sonars;
    public boolean user_sonar;

    public RobotSonarListResponse()
    {
        return;
    }

    public java.util.List getSonars()
    {
        return java.util.Arrays.asList(this.sonars);
    }

    public boolean isUserSonar()
    {
        return this.user_sonar;
    }

    public void setSonars(java.util.List p2)
    {
        com.jlboat.phone.message.map_msgs.RobotSonarEntry[] v0_1 = new com.jlboat.phone.message.map_msgs.RobotSonarEntry[0];
        this.sonars = ((com.jlboat.phone.message.map_msgs.RobotSonarEntry[]) p2.toArray(v0_1));
        return;
    }

    public void setUserSonar(boolean p1)
    {
        this.user_sonar = p1;
        return;
    }
}
