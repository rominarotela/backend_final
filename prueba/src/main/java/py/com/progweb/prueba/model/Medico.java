package py.com.progweb.prueba.model;

import javax.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @Column(name = "id_medico")
    @Basic(optional = false)
    @GeneratedValue(generator = "medicoSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "medicoSec", sequenceName = "medico_sec", allocationSize = 0)
    private Integer idMedico;
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
    @Column(name = "especialidad")
    @Basic(optional = false)
    private Integer especialidad;
    @Column(name = "usuario", length = 50)
    @Basic(optional = false)
    private String usuario;
    @Column(name = "contrasena", length = 50)
    @Basic(optional = false)
    private String contrasena;

    public Medico() {

    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
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

    public Integer getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Integer especialidad) {
        this.especialidad = especialidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String user) {
        this.usuario = user;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String password) {
        this.contrasena = password;
    }

    public void update(Medico p) {
        nombre = p.getNombre() != null ? p.getNombre() : null;
        apellido = p.getApellido() != null ? p.getApellido() : null;
        cedula = p.getCedula() != null ? p.getCedula() : null;
        email = p.getEmail() != null ? p.getEmail() : null;
        telefono = p.getTelefono() != null ? p.getTelefono() : null;
        nacimiento = p.getNacimiento() != null ? p.getNacimiento() : null;
        especialidad = p.getEspecialidad() != null ? p.getEspecialidad() : null;
        usuario = p.getUsuario() != null ? p.getUsuario() : null;
        contrasena = p.getContrasena() != null ? p.getContrasena() : null;
    }
}
