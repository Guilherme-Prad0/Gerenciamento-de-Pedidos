package com.rdg.GerenciamentoPedidos.repository;

import com.rdg.GerenciamentoPedidos.models.PedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<PedidosModel, Long> {
}
