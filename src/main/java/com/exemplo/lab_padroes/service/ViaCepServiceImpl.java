package com.exemplo.lab_padroes.service;
import com.exemplo.lab_padroes.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
@Service
public class ViaCepServiceImpl implements ViaCepService {
    private final RestClient restClient = RestClient.create();
    @Override
    public Endereco consultarCep(String cep) {
        ViaCepResponse r = restClient.get().uri("https://viacep.com.br/ws/{cep}/json/", cep).retrieve().body(ViaCepResponse.class);
        if (r == null || Boolean.TRUE.equals(r.erro())) throw new RuntimeException("CEP não encontrado: " + cep);
        return Endereco.builder().cep(r.cep()).logradouro(r.logradouro()).complemento(r.complemento())
                .bairro(r.bairro()).localidade(r.localidade()).uf(r.uf()).build();
    }
    record ViaCepResponse(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, Boolean erro) {}
}
