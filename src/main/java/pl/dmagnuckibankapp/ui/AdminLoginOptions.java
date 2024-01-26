package pl.dmagnuckibankapp.ui;

import java.util.Scanner;

public class AdminLoginOptions {
    static boolean loggedIn = false;

    public class LoginPage {
        public static void getLoginPage() {
            System.out.println("1. Login");
            System.out.println("2. Register New Admin Account");
        }
    }

    public static class AdminMenuPage {
        public static void getAdminMenuOptions() {
            if (!loggedIn) {
                System.out.println("1. Manage Your Account");
                System.out.println("2. Create New Client Account");
                System.out.println("3. Update Existing Client Account");
                System.out.println("4. Delete Existing Client Account");
                System.out.println("5. Logout");
            }
        }
    }

    public static int getUserInput() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

