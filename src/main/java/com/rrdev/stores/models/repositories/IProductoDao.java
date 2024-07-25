/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rrdev.stores.models.repositories;

import com.rrdev.stores.models.entities.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rresabala
 */
public interface IProductoDao extends CrudRepository<Producto, Long> {
    
}
