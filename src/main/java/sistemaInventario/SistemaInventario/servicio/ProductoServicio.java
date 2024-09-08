/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaInventario.SistemaInventario.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaInventario.SistemaInventario.modelo.Producto;
import sistemaInventario.SistemaInventario.repositorio.ProductoRepositorio;

/**
 *
 * @author joel_
 */
@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> obtenerTodosProductos() {
        return productoRepositorio.findAll();
    }

    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }
}
