package uk.co.ipolding.whsmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class WhsMapperConfiguration extends Configuration {


	@Valid
	@NotNull
	@JsonProperty
	private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

	// this lets jackson deserialize this information from the YAML file


}
