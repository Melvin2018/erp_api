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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "proveedor")
@Setter
@Getter
@NoArgsConstructor
public class Proveedor implements Serializable {

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
	@Column(name = "nombrecomercial")
	private String nombrecomercial;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "nit")
	private String nit;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "nrc")
	private String nrc;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "contacto")
	private String contacto;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "telefono")
	private String telefono;
	@Size(max = 45)
	@Column(name = "giro")
	private String giro;
	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
	@Size(max = 45)
	@Column(name = "email")
	private String email;
	@Size(max = 45)
	@Column(name = "direccion")
	private String direccion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor", fetch = FetchType.LAZY)
	private List<Ordencompra> ordencompraList;

}
