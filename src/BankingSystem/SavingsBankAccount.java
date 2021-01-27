package BankingSystem;

public class SavingsBankAccount extends BankAccount {

    double minimumBalance;

    public SavingsBankAccount(double minimumBalance, double balance) {
        this.minimumBalance = minimumBalance;
        accountId = IDS_GENERATOR++;
        if (balance >= minimumBalance) {
            super.balance = balance;
        } else {
            System.out.println(" The minimum of amount should be greater than Minimum Balance ");
        }
    }

    public SavingsBankAccount(double balance) {
        minimumBalance = 1000;
        accountId = IDS_GENERATOR++;
        if (balance >= minimumBalance) {
            super.balance = balance;
        } else {
            System.out.println(" The minimum of amount should be greater than Minimum Balance ");
        }
    }

    public SavingsBankAccount() {
        super(1000);
        minimumBalance = 1000;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("error....invalid input");
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public boolean deposit(double amountOfMoney) {
        if (amountOfMoney < 100) {
            System.out.println("error amount should be > 100");
            return false;
        }
        return super.deposit(amountOfMoney);
    }

    @Override
    public void view() {
        System.out.println("Savings Bank Account");
        System.out.println("account ID : " + accountId);
        System.out.println("balance : " + balance);
        System.out.println("min Balance : " + minimumBalance);
        owner.view();
    }

}
