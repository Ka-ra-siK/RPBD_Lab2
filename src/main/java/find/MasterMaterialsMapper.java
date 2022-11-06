package find;

import salon.MastersMaterials;

public class MasterMaterialsMapper extends BaseMapper <MastersMaterials> {
    @Override
    protected Class<MastersMaterials> getType() {
        return MastersMaterials.class;
    }

    @Override
    protected String getTableName() {
        return "MastersMaterials";
    }
}
