package uk.co.ipolding.whsmapper.jdbi;


import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

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

    public static DBI getSQLiteDatabaseInstance() throws Exception {

        SQLiteConnectionPoolDataSource ds = new SQLiteConnectionPoolDataSource();
        ds.setUrl("jdbc:sqlite:sites.db");
        ds.getConnection("ian","password");
        return new DBI(ds);


//        Connection c = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:sites.db",
//                    "ian",
//                    "password");
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Opened database successfully");
//        c.close();
//
//        SQLiteDataSource dataSource= new SQLiteDataSource();
//        return new DBI(dataSource);
    }

 }