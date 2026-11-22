package com.exemplo.lab_padroes.model;
import jakarta.persistence.*;
@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    public Cliente() {}
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private final Cliente c = new Cliente();
        public Builder nome(String v) { c.nome = v; return this; }
        public Builder endereco(Endereco v) { c.endereco = v; return this; }
        public Cliente build() { return c; }
    }
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public Endereco getEndereco() { return endereco; } public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}
