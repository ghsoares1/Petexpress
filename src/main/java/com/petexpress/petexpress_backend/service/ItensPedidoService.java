/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.petexpress.petexpress_backend.service;

/**
 *
 * @author Gi
 */
import com.petexpress.petexpress_backend.entity.ItensPedido;
import java.util.List;
import java.util.Optional;


public interface ItensPedidoService {
    List<ItensPedido> findAll();
    Optional<ItensPedido> findById(Integer id);
    ItensPedido save(ItensPedido itensPedido);
    void deleteById(Integer id);
    ItensPedido update(Integer id, ItensPedido itensPedido);
}

