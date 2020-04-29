package erp.compra.Controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import erp.compra.Entidades.Empleado;
import erp.compra.Servicios.Empleado_Service;

@RequestMapping(value = "/api/v1/")
public class EmpleadoControler {

    @Autowired
    private Empleado_Service service;

    @GetMapping(value = "empleado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Empleado>> findAll(@RequestParam(value = "sucursal", required = true) Long id) {
        return service.findAll(id);
    }

    @GetMapping(value = "empleado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> findById(@PathVariable(value = "id", required = true) Long id) {
        return service.findById(id);
    }

    

    @PostMapping(value = "empleado", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> findById(@RequestBody @Valid Empleado empleado) {
        return service.save(empleado);
    }

    @DeleteMapping(value = "empleado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return service.deleteById(id);
    }
} 