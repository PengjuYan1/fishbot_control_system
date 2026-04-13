package com.boat.jrosbridge.message;
public class Log extends com.boat.jrosbridge.message.Message {
    public String file;
    public String function;
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public byte level;
    public long line;
    public String msg;
    public String name;
    public String[] topics;

    public Log()
    {
        return;
    }

    public static void d(String p0, String p1)
    {
        return;
    }
}
