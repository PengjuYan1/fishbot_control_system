package com.jlboat.phone.view;
public class SonarView extends android.view.View {
    private android.graphics.Paint circle;
    boolean hasdata;
    java.util.List ints;
    private float left_angel;
    private float leftm_angel;
    private android.graphics.Paint mLinePaint;
    private android.graphics.Paint pa;
    private float right_angel;
    private float rightm_angel;
    private int sonar_max;
    private com.boat.jrosbridge.Topic tfSubscriber;
    private String topicName;

    public SonarView(android.content.Context p2)
    {
        super(p2);
        super.hasdata = 0;
        super.sonar_max = 200;
        super.left_angel = 1043511490;
        super.leftm_angel = 1063216883;
        super.right_angel = 1077797966;
        super.rightm_angel = 1074869790;
        super.ints = new java.util.concurrent.CopyOnWriteArrayList();
        super.topicName = "";
        return;
    }

    public SonarView(android.content.Context p2, android.util.AttributeSet p3)
    {
        super(p2, p3);
        super.hasdata = 0;
        super.sonar_max = 200;
        super.left_angel = 1043511490;
        super.leftm_angel = 1063216883;
        super.right_angel = 1077797966;
        super.rightm_angel = 1074869790;
        super.ints = new java.util.concurrent.CopyOnWriteArrayList();
        super.topicName = "";
        super.init();
        return;
    }

    public SonarView(android.content.Context p2, android.util.AttributeSet p3, int p4)
    {
        super(p2, p3, p4);
        super.hasdata = 0;
        super.sonar_max = 200;
        super.left_angel = 1043511490;
        super.leftm_angel = 1063216883;
        super.right_angel = 1077797966;
        super.rightm_angel = 1074869790;
        super.ints = new java.util.concurrent.CopyOnWriteArrayList();
        super.topicName = "";
        return;
    }

    private void init()
    {
        this.mLinePaint = new android.graphics.Paint(1);
        this.mLinePaint.setColor(this.getResources().getColor(2131034165));
        this.mLinePaint.setStrokeWidth(1077936128);
        this.mLinePaint.setTextSize(1106247680);
        this.circle = new android.graphics.Paint();
        this.pa = new android.graphics.Paint();
        this.circle.setColor(this.getResources().getColor(2131034162));
        return;
    }

    protected void onDraw(android.graphics.Canvas p33)
    {
        void v32_1 = super.onDraw(p33);
        int v8_1 = v32_1.getWidth();
        String v9_1 = v32_1.getHeight();
        int v10 = (v8_1 / 2);
        int v11_5 = (v9_1 / 2);
        int v12_2 = (v10 - 20);
        this.pa.setColor(-16711936);
        this.pa.setAntiAlias(1);
        this.pa.setStyle(android.graphics.Paint$Style.STROKE);
        this.pa.setStrokeWidth(1077936128);
        p33.drawCircle(((float) v10), ((float) v11_5), ((float) v12_2), this.pa);
        int v14_11 = new android.graphics.Path();
        v14_11.moveTo(((float) v10), ((float) (v11_5 - 50)));
        v14_11.lineTo(((float) (v10 - 20)), ((float) (v11_5 + 30)));
        v14_11.lineTo(((float) (v10 + 20)), ((float) (v11_5 + 30)));
        v14_11.close();
        p33.drawPath(v14_11, this.circle);
        if (!this.hasdata) {
            String v20 = v9_1;
            int v17 = v14_11;
        } else {
            android.graphics.Paint v6_21 = ((int) (((double) v10) - (Math.cos(((double) this.left_angel)) * ((double) ((((Integer) this.ints.get(2)).intValue() * v12_2) / this.sonar_max)))));
            int v13_17 = ((int) (((double) v11_5) - (Math.sin(((double) this.left_angel)) * ((double) ((((Integer) this.ints.get(2)).intValue() * v12_2) / this.sonar_max)))));
            String v15_3 = v6_21;
            p33.drawLine(((float) v10), ((float) v11_5), ((float) v6_21), ((float) v13_17), this.mLinePaint);
            p33.drawCircle(((float) v15_3), ((float) v13_17), 1088421888, this.circle);
            p33.drawText(new StringBuilder().append(v32_1.getResources().getString(2131493187)).append("(").append(this.ints.get(2)).append(")").toString(), ((float) ((int) (((double) v10) - (Math.cos(((double) this.left_angel)) * ((double) v12_2))))), ((float) ((int) (((double) v11_5) - (Math.sin(((double) this.left_angel)) * ((double) v12_2))))), this.mLinePaint);
            String v15_0 = ((int) (((double) v10) - (Math.cos(((double) this.leftm_angel)) * ((double) ((((Integer) this.ints.get(4)).intValue() * v12_2) / this.sonar_max)))));
            android.graphics.Paint v6_3 = ((int) (((double) v11_5) - (Math.sin(((double) this.leftm_angel)) * ((double) ((((Integer) this.ints.get(4)).intValue() * v12_2) / this.sonar_max)))));
            int v14_8 = v6_3;
            p33.drawLine(((float) v10), ((float) v11_5), ((float) v15_0), ((float) v6_3), this.mLinePaint);
            p33.drawCircle(((float) v15_0), ((float) v14_8), 1088421888, this.circle);
            int v21 = v14_8;
            p33.drawText(new StringBuilder().append(v32_1.getResources().getString(2131493188)).append("(").append(this.ints.get(4)).append(")").toString(), ((float) ((int) (((double) v10) - (Math.cos(((double) this.leftm_angel)) * ((double) v12_2))))), ((float) ((int) (((double) v11_5) - (Math.sin(((double) this.leftm_angel)) * ((double) v12_2))))), this.mLinePaint);
            int v13_5 = (v10 - 10);
            android.graphics.Paint v6_6 = (v11_5 - ((((Integer) this.ints.get(0)).intValue() * v12_2) / this.sonar_max));
            int v14_10 = v6_6;
            p33.drawLine(((float) (v10 - 10)), ((float) (v11_5 - 5)), ((float) v13_5), ((float) v6_6), this.mLinePaint);
            p33.drawCircle(((float) v13_5), ((float) v14_10), 1088421888, this.circle);
            p33.drawText(new StringBuilder().append(v32_1.getResources().getString(2131493186)).append("(").append(this.ints.get(0)).append(")").toString(), ((float) (v10 - 90)), 1108082688, this.mLinePaint);
            float v5_21 = (v10 + 10);
            android.graphics.Paint v4_13 = (v11_5 - ((((Integer) this.ints.get(1)).intValue() * v12_2) / this.sonar_max));
            int v14_12 = v4_13;
            int v25_1 = v8_1;
            int v8_0 = v5_21;
            int v27 = v11_5;
            p33.drawLine(((float) (v10 + 10)), ((float) (v11_5 - 5)), ((float) v5_21), ((float) v4_13), this.mLinePaint);
            p33.drawCircle(((float) v8_0), ((float) v14_12), 1088421888, this.circle);
            p33.drawText(new StringBuilder().append(v32_1.getResources().getString(2131493191)).append("(").append(this.ints.get(1)).append(")").toString(), ((float) (v10 + 30)), 1108082688, this.mLinePaint);
            int v13_7 = ((int) (((double) v10) - (Math.cos(((double) this.right_angel)) * ((double) ((((Integer) this.ints.get(3)).intValue() * v12_2) / this.sonar_max)))));
            android.graphics.Paint v6_12 = v27;
            int v23_1 = v12_2;
            int v11_4 = ((int) (((double) v6_12) - (Math.sin(((double) this.right_angel)) * ((double) ((((Integer) this.ints.get(3)).intValue() * v12_2) / this.sonar_max)))));
            int v8_2 = v6_12;
            p33.drawLine(((float) v10), ((float) v6_12), ((float) v13_7), ((float) v11_4), this.mLinePaint);
            p33.drawCircle(((float) v13_7), ((float) v11_4), 1088421888, this.circle);
            int v12_1 = v23_1;
            p33.drawText(new StringBuilder().append(v32_1.getResources().getString(2131493189)).append("(").append(this.ints.get(3)).append(")").toString(), ((float) (((int) (((double) v10) - (Math.cos(((double) this.right_angel)) * ((double) v12_1)))) - 125)), ((float) ((int) (((double) v8_2) - (Math.sin(((double) this.right_angel)) * ((double) v12_1))))), this.mLinePaint);
            int v14_13 = ((int) (((double) v10) - (Math.cos(((double) this.rightm_angel)) * ((double) ((((Integer) this.ints.get(5)).intValue() * v12_1) / this.sonar_max)))));
            android.graphics.Paint v6_16 = ((int) (((double) v8_2) - (Math.sin(((double) this.rightm_angel)) * ((double) ((((Integer) this.ints.get(5)).intValue() * v12_1) / this.sonar_max)))));
            int v13_11 = v6_16;
            p33.drawLine(((float) v10), ((float) v8_2), ((float) v14_13), ((float) v6_16), this.mLinePaint);
            p33.drawCircle(((float) v14_13), ((float) v13_11), 1088421888, this.circle);
            int v28 = v14_13;
            p33.drawText(new StringBuilder().append(v32_1.getResources().getString(2131493190)).append("(").append(this.ints.get(5)).append(")").toString(), ((float) (((int) (((double) v10) - (Math.cos(((double) this.rightm_angel)) * ((double) v12_1)))) - 60)), ((float) ((int) (((double) v8_2) - (Math.sin(((double) this.rightm_angel)) * ((double) v12_1))))), this.mLinePaint);
            int v13_14 = (v25_1 / 2);
            android.graphics.Paint v6_18 = (v8_2 + ((((Integer) this.ints.get(6)).intValue() * v12_1) / this.sonar_max));
            int v14_15 = v6_18;
            p33.drawLine(((float) v10), ((float) v8_2), ((float) v13_14), ((float) v6_18), this.mLinePaint);
            p33.drawCircle(((float) v13_14), ((float) v14_15), 1088421888, this.circle);
            p33.drawText(new StringBuilder().append(v32_1.getResources().getString(2131493185)).append("(").append(this.ints.get(6)).append(")").toString(), ((float) (v10 + 10)), ((float) ((v8_2 * 2) - 20)), this.mLinePaint);
        }
        return;
    }

    public void onStart()
    {
        this.tfSubscriber = new com.boat.jrosbridge.Topic("/sonar_actual", com.boat.jrosbridge.message.std_msgs.Float32MultiArray, com.jlboat.phone.application.BoatSlamApplication.client);
        this.tfSubscriber.subscribe(new com.jlboat.phone.view.SonarView$1(this));
        return;
    }

    public void onStop()
    {
        this.tfSubscriber.unsubscribe();
        return;
    }

    public void setDataList(java.util.List p5)
    {
        if (!this.ints.isEmpty()) {
            this.ints.clear();
        }
        int v0_6 = p5.iterator();
        while (v0_6.hasNext()) {
            this.ints.add(Integer.valueOf(((int) ((Float) v0_6.next()).floatValue())));
        }
        if (this.ints.size() >= 7) {
            this.hasdata = 1;
            this.invalidate();
            return;
        } else {
            return;
        }
    }
}
