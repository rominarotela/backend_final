package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.FichaDAO;
import py.com.progweb.prueba.model.Ficha;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path(value = "ficha")
@Consumes("application/json")
@Produces("application/json")
public class FichaRest {
    @Inject
    private FichaDAO fichaDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(fichaDAO.getAll()).build();
    }

    @GET
    @Path("/{id_ficha}")
    public Response getById(@PathParam("id_ficha") Integer id) {
        Ficha ficha = fichaDAO.get(id);
        return ficha != null ? Response.ok(ficha).build() : Response.serverError().build();
    }

    @PUT
    @Path("/{id_ficha}")
    public Response update(@PathParam("id_ficha") Integer id_ficha, Ficha p) {
        Ficha ficha = fichaDAO.get(id_ficha);
        if (ficha != null && p != null) {
            ficha.update(p);
            fichaDAO.update(ficha);
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Ficha p) {
        fichaDAO.save(p);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id_ficha}")
    public Response eliminar(@PathParam("id_ficha") Integer id_ficha) {
        Ficha ficha = fichaDAO.get(id_ficha);

        if (ficha != null) {
            fichaDAO.delete(ficha);
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }

    }
}
