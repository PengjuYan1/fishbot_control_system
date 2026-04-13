package com.jlboat.phone.message.map_msgs;
public class NaviQueueList extends com.boat.jrosbridge.message.Message {
    public com.jlboat.phone.message.map_msgs.NaviQueueListEntry[] naviQueueListEntrys;

    public NaviQueueList()
    {
        return;
    }

    public com.jlboat.phone.message.map_msgs.NaviQueueListEntry[] getNaviQueueListEntrys()
    {
        return this.naviQueueListEntrys;
    }

    public void setNaviQueueListEntrys(com.jlboat.phone.message.map_msgs.NaviQueueListEntry[] p1)
    {
        this.naviQueueListEntrys = p1;
        return;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append("NaviQueueList{");
        v0_1.append("naviQueueListEntrys=[");
        if (this.naviQueueListEntrys == null) {
            v0_1.append("null");
        } else {
            int v1_0 = 0;
            while (v1_0 < this.naviQueueListEntrys.length) {
                String v3_4;
                if (this.naviQueueListEntrys[v1_0] == null) {
                    v3_4 = "null";
                } else {
                    v3_4 = this.naviQueueListEntrys[v1_0].toString();
                }
                v0_1.append(v3_4);
                if (v1_0 != (this.naviQueueListEntrys.length - 1)) {
                    v0_1.append(", ");
                }
                v1_0++;
            }
        }
        v0_1.append("]}");
        return v0_1.toString();
    }
}
