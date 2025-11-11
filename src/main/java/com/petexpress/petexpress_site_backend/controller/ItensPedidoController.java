/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.petexpress.petexpress_site_backend.controller;

/**
 *
 * @author Gi
 */

import com.petexpress.petexpress_backend.entity.ItensPedido;
import com.petexpress.petexpress_backend.service.ItensPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itensPedido")
public class ItensPedidoController {

    @Autowired
    private ItensPedidoService itensPedidoService;

    @GetMapping
    public List<ItensPedido> getAllItensPedido() {
        return itensPedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ItensPedido> getItensPedidoById(@PathVariable Integer id) {
        return itensPedidoService.findById(id);
    }

    @PostMapping
    public ItensPedido createItensPedido(@RequestBody ItensPedido itensPedido) {
        return itensPedidoService.save(itensPedido);
    }

    @PutMapping("/{id}")
    public ItensPedido updateItensPedido(@PathVariable Integer id, @RequestBody ItensPedido itensPedido) {
        return itensPedidoService.update(id, itensPedido);
    }

    @DeleteMapping("/{id}")
    public void deleteItensPedido(@PathVariable Integer id) {
        itensPedidoService.deleteById(id);
    }
}
