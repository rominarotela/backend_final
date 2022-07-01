package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.PacienteDAO;
import py.com.progweb.prueba.model.Paciente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path(value = "paciente")
@Consumes("application/json")
@Produces("application/json")
public class PacienteRest {
    @Inject
    private PacienteDAO pacienteDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(pacienteDAO.lista()).build();
    }

    @POST
    @Path("/")
    public Response crear(Paciente p) {
        this.pacienteDAO.agregar(p);
        return Response.ok().build();
    }
}
