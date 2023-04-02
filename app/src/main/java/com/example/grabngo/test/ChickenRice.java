package com.example.grabngo.test;

import java.math.BigDecimal;

/** Details about concrete class ChickenRice
 * Attributes from FoodV2: foodName, foodId, basePrice, stallName
 * Additional attributes: isAddMeat, isAddEgg, isAddTofu
 *
 * NOTE:
 *      1. added the add on prices to test the getting total price function
 *      2. added a method to calculate the net price of the food item
 *
 * Constructor is from ChickenRiceBuilder
 * The relationship with other classes is as follows FoodV2 <-- ChickenRice <-- SteamedChickenRice/RoastedChickenRice
 * Notation: superclass <-- subclass
 *
 * Java concept: Builder class
 *
 */

public class ChickenRice extends FoodV2 {

    // Builder attributes
    private boolean isAddMeat;
    private boolean isAddEgg;
    private boolean isAddTofu;

    private final double eggPrice = 0.80;
    private final double meatPrice = 1.00;
    private final double tofuPrice = 0.40;

    private double netPrice;

    public BigDecimal getNetPrice() {
        netPrice = super.getBasePrice();
        if (this.isAddEgg()) {
            netPrice = netPrice + this.getEggPrice();
        }

        if (this.isAddTofu()) {
            netPrice = netPrice + this.getTofuPrice();
        }

        if (this.isAddMeat()) {
            netPrice = netPrice + this.getMeatPrice();
        }
        BigDecimal netPriceBD = new BigDecimal(netPrice);
        return netPriceBD.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public double getEggPrice() {
        return eggPrice;
    }

    public double getMeatPrice() {
        return meatPrice;
    }

    public double getTofuPrice() {
        return tofuPrice;
    }

    // Constructor
    public ChickenRice(ChickenRiceBuilder chickenRiceBuilder) {
        super("Chicken Rice", 0, 4.00, "Stall-Chicken Rice");

        this.isAddMeat = chickenRiceBuilder.isAddMeat;
        this.isAddEgg = chickenRiceBuilder.isAddEgg;
        this.isAddTofu = chickenRiceBuilder.isAddTofu;
        this.setFoodName("Chicken Rice-test"); //Somehow this can update the foodname, but in RoastedChickenRice the setFoodName doesnt work
    }


    public boolean isAddMeat() {
        return isAddMeat;
    }

    public boolean isAddEgg() {
        return isAddEgg;
    }

    public boolean isAddTofu() {
        return isAddTofu;
    }


    abstract static class ChickenRiceBuilder {
        public ChickenRiceBuilder() {
        }

        private boolean isAddMeat;
        private boolean isAddEgg;
        private boolean isAddTofu;


        public ChickenRiceBuilder setAddMeat(boolean addMeat) {
            this.isAddMeat = addMeat;
            return this;
        }

        public ChickenRiceBuilder setAddEgg(boolean addEgg) {
            this.isAddEgg = addEgg;
            return this;
        }

        public ChickenRiceBuilder setAddTofu(boolean addTofu) {
            this.isAddTofu = addTofu;
            return this;
        }

        public ChickenRice build(){
            return new ChickenRice(this);
        }
    }
}
