package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.entity.usuario.Usuario;
import med.voll.api.infra.security.DadosTokenJWT;
import med.voll.api.records.usuario.DadosAutenticacao;
import med.voll.api.service.TokenService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager maneger; // classe do spring
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        try{
            var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());// converte ao DTO do SpringSecurity
            var authentication = maneger.authenticate(token); // chama o repository
            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

        }catch (Exception e){
            throw e;
        }
    }
}

// maneger consome tbm a AutenticacaoService


