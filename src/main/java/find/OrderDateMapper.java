package find;

import salon.OrderDate;

public class OrderDateMapper extends BaseMapper<OrderDate> {
    @Override
    protected Class<OrderDate> getType() {
        return OrderDate.class;
    }

    @Override
    protected String getTableName() {
        return "OrderDate";
    }
}
