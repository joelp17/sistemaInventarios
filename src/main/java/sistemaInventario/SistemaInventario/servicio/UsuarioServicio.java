/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaInventario.SistemaInventario.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sistemaInventario.SistemaInventario.modelo.Usuario;
import sistemaInventario.SistemaInventario.repositorio.UsuarioRepositorio;

/**
 *
 * @author joel_
 */
@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByNombre(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        if (usuario.getEstatus() != 1) {
            throw new UsernameNotFoundException("El usuario está inactivo");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getNombre())
                .password(usuario.getContrasenia())
                //.authorities("USER")
                .build();
    }

    public Usuario findByNombre(String nombre) {
        return usuarioRepositorio.findByNombre(nombre);
    }
}
