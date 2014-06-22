package uk.co.ipolding.whsmapper.jdbi;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import uk.co.ipolding.whsmapper.core.InventoryItem;
import uk.co.ipolding.whsmapper.core.InventoryItemMapper;

import java.util.List;

/**
 * Created by Ian on 15/05/14.
 */
public interface ItemDAO {

    @SqlQuery("SELECT count(*) FROM ITEMS where id > 0")
    int countRecordsInSiteTable();

    @SqlUpdate("CREATE TABLE IF NOT EXISTS ITEMS (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME VARCHAR(200), " +
            "DESCRIPTION VARCHAR(500))")
    void createItemTable();

    @SqlUpdate("insert into ITEMS ("+
            "name, " +
            "description)" +
            "values (:name, :description)")
    void insert(@Bind("name") String name,
                @Bind("description") String description);

    @SqlQuery("select * from items")
    @Mapper(InventoryItemMapper.class)
    List<InventoryItem> findAll();

    @SqlQuery("select name from ITEMS where id = :id")
    String findNameById(@Bind("id") int id);

    @SqlQuery("select * from ITEMS where id = :id")
    @Mapper(InventoryItemMapper.class)
    InventoryItem findById(@Bind("id") int id);

    /**
     * close with no args is used to close the connection
     */
    void close();
}