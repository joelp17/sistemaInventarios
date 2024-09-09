/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaInventario.SistemaInventario.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaInventario.SistemaInventario.modelo.MovimientosInventario;
import sistemaInventario.SistemaInventario.modelo.Producto;
import sistemaInventario.SistemaInventario.modelo.Ubicacion;
import sistemaInventario.SistemaInventario.repositorio.MovimientoRepositorio;
import sistemaInventario.SistemaInventario.repositorio.ProductoRepositorio;
import sistemaInventario.SistemaInventario.repositorio.UbicacionRepositorio;

/**
 *
 * @author joel_
 */
@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private UbicacionRepositorio ubicacionRepositorio;
    @Autowired
    private MovimientoRepositorio movimientoRepositorio;

    public List<Producto> obtenerTodosProductos() {
        return productoRepositorio.findAll();
    }

    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }

    public List<Ubicacion> obtenerTodasUbicaciones() {
        return ubicacionRepositorio.findAll();
    }

    public Ubicacion obtenerUbicacionPorId(Long id) {
        return ubicacionRepositorio.findById(id).orElse(null); // Devuelve null si no se encuentra
    }

    public Producto obtenerProductoPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    public void guardarProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    public void guardarMovimiento(MovimientosInventario movimiento) {
        movimientoRepositorio.save(movimiento);
    }
}
