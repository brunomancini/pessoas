package br.com.mancini.pessoas;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;

import br.com.mancini.pessoas.clients.Endereco;
import br.com.mancini.pessoas.clients.EnderecoService;
import io.quarkus.test.Mock;

@Priority(1)
@Mock
@ApplicationScoped
public class EnderecoServiceMock extends EnderecoService {
    
    @Override
    public Endereco getEndereco(String cep) {
        Endereco endereco = new Endereco();
        endereco.setBairro("Jd. Paineiras");
        endereco.setCep("09932-240");
        endereco.setUf("SP");

        return endereco;
    }
}