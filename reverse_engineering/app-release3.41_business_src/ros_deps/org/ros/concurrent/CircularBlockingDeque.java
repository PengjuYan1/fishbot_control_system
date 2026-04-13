package org.ros.concurrent;
public class CircularBlockingDeque implements java.lang.Iterable {
    private final Object[] deque;
    private int length;
    private final int limit;
    private final Object mutex;
    private int start;

    public CircularBlockingDeque(int p2)
    {
        int v0_0 = new Object[p2];
        this.deque = v0_0;
        this.mutex = new Object();
        this.limit = p2;
        this.start = 0;
        this.length = 0;
        return;
    }

    static synthetic int access$000(org.ros.concurrent.CircularBlockingDeque p1)
    {
        return p1.length;
    }

    static synthetic Object[] access$100(org.ros.concurrent.CircularBlockingDeque p1)
    {
        return p1.deque;
    }

    static synthetic int access$200(org.ros.concurrent.CircularBlockingDeque p1)
    {
        return p1.start;
    }

    static synthetic int access$300(org.ros.concurrent.CircularBlockingDeque p1)
    {
        return p1.limit;
    }

    public boolean addFirst(Object p5)
    {
        try {
            if ((this.start - 1) >= 0) {
                this.start = (this.start - 1);
            } else {
                this.start = (this.limit - 1);
            }
        } catch (Object v1_6) {
            throw v1_6;
        }
        this.deque[this.start] = p5;
        if (this.length < this.limit) {
            this.length = (this.length + 1);
        }
        this.mutex.notify();
        return 1;
    }

    public boolean addLast(Object p5)
    {
        try {
            this.deque[((this.start + this.length) % this.limit)] = p5;
        } catch (Object v1_7) {
            throw v1_7;
        }
        if (this.length != this.limit) {
            this.length = (this.length + 1);
        } else {
            this.start = ((this.start + 1) % this.limit);
        }
        this.mutex.notify();
        return 1;
    }

    public boolean isEmpty()
    {
        int v0_1;
        if (this.length != 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public java.util.Iterator iterator()
    {
        return new org.ros.concurrent.CircularBlockingDeque$1(this);
    }

    public Object peekFirst()
    {
        try {
            if (this.length <= 0) {
                return 0;
            } else {
                return this.deque[this.start];
            }
        } catch (Object v1_3) {
            throw v1_3;
        }
    }

    public Object peekLast()
    {
        try {
            if (this.length <= 0) {
                return 0;
            } else {
                return this.deque[(((this.start + this.length) - 1) % this.limit)];
            }
        } catch (Object v1_2) {
            throw v1_2;
        }
    }

    public Object takeFirst()
    {
        try {
            while (this.length <= 0) {
                this.mutex.wait();
            }
        } catch (Object v1_1) {
            throw v1_1;
        }
        Object v1_4 = this.deque[this.start];
        this.start = ((this.start + 1) % this.limit);
        this.length = (this.length - 1);
        return v1_4;
    }

    public Object takeLast()
    {
        try {
            while (this.length <= 0) {
                this.mutex.wait();
            }
        } catch (Object v1_2) {
            throw v1_2;
        }
        Object v1_1 = this.deque[(((this.start + this.length) - 1) % this.limit)];
        this.length = (this.length - 1);
        return v1_1;
    }
}
