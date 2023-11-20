package com.alfastore.interaksi2deviceaplikasi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelAPI {
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("android_id")
    @Expose
    private String androidId;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("store_id")
    @Expose
    private String storeId;
    @SerializedName("store_name")
    @Expose
    private String storeName;
    @SerializedName("date_tx")
    @Expose
    private String dateTx;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("member")
    @Expose
    private String member;
    @SerializedName("trans_detail")
    @Expose
    private List<TransDetail> transDetail;
    @SerializedName("order_time")
    @Expose
    private String orderTime;
    @SerializedName("pay_time")
    @Expose
    private String payTime;
    @SerializedName("done_time")
    @Expose
    private String doneTime;
    @SerializedName("taken_time")
    @Expose
    private String takenTime;
    @SerializedName("sync_time")
    @Expose
    private String syncTime;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDateTx() {
        return dateTx;
    }

    public void setDateTx(String dateTx) {
        this.dateTx = dateTx;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public List<TransDetail> getTransDetail() {
        return transDetail;
    }

    public void setTransDetail(List<TransDetail> transDetail) {
        this.transDetail = transDetail;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(String doneTime) {
        this.doneTime = doneTime;
    }

    public String getTakenTime() {
        return takenTime;
    }

    public void setTakenTime(String takenTime) {
        this.takenTime = takenTime;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public class TransDetail{
        @SerializedName("descp")
        @Expose
        private String descp;
        @SerializedName("qty")
        @Expose
        private Integer qty;
        @SerializedName("remark")
        @Expose
        private String remark;
        @SerializedName("time_entry")
        @Expose
        private String timeEntry;
        @SerializedName("done")
        @Expose
        private String done;

        public String getDescp() {
            return descp;
        }

        public void setDescp(String descp) {
            this.descp = descp;
        }

        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getTimeEntry() {
            return timeEntry;
        }

        public void setTimeEntry(String timeEntry) {
            this.timeEntry = timeEntry;
        }

        public String getDone() {
            return done;
        }

        public void setDone(String done) {
            this.done = done;
        }
    }
}
