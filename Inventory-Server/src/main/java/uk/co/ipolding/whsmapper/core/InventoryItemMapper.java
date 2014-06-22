package uk.co.ipolding.whsmapper.core;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryItemMapper implements ResultSetMapper<InventoryItem> {

    @Override
    public InventoryItem map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new InventoryItem(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"));
    }
}