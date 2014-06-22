package ipolding.co.uk;

import ipolding.co.uk.database.WhsSiteDao;
import ipolding.co.uk.domain.WorldHeritageSite;
import ipolding.co.uk.xml.WorldHeritageSiteParser;

import org.skife.jdbi.v2.DBI;
import org.w3c.dom.*;

import java.util.List;

import static ipolding.co.uk.database.DatabaseConfiguration.getH2DatabaseInstance;

public class App
{

    public static void main( String[] args ) throws Exception {
        System.out.println("Hello World!");

        WorldHeritageSiteParser parser = new WorldHeritageSiteParser();
        Document documentWhs = null;
        try {
            documentWhs = parser.getWhsDocument();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        List<WorldHeritageSite> siteList = parser.getWorldHeritageSite(documentWhs);

        DBI dbi = getH2DatabaseInstance();
        WhsSiteDao dao = dbi.open(WhsSiteDao.class);

        dao.createSiteTable();

        for (WorldHeritageSite site : siteList) {
            if (dao.findNameById(site.getId())==null)
                dao.insert(site.getId(), site.getName(), site.getDescription(), site.getLatitude(), site.getLongitude());
//            String name = dao.findNameById(1);
//            System.out.print(name);
        }
        dao.close();
    }
}