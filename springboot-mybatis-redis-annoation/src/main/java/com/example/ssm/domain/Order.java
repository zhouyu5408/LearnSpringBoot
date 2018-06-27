package com.example.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderId;

    private Date orderStartTime;

    private String userId;

    private String commodityId;

    private Integer orderNumber;

    private Integer orderTotalPrices;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Date orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId == null ? null : commodityId.trim();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderTotalPrices() {
        return orderTotalPrices;
    }

    public void setOrderTotalPrices(Integer orderTotalPrices) {
        this.orderTotalPrices = orderTotalPrices;
    }
}