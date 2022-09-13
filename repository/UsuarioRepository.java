package expertostech.tutorial.rest.api.repository;

import expertostech.tutorial.rest.api.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {


    static boolean existsById(long codigo) {
        return true;
    }

    static boolean deleteById(long codigo) {
        return true;
    }

    static boolean deleteALL() {
        return true;
    }

    static boolean findById(long codigo) {
        return true;
    }
}

