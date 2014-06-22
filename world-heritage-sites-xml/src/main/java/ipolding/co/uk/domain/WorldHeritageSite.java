package ipolding.co.uk.domain;

import ipolding.co.uk.database.WhsSiteDao;
import org.skife.jdbi.v2.sqlobject.Bind;

/**
 * Created by ian.polding on 15/05/2014.
 */
public class WorldHeritageSite implements WhsSiteDao {

    private String name;
    private String description;
    private double longitude;
    private double latitude;
    private int id;

    @Override
    public String toString() {

        return this.getName() + "\n"
                + this.getDescription() + "\n"
                + this.getLongitude() + "\n "
                + this.getLatitude() + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public void createSiteTable() {

    }

    @Override
    public void insert(@Bind("id") int id, @Bind("name") String name, @Bind("description") String description, @Bind("latitude") Double latitude, @Bind("longitude") Double longitude) {

    }

    @Override
    public String findNameById(@Bind("id") int id) {
        return null;
    }

    @Override
    public void close() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
