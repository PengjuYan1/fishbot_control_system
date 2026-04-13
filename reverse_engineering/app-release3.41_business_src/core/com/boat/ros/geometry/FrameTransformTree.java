package com.boat.ros.geometry;
public class FrameTransformTree {
    private static final int TRANSFORM_QUEUE_CAPACITY = 16;
    private final Object mutex;
    private final java.util.Map transforms;

    public FrameTransformTree()
    {
        this.mutex = new Object();
        this.transforms = new java.util.HashMap();
        return;
    }

    private void add(org.ros.namespace.GraphName p5, com.boat.ros.geometry.LazyFrameTransform p6)
    {
        org.ros.namespace.GraphName v0 = p5.toRelative();
        if (!this.transforms.containsKey(v0)) {
            this.transforms.put(v0, new org.ros.concurrent.CircularBlockingDeque(16));
        }
        try {
            ((org.ros.concurrent.CircularBlockingDeque) this.transforms.get(v0)).addFirst(p6);
            return;
        } catch (Throwable v2_3) {
            throw v2_3;
        }
    }

    private com.boat.ros.geometry.FrameTransform get(org.ros.namespace.GraphName p12, com.boat.jrosbridge.message.Time p13)
    {
        org.ros.concurrent.CircularBlockingDeque v0_2 = ((org.ros.concurrent.CircularBlockingDeque) this.transforms.get(p12));
        com.boat.ros.geometry.FrameTransform v1_0 = 0;
        if (v0_2 != null) {
            com.boat.ros.geometry.LazyFrameTransform v2 = 0;
            long v4 = 0;
            try {
                java.util.Iterator v6 = v0_2.iterator();
            } catch (com.boat.ros.geometry.FrameTransform v1_1) {
                throw v1_1;
            }
            while (v6.hasNext()) {
                com.boat.ros.geometry.LazyFrameTransform v7_2 = ((com.boat.ros.geometry.LazyFrameTransform) v6.next());
                if (v2 != null) {
                    long v8_4 = Math.abs(p13.subtract(v7_2.get().getTime()).totalNsecs());
                    if (v8_4 < v4) {
                        v2 = v7_2;
                        v4 = v8_4;
                    }
                } else {
                    v2 = v7_2;
                    v4 = Math.abs(p13.subtract(v7_2.get().getTime()).totalNsecs());
                }
            }
            if (v2 != null) {
                v1_0 = v2.get();
            } else {
            }
            return v1_0;
        } else {
            return 0;
        }
    }

    private com.boat.ros.geometry.FrameTransform getLatest(org.ros.namespace.GraphName p4)
    {
        org.ros.concurrent.CircularBlockingDeque v0_2 = ((org.ros.concurrent.CircularBlockingDeque) this.transforms.get(p4));
        com.boat.ros.geometry.FrameTransform v1 = 0;
        if (v0_2 != null) {
            com.boat.ros.geometry.LazyFrameTransform v2_1 = ((com.boat.ros.geometry.LazyFrameTransform) v0_2.peekFirst());
            if (v2_1 != null) {
                v1 = v2_1.get();
            }
            return v1;
        } else {
            return 0;
        }
    }

    public com.boat.ros.geometry.FrameTransform get(String p2)
    {
        return this.lookUp(org.ros.namespace.GraphName.of(p2));
    }

    public com.boat.ros.geometry.FrameTransform get(String p2, com.boat.jrosbridge.message.Time p3)
    {
        return this.lookUp(org.ros.namespace.GraphName.of(p2), p3);
    }

    public com.boat.ros.geometry.FrameTransform lookUp(org.ros.namespace.GraphName p2)
    {
        return this.getLatest(p2.toRelative());
    }

    public com.boat.ros.geometry.FrameTransform lookUp(org.ros.namespace.GraphName p2, com.boat.jrosbridge.message.Time p3)
    {
        return this.get(p2, p3);
    }

    public com.boat.ros.geometry.FrameTransform transform(String p3, String p4)
    {
        return this.transform(org.ros.namespace.GraphName.of(p3), org.ros.namespace.GraphName.of(p4));
    }

    public com.boat.ros.geometry.FrameTransform transform(org.ros.namespace.GraphName p8, org.ros.namespace.GraphName p9)
    {
        org.ros.namespace.GraphName v0 = p8.toRelative();
        org.ros.namespace.GraphName v1 = p9.toRelative();
        com.boat.ros.geometry.Transform v3_3 = 0;
        if (!v0.equals(v1)) {
            com.boat.ros.geometry.FrameTransform v2_3 = this.transformToRoot(v0);
            com.boat.ros.geometry.FrameTransform v4_0 = this.transformToRoot(v1);
            if ((v2_3 != null) || (v4_0 != null)) {
                if (v2_3 != null) {
                    if (v4_0 != null) {
                        if (!v2_3.getTargetFrame().equals(v4_0.getTargetFrame())) {
                            return 0;
                        } else {
                            return new com.boat.ros.geometry.FrameTransform(v4_0.getTransform().invert().multiply(v2_3.getTransform()), v0, v1, v2_3.getTime());
                        }
                    } else {
                        if (v2_3.getTargetFrame().equals(v1)) {
                            v3_3 = v2_3;
                        }
                        return v3_3;
                    }
                } else {
                    if (v4_0.getTargetFrame().equals(v0)) {
                        v3_3 = v4_0.invert();
                    }
                    return v3_3;
                }
            } else {
                return 0;
            }
        } else {
            return new com.boat.ros.geometry.FrameTransform(com.boat.ros.geometry.Transform.identity(), v0, v1, 0);
        }
    }

    com.boat.ros.geometry.FrameTransform transformToRoot(org.ros.namespace.GraphName p7)
    {
        com.boat.ros.geometry.FrameTransform v0 = this.getLatest(p7);
        if (v0 == null) {
            return 0;
        }
        while(true) {
            com.boat.ros.geometry.FrameTransform v1_2 = this.lookUp(v0.getTargetFrame(), v0.getTime());
            if (v1_2 == null) {
                break;
            }
            v0 = new com.boat.ros.geometry.FrameTransform(v1_2.getTransform().multiply(v0.getTransform()), p7, v1_2.getTargetFrame(), v0.getTime());
        }
        return v0;
    }

    public void update(com.boat.jrosbridge.message.geometry_msgs.TransformStamped p3)
    {
        this.add(org.ros.namespace.GraphName.of(p3.getChildFrameId()), new com.boat.ros.geometry.LazyFrameTransform(p3));
        return;
    }

    void update(com.boat.ros.geometry.FrameTransform p3)
    {
        this.add(p3.getSourceFrame(), new com.boat.ros.geometry.LazyFrameTransform(p3));
        return;
    }
}
