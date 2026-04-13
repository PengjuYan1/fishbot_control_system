package com.jlboat.phone.view;
 class PathItemchangeNamePopup$1 implements android.text.TextWatcher {
    final synthetic com.jlboat.phone.view.PathItemchangeNamePopup this$0;

    PathItemchangeNamePopup$1(com.jlboat.phone.view.PathItemchangeNamePopup p1)
    {
        this.this$0 = p1;
        return;
    }

    public void afterTextChanged(android.text.Editable p3)
    {
        this.this$0.newName = p3.toString();
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
