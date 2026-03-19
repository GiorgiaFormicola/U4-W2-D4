package GiorgiaFormicola.entities;

public class Customer {
    private static Long customersAmount = 0L;
    private Long id;
    private String name;
    private Integer tier;

    public Customer(String name, Integer tier) {
        customersAmount++;
        this.id = customersAmount;
        this.name = name;
        this.tier = tier;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
