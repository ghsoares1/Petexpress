/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.petexpress.petexpress_backend.service;

/**
 *
 * @author Gi
 */
import com.petexpress.petexpress_backend.entity.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> findAll();
    Optional<Pedido> findById(Integer id);
    Pedido save(Pedido pedido);
    void deleteById(Integer id);
    Pedido update(Integer id, Pedido pedido);
}

