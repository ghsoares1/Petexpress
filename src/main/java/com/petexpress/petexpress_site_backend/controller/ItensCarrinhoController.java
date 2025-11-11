/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.petexpress.petexpress_site_backend.controller;

/**
 *
 * @author Gi
 */

import com.petexpress.petexpress_backend.entity.ItensCarrinho;
import com.petexpress.petexpress_backend.service.ItensCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itensCarrinho")
public class ItensCarrinhoController {

    @Autowired
    private ItensCarrinhoService itensCarrinhoService;

    @GetMapping
    public List<ItensCarrinho> getAllItensCarrinho() {
        return itensCarrinhoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ItensCarrinho> getItensCarrinhoById(@PathVariable Integer id) {
        return itensCarrinhoService.findById(id);
    }

    @PostMapping
    public ItensCarrinho createItensCarrinho(@RequestBody ItensCarrinho itensCarrinho) {
        return itensCarrinhoService.save(itensCarrinho);
    }

    @PutMapping("/{id}")
    public ItensCarrinho updateItensCarrinho(@PathVariable Integer id, @RequestBody ItensCarrinho itensCarrinho) {
        return itensCarrinhoService.update(id, itensCarrinho);
    }

    @DeleteMapping("/{id}")
    public void deleteItensCarrinho(@PathVariable Integer id) {
        itensCarrinhoService.deleteById(id);
    }
}

