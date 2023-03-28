package med.voll.api.repository;

import med.voll.api.entity.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepoitory extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
