package erp.compra.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import erp.compra.Entidades.*;
import erp.compra.Repositorio.Repo_Usuario;

@Service
public class Service_Usuario {
    private Repo_Usuario user;

    public List<Usuario> findAll() {
        return user.findAll();
    }

    public ResponseEntity<Usuario> findOne(Long id) {
        Optional<Usuario> find = user.findById(id);
        return ResponseEntity.of(find);
    }

    public Usuario save(Usuario s) {
        return user.save(s);
    }

    public ResponseEntity<Usuario> deleteById(Long id){
        Optional<Usuario> opt = user.findById(id);
        if(opt.isPresent()){
            user.deleteById(id);
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}