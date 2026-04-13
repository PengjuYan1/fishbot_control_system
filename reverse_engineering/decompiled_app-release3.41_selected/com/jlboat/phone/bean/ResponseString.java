package com.jlboat.phone.bean;
public class ResponseString {
    private String type;
    private String value;

    public ResponseString()
    {
        return;
    }

    public String getType()
    {
        return this.type;
    }

    public String getValue()
    {
        return this.value;
    }

    public void setType(String p1)
    {
        this.type = p1;
        return;
    }

    public void setValue(String p1)
    {
        this.value = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("ResponseString{, value=").append(this.value).append(", type=").append(this.type).append(125).toString();
    }
}
