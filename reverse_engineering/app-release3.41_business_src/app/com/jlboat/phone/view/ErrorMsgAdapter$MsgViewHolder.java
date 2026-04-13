package com.jlboat.phone.view;
public class ErrorMsgAdapter$MsgViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder {
    private final android.widget.TextView service_name;
    final synthetic com.jlboat.phone.view.ErrorMsgAdapter this$0;
    private String title;

    public ErrorMsgAdapter$MsgViewHolder(com.jlboat.phone.view.ErrorMsgAdapter p3, android.view.View p4)
    {
        this.this$0 = p3;
        super(p4);
        super.title = com.jlboat.phone.view.ErrorMsgAdapter.access$000(super.this$0).getResources().getString(2131493402);
        super.service_name = ((android.widget.TextView) p4.findViewById(2131231246));
        return;
    }

    public void setData(com.jlboat.phone.view.Err p4)
    {
        if ((p4.getType() <= 0) || (p4.getType() >= 10)) {
            if ((p4.getType() <= 10) || (p4.getType() > 21)) {
                if ((p4.getType() < 41) || (p4.getType() > 51)) {
                    if ((p4.getType() < 101) || (p4.getType() >= 124)) {
                        if ((p4.getType() >= 61) && (p4.getType() <= 67)) {
                            this.title = com.jlboat.phone.view.ErrorMsgAdapter.access$000(this.this$0).getResources().getString(2131493400);
                        }
                    } else {
                        this.title = com.jlboat.phone.view.ErrorMsgAdapter.access$000(this.this$0).getResources().getString(2131493399);
                    }
                } else {
                    this.title = com.jlboat.phone.view.ErrorMsgAdapter.access$000(this.this$0).getResources().getString(2131493398);
                }
            } else {
                this.title = com.jlboat.phone.view.ErrorMsgAdapter.access$000(this.this$0).getResources().getString(2131493403);
            }
        } else {
            this.title = com.jlboat.phone.view.ErrorMsgAdapter.access$000(this.this$0).getResources().getString(2131493401);
        }
        this.service_name.setText(new StringBuilder().append(this.title).append("  ").append(com.jlboat.phone.util.Utils.getCurrentTime(p4.getDa())).append("  \n").append(p4.getMsg()).toString());
        return;
    }
}
