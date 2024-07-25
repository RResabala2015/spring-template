/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rrdev.stores.models.services;

import java.util.List;
import java.util.Optional;
import com.rrdev.stores.models.entities.Producto;
import com.rrdev.stores.models.repositories.IProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rresabala
 */
@Service
public class ProductoServiceImplement implements IProductoService{
    
    @Autowired
    private IProductoDao productoRepository;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return (Optional<Producto>) productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto, Long id) {
        Optional<Producto> optionalProducto;
        optionalProducto = productoRepository.findById(id);
        if(optionalProducto.isPresent()){
            Producto tmp = optionalProducto.get();
            tmp.setNombre(producto.getNombre());
            tmp.setStock(producto.getStock());
            tmp.setFechaVencimiento(producto.getFechaVencimiento());
            tmp.setCostoCompra(producto.getCostoCompra());
            tmp.setCostoVenta(producto.getCostoVenta());
            
            return save(tmp);
        }
        
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        boolean result = false;
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            result = true;
        }

        return result;
    }
    
}
