package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Paciente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

    public List<Paciente> lista() {
        Query q=this.em.createQuery("select p from Paciente p");
        return (List<Paciente>) q.getResultList();
    }
}
