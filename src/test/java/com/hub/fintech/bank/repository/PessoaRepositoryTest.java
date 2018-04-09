package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.BankApplication;
import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.model.enums.TipoPessoaEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankApplication.class)
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void givenPessoaRepository_whenSaveAndRetreiveEntity_thenOK() {

        Pessoa pessoa = new Pessoa();
        pessoa.setId(1l);
        pessoa.setPessoa(TipoPessoaEnum.CPF);
        pessoaRepository.save(pessoa);
        Pessoa encontrado = pessoaRepository
                .findById(pessoa.getId());

        assertNotNull(encontrado);
        assertEquals(pessoa.getId(), encontrado.getId());
    }
}