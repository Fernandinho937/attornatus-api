package com.attornatus.attornatus.model;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.attornatus.repository.ClienteRepository;

@RestController
@RequestMapping(path="/api/clientes")
@CrossOrigin("*")
public class Cliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
    return clienteRepository.findAll();        
    }
    
    @GetMapping(path="/api/clientes/{id}")
    public @ResponseBody Optional<Cliente> buscarCliente(@PathVariable Long id) {
        return clienteRepository.findById(id);
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("/")
    public @ResponseBody Cliente atualizar(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "Ok ao apagar";
    }
}


