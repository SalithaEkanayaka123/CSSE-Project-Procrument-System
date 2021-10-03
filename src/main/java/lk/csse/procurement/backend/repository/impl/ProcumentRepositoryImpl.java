package lk.csse.procurement.backend.repository.impl;

import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Repository
public class ProcumentRepositoryImpl implements ProcumentRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Order addOrder(Order order) {

        /**
        Date dateObj = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateObj);
        cal.add(Calendar.DAY_OF_YEAR, 0);
        Map<String, Object> params = new HashMap<>();

        String query = "INSERT INTO noc_vw_user_role(user_name, role, created_user, created_date) " +
                "    VALUES (:user_name, :role, :created_user, :created_date)";

        params.put("user_name", );
        params.put("role", );
        params.put("created_user", );
        params.put("created_date", new Timestamp(cal.getTimeInMillis()));
        return namedParameterJdbcTemplate.update(query, params);
         **/

        return null;
    }

    @Override
    public Order getAllOrderDetails(Order order) {
        return null;
    }

    /**
     *
     * PostgresSQL DB Methods.
     *
     * **/
}
