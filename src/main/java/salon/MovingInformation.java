package salon;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class MovingInformation {
    private int id;
    private String position;
    private String transferReason;
    private Integer orderNumber;
    private Date orderDate;
    private List<Staff> staffById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTransferReason() {
        return transferReason;
    }

    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovingInformation that = (MovingInformation) o;

        if (id != that.id) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (transferReason != null ? !transferReason.equals(that.transferReason) : that.transferReason != null)
            return false;
        if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (transferReason != null ? transferReason.hashCode() : 0);
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }

    public List<Staff> getStaffById() {
        return staffById;
    }

    public void setStaffById(List<Staff> staffById) {
        this.staffById = staffById;
    }

    @Override
    public String toString() {
        return position +
                ", " + transferReason +
                ", " + orderNumber +
                ", " + orderDate;
    }
}
