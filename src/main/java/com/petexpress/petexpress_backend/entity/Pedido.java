/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.petexpress.petexpress_backend.entity;

/**
 *
 * @author Gi
 */

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "Pedidos")
@Data
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "endereco_entrega", columnDefinition = "TEXT")
    private String enderecoEntrega;

    @Column(name = "tipo_entrega", columnDefinition = "ENUM('Imediata', 'Semanal', 'Mensal')")
    private String tipoEntrega;

    @Column(name = "status_pedido", columnDefinition = "ENUM('Processando', 'Enviado', 'Entregue') DEFAULT 'Processando'")
    private String statusPedido = "Processando";

    @Column(name = "forma_pagamento", columnDefinition = "ENUM('Cartao', 'Pix', 'Boleto', 'Pagamento na Entrega')")
    private String formaPagamento;

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "data_pedido")
    private Timestamp dataPedido;

    @Column(name = "data_agendamento")
    private Date dataAgendamento;

    @Column(name = "horario_agendamento")
    private Time horarioAgendamento;
}

