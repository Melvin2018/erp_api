package erp.compra.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import erp.compra.Entidades.*;
import erp.compra.Servicios.Service_Usuario;

@RestController
@RequestMapping(value = "/api/v1/")
public class UsuarioController {
    @Autowired
    private Service_Usuario user;
  

    @GetMapping(value="usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> findAll() {
        return user.findAll();
    }

    @GetMapping(value = "usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> findBy(@PathVariable(value = "id", required = true) Long id) {
        return user.findOne(id);
    }

    @PostMapping(value = "usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario save(@RequestBody Usuario inventarioo) {
        return user.save(inventarioo);
    }

    @DeleteMapping(value="usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return user.deleteById(id);
    }
}