package py.com.progweb.prueba.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ficha")
public class Ficha {
    @Id
    @Column(name = "id_ficha")
    @Basic(optional = false)
    @GeneratedValue(generator = "fichaSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "fichaSec", sequenceName = "ficha_sec", allocationSize = 0)
    private Integer idFicha;

    @Column(name = "fecha")
    @Basic(optional = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;


    public Ficha() {

    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void update(Ficha f) {
        fecha = f.getFecha() != null ? f.getFecha() : null;
        medico = f.getMedico() != null ? f.getMedico() : null;
        paciente = f.getPaciente() != null ? f.getPaciente() : null;
    }

}
