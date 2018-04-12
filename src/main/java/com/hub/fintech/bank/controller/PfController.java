package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.model.entity.Pf;
import com.hub.fintech.bank.model.enums.TipoPessoaEnum;
import com.hub.fintech.bank.service.PessoaService;
import com.hub.fintech.bank.service.PfService;
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
@RequestMapping("/pf")
public class PfController {

    @Autowired
    private PfService pfService;

    @Autowired
    private PessoaService pessoaService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<Pf> getAllPf() {
        List<Pf> pf = pfService.findAll();
        if (pf.isEmpty()) {
            logger.error("Lista de Pessoas Física vazia: " + pf);
        }
        return pf;
    }

    // Save
    @PutMapping(value = "/save/{pf}", produces = "application/text")
    public @ResponseBody
    String savePf(@Valid @RequestBody Pf pf) {

        pfService.save(pf);

        Pessoa pessoa = pfService.findById(pf.getId());
        ((Pf) pessoa).setDataNasc(pf.getDataNasc());
        ((Pf) pessoa).setNome(pf.getNome());
        pessoa.setCpf(pf.getCpf());
        pessoa.setPessoaTipo(TipoPessoaEnum.CPF);
        pessoa.setContaId(pf.getId());

        pessoaService.save(pessoa);

        if (pf.getCpf() != null || pf.getDataNasc() != null || pf.getNome() != null) {
            pfService.save(pf);
            logger.info("PF Salvo: " + pf.getNome() + ", " + pf.getDataNasc() + ", " + pf.getCpf() + "");
            return "Salvo com Sucesso.";
        } else {
            logger.error("Dados obrigatórios: cpf: " + pf.getCpf() + " dataNasc: " + pf.getDataNasc() + " nome: " + pf.getNome() + "");
            return "Dados obrigatórios: cpf: " + pf.getCpf() + " dataNasc: " + pf.getDataNasc() + " nome: " + pf.getNome() + "";
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    Pf getPfById(@PathVariable(value = "id") Long id) {
        Pf pf = pfService.findById(id);
        if (pf == null) {
            logger.error("ID: " + id + " não Localizado.");
        }
        return pf;
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/text")
    public @ResponseBody
    String updatePf(@PathVariable(value = "id") Long id,
                        @Valid @RequestBody Pf pfDetails) {
        Pf pf = pfService.findById(id);
        if (pf == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "ID: " + id + ". Não Localizado.";
        } else {
            pfService.save(pfDetails);
            logger.info("Pessoa Física atualizada com Sucesso.");
        }
        return "Atualizado com Sucesso.";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deletePf(@PathVariable(value = "id") Long id) {
        Pf pf = pfService.findById(id);
        if (pf == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "Pessoa Jurídica não localizada.";
        } else {
            pfService.delete(pf);
            return "Excluido com Sucesso.";
        }
    }
}