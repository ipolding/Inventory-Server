package uk.co.ipolding.whsmapper;



import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;
import uk.co.ipolding.whsmapper.jdbi.WhsDao;
import uk.co.ipolding.whsmapper.resources.WhsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import static uk.co.ipolding.whsmapper.jdbi.DatabaseLoader.loadDatabase;

public class WhsMapperApplication extends Application<WhsMapperConfiguration>{
	
	public static void main (String[] args) throws Exception {
		new WhsMapperApplication().run(args);
		}
	
	@Override
	public void initialize(Bootstrap<WhsMapperConfiguration> bootstrap){
//		Nothing to do yet
        try {
            loadDatabase();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
		}



    public void run(WhsMapperConfiguration configuration, Environment environment)throws ClassNotFoundException{

		final DBIFactory factory = new DBIFactory();
    	final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "sqlite");
    	final WhsDao dao = jdbi.onDemand(WhsDao.class); // this creates an object that implements the Dao interface.
        System.out.println("text from within run");
		environment.jersey().register(new WhsResource(dao));
        environment.jersey().register();




	}
	

}
