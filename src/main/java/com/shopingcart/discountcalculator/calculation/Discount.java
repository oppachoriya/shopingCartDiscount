package com.shopingcart.discountcalculator.calculation;

public class Discount {
    private Double discountPercent;

    private Double startVal ;
    private Double endVal ;

    public Discount(Double discountPercent, Double startVal, Double endVal) {
        this.discountPercent = discountPercent ;
        this.startVal = startVal ;
        this.endVal = endVal  ;
    }



    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getStartVal() {
        return startVal;
    }

    public void setStartVal(Double startVal) {
        this.startVal = startVal;
    }

    public Double getEndVal() {
        return endVal;
    }

    public void setEndVal(Double endVal) {
        this.endVal = endVal;
    }
}
