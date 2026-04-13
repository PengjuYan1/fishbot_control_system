package com.jlboat.phone.message.map_msgs;
public class NaviTestResultEntrys extends com.boat.jrosbridge.message.Message {
    public String test_time;
    public com.jlboat.phone.message.map_msgs.NaviTestResultEntry[] testresults;

    public NaviTestResultEntrys()
    {
        return;
    }

    public String getTestTime()
    {
        return this.test_time;
    }

    public java.util.List getTestresults()
    {
        return java.util.Arrays.asList(this.testresults);
    }

    public void setTestTime(String p1)
    {
        this.test_time = p1;
        return;
    }

    public void setTestresults(com.jlboat.phone.message.map_msgs.NaviTestResultEntry[] p1)
    {
        this.testresults = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("NaviTestResultEntrys{test_time=\'").append(this.test_time).append(39).append(", testresults=").append(java.util.Arrays.toString(this.testresults)).append(125).toString();
    }
}
