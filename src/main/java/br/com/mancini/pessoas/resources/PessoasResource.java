package br.com.mancini.pessoas.resources;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import br.com.mancini.pessoas.entitties.Pessoa;
import br.com.mancini.pessoas.respositories.PessoaRepository;

@Path("/pessoas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoasResource {
    @Inject
    PessoaRepository repository;

    @ConfigProperty(name = "pessoas.mensagem", defaultValue = "Deu errado")
    private Optional<String> message;
    
    @POST
    public Response criar(@Valid Pessoa pessoa) {
        return Response.status(Status.CREATED).entity(repository.save(pessoa)).build();
    }

    @GET
    public List<Pessoa> listarTodos() {
        System.out.println(message.get());
        return repository.findAll();
    }
}