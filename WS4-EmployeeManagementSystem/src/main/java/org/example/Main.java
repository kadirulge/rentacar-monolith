package org.example;


public class Main {
    public static void main(String[] args) {
        Engineer engineer = new Engineer("Kadir", "IT", 25000, "full stack");
        Manager manager = new Manager("Kaan", "IT", 20000, 1200000);
        Executive executive = new Executive("Engin", "IT", 50000, 10000);

        Notification[] notifications = {new EmailNotification(), new SmsNotification()};
        Employee[] employees = {engineer, manager, executive};

        EmployeeManager employeeManager = new EmployeeManager(notifications);

        employeeManager.addMultiple(employees);


    }
}