package com.pedidos.encomiendas_api.controller;

import com.pedidos.encomiendas_api.entity.Envio;
import com.pedidos.encomiendas_api.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @PostMapping
    public ResponseEntity<Envio> crearEnvio(@RequestBody Envio envio) {
        return ResponseEntity.ok(envioService.crearEnvio(envio));
    }

    @GetMapping
    public ResponseEntity<List<Envio>> listarEnvios() {
        return ResponseEntity.ok(envioService.listarTodos());
    }

    @GetMapping("/buscar")
    public ResponseEntity<Envio> buscarPorDniYApellido(
            @RequestParam String dni,
            @RequestParam String apellido) {
        return envioService.buscarPorDniYApellido(dni, apellido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
