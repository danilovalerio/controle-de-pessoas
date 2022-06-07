package com.microsservicos.projeto.controledepessoas.service;

import com.microsservicos.projeto.controledepessoas.compartilhado.PessoaDto;
import java.util.List;
import java.util.Optional;


public interface PessoaService {
    PessoaDto criarPessoa(PessoaDto pessoa);
    List<PessoaDto> obterTodos();
    Optional<PessoaDto> obterPorId(Integer id);
    void removerPessoa(Integer id);
    PessoaDto atualizarPessoa(Integer id, PessoaDto pessoa);
}
