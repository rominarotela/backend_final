package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.MedicoDAO;
import py.com.progweb.prueba.model.Medico;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path(value = "medico")
@Consumes("application/json")
@Produces("application/json")
public class MedicoRest {
    @Inject
    private MedicoDAO medicoDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(medicoDAO.getAll()).build();
    }

    @GET
    @Path("/{id_medico}")
    public Response getById(@PathParam("id_medico") Integer id) {
        Medico medico = medicoDAO.get(id);
        return medico != null ? Response.ok(medico).build() : Response.serverError().build();
    }

    @PUT
    @Path("/{id_medico}")
    public Response update(@PathParam("id_medico") Integer id_medico, Medico p) {
        Medico medico = medicoDAO.get(id_medico);
        if (medico != null && p != null) {
            medico.update(p);
            medicoDAO.update(medico);
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Medico p) {
        medicoDAO.save(p);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id_medico}")
    public Response eliminar(@PathParam("id_medico") Integer id_medico) {
        Medico medico = medicoDAO.get(id_medico);

        if (medico != null) {
            medicoDAO.delete(medico);
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }

    }
}
