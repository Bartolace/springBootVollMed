package med.voll.api.controller;

import med.voll.api.entity.Endereco;
import med.voll.api.entity.Medico;
import med.voll.api.enums.Especialidade;
import med.voll.api.records.medico.DadosCadastroMedico;
import med.voll.api.records.medico.DadosDetalhamentoMedico;
import med.voll.api.records.medico.DadosEndereco;
import med.voll.api.repository.MedicoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroMedico> dadosCadastroMedicoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoMedico> dadosDetalhamentoMedicoJson;

    @MockBean
    private MedicoRepository repository;

    @Test
    @DisplayName("Deveria devolver http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrarCenari1() throws Exception {
        //given
        var response = mvc.perform(post("/medicos"))
                .andReturn().getResponse();
        //when ou act
        //nothing
        //then ou assert
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver http 201 quando informacoes estao validas")
    @WithMockUser
    void cadastrarCenario2() throws Exception {
        //given
        var dadosCadastroMedico = new DadosCadastroMedico(
                "Gabriel",
                "gabriel@vollmed.com",
                "67991031805",
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco());

        //when ou act
        when(repository.save(any())).thenReturn(new Medico(dadosCadastroMedico));

        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastroMedico)
                                .getJson())
                ).andReturn().getResponse();

        var dadosDetalhamentoMedico = new DadosDetalhamentoMedico(
                null,
                dadosCadastroMedico.nome(),
                dadosCadastroMedico.email(),
                dadosCadastroMedico.telefone(),
                dadosCadastroMedico.crm(),
                dadosCadastroMedico.especialidade(),
                new Endereco(dadosCadastroMedico.endereco())
        );


        //then ou assert
        var jsonEsperado = dadosDetalhamentoMedicoJson.write(dadosDetalhamentoMedico).getJson();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Campo Grande",
                "MS",
                "casa terrea",
                "378"

        );
    }
}