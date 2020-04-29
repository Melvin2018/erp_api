package erp.compra.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import erp.compra.Entidades.Proveedor;
import erp.compra.Repositorio.Repo_Proveedor;

@Service
public class Service_Proveedor {
    private Repo_Proveedor proveedor;

    public List<Proveedor> findAll() {
        return proveedor.findAll();
    }

    public ResponseEntity<Proveedor> findOne(Long id) {
        Optional<Proveedor> find = proveedor.findById(id);
        return ResponseEntity.of(find);
    }

    public Proveedor save(Proveedor s) {
        return proveedor.save(s);
    }

    public ResponseEntity<Proveedor> deleteById(Long id){
        Optional<Proveedor> opt = proveedor.findById(id);
        if(opt.isPresent()){
            proveedor.deleteById(id);
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}