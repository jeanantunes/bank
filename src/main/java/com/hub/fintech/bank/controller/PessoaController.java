package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Copyright JotaIT Services
 */

// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@RestController
@RequestMapping("/api") // declares that the url for all the apis in this controller will start with /api.
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/pessoa/list")
    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    // @RequestBody annotation is used to bind the request body with a method parameter.
    // @Valid annotation makes sure that the request body is valid. Remember, we had marked Note’s title and content
    // Save
    @PutMapping(value = "/pessoa/save/{pessoa}", produces = "application/text")
    public @ResponseBody
    String savePessoa(@Valid @RequestBody Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return "Pessoa Salva com Sucesso.";
    }

    // @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter.
    @PostMapping(value = "/pessoa/find/{id}", produces = "application/json")
    public @ResponseBody Pessoa getPessoaById(@PathVariable(value = "id") Long id) {
        return pessoaRepository.findById(id);
    }

    // Update
    @PutMapping(value = "/pessoa/update/{id}", produces = "application/json")
    public @ResponseBody Pessoa updatePessoa(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody Pessoa pessoaDetails) {

        Pessoa pessoa = pessoaRepository.findById(id);
        if (pessoa != null){
        pessoaRepository.save(pessoaDetails);
        }else {
            System.out.println("Pessoa não encontrada");
        }
        return pessoaDetails;
    }

    // Delete
    @DeleteMapping("/pessoa/delete/{id}")
    public String deletePessoa(@PathVariable(value = "id") Long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (pessoa != null) {
            pessoaRepository.delete(id);
            return "DELETE realizado com Sucesso.";
        }else {
            return "Pessoa não localizada";
        }
    }
}
