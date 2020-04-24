package br.com.mancini.pessoas.clients;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.cache.CacheResult;

@RegisterRestClient
@Path("/ws")
public interface EnderecoClient {

    @GET
    @Path("/{cep}/json")
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "endereco", lockTimeout = 10)
    public Endereco getEndereco(@PathParam(value = "cep") String cep);
}