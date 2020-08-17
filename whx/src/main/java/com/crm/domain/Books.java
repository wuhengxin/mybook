package com.crm.domain;

/**
 * @program: CRM
 * @description:Books实体类
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public class Books {
    /**
     * 图书id
     */
    private Long bId;

    /**
     * 图书名称
     */
    private String bName;

    /**
     * 图书数量
     */
    private String bAccount;

    /**
     * 图书相关描述信息
     */
    private String bDescribe;

    /**
     * 图书状态: 1为上架，0为下架
     */
    private Integer bState;

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAccount() {
        return bAccount;
    }

    public void setbAccount(String bAccount) {
        this.bAccount = bAccount;
    }

    public String getbDescribe() {
        return bDescribe;
    }

    public void setbDescribe(String bDescribe) {
        this.bDescribe = bDescribe;
    }

    public Integer getbState() {
        return bState;
    }

    public void setbState(Integer bState) {
        this.bState = bState;
    }

    public Books() {
    }

    public Books(Long bId, String bName, String bAccount, String bDescribe, Integer bState) {
        this.bId = bId;
        this.bName = bName;
        this.bAccount = bAccount;
        this.bDescribe = bDescribe;
        this.bState = bState;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                ", bAccount='" + bAccount + '\'' +
                ", BDescribe='" + bDescribe + '\'' +
                ", bState=" + bState +
                '}';
    }
}
