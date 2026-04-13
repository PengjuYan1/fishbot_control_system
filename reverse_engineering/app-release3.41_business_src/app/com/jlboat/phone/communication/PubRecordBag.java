package com.jlboat.phone.communication;
public class PubRecordBag {
    private com.boat.jrosbridge.Topic grabagPublisher;
    private com.jlboat.phone.message.map_msgs.RecordBag grabaglocal;

    public PubRecordBag()
    {
        this.grabagPublisher = new com.boat.jrosbridge.Topic("Record_bag", com.jlboat.phone.message.map_msgs.RecordBag, com.jlboat.phone.application.BoatSlamApplication.client);
        this.grabagPublisher.advertise();
        this.grabaglocal = new com.jlboat.phone.message.map_msgs.RecordBag();
        return;
    }

    public void onDestory()
    {
        this.grabagPublisher.unadvertise();
        return;
    }

    public void setType(int p3)
    {
        if ((this.grabagPublisher != null) || (this.grabaglocal != null)) {
            this.grabaglocal.setType(p3);
            this.grabagPublisher.publish(this.grabaglocal);
            return;
        } else {
            return;
        }
    }

    public void setType(int p3, String p4, java.util.List p5)
    {
        if ((this.grabagPublisher != null) || (this.grabaglocal != null)) {
            this.grabaglocal.setType(p3);
            this.grabaglocal.setBagName(p4);
            this.grabaglocal.setTopicList(p5);
            this.grabagPublisher.publish(this.grabaglocal);
            return;
        } else {
            return;
        }
    }

    public void setType(int p3, String p4, String[] p5)
    {
        if ((this.grabagPublisher != null) || (this.grabaglocal != null)) {
            this.grabaglocal.setType(p3);
            this.grabaglocal.setBagName(p4);
            this.grabaglocal.setTopicList(java.util.Arrays.asList(p5));
            this.grabagPublisher.publish(this.grabaglocal);
            return;
        } else {
            return;
        }
    }
}
