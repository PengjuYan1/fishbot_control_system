package com.jlboat.phone.viewgroupe;
public class AntoLineUtil extends android.view.ViewGroup {
    private android.content.Context context;
    private int mHorizontalSpacing;
    private int mVerticalSpacing;

    public AntoLineUtil(android.content.Context p2)
    {
        this(p2, 0);
        this.context = p2;
        return;
    }

    public AntoLineUtil(android.content.Context p2, android.util.AttributeSet p3)
    {
        this(p2, p3, 0);
        return;
    }

    public AntoLineUtil(android.content.Context p4, android.util.AttributeSet p5, int p6)
    {
        super(p4, p5, p6);
        if (p5 != null) {
            android.content.res.TypedArray v0_1 = p4.obtainStyledAttributes(p5, com.jlboat.deliverphone.R$styleable.AntoLineUtil);
            super.mHorizontalSpacing = v0_1.getDimensionPixelOffset(0, 0);
            super.mVerticalSpacing = v0_1.getDimensionPixelOffset(1, 0);
            v0_1.recycle();
            if (super.mHorizontalSpacing < 0) {
                super.mHorizontalSpacing = 0;
            }
            if (super.mVerticalSpacing < 0) {
                super.mVerticalSpacing = 0;
            }
        }
        return;
    }

    private int getAutoLinefeedHeight(int p12)
    {
        int v0_2 = ((p12 - this.getPaddingLeft()) - this.getPaddingRight());
        int v1_0 = v0_2;
        int v2_0 = (this.getPaddingTop() + this.getPaddingBottom());
        int v3_1 = 0;
        int v4 = 0;
        int v5 = 0;
        while (v5 < this.getChildCount()) {
            int v9_1;
            android.view.View v6_1 = this.getChildAt(v5);
            int v7 = v6_1.getMeasuredWidth();
            int v8 = v6_1.getMeasuredHeight();
            if (v5 != 0) {
                v9_1 = (this.mHorizontalSpacing + v7);
            } else {
                v9_1 = v7;
            }
            if (v1_0 < v9_1) {
                v2_0 += v4;
                if (v5 > 0) {
                    v2_0 += this.mVerticalSpacing;
                }
                v1_0 = v0_2;
                v4 = 0;
                v3_1 = 0;
            }
            int v10_2;
            if (v3_1 != 0) {
                v10_2 = (this.mHorizontalSpacing + v7);
            } else {
                v10_2 = v7;
            }
            v4 = Math.max(v8, v4);
            v1_0 -= v10_2;
            v3_1++;
            v5++;
        }
        return (v2_0 + v4);
    }

    private int getAutoLinefeedWidth(int p5)
    {
        int v0_1 = (this.getPaddingLeft() + this.getPaddingRight());
        int v1_0 = 0;
        while (v1_0 < this.getChildCount()) {
            if (v1_0 > 0) {
                v0_1 += this.mHorizontalSpacing;
            }
            v0_1 += this.getChildAt(v1_0).getMeasuredWidth();
            if (v0_1 < p5) {
                v1_0++;
            } else {
                v0_1 = p5;
                break;
            }
        }
        return v0_1;
    }

    private void layout()
    {
        com.jlboat.phone.viewgroupe.AntoLineUtil v0_0 = this;
        int v1 = this.getChildCount();
        int v2 = this.getPaddingLeft();
        int v3 = this.getPaddingTop();
        int v4_1 = ((this.getMeasuredWidth() - this.getPaddingRight()) - this.getPaddingLeft());
        int v5_2 = v4_1;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        while (v8 < v1) {
            int v12_1;
            android.view.View v9 = v0_0.getChildAt(v8);
            int v10 = v9.getMeasuredWidth();
            int v11 = v9.getMeasuredHeight();
            if (v8 != 0) {
                v12_1 = (v0_0.mHorizontalSpacing + v10);
            } else {
                v12_1 = v10;
            }
            if (v5_2 < v12_1) {
                v5_2 = v4_1;
                v3 += v7;
                if (v8 > 0) {
                    v3 += v0_0.mVerticalSpacing;
                }
                v7 = 0;
                v2 = this.getPaddingLeft();
                v6 = 0;
            }
            int v13_2;
            if (v6 != 0) {
                v13_2 = (v0_0.mHorizontalSpacing + v10);
            } else {
                v13_2 = v10;
            }
            v7 = Math.max(v7, v11);
            v9.layout(((v2 + v13_2) - v10), v3, (v2 + v13_2), (v3 + v11));
            v5_2 -= v13_2;
            v2 += v13_2;
            v6++;
            v8++;
            v0_0 = this;
        }
        return;
    }

    public int getHorizontalSpacing()
    {
        return this.mHorizontalSpacing;
    }

    public int getVerticalSpacing()
    {
        return this.mVerticalSpacing;
    }

    protected void onLayout(boolean p1, int p2, int p3, int p4, int p5)
    {
        this.layout();
        return;
    }

    protected void onMeasure(int p6, int p7)
    {
        int v0 = android.view.View$MeasureSpec.getSize(p6);
        int v1 = this.getChildCount();
        int v2_0 = 0;
        while (v2_0 < v1) {
            this.measureChild(this.getChildAt(v2_0), p6, p7);
            v2_0++;
        }
        int v2_1 = android.view.View$MeasureSpec.getMode(p6);
        if (v2_1 != 1073741824) {
            p6 = android.view.View$MeasureSpec.makeMeasureSpec(this.getAutoLinefeedWidth(v0), v2_1);
        }
        int v4_1 = android.view.View$MeasureSpec.getMode(p7);
        if (v4_1 != 1073741824) {
            p7 = android.view.View$MeasureSpec.makeMeasureSpec(this.getAutoLinefeedHeight(v0), v4_1);
        }
        super.onMeasure(p6, p7);
        return;
    }

    public void setHorizontalSpacing(int p1)
    {
        this.mHorizontalSpacing = p1;
        return;
    }

    public void setVerticalSpacing(int p1)
    {
        this.mVerticalSpacing = p1;
        return;
    }
}
