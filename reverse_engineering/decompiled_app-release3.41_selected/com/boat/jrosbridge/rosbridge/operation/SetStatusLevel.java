package com.boat.jrosbridge.rosbridge.operation;
public class SetStatusLevel extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public String level;

    public SetStatusLevel()
    {
        return;
    }

    public SetStatusLevel(String p2)
    {
        this.level = 0;
        if (("none".equals(p2)) || (("warning".equals(p2)) || (("error".equals(p2)) || ("info".equals(p2))))) {
            this.level = p2;
        }
        return;
    }
}
