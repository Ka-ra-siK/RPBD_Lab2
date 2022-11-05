package salon;

import java.util.Collection;
import java.util.List;

public class Order {
    private int id;
    private String serviceName;
    private Integer servicePrice;
    private Masters mastersByMasterId;
    private List<OrderDate> orderDatesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (serviceName != null ? !serviceName.equals(order.serviceName) : order.serviceName != null) return false;
        if (servicePrice != null ? !servicePrice.equals(order.servicePrice) : order.servicePrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (servicePrice != null ? servicePrice.hashCode() : 0);
        return result;
    }

    public Masters getMastersByMasterId() {
        return mastersByMasterId;
    }

    public void setMastersByMasterId(Masters mastersByMasterId) {
        this.mastersByMasterId = mastersByMasterId;
    }

    public List<OrderDate> getOrderDatesById() {
        return orderDatesById;
    }

    public void setOrderDatesById(List<OrderDate> orderDatesById) {
        this.orderDatesById = orderDatesById;
    }

    @Override
    public String toString() {
        return serviceName +
                " " + servicePrice + " rub";
    }
}
