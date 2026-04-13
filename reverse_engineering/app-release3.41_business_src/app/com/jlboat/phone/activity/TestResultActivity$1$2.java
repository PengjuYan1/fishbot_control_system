package com.jlboat.phone.activity;
 class TestResultActivity$1$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.TestResultActivity$1 this$1;
    final synthetic boolean val$finalIsEnd;
    final synthetic java.util.List val$resultEntries;

    TestResultActivity$1$2(com.jlboat.phone.activity.TestResultActivity$1 p1, java.util.List p2, boolean p3)
    {
        this.this$1 = p1;
        this.val$resultEntries = p2;
        this.val$finalIsEnd = p3;
        return;
    }

    public void run()
    {
        com.jlboat.phone.activity.TestResultActivity.access$500(this.this$1.this$0).setData2(com.jlboat.phone.activity.TestResultActivity.access$100(this.this$1.this$0));
        com.jlboat.phone.activity.TestResultActivity.access$500(this.this$1.this$0).setData(this.val$resultEntries);
        android.util.Log.d("TestResultActivity", new StringBuilder().append("localMapList2:").append(com.jlboat.phone.activity.TestResultActivity.access$100(this.this$1.this$0)).toString());
        if (!this.val$finalIsEnd) {
            com.jlboat.phone.activity.TestResultActivity.access$600(this.this$1.this$0).setVisibility(0);
        } else {
            com.jlboat.phone.activity.TestResultActivity.access$600(this.this$1.this$0).setVisibility(8);
        }
        com.jlboat.phone.activity.TestResultActivity.access$700(this.this$1.this$0).setText(com.jlboat.phone.activity.TestResultActivity.access$000(this.this$1.this$0));
        return;
    }
}
