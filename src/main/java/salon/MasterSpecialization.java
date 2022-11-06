package salon;

public class MasterSpecialization {
    private Masters mastersByMasterId;
    private Specialization specializationBySpecializationId;
    private int id;

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

        MasterSpecialization that = (MasterSpecialization) o;

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Masters getMastersByMasterId() {
        return mastersByMasterId;
    }

    public void setMastersByMasterId(Masters mastersByMasterId) {
        this.mastersByMasterId = mastersByMasterId;
    }

    public Specialization getSpecializationBySpecializationId() {
        return specializationBySpecializationId;
    }

    public void setSpecializationBySpecializationId(Specialization specializationBySpecializationId) {
        this.specializationBySpecializationId = specializationBySpecializationId;
    }

    @Override
    public String toString() {
        return specializationBySpecializationId.getName();
    }
}
