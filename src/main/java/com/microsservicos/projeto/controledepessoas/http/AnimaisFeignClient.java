package com.microsservicos.projeto.controledepessoas.http;

import com.microsservicos.projeto.controledepessoas.compartilhado.AnimalDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "controle-animais-ms")
public interface AnimaisFeignClient {

    /**
     * O OpenFeign vai fazer uma requisição para a api de controle de animais
     * Só será executado quando chamar esse path
     * @param dono id do bono
     * @return lista de animais de acordo com o dono
     */
    @GetMapping(path = "/api/animais/{dono}/lista")
    List<AnimalDto> obterAnimaisPorDono(@PathVariable Integer dono);
}
