package uk.co.ipolding.whsmapper.jdbi;

import org.skife.jdbi.v2.DBI;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

public class DatabaseConfiguration {

    private static final String databaseURL = "jdbc:sqlite:";
    private static final String databaseName = "inventory.db";
    private static final String databaseUser = "ian";
    private static final String databasePassword = "password";

    public static DBI getSQLiteDatabaseInstance() throws Exception {

        SQLiteConnectionPoolDataSource ds = new SQLiteConnectionPoolDataSource();
        ds.setUrl(databaseURL +databaseName);
        ds.getConnection(databaseUser, databasePassword);
        return new DBI(ds);
    }
 }