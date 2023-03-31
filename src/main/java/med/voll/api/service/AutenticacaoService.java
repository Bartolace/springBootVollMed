package med.voll.api.service;

import med.voll.api.repository.UsuarioRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepoitory repoitory;

    @Override // implementacao
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repoitory.findByLogin(username);
    }
}
// UserDatailsService: detectada automaticamente no processo de Login