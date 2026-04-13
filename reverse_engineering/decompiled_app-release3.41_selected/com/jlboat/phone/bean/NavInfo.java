package com.jlboat.phone.bean;
public class NavInfo {
    private String carto_version_name;
    private String coco_num;
    private String coco_num_pc;
    private String navi_channel;
    private String numero;
    private String stm32_channel;
    private String stm32_code;
    private String stm32_version_name;
    private String version_code;
    private String version_name;

    public NavInfo()
    {
        return;
    }

    public String getCarto_version_name()
    {
        return this.carto_version_name;
    }

    public String getCoco_num()
    {
        return this.coco_num;
    }

    public String getCoco_num_pc()
    {
        return this.coco_num_pc;
    }

    public String getNavi_channel()
    {
        return this.navi_channel;
    }

    public String getNumero()
    {
        return this.numero;
    }

    public String getStm32_channel()
    {
        return this.stm32_channel;
    }

    public String getStm32_code()
    {
        return this.stm32_code;
    }

    public String getStm32_version_name()
    {
        return this.stm32_version_name;
    }

    public String getVersion_code()
    {
        return this.version_code;
    }

    public String getVersion_name()
    {
        return this.version_name;
    }

    public void setCarto_version_name(String p1)
    {
        this.carto_version_name = p1;
        return;
    }

    public void setCoco_num(String p1)
    {
        this.coco_num = p1;
        return;
    }

    public void setCoco_num_pc(String p1)
    {
        this.coco_num_pc = p1;
        return;
    }

    public void setNavi_channel(String p1)
    {
        this.navi_channel = p1;
        return;
    }

    public void setNumero(String p1)
    {
        this.numero = p1;
        return;
    }

    public void setStm32_channel(String p1)
    {
        this.stm32_channel = p1;
        return;
    }

    public void setStm32_code(String p1)
    {
        this.stm32_code = p1;
        return;
    }

    public void setStm32_version_name(String p1)
    {
        this.stm32_version_name = p1;
        return;
    }

    public void setVersion_code(String p1)
    {
        this.version_code = p1;
        return;
    }

    public void setVersion_name(String p1)
    {
        this.version_name = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("NavInfo{coco_num=\'").append(this.coco_num).append(39).append(", navi_channel=\'").append(this.navi_channel).append(39).append(", version_code=\'").append(this.version_code).append(int v1_3).append(", version_name=\'").append(this.version_name).append(39).append(", stm32_version_name=\'").append(this.stm32_version_name).append(39).append(", carto_version_name=\'").append(this.carto_version_name).append(39).append(", numero=\'").append(this.numero).append(39).append(125).toString();
    }
}
