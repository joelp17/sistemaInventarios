/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaInventario.SistemaInventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistemaInventario.SistemaInventario.modelo.Usuario;

/**
 *
 * @author joel_
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    Usuario findByNombre(String nombre);
}
