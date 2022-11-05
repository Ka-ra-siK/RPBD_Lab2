package find;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.Order;

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

//    public List<Order> findAllByMastersSurname(String surname) {
//        String hql = String.format("Select O From %s O join O.Masters M where M.surname like :surname", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Order> query = session.createQuery(hql, getType());
//        query.setParameter("surname", "%" + surname + "%");
//        List<Order> list = query.list();
//        session.close();
//        return list;
//    }

    @Override
    protected Class<Order> getType() {
        return Order.class;
    }

    @Override
    protected String getTableName() {
        return "Order";
    }
}
