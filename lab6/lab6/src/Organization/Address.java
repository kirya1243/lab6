package Organization;

import java.io.Serializable;

public class Address implements Serializable {
    private String street; //Поле не может быть null

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}
