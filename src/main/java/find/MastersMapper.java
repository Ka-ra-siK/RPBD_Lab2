package find;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.Masters;
import salon.Materials;
import salon.MovingInformation;
import salon.Staff;

import java.util.List;

public class MastersMapper extends BaseMapper<Masters> {

    /*
    private String surname; +
    private Collection<MasterSpecialization> masterSpecializationsById; +
    private Collection<MastersMaterials> mastersMaterialsById; +
    private Collection<Order> ordersById; +
    */

    public List<Masters> findByStaff(Object staff){
        return ((Staff)staff).getMastersById();
    }

    @Override
    protected Class<Masters> getType() {
        return Masters.class;
    }

    @Override
    protected String getTableName() {
        return "Masters";
    }
}
