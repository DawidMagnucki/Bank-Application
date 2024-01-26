package pl.dmagnuckibankapp.ui;

import java.util.Scanner;

public class UserLoginOptions {
    static boolean loggedIn = false;


    public class LoginPage {
        public static void getLoginPage() {
            System.out.println("1. Login");

        }
    }

    public static class LogoutPage {
        public static void logout() {
            if (!loggedIn) {
                System.out.println("1. Logout");
            }
        }
    }

    public static int getUserInput() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
