/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rrdev.stores.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rrdev.stores.models.entities.Producto;
import java.time.Instant;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author rresabala
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ProductosControllerTest {
       
    @Autowired
    private MockMvc mockMvc;
    
    @DisplayName("pudo obtener todos los productos?")
    @Test
    public void shouldGetAllProducts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/productos")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }
    
    @DisplayName("pudo obtener producto por medio de id?")
    @Test
    public void shouldGetByIdProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/productos/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/productos/{id}", 20)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
    }
    
        @DisplayName("puede guardar el objeto producto")
    @Test
    public void shouldSaveProduct() throws Exception{
        Producto producto = new Producto();
        producto.setNombre("Galletas Oreo");
        producto.setStock(20);
        producto.setFechaVencimiento(Date.from(Instant.now()));
        producto.setCostoCompra(0.50);
        producto.setCostoVenta(0.75);
        
        mockMvc.perform(MockMvcRequestBuilders
            .post("/api/v1/productos")
            .content(asJsonString(producto))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());

    }
    
    @DisplayName("puede actualizar el objeto producto por medio de id?")
    @Test
    public void shouldUpdateByIdProduct() throws Exception{
        Producto producto = new Producto();
        producto.setNombre("Galletas Oreo");
        producto.setStock(40);
        producto.setFechaVencimiento(Date.from(Instant.now()));
        producto.setCostoCompra(0.55);
        producto.setCostoVenta(0.85);
        
        
        mockMvc.perform(MockMvcRequestBuilders
            .put("/api/v1/productos/{id}", 2)
            .content(asJsonString(producto))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

        mockMvc.perform(MockMvcRequestBuilders
            .put("/api/v1/productos/{id}", 20)
            .content(asJsonString(producto))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
    }
    
    @DisplayName("pudo eliminar producto por medio de id?")
    @Test
    public void shouldDeleteByIdTransporter() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .delete("/api/v1/productos/{id}", 4)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

        mockMvc.perform(MockMvcRequestBuilders
            .delete("/api/v1/productos/{id}", 4)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
    }
    
    /**
     * @param obj
     * 
     * @return 
     */
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
