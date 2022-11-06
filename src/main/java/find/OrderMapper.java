package find;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.Masters;
import salon.Order;
import salon.Staff;

import java.util.List;

public class OrderMapper extends BaseMapper<Order> {
    /*
    private String serviceName; +
    private Integer servicePrice; +
    private Masters mastersByMasterId; +
    */
    public List<Order> findAllByServiceName(Object serviceName) {
        return findByField(".byServiceName", serviceName);
    }

    public List<Order> findAllByServicePrice(Object servicePrice) {
        return findByField(".byServicePrice", servicePrice);
    }

    public List<Order> findByMaters(Object master){
        return ((Masters)master).getOrdersById();
    }

    @Override
    protected Class<Order> getType() {
        return Order.class;
    }

    @Override
    protected String getTableName() {
        return "Order";
    }
}
