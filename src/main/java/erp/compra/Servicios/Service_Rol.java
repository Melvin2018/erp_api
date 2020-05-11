package erp.compra.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import erp.compra.Entidades.*;
import erp.compra.Repositorio.Repo_Rol;

@Service
public class Service_Rol {
    private Repo_Rol rol;

    public List<Rol> findAll() {
        return rol.findAll();
    }

    public ResponseEntity<Rol> findOne(Long id) {
        Optional<Rol> find = rol.findById(id);
        return ResponseEntity.of(find);
    }

    public Rol save(Rol s) {
        return rol.save(s);
    }

    public ResponseEntity<Rol> deleteById(Long id){
        Optional<Rol> opt = rol.findById(id);
        if(opt.isPresent()){
            rol.deleteById(id);
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}