package com.jlboat.phone.message.map_msgs;
public class SetEraserModeRequest extends com.boat.jrosbridge.message.Message {
    public int erasermode;

    public SetEraserModeRequest()
    {
        return;
    }

    public int getErasermode()
    {
        return this.erasermode;
    }

    public void setErasermode(int p1)
    {
        this.erasermode = p1;
        return;
    }
}
