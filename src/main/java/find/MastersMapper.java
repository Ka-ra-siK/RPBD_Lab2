package find;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.Masters;
import salon.Staff;

import java.util.List;

public class MastersMapper extends BaseMapper<Masters> {

    /*
    private String surname; +
    private Collection<MasterSpecialization> masterSpecializationsById; +
    private Collection<MastersMaterials> mastersMaterialsById; +
    private Collection<Order> ordersById; +
    */
    public List<Masters> findAllBySurname(Object surname) {
        return findByField(".bySurname", surname);
    }

//    public List<Masters> findAllBySpecialization(String name){
//        String hql = String.format("Select M From %s M join M.Specialization S " +
//                "where S.name like :name", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Masters> query = session.createQuery(hql, getType());
//        query.setParameter("name", "%" + name + "%");
//        List<Masters> list = query.list();
//        session.close();
//        return list;
//    }
//
//    public List<Masters> findAllByMaterials(String name){
//        String hql = String.format("Select M From %s M join M.Materials MAT " +
//                "where MAT.name like :name", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Masters> query = session.createQuery(hql, getType());
//        query.setParameter("name", "%" + name + "%");
//        List<Masters> list = query.list();
//        session.close();
//        return list;
//    }
//    public List<Masters> findAllByMaterialsQuantity(int quantity){
//        String hql = String.format("Select M From %s M join M.MastersMaterials MM " +
//                "where MM.quantity > :quantity", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Masters> query = session.createQuery(hql, getType());
//        query.setParameter("quantity", quantity );
//        List<Masters> list = query.list();
//        session.close();
//        return list;
//    }
//
//    public List<Masters> findAllByStaffSurname(String surname) {
//        String hql = String.format("Select M From %s M join M.Staff S where S.surname like :surname", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Masters> query = session.createQuery(hql, getType());
//        query.setParameter("surname", "%" + surname + "%");
//        List<Masters> list = query.list();
//        session.close();
//        return list;
//    }

    @Override
    protected Class<Masters> getType() {
        return Masters.class;
    }

    @Override
    protected String getTableName() {
        return "Masters";
    }
}
