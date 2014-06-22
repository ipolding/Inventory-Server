package uk.co.ipolding.whsmapper.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorldHeritageSiteMapper implements ResultSetMapper<WorldHeritageSite> {

    @Override
    public WorldHeritageSite map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new WorldHeritageSite(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getDouble("latitude"),
                resultSet.getDouble("longitude"));
    }
}