package BankingSystem;

import java.util.*;

public class BankingSystem {

    static ArrayList<Client> allClients = new ArrayList<>();
    static ArrayList<BankAccount> allAccounts = new ArrayList<>();
    static Scanner input = new Scanner(System.in);


    static void showAllAccounts() {
        for (int i = 0; i < allAccounts.size(); i++) {
            allAccounts.get(i).view();
            System.out.println("/*******************************************/");
        }
    }

    static void searchForAccount() {
        System.out.println("please enter account ID");
        int id = input.nextInt();
        int index = search(id);
        if (index == -1) {
            System.out.println("error...account not found");
            return;
        }
        allAccounts.get(index).view();
    }

    static boolean deleteAccount() {
        System.out.println("please enter account ID");
        int id = input.nextInt();
        int index = search(id);
        if (index == -1) {
            System.out.println("error...account not found");
            return false;
        }

        allAccounts.get(index).setOwner(null);
        allClients.get(index).setAccount(null);
        
        allAccounts.remove(index);
        allClients.remove(index);
        return true;
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
        System.out.println("Enter the amount of money you want to deposit");
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
    
    private static void addAccount() {
        input.nextLine();
        System.out.println("Enter Name of Client :");
        String clientName=input.nextLine();
        System.out.println("Enter Address of Client :");
        String clientAddress=input.nextLine();
        System.out.println("Enter Phone of Client :");
        String clientPhone=input.nextLine();
        
        Client client=new Client(clientName, clientAddress, clientPhone);
        System.out.println("1-Basic Bank Account\n2-Saving BankAccount");
        
        BankAccount account=null;
        
        double balance=0;
        int option=input.nextInt();
        
        switch(option)
        {
            case 1:
            {
                System.out.println("Enter the amount of money ");
                balance=input.nextDouble();
                account=new BankAccount(balance);
                break;
            }
            case 2:
            {
                System.out.println("Enter the amount of money considering minimum balance takes a default value of (1000 L.E)");
                balance=input.nextDouble();
                account=new SavingsBankAccount(balance);
                break;
            }
            default:
            {
                System.out.println("Enter Valid Number ");
            }
        }
        
        client.setAccount(account);
        account.setOwner(client);
        
        allClients.add(client);
        allAccounts.add(account);
    }

    public static void main(String[] args) {
        dummyData();
        while (true) {
            System.out.println("1- add Account");
            System.out.println("2- search for account");
            System.out.println("3- show all accounts");
            System.out.println("4- remove account");
            System.out.println("5- deposit");
            System.out.println("6- withdraw");
            System.out.println("7- exit");

            int option = input.nextInt();
            switch (option) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    searchForAccount();
                    break;
                case 3:
                    showAllAccounts();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    deposit();
                    break;
                case 6:
                    withdraw();
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }
    }

    private static void dummyData() {
        for(int i=0;i<10;i++)
        {
            BankAccount acc=new BankAccount(1000*i);
            Client c1=new Client("client "+i , "address "+i, "012234"+i);
            
            c1.setAccount(acc);
            acc.setOwner(c1);
            
            allClients.add(c1);
            allAccounts.add(acc);
        }
    }

}
