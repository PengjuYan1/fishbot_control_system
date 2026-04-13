package com.jlboat.phone.util;
public class ROSColor {
    private float alpha;
    private float blue;
    private float green;
    private float red;

    public ROSColor(float p1, float p2, float p3, float p4)
    {
        this.red = p1;
        this.green = p2;
        this.blue = p3;
        this.alpha = p4;
        return;
    }

    public static com.jlboat.phone.util.ROSColor copyOf(com.jlboat.phone.util.ROSColor p5)
    {
        return new com.jlboat.phone.util.ROSColor(p5.red, p5.green, p5.blue, p5.alpha);
    }

    public static com.jlboat.phone.util.ROSColor fromHex(String p8)
    {
        int v0 = p8.length();
        if (v0 != 6) {
            if (v0 != 8) {
                return new com.jlboat.phone.util.ROSColor(0, 0, 0, 0);
            } else {
                return new com.jlboat.phone.util.ROSColor((((float) Integer.parseInt(p8.substring(2, 4), 16)) / 1132396544), (((float) Integer.parseInt(p8.substring(4, 6), 16)) / 1132396544), (((float) Integer.parseInt(p8.substring(6), 16)) / 1132396544), (((float) Integer.parseInt(p8.substring(0, 2), 16)) / 1132396544));
            }
        } else {
            return new com.jlboat.phone.util.ROSColor((((float) Integer.parseInt(p8.substring(0, 2), 16)) / 1132396544), (((float) Integer.parseInt(p8.substring(2, 4), 16)) / 1132396544), (((float) Integer.parseInt(p8.substring(4), 16)) / 1132396544), 1065353216);
        }
    }

    public static com.jlboat.phone.util.ROSColor fromHexAndAlpha(String p5, float p6)
    {
        return new com.jlboat.phone.util.ROSColor((((float) Integer.parseInt(p5.substring(0, 2), 16)) / 1132396544), (((float) Integer.parseInt(p5.substring(2, 4), 16)) / 1132396544), (((float) Integer.parseInt(p5.substring(4), 16)) / 1132396544), p6);
    }

    public static com.jlboat.phone.util.ROSColor fromInt(int p5)
    {
        return new com.jlboat.phone.util.ROSColor((((float) ((p5 >> 16) & 255)) / 1132396544), (((float) ((p5 >> 8) & 255)) / 1132396544), (((float) (p5 & 255)) / 1132396544), (((float) ((p5 >> 24) & 255)) / 1132396544));
    }

    public void apply(javax.microedition.khronos.opengles.GL10 p5)
    {
        p5.glColor4f(this.red, this.green, this.blue, this.alpha);
        return;
    }

    public float getAlpha()
    {
        return this.alpha;
    }

    public float getBlue()
    {
        return this.blue;
    }

    public float getGreen()
    {
        return this.green;
    }

    public float getRed()
    {
        return this.red;
    }

    public com.jlboat.phone.util.ROSColor interpolate(com.jlboat.phone.util.ROSColor p7, float p8)
    {
        return new com.jlboat.phone.util.ROSColor((((p7.red - this.red) * p8) + this.red), (((p7.green - this.green) * p8) + this.green), (((p7.blue - this.blue) * p8) + this.blue), (((p7.alpha - this.alpha) * p8) + this.alpha));
    }

    public void setAlpha(float p1)
    {
        this.alpha = p1;
        return;
    }

    public void setBlue(float p1)
    {
        this.blue = p1;
        return;
    }

    public void setGreen(float p1)
    {
        this.green = p1;
        return;
    }

    public void setRed(float p1)
    {
        this.red = p1;
        return;
    }

    public int toInt()
    {
        return (((((((int) (this.alpha * 1132396544)) << 24) & -16777216) | ((((int) (this.red * 1132396544)) << 16) & 16711680)) | ((((int) (this.green * 1132396544)) << 8) & 65280)) | (((int) (this.blue * 1132396544)) & 255));
    }

    public String toString()
    {
        return new StringBuilder().append("Color = R:").append(this.red).append(" B:").append(this.blue).append(" G:").append(this.green).append(" A:").append(this.alpha).toString();
    }
}
