package br.com.mancini.pessoas.clients;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class EnderecoService {
    @RestClient
	@Inject
	EnderecoClient enderecoClient;
    
    @Traced
    public Endereco getEndereco(String cep) {
        Endereco endereco = enderecoClient.getEndereco(cep);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }
}