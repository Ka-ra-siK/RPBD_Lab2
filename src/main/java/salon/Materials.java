package salon;

import java.util.Collection;

public class Materials {
    private int id;
    private String name;
    private String unitMeasurement;
    private Integer cost;
    private Collection<MastersMaterials> mastersMaterialsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Materials materials = (Materials) o;

        if (id != materials.id) return false;
        if (name != null ? !name.equals(materials.name) : materials.name != null) return false;
        if (unitMeasurement != null ? !unitMeasurement.equals(materials.unitMeasurement) : materials.unitMeasurement != null)
            return false;
        if (cost != null ? !cost.equals(materials.cost) : materials.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unitMeasurement != null ? unitMeasurement.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    public Collection<MastersMaterials> getMastersMaterialsById() {
        return mastersMaterialsById;
    }

    public void setMastersMaterialsById(Collection<MastersMaterials> mastersMaterialsById) {
        this.mastersMaterialsById = mastersMaterialsById;
    }

    @Override
    public String toString() {
        return name +
                ", " + unitMeasurement +
                ", " + cost + " rub";
    }
}
