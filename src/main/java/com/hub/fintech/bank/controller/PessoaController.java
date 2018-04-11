package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.model.entity.Pf;
import com.hub.fintech.bank.model.entity.Pj;
import com.hub.fintech.bank.service.PessoaService;
import com.hub.fintech.bank.service.PfService;
import com.hub.fintech.bank.service.PjService;
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
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PfService pfService;

    @Autowired
    private PjService pjService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<Pessoa> getAllPessoas() {
        List<Pessoa> p = pessoaService.findAll();
        if (p.isEmpty()){
            logger.error("Lista de Pessoas vazia: "+p);
        }
        return p;
    }

    // Save
    @PutMapping(value = "/save/{pessoa}", produces = "application/text")
    public @ResponseBody
    String savePessoa(@Valid @RequestBody Pessoa pessoa) {
        pessoaService.save(pessoa);
        if (pessoa.getContaId() == null){
            logger.warn("PESSOA_ID: "+pessoa.getId()+" não possui Conta associada."+" CONTA_ID: "+pessoa.getContaId());
            return "PESSOA_ID: "+pessoa.getId()+". Não possui Conta associada. Pessoa Salva com Sucesso.";
        }
        return "Pessoa Salva com Sucesso.";
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    Pessoa getPessoaById(@PathVariable(value = "id") Long id) {
        Pessoa p = pessoaService.findById(id);
        if (p == null){
            logger.error("ID: "+id+" não Localizado.");
        }
        return p;
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/text")
    public @ResponseBody
    String updatePessoa(@PathVariable(value = "id") Long id,
                        @Valid @RequestBody Pessoa pessoaDetails) {
        Pessoa p = pessoaService.findById(id);
        if (p == null) {
            logger.error("ID: "+id+". Não Localizado.");
            return "ID: "+id+". Não Localizado.";
        } else {
            pessoaService.save(pessoaDetails);
            logger.info("Pessoa atualizada com Sucesso.");
        }
        return "Atualizado com Sucesso.";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deletePessoa(@PathVariable(value = "id") Long id) {
        Pessoa p = pessoaService.findById(id);
        if (p == null) {
            logger.error("ID: "+id+". Não Localizado.");
            return "Pessoa não localizada.";
        }else {
        pessoaService.delete(p);
        return "Excluido com Sucesso.";
        }
    }
}
