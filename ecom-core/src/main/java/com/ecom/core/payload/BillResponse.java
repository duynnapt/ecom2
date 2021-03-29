package com.ecom.core.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillResponse {
    private String id;
    @JsonProperty("customer_code")
    private String customerCode;

    @JsonProperty("customer_name")
    private String customerName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
