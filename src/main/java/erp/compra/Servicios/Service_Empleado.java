package erp.compra.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import erp.compra.Entidades.*;
import erp.compra.Repositorio.Repo_Empleado;
import erp.compra.Repositorio.Repo_Sucursal;

public class Service_Empleado {
    @Autowired
    private Repo_Empleado empleado;
    @Autowired
    private Repo_Sucursal sucursal;

    public ResponseEntity<List<Empleado>> findAll(Long id) {
        Optional<Sucursal> opt = sucursal.findById(id);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get().getEmpleadoList().stream()
                    .sorted(Comparator.comparing(Empleado::getNombre)).collect(Collectors.toList()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Empleado> save(Empleado empleado) {
        return ResponseEntity.ok(this.empleado.saveAndFlush(empleado));
    }
    public ResponseEntity<Empleado> findById(Long id) {
        Optional<Empleado> opt = empleado.findById(id);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    public ResponseEntity<Empleado> deleteById(Long id) {
        Optional<Empleado> opt = empleado.findById(id);
        if (opt.isPresent()) {
            empleado.deleteById(id);
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}