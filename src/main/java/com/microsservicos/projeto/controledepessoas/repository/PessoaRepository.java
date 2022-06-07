package com.microsservicos.projeto.controledepessoas.repository;

import com.microsservicos.projeto.controledepessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
}
