package com.pedidos.encomiendas_api.service;

import com.pedidos.encomiendas_api.entity.Envio;
import com.pedidos.encomiendas_api.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioServiceImpl implements EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public Envio crearEnvio(Envio envio) {
        return envioRepository.save(envio);
    }

    @Override
    public Optional<Envio> buscarPorDniYApellido(String dni, String apellido) {
        return envioRepository.findByDniReceptorAndApellidoReceptor(dni, apellido);
    }

    @Override
    public List<Envio> listarTodos() {
        return envioRepository.findAll();
    }
}
