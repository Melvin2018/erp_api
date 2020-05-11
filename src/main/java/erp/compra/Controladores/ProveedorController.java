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
import erp.compra.Servicios.Service_Proveedor;


@RestController
@RequestMapping(value = "/api/v1/")
public class ProveedorController {
    @Autowired
    private Service_Proveedor repo_proveedor;
  

    @GetMapping(value="proveedor", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Proveedor> findAll() {
        return repo_proveedor.findAll();
    }

    @GetMapping(value = "proveedor/{id}", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Proveedor> findBy(@PathVariable(value = "id", required = true) Long id) {
        return repo_proveedor.findOne(id);
    }

    @PostMapping(value = "proveedor", produces =  MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public Proveedor save(@RequestBody Proveedor proveedor) {
        return repo_proveedor.save(proveedor);
    }

    @DeleteMapping(value="proveedor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proveedor> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return repo_proveedor.deleteById(id);
    }
}