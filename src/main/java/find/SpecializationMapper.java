package find;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.Specialization;

import java.util.List;

public class SpecializationMapper extends BaseMapper<Specialization> {

//    public List<Specialization> findAllBySurnameOfMaster(String surname) {
//        String hql = String.format("Select S From %s S join S.Masters M where M.surname like :surname", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Specialization> query = session.createQuery(hql, getType());
//        query.setParameter("surname", "%" + surname + "%");
//        List<Specialization> list = query.list();
//        session.close();
//        return list;
//    }

    public List<Specialization> findAllByNameOfSpecialization(Object name) {
        return findByField(".byName", name);
    }

    @Override
    protected Class<Specialization> getType() {
        return Specialization.class;
    }

    @Override
    protected String getTableName() {
        return "Specialization";
    }
}
