/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.petexpress.petexpress_backend.service;

/**
 *
 * @author Gi
 */
import com.petexpress.petexpress_backend.entity.ItensCarrinho;
import com.petexpress.petexpress_backend.repository.ItensCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItensCarrinhoServiceImpl implements ItensCarrinhoService {

    @Autowired
    private ItensCarrinhoRepository itensCarrinhoRepository;

    @Override
    public List<ItensCarrinho> findAll() {
        return itensCarrinhoRepository.findAll();
    }

    @Override
    public Optional<ItensCarrinho> findById(Integer id) {
        return itensCarrinhoRepository.findById(id);
    }

    @Override
    public ItensCarrinho save(ItensCarrinho itensCarrinho) {
        return itensCarrinhoRepository.save(itensCarrinho);
    }

    @Override
    public void deleteById(Integer id) {
        itensCarrinhoRepository.deleteById(id);
    }

    @Override
    public ItensCarrinho update(Integer id, ItensCarrinho itensCarrinho) {
       Optional<ItensCarrinho> itensCarrinhoOptional = itensCarrinhoRepository.findById(id);
        if (itensCarrinhoOptional.isPresent()) {
            itensCarrinho.setIdItemCarrinho(id);
            return itensCarrinhoRepository.save(itensCarrinho);
        } else {
            throw new RuntimeException("ItensCarrinho não encontrado com o id: " + id);
        }
    }
}

