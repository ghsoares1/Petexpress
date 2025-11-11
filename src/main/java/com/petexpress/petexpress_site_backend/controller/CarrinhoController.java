/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.petexpress.petexpress_site_backend.controller;

/**
 *
 * @author Gi
 */
import com.petexpress.petexpress_backend.entity.Carrinho;
import com.petexpress.petexpress_backend.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public List<Carrinho> getAllCarrinhos() {
        return carrinhoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Carrinho> getCarrinhoById(@PathVariable Integer id) {
        return carrinhoService.findById(id);
    }

    @PostMapping
    public Carrinho createCarrinho(@RequestBody Carrinho carrinho) {
        return carrinhoService.save(carrinho);
    }

    @PutMapping("/{id}")
    public Carrinho updateCarrinho(@PathVariable Integer id, @RequestBody Carrinho carrinho) {
        return carrinhoService.update(id, carrinho);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrinho(@PathVariable Integer id) {
        carrinhoService.deleteById(id);
    }
}

