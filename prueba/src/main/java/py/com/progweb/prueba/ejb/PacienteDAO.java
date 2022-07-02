package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Paciente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class PacienteDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public Paciente get(Integer id) {
        return em.find(Paciente.class, id);
    }

    public List<Paciente> getAll() {
        TypedQuery<Paciente> tq = em.createQuery("SELECT e FROM Paciente e", Paciente.class);
        return tq.getResultList();
    }

    @Transactional
    public void save(Paciente entidad) {
        em.persist(entidad);
    }

    @Transactional
    public void update(Paciente paciente) {
        em.merge(paciente);
    }

    @Transactional
    public void delete(Paciente paciente) {
        em.remove(em.contains(paciente) ? paciente : em.merge(paciente));
    }

}
