package py.com.progweb.prueba.model;

import javax.persistence.*;

@Entity
@Table(name = "detalleficha")
public class Detalleficha {
    @Id
    @Column(name = "id_detalleficha")
    @Basic(optional = false)
    @GeneratedValue(generator = "detallefichaSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "detallefichaSec", sequenceName = "detalleficha_sec", allocationSize = 0)
    private Integer idDetalleficha;

    @ManyToOne
    @JoinColumn(name = "id_ficha")
    private Ficha ficha;

    @Column(name = "motivo", length = 100)
    @Basic(optional = false)
    private String motivo;

    @Column(name = "diagnostico", length = 100)
    @Basic(optional = false)
    private String diagnostico;

    @Column(name = "tratamiento", length = 100)
    @Basic(optional = false)
    private String tratamiento;

    public Detalleficha() {

    }

    public Integer getIdDetalleficha() {
        return idDetalleficha;
    }

    public void setIdDetalleficha(Integer idDetalleficha) {
        this.idDetalleficha = idDetalleficha;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
}
