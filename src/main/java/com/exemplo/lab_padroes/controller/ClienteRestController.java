package com.exemplo.lab_padroes.controller;
import com.exemplo.lab_padroes.model.Cliente;
import com.exemplo.lab_padroes.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/clientes")
public class ClienteRestController {
    private final ClienteService service;
    public ClienteRestController(ClienteService service) { this.service = service; }
    @GetMapping public ResponseEntity<Iterable<Cliente>> buscarTodos() { return ResponseEntity.ok(service.buscarTodos()); }
    @GetMapping("/{id}") public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) { return ResponseEntity.ok(service.buscarPorId(id)); }
    @PostMapping public ResponseEntity<Cliente> inserir(@RequestBody Cliente c) { service.inserir(c); return ResponseEntity.ok(c); }
    @PutMapping("/{id}") public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente c) { service.atualizar(id, c); return ResponseEntity.ok(c); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> deletar(@PathVariable Long id) { service.deletar(id); return ResponseEntity.noContent().build(); }
}
