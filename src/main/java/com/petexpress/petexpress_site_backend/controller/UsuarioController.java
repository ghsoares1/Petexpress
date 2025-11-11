/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.petexpress.petexpress_site_backend.controller;

/**
 *
 * @author Gi
 */
    import com.petexpress.petexpress_backend.entity.Usuario;
    import com.petexpress.petexpress_backend.service.UsuarioService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/usuarios")
    public class UsuarioController {

        @Autowired
        private UsuarioService usuarioService;

        @GetMapping
        public List<Usuario> getAllUsuarios() {
            return usuarioService.findAll();
        }

        @GetMapping("/{id}")
        public Optional<Usuario> getUsuarioById(@PathVariable Integer id) {
            return usuarioService.findById(id);
        }

        @PostMapping
        public Usuario createUsuario(@RequestBody Usuario usuario) {
            return usuarioService.save(usuario);
        }

        @PutMapping("/{id}")
        public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
            return usuarioService.update(id, usuario);
        }

        @DeleteMapping("/{id}")
        public void deleteUsuario(@PathVariable Integer id) {
            usuarioService.deleteById(id);
        }
    }

