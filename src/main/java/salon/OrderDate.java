package salon;

import java.sql.Date;

public class OrderDate {
    private Date orderDate;
    private Clients clientsByClientId;
    private Order orderByOrderId;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDate orderDate1 = (OrderDate) o;

        if (orderDate != null ? !orderDate.equals(orderDate1.orderDate) : orderDate1.orderDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }

    public Clients getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(Clients clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
