package erp.compra.Repositorio;

import erp.compra.Entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_DetalleInventario extends JpaRepository<Detalleinventario, Long> {
    
}