package com.shopingcart.discountcalculator;

import com.shopingcart.discountcalculator.calculation.CalculationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DiscountCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscountCalculatorApplication.class, args);
        CalculationService calculationService = new CalculationService();

        //Sample Test cases
        List<Double> billingAmounts = new ArrayList<>();
        billingAmounts.add(calculationService.getBillAmount(5000.0,  "Regular"));
        billingAmounts.add(calculationService.getBillAmount(10000.0, "Regular"));
        billingAmounts.add(calculationService.getBillAmount(15000.0, "Regular"));
        billingAmounts.add(calculationService.getBillAmount(4000.0, "Premium"));
        billingAmounts.add(calculationService.getBillAmount(8000.0, "Premium"));
        billingAmounts.add(calculationService.getBillAmount(12000.0, "Premium"));
        billingAmounts.add(calculationService.getBillAmount(20000.0, "Premium"));

        System.out.println(billingAmounts);
    }

}
