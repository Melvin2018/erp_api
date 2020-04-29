package erp.compra.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import erp.compra.Entidades.Marca;
import erp.compra.Repositorio.Repo_Marca;

@Service
public class Service_Marca {
    private Repo_Marca marca;

    public List<Marca> findAll() {
        return marca.findAll();
    }

    public ResponseEntity<Marca> findOne(Long id) {
        Optional<Marca> find = marca.findById(id);
        return ResponseEntity.of(find);
    }

    public Marca save(Marca s) {
        return marca.save(s);
    }

    public ResponseEntity<Marca> deleteById(Long id){
        Optional<Marca> opt = marca.findById(id);
        if(opt.isPresent()){
            marca.deleteById(id);
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}