package com.jlboat.phone.view;
public class JoystickView extends com.jlboat.phone.view.WidgetView implements android.view.animation.Animation$AnimationListener {
    private static final float MAX_ANGULAR_SPEED = 1058642330;
    private static final float MAX_LINEAR_SPEED = 1053609165;
    public static final String TAG;
    private android.graphics.Point contactUpLocation;
    private com.boat.jrosbridge.message.geometry_msgs.Twist currentVelocityCommand;
    boolean isdiy;
    android.graphics.Paint joystickPaint;
    float joystickRadius;
    android.graphics.Paint linePaint;
    android.graphics.Paint outerPaint;
    float posX;
    float posY;
    private volatile boolean publishVelocity;
    private com.boat.jrosbridge.Topic publisher;
    private java.util.Timer publisherTimer;
    private String topicName;

    static JoystickView()
    {
        com.jlboat.phone.view.JoystickView.TAG = com.jlboat.phone.view.JoystickView.getSimpleName();
        return;
    }

    public JoystickView(android.content.Context p2)
    {
        super(p2);
        super.topicName = "/cmd_vel";
        super.init();
        return;
    }

    public JoystickView(android.content.Context p2, android.util.AttributeSet p3)
    {
        super(p2, p3);
        super.topicName = "/cmd_vel";
        super.init();
        return;
    }

    static synthetic boolean access$000(com.jlboat.phone.view.JoystickView p1)
    {
        return p1.publishVelocity;
    }

    static synthetic com.boat.jrosbridge.message.geometry_msgs.Twist access$100(com.jlboat.phone.view.JoystickView p1)
    {
        return p1.currentVelocityCommand;
    }

    static synthetic com.boat.jrosbridge.Topic access$200(com.jlboat.phone.view.JoystickView p1)
    {
        return p1.publisher;
    }

    private float[] convertFromPolarToPx(float p7, float p8)
    {
        float v0_2 = (((float) this.getWidth()) / 1073741824);
        float v2_2 = (((float) this.getHeight()) / 1073741824);
        float v1_0 = (v0_2 - this.joystickRadius);
        float[] v3_1 = new float[2];
        v3_1[0] = ((p7 * v1_0) + v0_2);
        v3_1[1] = (v2_2 - (p8 * v1_0));
        return v3_1;
    }

    private float[] convertFromPxToPolar(float p13, float p14)
    {
        float v0_2 = (((float) this.getWidth()) / 1073741824);
        float v1_0 = (v0_2 - this.joystickRadius);
        float v3 = (p13 - v0_2);
        float v4 = (p14 - (((float) this.getHeight()) / 1073741824));
        double v5_1 = Math.atan2(((double) v4), ((double) v3));
        double v7_6 = Math.min(4607182418800017408, (Math.sqrt(((double) ((v3 * v3) + (v4 * v4)))) / ((double) v1_0)));
        float[] v9_3 = new float[2];
        v9_3[0] = ((float) (Math.cos(v5_1) * v7_6));
        v9_3[1] = ((float) ((- Math.sin(v5_1)) * v7_6));
        return v9_3;
    }

    private void init()
    {
        this.joystickRadius = (com.jlboat.phone.util.Utils.cmToPx(this.getContext(), 1065353216) / 1077936128);
        this.joystickPaint = new android.graphics.Paint();
        this.joystickPaint.setColor(this.getResources().getColor(2131034205));
        this.outerPaint = new android.graphics.Paint();
        this.outerPaint.setColor(this.getResources().getColor(2131034163));
        this.outerPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.outerPaint.setStrokeWidth(com.jlboat.phone.util.Utils.dpToPx(this.getContext(), 1077936128));
        this.linePaint = new android.graphics.Paint();
        this.linePaint.setColor(this.getResources().getColor(2131034164));
        this.linePaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.linePaint.setAlpha(50);
        this.linePaint.setStrokeWidth(com.jlboat.phone.util.Utils.dpToPx(this.getContext(), 1073741824));
        this.contactUpLocation = new android.graphics.Point(0, 0);
        return;
    }

    private void moveTo(float p6, float p7)
    {
        this.posX = p6;
        this.posY = p7;
        this.posX = p6;
        this.posY = p7;
        int v0_0 = (1053609165 * p7);
        int v1_0 = ((- p6) * 1058642330);
        if (Math.abs(v0_0) < 1028443341) {
            v0_0 = 0;
        }
        if (Math.abs(v1_0) < 1028443341) {
            v1_0 = 0;
        }
        this.currentVelocityCommand.getLinear().setX(((double) v0_0));
        this.currentVelocityCommand.getLinear().setY(0);
        this.currentVelocityCommand.getLinear().setZ(0);
        this.currentVelocityCommand.getAngular().setX(0);
        this.currentVelocityCommand.getAngular().setY(0);
        this.currentVelocityCommand.getAngular().setZ(((double) v1_0));
        this.invalidate();
        return;
    }

    public void onAnimationEnd(android.view.animation.Animation p1)
    {
        return;
    }

    public void onAnimationRepeat(android.view.animation.Animation p1)
    {
        return;
    }

    public void onAnimationStart(android.view.animation.Animation p1)
    {
        return;
    }

    public void onDraw(android.graphics.Canvas p8)
    {
        super.onDraw(p8);
        float v0_1 = ((float) this.getWidth());
        float v1_1 = ((float) this.getHeight());
        float[] v2_0 = this.convertFromPolarToPx(this.posX, this.posY);
        p8.drawCircle((v0_1 / 1073741824), (v1_1 / 1073741824), ((v0_1 / 1073741824) - this.joystickRadius), this.outerPaint);
        p8.drawCircle(v2_0[0], v2_0[1], this.joystickRadius, this.joystickPaint);
        return;
    }

    public void onStart()
    {
        this.publisher = new com.boat.jrosbridge.Topic(this.topicName, com.boat.jrosbridge.message.geometry_msgs.Twist, com.jlboat.phone.application.BoatSlamApplication.client);
        this.currentVelocityCommand = new com.boat.jrosbridge.message.geometry_msgs.Twist();
        com.boat.jrosbridge.message.geometry_msgs.Vector3 v0_1 = new com.boat.jrosbridge.message.geometry_msgs.Vector3();
        com.boat.jrosbridge.message.geometry_msgs.Vector3 v1_2 = new com.boat.jrosbridge.message.geometry_msgs.Vector3();
        this.currentVelocityCommand.setLinear(v0_1);
        this.currentVelocityCommand.setAngular(v1_2);
        this.publisherTimer = new java.util.Timer();
        this.publisherTimer.schedule(new com.jlboat.phone.view.JoystickView$1(this), 0, 80);
        return;
    }

    public void onStop()
    {
        this.publisherTimer.cancel();
        this.publisherTimer.purge();
        this.publisher.unadvertise();
        return;
    }

    public boolean onTouchEvent(android.view.MotionEvent p7)
    {
        float[] v2 = this.convertFromPxToPolar(p7.getX(), p7.getY());
        switch (p7.getActionMasked()) {
            case 0:
            case 2:
                this.publishVelocity = 1;
                this.moveTo(v2[0], v2[1]);
                break;
            case 1:
                this.publishVelocity = 0;
                this.moveTo(0, 0);
                this.publisher.publish(this.currentVelocityCommand);
                break;
            default:
                return 0;
        }
        return 1;
    }

    public void setDy(boolean p1)
    {
        this.isdiy = p1;
        return;
    }

    public void setTopicName(String p1)
    {
        this.topicName = p1;
        return;
    }
}
