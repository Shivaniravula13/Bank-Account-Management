public class Customer extends Person {

    private String customerId;
    private Address address;

    public Customer(String name, int age,
                    String customerId, Address address) {

        super(name, age);
        this.customerId = customerId;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String getDetails() {
        return "Customer ID: " + customerId + ", Name: " + getName() +  ", Age: " + getAge() +  ", Address: " + address;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}