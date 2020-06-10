package BankingSystem;
public class Client implements Viewer {
    String name;
    String address;
    String phone;
    
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

    @Override
    public void view() {
        System.out.println("name " + name);
        System.out.println("address : " + address);
        System.out.println("phone : " + phone);
    }

}