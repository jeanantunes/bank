package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Conta;
import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.model.enums.StatusEnum;
import com.hub.fintech.bank.model.enums.TipoContaEnum;
import com.hub.fintech.bank.model.enums.TipoPessoaEnum;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ContaServiceTest {

    @Autowired
    private ContaService contaService;

    @Autowired
    private PessoaService pessoaService;


    /*
     * Conta
     */

    Long id = 1l;
    String nome = "CONTA 1";
    TipoPessoaEnum pessoaTipo = TipoPessoaEnum.CPF;
    TipoContaEnum tipoConta = TipoContaEnum.MATRIZ;
    StatusEnum status = StatusEnum.ATIVO;

    /*
     * Pessoa
     */

    private Conta conta;
    private Pessoa pessoa;

    @Before
    public void setup() {
        conta = contaService.save(createNewConta());
        pessoa = pessoaService.save(createNewPessoa());
    }

    @After
    public void rollback() {
        if (conta != null) {
            contaService.deleteById(conta.getId());
            pessoaService.deleteById(pessoa.getId());
        }
    }

    @Ignore
    @Test
    public void save() {
        conta = createNewConta();
        pessoa = createNewPessoa();

        conta = contaService.save(conta);
        pessoa = pessoaService.save(pessoa);

        Assert.assertNotNull(conta.getId());
        Assert.assertNotNull(pessoa.getId());
    }

    private Conta createNewConta() {
        Conta conta = new Conta();
        conta.setId(id);
        conta.setNome(nome);
        conta.setPessoaTipo(pessoaTipo);
        conta.setTipoConta(tipoConta);
        conta.setStatus(status);
        return conta;
    }

    private Pessoa createNewPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setPessoaTipo(pessoaTipo);
        return pessoa;
    }
}