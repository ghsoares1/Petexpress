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

@Entity
@Table(name = "Produtos")
@Data
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nome_produto", length = 255, nullable = false)
    private String nomeProduto;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "categoria", length = 100, nullable = false)
    private String categoria;

    @Column(name = "marca", length = 100, nullable = false)
    private String marca;

    @Column(name = "idade_recomendada", length = 100)
    private String idadeRecomendada;

    @Column(name = "porte_recomendado", length = 100)
    private String porteRecomendado;

    @Column(name = "estoque", nullable = false)
    private Integer estoque;

    @Column(name = "imagem_url", length = 255)
    private String imagemUrl;

    @Column(name = "em_destaque")
    private Boolean emDestaque = true;
}

