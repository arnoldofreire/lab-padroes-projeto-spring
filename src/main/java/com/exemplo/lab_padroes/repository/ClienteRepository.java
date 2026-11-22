package com.exemplo.lab_padroes.repository;
import com.exemplo.lab_padroes.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {}
