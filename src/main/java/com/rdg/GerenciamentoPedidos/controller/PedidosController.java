package com.rdg.GerenciamentoPedidos.controller;

import com.rdg.GerenciamentoPedidos.models.PedidosModel;
import com.rdg.GerenciamentoPedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
    @Autowired
    private PedidosService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidosModel>> getAll() {
        List<PedidosModel> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<PedidosModel> create(@RequestBody PedidosModel pedido) {
        PedidosModel pedidoSalvo = pedidoService.save(pedido);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedidoSalvo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(pedidoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidosModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findById(id));
    }
}
