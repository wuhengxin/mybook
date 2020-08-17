package com.crm.domain;

/**
 * @program: CRM
 * @description: Position实体类
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public class Position {

    /**
     * 职位id
     */
    private Long id;

    /**
     *芝麻名称
     */
    private String positionname;

    /**
     *职位描述
     */
    private String positionmsg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname == null ? null : positionname.trim();
    }

    public String getPositionmsg() {
        return positionmsg;
    }

    public void setPositionmsg(String positionmsg) {
        this.positionmsg = positionmsg == null ? null : positionmsg.trim();
    }


    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionname='" + positionname + '\'' +
                ", positionmsg='" + positionmsg + '\'' +
                '}';
    }
}