package com.jlboat.phone.message.map_msgs;
public class SetCocoNumRequest extends com.boat.jrosbridge.message.Message {
    public int coco_num;

    public SetCocoNumRequest()
    {
        return;
    }

    public int getCocoNum()
    {
        return this.coco_num;
    }

    public void setCocoNum(int p1)
    {
        this.coco_num = p1;
        return;
    }
}
