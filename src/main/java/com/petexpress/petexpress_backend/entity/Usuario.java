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
import java.sql.Timestamp;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "sobrenome", length = 100, nullable = false)
    private String sobrenome;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "cpf", length = 20, nullable = false)
    private String cpf;

    @Column(name = "rg", length = 20, nullable = false)
    private String rg;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "endereco", length = 255, nullable = false)
    private String endereco;

    @Column(name = "complemento", length = 255)
    private String complemento;

    @Column(name = "bairro", length = 100, nullable = false)
    private String bairro;

    @Column(name = "cep", length = 20, nullable = false)
    private String cep;

    @Column(name = "data_criacao")
    private Timestamp dataCriacao;
}
