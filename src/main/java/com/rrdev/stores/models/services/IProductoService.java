/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rrdev.stores.models.services;

import java.util.List;
import java.util.Optional;
import com.rrdev.stores.models.entities.Producto;

/**
 *
 * @author rresabala
 */
public interface IProductoService {
    
    /**
     * 
     * @return 
     */
    public List<Producto> findAll();
    
    /**
     *
     * @param id
     * 
     * @return
     */
    public Optional<Producto> findById(Long id);
    
    /**
     * 
     * @param producto
     * 
     * @return 
     */
    public Producto save(Producto producto);

    /**
     * 
     * @param producto
     * @param id
     * 
     * @return 
     */
    public Producto update(Producto producto, Long id);
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean deleteById(Long id);
}
