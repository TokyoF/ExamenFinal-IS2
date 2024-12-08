package com.pedidos.encomiendas_api.service;

import com.pedidos.encomiendas_api.entity.Envio;

import java.util.List;
import java.util.Optional;

public interface EnvioService {
    Envio crearEnvio(Envio envio);
    Optional<Envio> buscarPorDniYApellido(String dni, String apellido);
    List<Envio> listarTodos();
}
