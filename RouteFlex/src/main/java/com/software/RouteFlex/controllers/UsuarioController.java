package com.software.RouteFlex.controllers;

import com.software.RouteFlex.dto.LoginRequest;
import com.software.RouteFlex.models.Usuario;
import com.software.RouteFlex.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("http://localhost:4200")
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
    public ResponseEntity<Usuario> validarUsuario(@RequestBody LoginRequest loginRequest) {
        try {
            // Intentamos validar al usuario usando el nombre y la contraseña recibidos en el JSON
            Usuario usuario = usuarioService.validarUsuario(loginRequest.getNombre(), loginRequest.getContrasena());
            // Si es válido, retornamos el usuario completo con código 200 (OK)
            return ResponseEntity.ok(usuario);
        } catch (IllegalArgumentException e) {
            // Si ocurre una excepción (usuario no encontrado o contraseña incorrecta)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);  // Código 401 (Unauthorized)
        }
    }
}
