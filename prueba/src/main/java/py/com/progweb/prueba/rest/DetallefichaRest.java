package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.DetallefichaDAO;
import py.com.progweb.prueba.model.Detalleficha;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path(value = "detalleficha")
@Consumes("application/json")
@Produces("application/json")
public class DetallefichaRest {
    @Inject
    private DetallefichaDAO detallefichaDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(detallefichaDAO.getAll()).build();
    }

    @GET
    @Path("/{id_detalleficha}")
    public Response getById(@PathParam("id_detalleficha") Integer id) {
        Detalleficha detalleficha = detallefichaDAO.get(id);
        return detalleficha != null ? Response.ok(detalleficha).build() : Response.serverError().build();
    }

    @POST
    @Path("/")
    public Response crear(Detalleficha f) {
        detallefichaDAO.save(f);
        return Response.ok().build();
    }

}
