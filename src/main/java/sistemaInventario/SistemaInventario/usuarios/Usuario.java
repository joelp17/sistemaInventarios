/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaInventario.SistemaInventario.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")  // Asegúrate de que el nombre coincida con el esquema de la tabla
    private int idusuario;
    @Column(name = "nombre")  // Asegúrate de que el nombre coincida con el esquema de la tabla
    private String nombre;
    @Column(name = "contrasenia")    
    private String contrasenia;
    @Column(name = "estatus")    
    private int estatus; // 1 activo, 0 inactivo

    // Getters y setters
    public int getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idusuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
}
