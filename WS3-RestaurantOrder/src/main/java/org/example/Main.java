package org.example;

public class Main {
    public static void main(String[] args) {
        RestaurantOrder restaurantOrder = new RestaurantOrder(1, "John", 100.0, true, false);
        restaurantOrder.viewOrderDetails();
        restaurantOrder.makePayment();
        restaurantOrder.viewOrderDetails();
        restaurantOrder.processOrder();
        restaurantOrder.cancelOrder();
        restaurantOrder.viewOrderDetails();
    }
}