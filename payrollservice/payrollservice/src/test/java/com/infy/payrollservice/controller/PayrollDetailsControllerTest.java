package com.infy.payrollservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.payrollservice.model.Payroll;
import com.infy.payrollservice.service.PayrollDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PayrollDetailsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PayrollDetailsService payrollDetailsService;

    @Test
    public void getPayrollDetailsByAccount() throws Exception{
        when(payrollDetailsService.getPayrollDetailsByAccount(anyString())).thenReturn(new Payroll("1","704597","SrujanKumar","Salaried",50000.0,8));
        MvcResult response=mockMvc.perform(MockMvcRequestBuilders.get("/payrolldetails/payroll/704597")).andExpect(status().isOk()).andReturn();
        ObjectMapper mapper=new ObjectMapper();
        Payroll payroll= mapper.readerFor(Payroll.class).readValue(response.getResponse().getContentAsString());
        assertThat(payroll.getAccountNumber()).isEqualTo("704597");
        assertThat(payroll.getIncome()).isEqualTo(50000);
    }
}
