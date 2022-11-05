package find;

import hibernate.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.Clients;
import salon.Order;

import java.util.List;
public class ClientsMapper extends BaseMapper<Clients> {

    public List<Clients> findAllByName(Object name){
        return findByField(".byName", name);
    }

    public List<Clients> findAllBySurname(Object surname){
        return findByField(".bySurname", surname);
    }

    public List<Clients> findAllByPatronymic(Object patronymic){
        return findByField(".byPatronymic", patronymic);
    }

    public List<Clients> findAllByPhoneNumber(Object phoneNumber){
        return findByField(".byPhoneNumber", phoneNumber);
    }

    public List<Clients> findAllByOrder(Object order) {
        //return ((Order)order).getOrderDatesById();
        return null;
    }

//    public List<Clients> findAllByOrderDate(String orderDate) {
//        String hql = String.format("Select C From %s C join C.OrderDate OD where OD.orderDate like :orderDate", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Clients> query = session.createQuery(hql, getType());
//        query.setParameter("orderDate", "%" + orderDate + "%");
//        List<Clients> list = query.list();
//        session.close();
//        return list;
//    }

    @Override
    protected Class<Clients> getType() {
        return Clients.class;
    }

    @Override
    protected String getTableName() {
        return "Clients";
    }
}
