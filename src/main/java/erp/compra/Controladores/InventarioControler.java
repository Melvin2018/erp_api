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

import erp.compra.Entidades.Inventario;
import erp.compra.Servicios.Service_Inventario;

@RestController
@RequestMapping(value = "/api/v1/")
public class InventarioControler {
    
    @Autowired
    private Service_Inventario inventario;

    @GetMapping(value="inventario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Inventario>> findAll(@PathVariable(value = "id", required = true) Long id) {
        return inventario.findAll(id);
    }

    @GetMapping(value = "inventario/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<Inventario> empresa(@PathVariable(value = "id", required = true) Long id) {
        return inventario.findOne(id);
    }

    @PostMapping(value = "inventario", produces = "application/json; charset=utf-8", consumes = "application/json")
    public Inventario save(@RequestBody Inventario inventarioo) {
        return inventario.save(inventarioo);
    }

    @DeleteMapping(value="inventario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventario> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return inventario.deleteById(id);
    }

}