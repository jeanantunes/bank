package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.model.entity.Pj;
import com.hub.fintech.bank.model.enums.TipoPessoaEnum;
import com.hub.fintech.bank.service.PessoaService;
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
@RequestMapping("/pj")
public class PjController {

    @Autowired
    private PjService pjService;

    @Autowired
    private PessoaService pessoaService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<Pj> getAllPj() {
        List<Pj> pj = pjService.findAll();
        if (pj.isEmpty()) {
            logger.error("Lista de Pessoas Jurídica vazia: " + pj);
        }
        return pj;
    }

    // Save
    @PutMapping(value = "/save/{pj}", produces = "application/text")
    public @ResponseBody
    String savePj(@Valid @RequestBody Pj pj) {

        pjService.save(pj);

        Pessoa pessoa = pjService.findById(pj.getId());
        pj.setRazaoSocial(pj.getRazaoSocial());
        pj.setNomeFantasia(pj.getNomeFantasia());
        pessoa.setCnpj(pj.getCnpj());
        pessoa.setPessoaTipo(TipoPessoaEnum.CNPJ);
        pessoa.setContaId(pj.getId());

        pessoaService.save(pessoa);

        if (pj.getCnpj() != null || pj.getRazaoSocial() != null || pj.getNomeFantasia() != null) {
            pjService.save(pj);
            logger.info("Pj Salvo: " + pj.getCnpj() + ", " + pj.getNomeFantasia() + ", " + pj.getRazaoSocial() + "");
            return "Salvo com Sucesso.";
        } else {
            logger.error("Dados obrigatórios: cnpj: " + pj.getCnpj() + " nomeFantasia: " + pj.getNomeFantasia() + " razaoSocial: " + pj.getRazaoSocial() + "");
            return "Dados obrigatórios: cnpj: " + pj.getCnpj() + " nomeFantasia: " + pj.getNomeFantasia() + " razaoSocial: " + pj.getRazaoSocial() + "";
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    Pj getPjById(@PathVariable(value = "id") Long id) {
        Pj Pj = pjService.findById(id);
        if (Pj == null) {
            logger.error("ID: " + id + " não Localizado.");
        }
        return Pj;
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/text")
    public @ResponseBody
    String updatePj(@PathVariable(value = "id") Long id,
                    @Valid @RequestBody Pj pjDetails) {
        Pj pj = pjService.findById(id);
        if (pj == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "ID: " + id + ". Não Localizado.";
        } else {
            pjService.save(pjDetails);
            logger.info("Pessoa Jurídica atualizada com Sucesso.");
        }
        return "Atualizado com Sucesso.";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deletePj(@PathVariable(value = "id") Long id) {
        Pj pj = pjService.findById(id);
        if (pj == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "Pessoa Jurídica não localizada.";
        } else {
            pjService.delete(pj);
            return "Excluido com Sucesso.";
        }
    }
}