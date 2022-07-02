package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Detalleficha;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class DetallefichaDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public Detalleficha get(Integer id) {
        return em.find(Detalleficha.class, id);
    }

    public List<Detalleficha> getAll() {
        TypedQuery<Detalleficha> tq = em.createQuery("SELECT e FROM Detalleficha e", Detalleficha.class);
        return tq.getResultList();
    }

    @Transactional
    public void save(Detalleficha entidad) {
        em.persist(entidad);
    }

}
