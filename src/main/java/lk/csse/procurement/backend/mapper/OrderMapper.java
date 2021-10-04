package lk.csse.procurement.backend.mapper;

import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.model.Supplier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getString("order_id"));
        order.setDescription(rs.getString("description"));
        order.setDeliveryAddress(rs.getString("delivery_address"));
        order.setPurchaseDate(rs.getDate("purchase_date"));
        order.setRequiredDate(rs.getDate("required_date"));
        order.setSiteLocation(rs.getString("site_location"));
        order.setStatus(rs.getString("status"));
        order.setSupplierId(rs.getString("suplierid"));
        order.setTotalPrice(rs.getFloat("total_price"));
        return order;
    }
}
