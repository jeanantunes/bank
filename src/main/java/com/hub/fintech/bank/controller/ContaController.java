package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Conta;
import com.hub.fintech.bank.service.ContaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@RestController
@RequestMapping("/api") // declares that the url for all the apis in this controller will start with /api.
public class ContaController {

    private ContaService contaService;

    @Autowired
    public void setContaService(ContaService contaService){
        this.contaService=contaService;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/conta/list")
    public List<Conta> getAllContas() {
        return contaService.findAll();
    }

    // @RequestBody annotation is used to bind the request body with a method parameter.
    // @Valid annotation makes sure that the request body is valid. Remember, we had marked Note’s title and content
    // Save
    @PutMapping(value = "/conta/save/{conta}", produces = "application/json")
    public @ResponseBody
    Conta saveConta(@Valid @RequestBody Conta conta) {
        contaService.save(conta);
        return conta;
    }

    // @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter.
    @PostMapping(value = "/conta/find/{id}", produces = "application/json")
    public @ResponseBody Conta getContaById(@PathVariable(value = "id") Long id) {
        return contaService.findById(id);
    }

    // Update
    @PutMapping(value = "/conta/update/{id}", produces = "application/json")
    public @ResponseBody Conta updateConta(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody Conta contaDetails) {

        Conta conta = contaService.findById(id);
        if (conta != null){
        contaService.save(contaDetails);
        }else {
            System.out.println("Conta não encontrada");
        }
        return contaDetails;
    }

    // Delete
    @DeleteMapping("/conta/delete/{id}")
    public String deleteConta(@PathVariable(value = "id") Long id) {
        Conta conta = contaService.findById(id);
        if (conta != null) {
            contaService.delete(id);
            return "DELETE realizado com Sucesso.";
        }else {
            return "Conta não localizada";
        }
    }
}
