package com.juancamargo.locadora.service;

import com.juancamargo.locadora.dto.ClienteDTO;
import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.repository.ClienteRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;


import java.util.List;
import java.util.Optional;

public class ClienteService {

    @Autowired
    ClienteRepositoty clienteRepositoty;


    public ClienteDTO salvarCliente( ClienteDTO clienteDTO) {

        Cliente cliente= clienteRepositoty.save(montaCliente(clienteDTO));

        return new ClienteDTO(cliente.getId(),cliente.getNomeCompleto(),cliente.getIdade(),cliente.getEndereco());
    }

    public Boolean deletarClientePeloId(Long id) {
        try {
           if( buscarClientePeloId(id) != null) {
               clienteRepositoty.deleteById(id);
               return true;
           }
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    public Cliente buscarClientePeloId(Long id) {
        Optional<Cliente> cliente = clienteRepositoty.findById(id);

        if (cliente.isPresent()) {
            return clienteRepositoty.findById(id).get();
        }
        return null;

    }

    public List<Cliente> buscarTodosCliente(List<Cliente> cliente) {
        return clienteRepositoty.findAll();
    }
    
    public Cliente atualizarCiente (ClienteDTO clienteDTO){
        salvarCliente(clienteDTO);

    }

    private Cliente montaCliente(ClienteDTO clienteDTO){

        return new Cliente(clienteDTO.getId(),clienteDTO.getNomeCompleto(),clienteDTO.getIdade(),clienteDTO.getEndereco());
    }


}
