package salon;

public class MastersMaterials {
    private Integer quantity;
    private Masters mastersByMastersId;
    private Materials materialsByMaterialsId;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MastersMaterials that = (MastersMaterials) o;

        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    public Masters getMastersByMastersId() {
        return mastersByMastersId;
    }

    public void setMastersByMastersId(Masters mastersByMastersId) {
        this.mastersByMastersId = mastersByMastersId;
    }

    public Materials getMaterialsByMaterialsId() {
        return materialsByMaterialsId;
    }

    public void setMaterialsByMaterialsId(Materials materialsByMaterialsId) {
        this.materialsByMaterialsId = materialsByMaterialsId;
    }
}
