package com.rdg.GerenciamentoPedidos.service;

import com.rdg.GerenciamentoPedidos.models.PedidosModel;
import com.rdg.GerenciamentoPedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidoRepository;

    public PedidosModel save(PedidosModel pedidosModel) {
        return pedidoRepository.save(pedidosModel);
    }

    public List<PedidosModel> findAll(){
        return pedidoRepository.findAll();
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    public PedidosModel update(Long id, PedidosModel pedidoModel) {
        PedidosModel pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setDataPedido(pedidoModel.getDataPedido());
        pedido.setStatus(pedidoModel.getStatus());
        pedido.setValorTotal(pedidoModel.getValorTotal());

        return pedidoRepository.save(pedido);
    }

    public PedidosModel findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
}