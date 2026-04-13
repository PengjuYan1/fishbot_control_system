package com.jlboat.phone.view;
 class SavaPathPopup$typeRgChangeListener implements android.widget.RadioGroup$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.view.SavaPathPopup this$0;

    SavaPathPopup$typeRgChangeListener(com.jlboat.phone.view.SavaPathPopup p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(android.widget.RadioGroup p4, int p5)
    {
        switch (p4.getId()) {
            case 2131231090:
                switch (p5) {
                    case 2131231089:
                        this.this$0.pathType = 0;
                        break;
                    case 2131231093:
                        this.this$0.pathType = 1;
                        break;
                    case 2131231094:
                        this.this$0.pathType = 2;
                        break;
                    default:
                }
                break;
            case 2131231091:
            default:
                break;
            case 2131231092:
                switch (p5) {
                    case 2131230775:
                        this.this$0.directional = 0;
                        break;
                    case 2131231343:
                        this.this$0.directional = 1;
                        break;
                    default:
                }
                break;
        }
        return;
    }
}
