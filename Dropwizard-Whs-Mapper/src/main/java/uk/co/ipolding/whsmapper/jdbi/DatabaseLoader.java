package uk.co.ipolding.whsmapper.jdbi;


import org.skife.jdbi.v2.DBI;
import org.w3c.dom.*;
import uk.co.ipolding.whsmapper.core.WorldHeritageSite;
import uk.co.ipolding.whsmapper.jdbi.xmlparser.WorldHeritageSiteParser;

import java.util.List;

import static uk.co.ipolding.whsmapper.jdbi.DatabaseConfiguration.getSQLiteDatabaseInstance;

public class DatabaseLoader
{

    public static void loadDatabase() throws Exception {

        System.out.println("Hello World!");

        WorldHeritageSiteParser parser = new WorldHeritageSiteParser();
        Document documentWhs = null;
        try {
            documentWhs = parser.getWhsDocument();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        DBI dbi = getSQLiteDatabaseInstance();
        WhsDao dao = dbi.open(WhsDao.class);
        dao.createSiteTable();

        if (dao.countRecordsInSiteTable() <= 0){
            List<WorldHeritageSite> siteList = parser.getWorldHeritageSite(documentWhs);
            for (WorldHeritageSite site : siteList) {
                if (dao.findNameById(site.getId())==null)
                    dao.insert(site.getId(), site.getName(), site.getDescription(), site.getLatitude(), site.getLongitude());
            }
        }

        System.out.println(dao.findById(2).getName());

        dao.close();

    }
}