package ipolding.co.uk.database;


import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

/**
 * Created by ian.polding on 16/05/2014.
 */
public class DatabaseConfiguration {

    public static DBI getH2DatabaseInstance() {

        DataSource ds = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/test",
                "ian",
                "password");

        return new DBI(ds);
    }

    public static DBI getH2MemoryDatabaseInstance() {

        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
                "ian",
                "password");

        return new DBI(ds);
    }

 }