package com.microsservicos.projeto.controledepessoas.view.model;

import com.microsservicos.projeto.controledepessoas.compartilhado.AnimalDto;
import java.util.List;

public class PessoaModeloResponseDetalhes extends PessoaModeloResponse {

    private List<AnimalDto> animais;

    public List<AnimalDto> getAnimais() {
        return animais;
    }

    public void setAnimais(List<AnimalDto> animais) {
        this.animais = animais;
    }
}
