package erp.compra.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "sucursal")
@Data
@ToString(of = { "id", "nombre", "encargado" })
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Lob
    @Size(max = 65535)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;
    @JoinColumn(name = "encargado", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario encargado;
    @JsonIgnore
    @OneToMany(mappedBy = "sucursal", fetch = FetchType.LAZY)
    private List<Inventario> inventarioList;
    @JsonIgnore
    @OneToMany(mappedBy = "sucursal", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    @PostPersist
    public void sucu() {
        this.encargado.getIdEmpleado().setSucursal(this);
    }
}
