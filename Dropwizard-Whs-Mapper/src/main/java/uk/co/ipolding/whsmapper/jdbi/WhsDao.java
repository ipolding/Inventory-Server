package uk.co.ipolding.whsmapper.jdbi;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import uk.co.ipolding.whsmapper.core.WorldHeritageSite;
import uk.co.ipolding.whsmapper.core.WorldHeritageSiteMapper;

import java.util.List;

/**
 * Created by Ian on 15/05/14.
 */
public interface WhsDao {

    @SqlQuery("SELECT count(*) FROM sites where id > 0")
    int countRecordsInSiteTable();

    @SqlUpdate("CREATE TABLE IF NOT EXISTS SITES (ID INT PRIMARY KEY, NAME VARCHAR(200), DESCRIPTION VARCHAR(1704), LATITUDE DOUBLE PRECISION NOT NULL, LONGITUDE DOUBLE PRECISION NOT NULL)")
    void createSiteTable();

    @SqlUpdate("insert into sites (id, name, description, latitude, longitude) values (:id, :name, :description, :latitude, :longitude)")
    void insert(@Bind("id") int id, @Bind("name") String name, @Bind("description") String description, @Bind("latitude") Double latitude, @Bind("longitude") Double longitude);

    @SqlQuery("select * from sites")
    @Mapper(WorldHeritageSiteMapper.class)
    List<WorldHeritageSite> findAll();

    @SqlQuery("select name from sites where id = :id")
    String findNameById(@Bind("id") int id);

    @SqlQuery("select * from sites where id = :id")
    @Mapper(WorldHeritageSiteMapper.class)
    WorldHeritageSite findById(@Bind("id") int id);

    /**
     * close with no args is used to close the connection
     */
    void close();
}
