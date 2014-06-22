package uk.co.ipolding.whsmapper.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import uk.co.ipolding.whsmapper.core.InventoryItem;
import uk.co.ipolding.whsmapper.jdbi.ItemDAO;

import java.util.List;

@Path("/inventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {
	
	private final ItemDAO dao;
	
	public ItemResource(ItemDAO dao){
		this.dao = dao;
	}
	
	@GET
    @Path("/item")
    public InventoryItem getById(@QueryParam("id") int id) {
        List<InventoryItem> items = dao.findAll();
        return items.get(items.size()-1);
	}

    @GET
    @Path("/all")
    public List<InventoryItem> getAll() {
        return dao.findAll();
    }

    @POST
        @Path("/item")
    public void addItem(InventoryItem item){
        dao.insert(item.getName(), item.getDescription());
    }

}