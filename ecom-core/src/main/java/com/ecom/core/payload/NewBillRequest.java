package com.ecom.core.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewBillRequest {
    @JsonProperty("customer_code")
    private String customerCode;

    @JsonProperty("customer_name")
    private String customerName;

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
