package BankingSystem;

import java.util.*;

public class BankingSystem {

    static ArrayList<Client> allClients = new ArrayList<>();
    static ArrayList<BankAccount> allAccounts = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void View(Viewer viewer) {
        viewer.view();
    }

    static void showAllAccounts() {
        for (int i = 0; i < allAccounts.size(); i++) {
            View(allAccounts.get(i));
            System.out.println("/************************************/");
        }

    }

    static void searchForAccount() {
        System.out.println("please enter account ID");
        int id = input.nextInt();
        int index = search(id);
        if (index == -1) {
            System.out.println("error . account not found");
            return;
        }
        allAccounts.get(index).view();
    }

    static void deleteAccount() {
        System.out.println("please enter account ID");
        int id = input.nextInt();
        int index = search(id);
        if (index == -1) {
            System.out.println("error . account not found");
            return;
        }

        allAccounts.get(index).setOwner(null);
        allClients.get(index).setAccount(null);

        allAccounts.remove(index);
        allClients.remove(index);
    }

    static void withdraw() {
        System.out.println("Enter Account ID ");
        int ID = input.nextInt();
        BankAccount account = searchBankAccount(ID);
        if (account == null) {
            System.out.println("Account not Exist ");
            return;
        }
        System.out.println("Enter amount of money you need ");
        int amount = input.nextInt();
        account.withdraw(amount);
    }

    static void deposit() {
        System.out.println("Enter Account ID ");
        int ID = input.nextInt();
        BankAccount account = searchBankAccount(ID);
        if (account == null) {
            System.out.println("Account not Exist ");
            return;
        }
        System.out.println("Enter your money ");
        int amount = input.nextInt();
        account.deposit(amount);
    }

    private static BankAccount searchBankAccount(int ID) {
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).accountId == ID) {
                return allAccounts.get(i);
            }
        }
        return null;
    }

    static int search(int accountId) {
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).getAccountId() == accountId) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1- add Account");
            System.out.println("2- search for account");
            System.out.println("3- show all accounts");
            System.out.println("4- remove account");
            System.out.println("5- deposit");
            System.out.println("6- withdraw");
            System.out.println("7- exit");

            int option = input.nextInt();
            if (option == 1) {
                addAccount();
            } else if (option == 2) {
                searchForAccount();
            } else if (option == 3) {
                showAllAccounts();
            } else if (option == 4) {
                deleteAccount();
            } else if (option == 5) {
                deposit();
            } else if (option == 6) {
                withdraw();
            } else if (option == 7) {
                return;
            }
        }
    }

    private static void addAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


