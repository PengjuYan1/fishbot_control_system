package org.ros.concurrent;
 class CircularBlockingDeque$1 implements java.util.Iterator {
    int offset;
    final synthetic org.ros.concurrent.CircularBlockingDeque this$0;

    CircularBlockingDeque$1(org.ros.concurrent.CircularBlockingDeque p2)
    {
        this.this$0 = p2;
        this.offset = 0;
        return;
    }

    public boolean hasNext()
    {
        int v0_1;
        if (this.offset >= org.ros.concurrent.CircularBlockingDeque.access$000(this.this$0)) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public Object next()
    {
        if (this.offset == org.ros.concurrent.CircularBlockingDeque.access$000(this.this$0)) {
            throw new java.util.NoSuchElementException();
        } else {
            java.util.NoSuchElementException v0_2 = org.ros.concurrent.CircularBlockingDeque.access$100(this.this$0)[((org.ros.concurrent.CircularBlockingDeque.access$200(this.this$0) + this.offset) % org.ros.concurrent.CircularBlockingDeque.access$300(this.this$0))];
            this.offset = (this.offset + 1);
            return v0_2;
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
