package com.emora.domain;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 10:43
 */
public class Orders {
    private Integer id;
    private String orderNum;
    private String orderTime;
    private Integer peopleCount;
    private String oderDesc;
    private Integer payType;
    private Integer oderStatus;
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOderDesc() {
        return oderDesc;
    }

    public void setOderDesc(String oderDesc) {
        this.oderDesc = oderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOderStatus() {
        return oderStatus;
    }

    public void setOderStatus(Integer oderStatus) {
        this.oderStatus = oderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
