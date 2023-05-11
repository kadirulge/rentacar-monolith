package org.example;

public class RestaurantOrder {
    private  int orderId;
    private String customerName;
    private double totalPrice;
    private boolean isDelivery;
    private boolean isPaid;

public RestaurantOrder(int orderId, String customerName, double totalPrice, boolean isDelivery, boolean isPaid) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.isDelivery = isDelivery;
        this.isPaid = isPaid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void makePayment(){
        if (!isPaid){
            System.out.println("Payment is made");
            isPaid = true;
        }else{
            System.out.println("Payment is already made");
        }
    }

    public void cancelOrder(){
    if (!isPaid){
            System.out.println("Siparis bulunamadi");
        }else{
            isPaid = false;
            totalPrice = 0;
            System.out.println("siparis iptal edildi");
        }

    }

    public void viewOrderDetails(){
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Is Delivery: " + isDelivery);
        System.out.println("Is Paid: " + isPaid);
    }

    public void processOrder() {
        if (isDelivery) {
            System.out.println("Order is being delivered");
        } else {
            System.out.println("Order is ready for pickup");
        }
    }




}
