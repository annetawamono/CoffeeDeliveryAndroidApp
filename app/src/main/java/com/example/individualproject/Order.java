package com.example.individualproject;

public class Order {
    private Size size;

    public Order() {}

    public Order(Size size, Integer qty, Integer shots, String flavour) {
        this.size = size;
        this.qty = qty;
        this.shots = shots;
        this.flavour = flavour;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    private Integer qty;
    private Integer shots;
    private String flavour;

    public enum Size {
        SMALL("Small"),
        MEDIUM("Medium"),
        LARGE("Large");

        private String stringValue;
        private Size(String s) {
            stringValue = s;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }
}
