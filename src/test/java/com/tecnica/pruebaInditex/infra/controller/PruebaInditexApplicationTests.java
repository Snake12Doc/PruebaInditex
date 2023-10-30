package com.tecnica.pruebaInditex.infra.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class PruebaInditexApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findPrice_whenDate20206141000_shouldReturnOK() throws Exception {
        String applicationDate = "2020-06-14-10.00.00";
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/price/info")
                .param("appDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void findPrice_whenDate20206141600_shouldReturnOK() throws Exception {
        String applicationDate = "2020-06-14-16.00.00";
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/price/info")
                .param("appDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    public void findPrice_whenDate20206142100_shouldReturnOK() throws Exception {
        String applicationDate = "2020-06-14-21.00.00";
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/price/info")
                .param("appDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void findPrice_whenDate20206151000_shouldReturnOK() throws Exception {
        String applicationDate = "2020-06-15-10.00.00";
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/price/info")
                .param("appDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    public void findPrice_whenDate20206162100_shouldReturnOK() throws Exception {
        String applicationDate = "2020-06-16-21.00.00";
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/price/info")
                .param("appDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value(38.95));
    }

    @Test
    public void findPrice_whenDate20226162100_shouldReturnKO() throws Exception {
        String applicationDate = "2022-06-16-21.00.00";
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/price/info")
                .param("appDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId)))
                .andExpect(status().isNotFound());
    }

}