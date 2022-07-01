package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Paciente;

import javax.ejb.Stateless;
import javax.enterprise.context.NonexistentConversationException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PacienteDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Paciente entidad) {
        this.em.persist(entidad);
    }

    public void eliminar(Integer id) {
        Paciente paciente = em.getReference(Paciente.class, id);
        paciente.getIdPacienteId(id);
        em.getTransaction().begin();
        em.remove(paciente);
        em.getTransaction().commit();
    }

    public List<Paciente> lista() {
        Query q=this.em.createQuery("select p from Paciente p");
        return (List<Paciente>) q.getResultList();
    }
}
