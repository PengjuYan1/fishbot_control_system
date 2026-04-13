package com.jlboat.phone.activity;
 class PointBindPathActivity$NavPointItemCL implements com.jlboat.phone.adapter.NavPointListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity this$0;

    private PointBindPathActivity$NavPointItemCL(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic PointBindPathActivity$NavPointItemCL(com.jlboat.phone.activity.PointBindPathActivity p1, com.jlboat.phone.activity.PointBindPathActivity$1 p2)
    {
        this(p1);
        return;
    }

    public void onClick(int p12)
    {
        if ((com.jlboat.phone.activity.PointBindPathActivity.access$400(this.this$0) != null) && (com.jlboat.phone.activity.PointBindPathActivity.access$400(this.this$0).size() > 0)) {
            com.boat.support.slam.entity.floors.Points v0_4 = ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.PointBindPathActivity.access$400(this.this$0).get(p12));
            if (com.jlboat.phone.activity.PointBindPathActivity.access$1700(this.this$0) != 0) {
                com.jlboat.phone.activity.PointBindPathActivity.access$1702(this.this$0, 0);
                android.support.v7.widget.RecyclerView v1_16 = ((com.boat.support.slam.entity.floors.Points) this.this$0.stringPointsMap.get("start"));
                if (!v1_16.equals(v0_4)) {
                    java.util.List v3_17 = com.jlboat.phone.activity.PointBindPathActivity.access$200(this.this$0).getAddPoints();
                    if ((v3_17 != null) && (v3_17.size() > 0)) {
                        int v4_19 = v3_17.iterator();
                        while (v4_19.hasNext()) {
                            com.boat.support.slam.entity.floors.AddPoints v5_1 = ((com.boat.support.slam.entity.floors.AddPoints) v4_19.next());
                            if ((v5_1.getX() == v1_16.getPointId()) && (v5_1.getY() == v0_4.getPointId())) {
                                this.this$0.newAddPos.remove((this.this$0.newAddPos.size() - 1));
                                com.jlboat.phone.activity.PointBindPathActivity.access$100(this.this$0).setData(this.this$0.newAddPos);
                                com.jlboat.phone.activity.PointBindPathActivity.access$1900(this.this$0).scrollToPosition((this.this$0.newAddPos.size() - 1));
                                this.this$0.toast(2131493297);
                                return;
                            }
                        }
                    }
                    int v4_22 = this.this$0.newAddPos.iterator();
                    while (v4_22.hasNext()) {
                        com.boat.support.slam.entity.floors.AddPoints v5_5 = ((java.util.Map) v4_22.next());
                        if ((v5_5.containsKey("start")) && ((v5_5.containsKey("end")) && ((((com.boat.support.slam.entity.floors.Points) v5_5.get("start")).equals(v1_16)) && (((com.boat.support.slam.entity.floors.Points) v5_5.get("end")).equals(v0_4))))) {
                            this.this$0.newAddPos.remove((this.this$0.newAddPos.size() - 1));
                            com.jlboat.phone.activity.PointBindPathActivity.access$100(this.this$0).setData(this.this$0.newAddPos);
                            com.jlboat.phone.activity.PointBindPathActivity.access$1900(this.this$0).scrollToPosition((this.this$0.newAddPos.size() - 1));
                            this.this$0.toast(2131493298);
                            return;
                        }
                    }
                    this.this$0.newAddPos.remove((this.this$0.newAddPos.size() - 1));
                    this.this$0.stringPointsMap.put("end", v0_4);
                    this.this$0.newAddPos.add(this.this$0.stringPointsMap);
                } else {
                    this.this$0.newAddPos.remove((this.this$0.newAddPos.size() - 1));
                    com.jlboat.phone.activity.PointBindPathActivity.access$100(this.this$0).setData(this.this$0.newAddPos);
                    com.jlboat.phone.activity.PointBindPathActivity.access$1900(this.this$0).scrollToPosition((this.this$0.newAddPos.size() - 1));
                    this.this$0.toast(2131493299);
                    return;
                }
            } else {
                this.this$0.stringPointsMap = new java.util.HashMap();
                this.this$0.stringPointsMap.put("start", v0_4);
                com.jlboat.phone.activity.PointBindPathActivity.access$1708(this.this$0);
                this.this$0.newAddPos.add(this.this$0.stringPointsMap);
            }
            com.jlboat.phone.activity.PointBindPathActivity.access$100(this.this$0).setData(this.this$0.newAddPos);
            com.jlboat.phone.activity.PointBindPathActivity.access$1900(this.this$0).scrollToPosition((this.this$0.newAddPos.size() - 1));
        }
        return;
    }
}
