package BankingSystem;
public class Client implements Viewer {
    String name;
    String address;
    String phone;
    BankAccount account;
    
    public Client(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
    

    @Override
    public void view() {
        System.out.println("Client Name " + name);
        System.out.println("Client Address : " + address);
        System.out.println("Client Phone : " + phone);
        //System.out.println("Account id : "+account.accountId);
    }

}
