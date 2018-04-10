package com.hub.fintech.bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hub.fintech.bank.model.entity.Conta;
import com.hub.fintech.bank.model.enums.StatusEnum;
import com.hub.fintech.bank.model.enums.TipoContaEnum;
import com.hub.fintech.bank.model.enums.TipoPessoaEnum;
import com.hub.fintech.bank.service.ContaService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// https://stackoverflow.com/questions/19198475/minimal-configuration-for-using-webapplicationcontext

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ContaControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private ContaService contaService;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getAllContas() {
    }

    @Test
    @Ignore
    public void testSaveConta() throws Exception {
        Conta conta = new Conta();
        conta.setId(1l);
        conta.setNome("CONTA 1");
        conta.setPessoaTipo(TipoPessoaEnum.CPF);
        conta.setTipoConta(TipoContaEnum.MATRIZ);
        conta.setStatus(StatusEnum.ATIVO);

        Mockito.when(contaService.save(conta)).thenReturn(conta);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(conta);
        this.mockMvc.perform(put("/api/conta/save/{conta}").contentType(MediaType.APPLICATION_JSON).content(jsonInString))
                .andExpect(status().isOk());
    }

    @Test
    public void getContaById() {
    }

    @Test
    public void updateConta() {
    }

    @Test
    public void deleteConta() {
    }

    @Test
    @Ignore
    public void testGetConta() throws Exception {
        Mockito.when(contaService.findById(1L)).thenReturn(new Conta());
        this.mockMvc.perform(get("/api/conta/")).andExpect(status().isOk());
    }

    @Ignore
    @Test
    public void testFindAllConta() throws Exception {
        Mockito.when(contaService.findAll()).thenReturn(new ArrayList<Conta>());
        this.mockMvc.perform(get("/api/conta")).andExpect(status().isOk());
    }

    @Ignore
    @Test
    public void testUpdateConta() throws Exception {
        Conta conta = new Conta();
        Mockito.when(contaService.save(conta)).thenReturn(conta);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(conta);
        this.mockMvc.perform(put("/api/conta").contentType(MediaType.APPLICATION_JSON).content(jsonInString))
                .andExpect(status().isOk());
    }

    @Test
    @Ignore
    public void testDeleteConta() throws Exception {
        Mockito.when(contaService.deleteById(1L)).thenReturn(String.valueOf(1L));
        this.mockMvc.perform(delete("/api/conta/1")).andExpect(status().isOk());
    }
}