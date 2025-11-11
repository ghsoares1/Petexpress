/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.petexpress.petexpress_backend.service;

/**
 *
 * @author Gi
 */
import com.petexpress.petexpress_backend.entity.ItensCarrinho;
import java.util.List;
import java.util.Optional;

public interface ItensCarrinhoService {
    List<ItensCarrinho> findAll();
    Optional<ItensCarrinho> findById(Integer id);
    ItensCarrinho save(ItensCarrinho itensCarrinho);
    void deleteById(Integer id);
     ItensCarrinho update(Integer id, ItensCarrinho itensCarrinho);
}
