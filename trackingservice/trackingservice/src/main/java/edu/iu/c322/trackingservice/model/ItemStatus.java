package edu.iu.c322.trackingservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ItemStatus", schema = "invoice")
public class ItemStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemStGen")
    @SequenceGenerator(name = "itemStGen", sequenceName = "itemStatusSeq", allocationSize = 1)
    private int orderId;


    private int itemId;

    private int getOrderId;

    private String status;

    private String date;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getGetOrderId() {
        return getOrderId;
    }

    public void setGetOrderId(int getOrderId) {
        this.getOrderId = getOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

