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
        return Response.ok(pacienteDAO.getAll()).build();
    }

    @GET
    @Path("/{id_paciente}")
    public Response getById(@PathParam("id_paciente") Integer id) {
        Paciente paciente = pacienteDAO.get(id);
        return paciente != null ? Response.ok(paciente).build() : Response.serverError().build();
    }

    @PUT
    @Path("/{id_paciente}")
    public Response update(@PathParam("id_paciente") Integer id_paciente, Paciente p) {
        Paciente paciente = pacienteDAO.get(id_paciente);
        if (paciente != null && p != null) {
            paciente.update(p);
            pacienteDAO.update(paciente);
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Paciente p) {
        pacienteDAO.save(p);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id_paciente}")
    public Response eliminar(@PathParam("id_paciente") Integer id_paciente) {
        Paciente paciente = pacienteDAO.get(id_paciente);

        if (paciente != null) {
            pacienteDAO.delete(paciente);
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }

    }

}
