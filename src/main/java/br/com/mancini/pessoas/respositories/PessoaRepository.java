package br.com.mancini.pessoas.respositories;

import javax.enterprise.context.ApplicationScoped;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mancini.pessoas.entitties.Pessoa;

@ApplicationScoped
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}