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

@RestController
@RequestMapping("/pj")
public class PjController {

    @Autowired
    private PjService pjService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<Pj> getAllPj() {
        return pjService.findAll();
    }

    // Save
    @PutMapping(value = "/save/{pj}", produces = "application/json")
    public @ResponseBody
    Pj savePj(@Valid @RequestBody Pj pj) {
        pjService.save(pj);
        return pj;
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    Pj getPjById(@PathVariable(value = "id") Long id) {
        return pjService.findById(id);
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/json")
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
    @DeleteMapping("/delete/{id}")
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
