package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Pf;
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

// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@RestController
@RequestMapping("/api") // declares that the url for all the apis in this controller will start with /api.
public class PfController {

    private PfService pfService;

    @Autowired
    public void setPfService(PfService pfService) {
        this.pfService = pfService;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/pf/list")
    public List<Pf> getAllPf() {
        return pfService.findAll();
    }

    // @RequestBody annotation is used to bind the request body with a method parameter.
    // @Valid annotation makes sure that the request body is valid. Remember, we had marked Note’s title and content
    // Save
    @PutMapping(value = "/pf/save/{pf}", produces = "application/json")
    public @ResponseBody
    Pf savePf(@Valid @RequestBody Pf pf) {
        pfService.save(pf);
        return pf;
    }

    // @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter.
    @PostMapping(value = "/pf/find/{id}", produces = "application/json")
    public @ResponseBody
    Pf getPfById(@PathVariable(value = "id") Long id) {
        return pfService.findById(id);
    }

    // Update
    @PutMapping(value = "/pf/update/{id}", produces = "application/json")
    public @ResponseBody
    Pf updatePf(@PathVariable(value = "id") Long id,
                @Valid @RequestBody Pf pfDetails) {

        Pf pf = pfService.findById(id);
        if (pf != null) {
            pfService.save(pfDetails);
        } else {
            System.out.println("Pessoa Física não encontrada");
        }
        return pfDetails;
    }

    // Delete
    @DeleteMapping("/pf/delete/{id}")
    public String deletePf(@PathVariable(value = "id") Long id) {
        Pf pf = pfService.findById(id);
        if (pf != null) {
            pfService.delete(id);
            return "DELETE realizado com Sucesso.";
        } else {
            return "Pessoa Fícica não localizada";
        }
    }
}
