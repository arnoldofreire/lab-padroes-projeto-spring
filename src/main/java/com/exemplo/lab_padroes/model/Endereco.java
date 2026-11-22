package com.exemplo.lab_padroes.model;
import jakarta.persistence.*;
@Entity
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep, logradouro, complemento, bairro, localidade, uf;
    public Endereco() {}
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private final Endereco e = new Endereco();
        public Builder cep(String v) { e.cep = v; return this; }
        public Builder logradouro(String v) { e.logradouro = v; return this; }
        public Builder complemento(String v) { e.complemento = v; return this; }
        public Builder bairro(String v) { e.bairro = v; return this; }
        public Builder localidade(String v) { e.localidade = v; return this; }
        public Builder uf(String v) { e.uf = v; return this; }
        public Endereco build() { return e; }
    }
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getCep() { return cep; } public void setCep(String cep) { this.cep = cep; }
    public String getLogradouro() { return logradouro; } public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getComplemento() { return complemento; } public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getBairro() { return bairro; } public void setBairro(String bairro) { this.bairro = bairro; }
    public String getLocalidade() { return localidade; } public void setLocalidade(String localidade) { this.localidade = localidade; }
    public String getUf() { return uf; } public void setUf(String uf) { this.uf = uf; }
}
