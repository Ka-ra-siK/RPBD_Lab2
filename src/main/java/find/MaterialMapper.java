package find;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.Materials;

import java.util.List;

public class MaterialMapper extends BaseMapper<Materials> {

    /*
    private String name;+
    private String unitMeasurement;+
    private Integer cost;+
    private Collection<MastersMaterials> mastersMaterialsById;+
    */

//    public List<Materials> findAllByMasters(String surname){
//        String hql = String.format("Select MAT From %s MAT join MAT.Masters M where M.surname like :surname", getTableName());
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Query<Materials> query = session.createQuery(hql, getType());
//        query.setParameter("surname", "%" + surname + "%");
//        List<Materials> list = query.list();
//        session.close();
//        return list;
//    }

    public List<Materials> findAllByNameMaterial(Object name){
        return findByField(".byName", name);
    }

    public List<Materials> findAllByUnitMeasurement(Object unitMeasurement){
        return findByField(".byUnitMeasurement", unitMeasurement);
    }

    public List<Materials> findAllByCost(Object cost){
        return findByField(".byCost", cost);
    }

    @Override
    protected Class<Materials> getType() {
        return Materials.class;
    }

    @Override
    protected String getTableName() {
        return "Materials";
    }
}
