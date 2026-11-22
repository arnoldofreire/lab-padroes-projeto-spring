package com.exemplo.lab_padroes.repository;
import com.exemplo.lab_padroes.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {}
