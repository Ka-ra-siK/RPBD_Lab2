package salon;

import java.util.Collection;
import java.util.List;

public class Clients {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    private List<OrderDate> orderDatesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (id != clients.id) return false;
        if (name != null ? !name.equals(clients.name) : clients.name != null) return false;
        if (surname != null ? !surname.equals(clients.surname) : clients.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(clients.patronymic) : clients.patronymic != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(clients.phoneNumber) : clients.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    public List<OrderDate> getOrderDatesById() {
        return orderDatesById;
    }

    public void setOrderDatesById(List<OrderDate> orderDatesById) {
        this.orderDatesById = orderDatesById;
    }

    @Override
    public String toString() {

        String date = "Date: ";
        int i = 1;
        for (OrderDate orderDate :
                orderDatesById) {
            date += orderDate.getOrderDate();
            i += 1;
        }

        return surname +
                " " + name +
                " " + patronymic +
                ", " + phoneNumber +
                ", " + date;
    }
}
