package lk.csse.procurement.backend.mapper;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setDescription(rs.getString("description"));
        item.setItemName(rs.getString("item_name"));
        item.setItemId(rs.getInt("item_id"));
        item.setQty(rs.getInt("qty"));
        item.setPrice(rs.getDouble("price"));
        return item;
    }
}
