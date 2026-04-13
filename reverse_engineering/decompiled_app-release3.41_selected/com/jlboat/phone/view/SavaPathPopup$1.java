package com.jlboat.phone.view;
 class SavaPathPopup$1 implements android.text.TextWatcher {
    final synthetic com.jlboat.phone.view.SavaPathPopup this$0;

    SavaPathPopup$1(com.jlboat.phone.view.SavaPathPopup p1)
    {
        this.this$0 = p1;
        return;
    }

    public void afterTextChanged(android.text.Editable p3)
    {
        this.this$0.pathName = p3.toString().trim();
        return;
    }

    public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }

    public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }
}
