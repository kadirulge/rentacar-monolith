package org.example;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager(new EDevletServiceAdapter());
        userManager.register(new User(1, "12345678910", "Kadir", "Ülge", "2000"));
        userManager.register(new User(2, "12345678911", "Engin", "Demiroğ", "1995"));
        userManager.register(new User(3, "12345678912", "Jack", "Doe", "1992"));
        userManager.register(new User(4, "12345678913", "John", "Doe", "1993"));
        userManager.register(new User(5, "12345678914", "Jill", "Doe", "1994"));
    }
    // Sadece 3. kullanıcı için kontrolleri geçecek şekilde doğru veri girildi.
}

