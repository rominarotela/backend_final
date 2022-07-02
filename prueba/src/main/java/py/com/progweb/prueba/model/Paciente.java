package py.com.progweb.prueba.model;

import javax.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name = "id_paciente")
    @Basic(optional = false)
    @GeneratedValue(generator = "pacienteSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "pacienteSec", sequenceName = "paciente_sec", allocationSize = 0)
    private Integer idPaciente;
    @Column(name = "nombre", length = 50)
    @Basic(optional = false)
    private String nombre;
    @Column(name = "apellido", length = 50)
    @Basic(optional = false)
    private String apellido;
    @Column(name = "cedula", length = 50)
    @Basic(optional = false)
    private String cedula;
    @Column(name = "email", length = 50)
    @Basic(optional = false)
    private String email;
    @Column(name = "telefono", length = 50)
    @Basic(optional = false)
    private String telefono;
    @Column(name = "nacimiento", length = 50)
    @Basic(optional = false)
    private String nacimiento;

    public Paciente() {

    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdPacienteId(Integer id) {
        return idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void update(Paciente p) {
        nombre = p.getNombre() != null ? p.getNombre() : null;
        apellido = p.getApellido() != null ? p.getApellido() : null;
        cedula = p.getCedula() != null ? p.getCedula() : null;
        email = p.getEmail() != null ? p.getEmail() : null;
        telefono = p.getTelefono() != null ? p.getTelefono() : null;
        nacimiento = p.getNacimiento() != null ? p.getNacimiento() : null;
    }
}

//creando pacientes