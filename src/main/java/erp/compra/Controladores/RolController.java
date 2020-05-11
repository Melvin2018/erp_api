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
import erp.compra.Servicios.Service_Rol;

@RestController
@RequestMapping(value = "/api/v1/")
public class RolController {
    @Autowired
    private Service_Rol repo_rol;
  

    @GetMapping(value="rol", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Rol> findAll() {
        return repo_rol.findAll();
    }

    @GetMapping(value = "rol/{id}", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Rol> findBy(@PathVariable(value = "id", required = true) Long id) {
        return repo_rol.findOne(id);
    }

    @PostMapping(value = "rol", produces =  MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public Rol save(@RequestBody Rol rol) {
        return repo_rol.save(rol);
    }

    @DeleteMapping(value="rol/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rol> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return repo_rol.deleteById(id);
    }
}