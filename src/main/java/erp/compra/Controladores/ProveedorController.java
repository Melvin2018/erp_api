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

import erp.compra.Entidades.Proveedor;
import erp.compra.Servicios.Service_Proveedor;


@RestController
@RequestMapping(value = "/api/v1/")
public class ProveedorController {
    @Autowired
    private Service_Proveedor proveedor;
  

    @GetMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Proveedor> findAll() {
        return proveedor.findAll();
    }

    @GetMapping(value = "categoria/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<Proveedor> empresa(@PathVariable(value = "id", required = true) Long id) {
        return proveedor.findOne(id);
    }

    @PostMapping(value = "categoria", produces = "application/json; charset=utf-8", consumes = "application/json")
    public Proveedor save(@RequestBody Proveedor inventarioo) {
        return proveedor.save(inventarioo);
    }

    @DeleteMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proveedor> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return proveedor.deleteById(id);
    }
}