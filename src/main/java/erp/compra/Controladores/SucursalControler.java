package erp.compra.Controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import erp.compra.Entidades.Sucursal;
import erp.compra.Servicios.Service_Sucursal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api/v1/")
public class SucursalControler {
    @Autowired
    private Service_Sucursal sucusal;

    @GetMapping(value = "sucursal", produces = "application/json; charset=utf-8")
    public List<Sucursal> finAll() {
        return sucusal.findAll();
    }

    @GetMapping(value = "sucursal/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<Sucursal> empresa(@PathVariable(value = "id", required = true) Long id) {
        return sucusal.findOne(id);
    }

    @PostMapping(value = "sucursal", produces = "application/json; charset=utf-8", consumes = "application/json")
    public Sucursal save(@RequestBody Sucursal sucursal) {
        return sucusal.save(sucursal);
    }

}