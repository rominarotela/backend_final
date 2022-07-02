package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Ficha;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class FichaDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public Ficha get(Integer id) {
        return em.find(Ficha.class, id);
    }

    public List<Ficha> getAll() {
        TypedQuery<Ficha> tq = em.createQuery("SELECT e FROM Ficha e", Ficha.class);
        return tq.getResultList();
    }

    @Transactional
    public void save(Ficha entidad) {
        em.persist(entidad);
    }

    @Transactional
    public void update(Ficha ficha) {
        em.merge(ficha);
    }

    @Transactional
    public void delete(Ficha ficha) {
        em.remove(em.contains(ficha) ? ficha : em.merge(ficha));
    }
}
