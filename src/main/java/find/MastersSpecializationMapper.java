package find;

import salon.MasterSpecialization;

public class MastersSpecializationMapper extends BaseMapper<MasterSpecialization>{
    @Override
    protected Class<MasterSpecialization> getType() {
        return MasterSpecialization.class;
    }

    @Override
    protected String getTableName() {
        return "MasterSpecialization";
    }
}
