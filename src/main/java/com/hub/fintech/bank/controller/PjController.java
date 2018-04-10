package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Pj;
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

// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@RestController
@RequestMapping("/api") // declares that the url for all the apis in this controller will start with /api.
public class PjController {

    private PjService pjService;

    @Autowired
    public void setPjService(PjService pjService) {
        this.pjService = pjService;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/pj/list")
    public List<Pj> getAllPj() {
        return pjService.findAll();
    }

    // @RequestBody annotation is used to bind the request body with a method parameter.
    // @Valid annotation makes sure that the request body is valid. Remember, we had marked Note’s title and content
    // Save
    @PutMapping(value = "/pj/save/{pj}", produces = "application/json")
    public @ResponseBody
    Pj savePj(@Valid @RequestBody Pj pj) {
        pjService.save(pj);
        return pj;
    }

    // @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter.
    @PostMapping(value = "/pj/find/{id}", produces = "application/json")
    public @ResponseBody
    Pj getPjById(@PathVariable(value = "id") Long id) {
        return pjService.findById(id);
    }

    // Update
    @PutMapping(value = "/pj/update/{id}", produces = "application/json")
    public @ResponseBody
    Pj updatePj(@PathVariable(value = "id") Long id,
                @Valid @RequestBody Pj pjDetails) {

        Pj pj = pjService.findById(id);
        if (pj != null) {
            pjService.save(pjDetails);
        } else {
            System.out.println("Pessoa Física não encontrada");
        }
        return pjDetails;
    }

    // Delete
    @DeleteMapping("/pj/delete/{id}")
    public String deletePj(@PathVariable(value = "id") Long id) {
        Pj pj = pjService.findById(id);
        if (pj != null) {
            pjService.delete(id);
            return "DELETE realizado com Sucesso.";
        } else {
            return "Pessoa Jurídica não localizada";
        }
    }
}
