package salon;

import java.util.Collection;

public class Masters {
    private int id;
    private String surname;
    private Collection<MasterSpecialization> masterSpecializationsById;
    private Staff staffByStaffId;
    private Collection<MastersMaterials> mastersMaterialsById;
    private Collection<Order> ordersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Masters masters = (Masters) o;

        if (id != masters.id) return false;
        if (surname != null ? !surname.equals(masters.surname) : masters.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    public Collection<MasterSpecialization> getMasterSpecializationsById() {
        return masterSpecializationsById;
    }

    public void setMasterSpecializationsById(Collection<MasterSpecialization> masterSpecializationsById) {
        this.masterSpecializationsById = masterSpecializationsById;
    }

    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    public Collection<MastersMaterials> getMastersMaterialsById() {
        return mastersMaterialsById;
    }

    public void setMastersMaterialsById(Collection<MastersMaterials> mastersMaterialsById) {
        this.mastersMaterialsById = mastersMaterialsById;
    }

    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }

    @Override
    public String toString() {
        return surname;
    }
}
