/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pila.API.servicio;

import com.pila.API.modelo.Producto;
import com.pila.API.repositorio.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author dylanpilrod
 */
@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio repositorio;
    
    public List<Producto>listarProductos(){
        return repositorio.findAll();
    }
    
    public void guardarProducto(Producto producto){
        repositorio.save(producto);
    }
    
    public Producto obtenerProductoPorId(Integer id){
        return repositorio.findById(id).get();
    }
    
    public void eliminarProducto (Integer id){
        repositorio.deleteById(id);
    }
}
