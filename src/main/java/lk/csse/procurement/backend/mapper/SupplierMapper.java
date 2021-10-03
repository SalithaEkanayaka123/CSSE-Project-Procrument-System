package lk.csse.procurement.backend.mapper;

import lk.csse.procurement.backend.model.Supplier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierMapper implements RowMapper<Supplier> {
    @Override
    public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
        Supplier person = new Supplier();
        person.setUserID(rs.getString("userid"));
        person.setEmail(rs.getString("email"));
        person.setFirstName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));
        person.setPassword(rs.getString("password"));
        person.setPhoneNo(rs.getString("phone_no"));
        person.setType(rs.getString("type"));
        person.setAvailability(rs.getBoolean("availability"));
        return person;
    }
}
