/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaInventario.SistemaInventario.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import sistemaInventario.SistemaInventario.modelo.Ubicacion;

/**
 *
 * @author joel_
 */
public interface UbicacionRepositorio extends JpaRepository<Ubicacion, Integer> {
    // Métodos adicionales si es necesario
}