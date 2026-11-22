package com.exemplo.lab_padroes.service;
import com.exemplo.lab_padroes.model.Cliente;
import com.exemplo.lab_padroes.model.Endereco;
import com.exemplo.lab_padroes.repository.ClienteRepository;
import com.exemplo.lab_padroes.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repo;
    private final EnderecoRepository repoEnd;
    private final ViaCepService viaCep;
    public ClienteServiceImpl(ClienteRepository repo, EnderecoRepository repoEnd, ViaCepService viaCep) {
        this.repo = repo; this.repoEnd = repoEnd; this.viaCep = viaCep;
    }
    @Override public Iterable<Cliente> buscarTodos() { return repo.findAll(); }
    @Override public Cliente buscarPorId(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado")); }
    @Override public void inserir(Cliente c) { salvar(c); }
    @Override public void atualizar(Long id, Cliente c) { c.setId(buscarPorId(id).getId()); salvar(c); }
    @Override public void deletar(Long id) { repo.deleteById(id); }
    private void salvar(Cliente c) {
        Endereco end = viaCep.consultarCep(c.getEndereco().getCep());
        c.setEndereco(repoEnd.save(end));
        repo.save(c);
    }
}
