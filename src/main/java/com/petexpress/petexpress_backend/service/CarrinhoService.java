/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.petexpress.petexpress_backend.service;

/**
 *
 * @author Gi
 */
import com.petexpress.petexpress_backend.entity.Carrinho;
import java.util.List;
import java.util.Optional;

public interface CarrinhoService {
    List<Carrinho> findAll();
    Optional<Carrinho> findById(Integer id);
    Carrinho save(Carrinho carrinho);
    void deleteById(Integer id);
    Carrinho update(Integer id, Carrinho carrinho);
}
