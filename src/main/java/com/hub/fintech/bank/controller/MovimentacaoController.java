package com.hub.fintech.bank.controller;

import com.hub.fintech.bank.model.entity.Movimentacao;
import com.hub.fintech.bank.service.MovimentacaoService;
import com.hub.fintech.bank.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private PessoaService pessoaService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<Movimentacao> getAllMovimentacao() {
        List<Movimentacao> movimentacao = movimentacaoService.findAll();
        if (movimentacao.isEmpty()) {
            logger.error("Lista de Pessoas Jurídica vazia: " + movimentacao);
        }
        return movimentacao;
    }

    // Save
    @PutMapping(value = "/save/{movimentacao}", produces = "application/text")
    public @ResponseBody
    String saveMovimentacao(@RequestBody Movimentacao movimentacao) {
        try {
            movimentacaoService.save(movimentacao);
            logger.info("Saldo: " + movimentacao.getSaldo());

            return "Saldo: " + movimentacao.getSaldo();

        } catch (Exception e) {
            logger.error("Erro ao realizar Movimentação: " + e.getMessage());
            return "Erro ao realizar Movimentação";
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    Movimentacao getMovimentacaoById(@PathVariable(value = "id") Long id) {
        Movimentacao Movimentacao = movimentacaoService.findById(id);
        if (Movimentacao == null) {
            logger.error("ID: " + id + " não Localizado.");
        }
        return Movimentacao;
    }
}