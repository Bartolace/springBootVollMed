package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.records.usuario.DadosAutenticacao;
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

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        try{
            var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authentication = maneger.authenticate(token);
            return ResponseEntity.ok().build();

        }catch (Exception e){
            throw e;
        }
    }
}

// maneger consome tbm a AutenticacaoService


