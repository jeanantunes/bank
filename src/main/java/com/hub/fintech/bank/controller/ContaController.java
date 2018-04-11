package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Conta;
import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.service.ContaService;
import com.hub.fintech.bank.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private PessoaService pessoaService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<Conta> getAllContas() {
        List<Conta> c = contaService.findAll();
        if (c.isEmpty()){
            logger.error("Lista de Contas vazia: "+c);
        }
        return c;
    }

    // Save
    public @RequestMapping(method = RequestMethod.PUT, value = "/save/{conta}", produces = "application/text")
    String saveConta(@Valid @RequestBody Conta conta,
                    @RequestParam(name = "pessoaId") Long pessoaId, Model model) {
        model.addAttribute("pessoaId", pessoaId);
        Pessoa p = pessoaService.findById(pessoaId);
        if (p == null){
            logger.error("PESSOA_ID: "+pessoaId+". Não Localizado. Obrigatório associar Pessoa a Conta.");
            return "PESSOA_ID: "+pessoaId+". Não Localizado. Obrigatório associar Pessoa a Conta.";
        }else {
        conta.setPessoaId(pessoaId);
        if (p.getCpf() != null || p.getCnpj() != null) {
            p.setPessoaTipo(conta.getPessoaTipo());
            p.setCpf(conta.getCpf());
            p.setCnpj(conta.getCnpj());
            p.setContaId(pessoaId);
            pessoaService.save(p);
            conta.setContaId(pessoaId);
            contaService.save(conta);
            logger.info("PESSOA_ID: "+pessoaId+" CONTA_ID: "+conta.getId()+". Conta criada com Sucesso.");
            return "Conta criada com Sucesso.";
            }else {
            logger.error("Pessoa CPF ou CNPJ obrigatório.");
            return "Pessoa CPF ou CNPJ Obrigatório. Atualize antes de associar a Conta.";
        }
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    Conta getContaById(@PathVariable(value = "id") Long id) {
        Conta c = contaService.findById(id);
        if (c == null){
            logger.error("ID: "+id+" não Localizado.");
        }
        return c;
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/text")
    public @ResponseBody
    String updateConta(@PathVariable(value = "id") Long id,
                      @Valid @RequestBody Conta contaDetails) {
        Conta c = contaService.findById(id);
        if (c == null) {
            logger.error("ID: "+id+". Não Localizado.");
            return "ID: "+id+". Não Localizado.";
        } else {
            contaService.save(contaDetails);
            logger.info("Conta atualizada com Sucesso.");
        }
        return "Atualizado com Sucesso.";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deleteConta(@PathVariable(value = "id") Long id) {
        Conta c = contaService.findById(id);
        if (c == null) {
            logger.error("ID: "+id+". Não Localizado.");
            return "Conta não localizada.";
        } else {
            contaService.delete(c);
            return "Excluido com Sucesso.";
        }
    }
}
