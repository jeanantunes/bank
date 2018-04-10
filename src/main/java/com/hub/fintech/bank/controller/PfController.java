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

@RestController
@RequestMapping("/api")
public class PfController {

    @Autowired
    private PfService pfService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/pf/list")
    public List<Pf> getAllPf() {
        return pfService.findAll();
    }

    // Save
    @PutMapping(value = "/pf/save/{pf}", produces = "application/json")
    public @ResponseBody
    Pf savePf(@Valid @RequestBody Pf pf) {
        pfService.save(pf);
        return pf;
    }

    // Find
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
