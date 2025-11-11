/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.petexpress.petexpress_backend.service;

/**
 *
 * @author Gi
 */
import com.petexpress.petexpress_backend.entity.ItensPedido;
import com.petexpress.petexpress_backend.repository.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItensPedidoServiceImpl implements ItensPedidoService {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Override
    public List<ItensPedido> findAll() {
        return itensPedidoRepository.findAll();
    }

    @Override
    public Optional<ItensPedido> findById(Integer id) {
        return itensPedidoRepository.findById(id);
    }

    @Override
    public ItensPedido save(ItensPedido itensPedido) {
        return itensPedidoRepository.save(itensPedido);
    }

    @Override
    public void deleteById(Integer id) {
        itensPedidoRepository.deleteById(id);
    }
    
    @Override
    public ItensPedido update(Integer id, ItensPedido itensPedido) {
        Optional<ItensPedido> itensPedidoOptional = itensPedidoRepository.findById(id);
        if (itensPedidoOptional.isPresent()) {
            itensPedido.setIdItemPedido(id);
            return itensPedidoRepository.save(itensPedido);
        } else {
            throw new RuntimeException("ItensPedido não encontrado com o id: " + id);
        }
    }
}