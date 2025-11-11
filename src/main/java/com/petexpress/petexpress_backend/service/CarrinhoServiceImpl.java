/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.petexpress.petexpress_backend.service;

/**
 *
 * @author Gi
 */
import com.petexpress.petexpress_backend.entity.Carrinho;
import com.petexpress.petexpress_backend.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Override
    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

    @Override
    public Optional<Carrinho> findById(Integer id) {
        return carrinhoRepository.findById(id);
    }

    @Override
    public Carrinho save(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    @Override
    public void deleteById(Integer id) {
        carrinhoRepository.deleteById(id);
    }

     @Override
    public Carrinho update(Integer id, Carrinho carrinho) {
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
        if (carrinhoOptional.isPresent()) {
            carrinho.setIdCarrinho(id);
            return carrinhoRepository.save(carrinho);
        } else {
            throw new RuntimeException("Carrinho não encontrado com o id: " + id);
        }
    }
}

