package com.microsservicos.projeto.controledepessoas.service;

import com.microsservicos.projeto.controledepessoas.compartilhado.AnimalDto;
import com.microsservicos.projeto.controledepessoas.compartilhado.PessoaDto;
import com.microsservicos.projeto.controledepessoas.http.AnimaisFeignClient;
import com.microsservicos.projeto.controledepessoas.model.Pessoa;
import com.microsservicos.projeto.controledepessoas.repository.PessoaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository repo;

    @Autowired
    private AnimaisFeignClient animaisMsClient;

    @Override
    public PessoaDto criarPessoa(PessoaDto pessoa) {
        return salvarPessoa(pessoa);
    }

    @Override
    public List<PessoaDto> obterTodos() {
        List<Pessoa> pessoas = repo.findAll();

        return pessoas.stream()
            .map(pessoa -> new ModelMapper().map(pessoa, PessoaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<PessoaDto> obterPorId(Integer id) {
       Optional<Pessoa> pessoa = repo.findById(id);

       if(pessoa.isPresent()) {

            PessoaDto dto = new ModelMapper().map(pessoa.get(), PessoaDto.class);

           /**
            * Aqui obter animais da pessoa lá na api de animais
            */
           List<AnimalDto> animais = animaisMsClient.obterAnimaisPorDono(id);
           dto.setAnimais(animais);
           return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public void removerPessoa(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public PessoaDto atualizarPessoa(Integer id, PessoaDto pessoa) {
        pessoa.setId(id);
        return salvarPessoa(pessoa);
    }

    private PessoaDto salvarPessoa(PessoaDto pessoa) {
        ModelMapper mapper = new ModelMapper();
        Pessoa pessoaEntidade = mapper.map(pessoa, Pessoa.class);
        pessoaEntidade = repo.save(pessoaEntidade);

        return mapper.map(pessoaEntidade, PessoaDto.class);
    }
}
