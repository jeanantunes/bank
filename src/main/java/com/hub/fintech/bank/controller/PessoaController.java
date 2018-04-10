package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@RestController
@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/pessoa/list")
    public List<Pessoa> getAllPessoas() {
        return pessoaService.findAll();
    }

    // Save
    @PutMapping(value = "/pessoa/save/{pessoa}", produces = "application/text")
    public @ResponseBody
    String savePessoa(@Valid @RequestBody Pessoa pessoa) {
        pessoaService.save(pessoa);
        return "Pessoa Salva com Sucesso.";
    }

    // Find
    @PostMapping(value = "/pessoa/find/{id}", produces = "application/json")
    public @ResponseBody
    Pessoa getPessoaById(@PathVariable(value = "id") Long id) {
        return pessoaService.findById(id);
    }

    // Update
    @PutMapping(value = "/pessoa/update/{id}", produces = "application/json")
    public @ResponseBody
    Pessoa updatePessoa(@PathVariable(value = "id") Long id,
                        @Valid @RequestBody Pessoa pessoaDetails) {

        Pessoa pessoa = pessoaService.findById(id);
        if (pessoa != null) {
            pessoaService.save(pessoaDetails);
        } else {
            System.out.println("Pessoa não encontrada");
        }
        return pessoaDetails;
    }

    // Delete
    @DeleteMapping("/pessoa/delete/{id}")
    public String deletePessoa(@PathVariable(value = "id") Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        if (pessoa != null) {
            pessoaService.delete(id);
            return "DELETE realizado com Sucesso.";
        } else {
            return "Pessoa não localizada";
        }
    }
}
