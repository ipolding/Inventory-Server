package uk.co.ipolding.whsmapper;



import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import uk.co.ipolding.whsmapper.jdbi.ItemDAO;
import uk.co.ipolding.whsmapper.resources.ItemResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import static uk.co.ipolding.whsmapper.jdbi.DatabaseLoader.loadDatabase;

public class InventoryServerApplication extends Application<InventoryServerConfiguration>{
	
	public static void main (String[] args) throws Exception {
		new InventoryServerApplication().run(args);
		}
	
	@Override
	public void initialize(Bootstrap<InventoryServerConfiguration> bootstrap){
//		Nothing to do yet
        try {
            loadDatabase();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
		}



    public void run(InventoryServerConfiguration configuration, Environment environment)throws ClassNotFoundException{

        // parent context
        AnnotationConfigWebApplicationContext parent = new AnnotationConfigWebApplicationContext();

        //context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        parent.refresh();
        parent.getBeanFactory().registerSingleton("configuration", configuration);
        parent.registerShutdownHook();
        parent.start();

        try {
            loadDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        final DBIFactory factory = new DBIFactory();
    	final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "sqlite");
    	final ItemDAO dao = jdbi.onDemand(ItemDAO.class); // this creates an object that implements the Dao interface.
        System.out.println("text from within run");
		environment.jersey().register(new ItemResource(dao));

	}
	

}
