package find;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import salon.MovingInformation;

import java.util.Date;
import java.util.List;

public class MovingMapper extends BaseMapper<MovingInformation> {
    /*
    private String position; +
    private String transferReason; +
    private Integer orderNumber; +
    private Date orderDate; +
    private Collection<Staff> staffById; +
    * */

    public List<MovingInformation> findAllByPosition(Object position) {
        return findByField(".byPosition", position);
    }

    public List<MovingInformation> findAllByTransferReason(Object transferReason) {
        return findByField(".byTransferReason", transferReason);
    }

    public List<MovingInformation> findAllByOrderNumber(Object orderNumber) {
        return findByField(".byOrderNumber", orderNumber);
    }

    public List<MovingInformation> findAlByOrderDate(Object orderDate){
        return findByField(".byOrderDate", orderDate);
    }


    @Override
    protected Class<MovingInformation> getType() {
        return MovingInformation.class;
    }

    @Override
    protected String getTableName() {
        return "MovingInformation";
    }
}
