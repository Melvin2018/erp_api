package erp.compra.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import erp.compra.Entidades.*;
import erp.compra.Repositorio.Repo_Inventario;
import erp.compra.Repositorio.Repo_Sucursal;

@Service
public class Service_Inventario {
    @Autowired
    private Repo_Inventario inventario;
    @Autowired
    private Repo_Sucursal sucursal;

    public ResponseEntity<List<Inventario>> findAll(Long id) {
        Optional<Sucursal> opt = sucursal.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok(opt.get().getInventarioList().stream()
            .sorted(Comparator.comparing(Inventario::getId)).collect(Collectors.toList()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Inventario> findOne(Long id) {
        Optional<Inventario> find = inventario.findById(id);
        return ResponseEntity.of(find);
    }

    public Inventario save(Inventario s) {
        return inventario.save(s);
    }
    public ResponseEntity<Inventario> deleteById(Long id){
        Optional<Inventario> opt = inventario.findById(id);
        if(opt.isPresent()){
            inventario.deleteById(id);
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}