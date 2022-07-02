package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Medico;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class MedicoDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public Medico get(Integer id) {
        return em.find(Medico.class, id);
    }

    public List<Medico> getAll() {
        TypedQuery<Medico> tq = em.createQuery("SELECT e FROM Medico e", Medico.class);
        return tq.getResultList();
    }

    @Transactional
    public void save(Medico entidad) {
        em.persist(entidad);
    }

    @Transactional
    public void update(Medico medico) {
        em.merge(medico);
    }

    @Transactional
    public void delete(Medico medico) {
        em.remove(em.contains(medico) ? medico : em.merge(medico));
    }
}
