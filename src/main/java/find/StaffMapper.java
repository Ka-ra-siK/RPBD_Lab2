package find;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.Staff;

import java.util.Date;
import java.util.List;

public class StaffMapper extends BaseMapper<Staff> {

    /*
    private String name;+
    private String surname;+
    private String patronymic;+
    private String address;+
    private Date birthDate;+
    private String position;+
    private Integer salary; +
    private Collection<Masters> mastersById;+
    */

    public List<Staff> findAllByName(Object name){
        return findByField(".byName", name);
    }

    public List<Staff> findAllBySurname(Object surname){
        return findByField(".bySurname", surname);
    }

    public List<Staff> findAllByPatronymic(Object patronymic){
        return findByField(".byPatronymic", patronymic);
    }

    public List<Staff> findAllByAddress(Object address){
        return findByField(".byAddress", address);
    }

    public List<Staff> findAllByPosition(Object position){
        return findByField(".byPosition", position);
    }

    public List<Staff> findAlByBirthDate(Object birthDate){
        return findByField(".byBirthDate", birthDate);
    }

    public List<Staff> findAllBySalary(Object salary) {
        return findByField(".bySalary", salary);
    }

//    public List<Staff> findAllByMovingInformation(String transferReason) {
//        String hql = String.format("Select S From %s S join S.MovingInformation MI where MI.transferReason like :transferReason", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Staff> query = session.createQuery(hql, getType());
//        query.setParameter("transferReason", "%" + transferReason + "%");
//        List<Staff> list = query.list();
//        session.close();
//        return list;
//    }


    @Override
    protected Class<Staff> getType() {
        return Staff.class;
    }

    @Override
    protected String getTableName() {
        return "Staff";
    }
}
