package com.software.RouteFlex.controllers;

import com.software.RouteFlex.dto.LoginRequest;
import com.software.RouteFlex.models.Usuario;
import com.software.RouteFlex.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("http://localhost:4200/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return usuarioService.listarUsuario();
    }

    @GetMapping("/listar/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @PostMapping("/crear")
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @PutMapping("/actualizar")
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        String nombre = loginRequest.getNombre();
        String contrasena = loginRequest.getContrasena();

        if(usuarioService.validarUsuario(nombre, contrasena)) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.badRequest().body("Usuario o contraseña incorrectos");
        }
    }
}
