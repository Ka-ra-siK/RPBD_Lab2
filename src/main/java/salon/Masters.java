package salon;

import java.util.List;

public class Masters {
    private int id;
    private List<MasterSpecialization> masterSpecializationsById;
    private Staff staffByStaffId;
    private List<MastersMaterials> mastersMaterialsById;
    private List<Order> ordersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Masters masters = (Masters) o;

        if (id != masters.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }

    public List<MasterSpecialization> getMasterSpecializationsById() {
        return masterSpecializationsById;
    }

    public void setMasterSpecializationsById(List<MasterSpecialization> masterSpecializationsById) {
        this.masterSpecializationsById = masterSpecializationsById;
    }

    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    public List<MastersMaterials> getMastersMaterialsById() {
        return mastersMaterialsById;
    }

    public void setMastersMaterialsById(List<MastersMaterials> mastersMaterialsById) {
        this.mastersMaterialsById = mastersMaterialsById;
    }

    public List<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(List<Order> ordersById) {
        this.ordersById = ordersById;
    }

    @Override
    public String toString() {
        String specializations = "Specializations: ";
        int i = 1;
        for (MasterSpecialization specialization :
                masterSpecializationsById) {
            specializations += "\n" + i + ") " + specialization.getSpecializationBySpecializationId().getName() + " ";
            i += 1;
        }

        String materialsName = "Materials: ";
        int j = 1;
        for (MastersMaterials materials :
                mastersMaterialsById) {
            materialsName += "\n" + j + ") " +
                    materials.getMaterialsByMaterialsId().getName() +
                    " " + materials.getMaterialsByMaterialsId().getUnitMeasurement() +
                    " " + materials.getQuantity() + " pieces";
            j += 1;
        }
        specializations += "\n";
        materialsName += "\n";

        return staffByStaffId.getSurname() +
                " " + staffByStaffId.getName() +
                " " + staffByStaffId.getPatronymic() +
                "\n" + specializations +
                "\n" + materialsName;
    }
}
