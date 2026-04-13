package com.jlboat.phone.view;
 class JoystickView$1 extends java.util.TimerTask {
    final synthetic com.jlboat.phone.view.JoystickView this$0;

    JoystickView$1(com.jlboat.phone.view.JoystickView p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        if (com.jlboat.phone.view.JoystickView.access$000(this.this$0)) {
            com.jlboat.phone.view.JoystickView.access$200(this.this$0).publish(com.jlboat.phone.view.JoystickView.access$100(this.this$0));
        }
        return;
    }
}
