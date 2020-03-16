package erp.compra.Repositorio;

import erp.compra.Entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Roles_Usuario extends JpaRepository<Rolesusuarios, Long> {

}
