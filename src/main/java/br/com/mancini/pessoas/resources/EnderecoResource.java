package br.com.mancini.pessoas.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.mancini.pessoas.clients.Endereco;
import br.com.mancini.pessoas.clients.EnderecoService;
import io.quarkus.security.Authenticated;

@Path("/enderecos")
@SecurityScheme(securitySchemeName = "quarkus-auth", type = SecuritySchemeType.OAUTH2, 
flows = @OAuthFlows(password = @OAuthFlow(tokenUrl = "http://localhost:8180/auth/realms/quarkus/protocol/openid-connect/token")))
@Tag(name = "enderecos")
@SecurityRequirement(name = "quarkus-auth")
@Authenticated
public class EnderecoResource {

	@Inject
	EnderecoService enderecoService;

    @GET
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(
        name = "quantidade de busca de endereco",
        description = "quantidade de busca de endereços"
    )
    @Timed(name = "tempo de busca endereco")
    public Endereco buscarEndereco(@PathParam("cep") String cep) {
        return enderecoService.getEndereco(cep);
    }
}