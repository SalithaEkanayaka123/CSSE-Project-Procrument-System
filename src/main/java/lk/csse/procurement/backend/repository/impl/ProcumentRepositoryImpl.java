package lk.csse.procurement.backend.repository.impl;

import lk.csse.procurement.backend.repository.ProcumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class ProcumentRepositoryImpl implements ProcumentRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     *
     * PostgresSQL DB Methods.
     *
     * **/
}
