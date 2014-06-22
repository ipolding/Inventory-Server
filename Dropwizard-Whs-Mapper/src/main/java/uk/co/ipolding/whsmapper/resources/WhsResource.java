package uk.co.ipolding.whsmapper.resources;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import uk.co.ipolding.whsmapper.jdbi.WhsDao;
import uk.co.ipolding.whsmapper.core.WorldHeritageSite;

import java.util.List;
import java.util.ArrayList;

@Path("/whs")
@Produces(MediaType.APPLICATION_JSON)
public class WhsResource {
	
	private final WhsDao dao;
	
	public WhsResource(WhsDao dao){
		this.dao = dao;
	}
	
	@GET
    @Path("/site")
    public WorldHeritageSite getById(@QueryParam("id") int id) {
		return dao.findById(id);
	}

    @GET
    @Path("/all")
    public List<WorldHeritageSite> getAll() {
        return dao.findAll();
    }
}