/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pila.API.controller;

import com.pila.API.modelo.Producto;
import com.pila.API.servicio.ProductoServicio;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dylanpilrod
 */
@RestController
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoServicio productoServicio;

    @GetMapping("/producto")
    public List<Producto> listarProductos() {
        return productoServicio.listarProductos();
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        try {
            Producto producto = productoServicio.obtenerProductoPorId(id);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/producto")
    public void nuevoProducto(@RequestBody Producto producto) {
        productoServicio.guardarProducto(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> editarProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Producto productoExistente = productoServicio.obtenerProductoPorId(id);
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoServicio.guardarProducto(productoExistente);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/producto/{id}")
    public void borrarProducto(@PathVariable Integer id) {
        productoServicio.eliminarProducto(id);
    }

}
