package erp.compra.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import erp.compra.Entidades.*;
import erp.compra.Repositorio.Repo_Categoria;


@Service
public class Service_Categoria {
    
    private Repo_Categoria categoria;

    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok(categoria.findAll());
    }

    public ResponseEntity<Categoria> findOne(Long id) {
        Optional<Categoria> find = categoria.findById(id);
        return ResponseEntity.of(find);
    }

    public Categoria save(Categoria s) {
        return categoria.save(s);
    }

    public ResponseEntity<Categoria> deleteById(Long id){
        Optional<Categoria> opt = categoria.findById(id);
        if(opt.isPresent()){
            categoria.deleteById(id);
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}