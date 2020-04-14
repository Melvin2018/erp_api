package erp.compra.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import erp.compra.Entidades.Empresa;
import erp.compra.Repositorio.Repo_Empresa;

@Service
public class Service_Empresa {
	@Autowired
	private Repo_Empresa iempresa;

	public List<Empresa> findAll() {
		return iempresa.findAll();
	}

	public ResponseEntity<Empresa> findOne(Long id) {
		return ResponseEntity.of(iempresa.findById(id));
	}

	public Empresa save(Empresa empresa) {
		return iempresa.save(empresa);
	}
}
