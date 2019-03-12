package com.vodqa.ft.strategy;

public class CalculationService {
    public static double calculateShipping(double price){
        return 4.05;
    }
    public static double calculateGift(double price){
        double dPrice=price;
        return dPrice*0.01;
    }
    public static double calculateSalesTax(double price,String country){
        return (price+calculateShipping(price)+calculateGift(price))*0.1;
    }
    public static double calculateVatTax(double price,String country){
        return (price+calculateShipping(price)+calculateGift(price))*0.05;
    }
}
