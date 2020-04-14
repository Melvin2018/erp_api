package erp.compra.Controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import erp.compra.Entidades.Empresa;
import erp.compra.Servicios.Service_Empresa;

@RestController
@RequestMapping(value = "/api/v1/")
public class EmpresaControler {

    @Autowired
    private Service_Empresa s_empresa;

    @GetMapping(value = "empresa", produces = "application/json; charset=utf-8")
    public List<Empresa> finAll() {
        return s_empresa.findAll();
    }

    @GetMapping(value = "empresa/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<Empresa> empresa(@PathVariable(value = "id", required = true) Long id) {
        return s_empresa.findOne(id);
    }

    @PostMapping(value = "empresa", produces = "application/json; charset=utf-8", consumes = "application/json")
    public Empresa save(@RequestBody @Valid Empresa empresa) {
        return s_empresa.save(empresa);
    }
}
