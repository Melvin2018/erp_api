package erp.compra.Repositorio;

import erp.compra.Entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Compra extends JpaRepository<Compra, Long> {

}
