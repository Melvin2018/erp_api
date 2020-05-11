package erp.compra.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import erp.compra.Entidades.*;
import erp.compra.Repositorio.Repo_Sucursal;

@Service
public class Service_Sucursal {

    @Autowired
    private Repo_Sucursal sucursal;

    public List<Sucursal> findAll() {
        return sucursal.findAll();
    }

    public ResponseEntity<Sucursal> findOne(Long id) {
        Optional<Sucursal> find = sucursal.findById(id);
        return ResponseEntity.of(find);
    }

    public Sucursal save(Sucursal s) {
        return sucursal.save(s);
    }
}