/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rrdev.stores.controllers;


import com.rrdev.stores.models.entities.Producto;
import com.rrdev.stores.models.services.IProductoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rresabala
 */
@RestController
@RequestMapping("/api/v1/productos")
public class ProductosController {
    
    @Autowired
    private IProductoService productoService;
    
    /**
     * @return
     */
    @GetMapping("")
    public List<Producto> listar(){
        return productoService.findAll();
    }
    
    
    /**
     * @param id
     * 
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id){
        Optional<Producto> optionalProducto;
        optionalProducto = productoService.findById(id);
        if(optionalProducto.isPresent()){
            return new ResponseEntity(
                optionalProducto.get(),
                HttpStatus.OK
            );
        }
        
        return ResponseEntity.notFound().build();
    }
    
    /**
      * 
      * @param producto
      * 
      * @return 
      */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping("")
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        try {
            return new ResponseEntity(
                this.productoService.save(producto),
                HttpStatus.CREATED
            );
        } catch (Exception e) {
            
        }

        return ResponseEntity.notFound().build();
    }
    
    
    /**
      * 
      * @param producto
      * @param id
      * 
      * @return 
      */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarParcialmente(
        @RequestBody Producto producto,
        @PathVariable Long id
    ){
        Producto productoActualizado;
        productoActualizado = productoService.update(producto, id);
        if(productoActualizado != null){
            return new ResponseEntity(
                productoActualizado,
                HttpStatus.OK
            );
        }
        
        return ResponseEntity.notFound().build();
    }
    
    /**
     * @param id
     * 
     * @return
     */
    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Long id){
        boolean respuesta = this.productoService.deleteById(id);
            
        return (respuesta) ?
            ResponseEntity.noContent().build() : 
            ResponseEntity.notFound().build();
    }
}
