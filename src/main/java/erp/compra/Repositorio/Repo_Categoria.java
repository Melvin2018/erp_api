package erp.compra.Repositorio;

import erp.compra.Entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Categoria extends JpaRepository<Categoria, Long> {
    
}
