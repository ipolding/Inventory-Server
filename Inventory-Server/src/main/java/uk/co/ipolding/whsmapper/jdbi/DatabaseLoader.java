package uk.co.ipolding.whsmapper.jdbi;


import org.slf4j.LoggerFactory;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;

import static uk.co.ipolding.whsmapper.jdbi.DatabaseConfiguration.getSQLiteDatabaseInstance;

public class DatabaseLoader
{
    static Logger LOGGER = LoggerFactory.getLogger(DatabaseLoader.class);

    public static void loadDatabase() throws Exception {

        LOGGER.info("Loading database");

        DBI dbi = getSQLiteDatabaseInstance();
        ItemDAO dao = dbi.open(ItemDAO.class);
        LOGGER.info("Creating table");
        dao.createItemTable();
        dao.close();

    }
}