package com.juancamargo.locadora.service;

import com.juancamargo.locadora.dto.ClienteDTO;
import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.repository.ClienteRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepositoty clienteRepositoty;


    public ClienteDTO salvarCliente( ClienteDTO clienteDTO) {

        Cliente cliente= clienteRepositoty.save(montaCliente(clienteDTO));

        return new ClienteDTO(cliente.getId(),
                            cliente.getNomeCompleto(),
                            cliente.getIdade(),
                            cliente.getEndereco());
    }

    public ClienteDTO atualizarCliente( ClienteDTO clienteDTO,Long id) {
        Cliente novoCliente = buscarClientePeloId(id);
        novoCliente.setNomeCompleto(clienteDTO.getNomeCompleto());
        novoCliente.setIdade(clienteDTO.getIdade());
        novoCliente.setEndereco(clienteDTO.getEndereco());

        Cliente cliente= clienteRepositoty.save(novoCliente);

        return new ClienteDTO(novoCliente.getId(),
                novoCliente.getNomeCompleto(),
                novoCliente.getIdade(),
                novoCliente.getEndereco());
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
        return null;
    }

    public Cliente buscarClientePeloId(Long id) {
        Optional<Cliente> cliente = clienteRepositoty.findById(id);

        if (cliente.isPresent()) {
            return clienteRepositoty.findById(id).get();
        }
        return null;

    }

    public List<Cliente> buscarTodosCliente() {
        return clienteRepositoty.findAll();
    }
    
    public ClienteDTO atualizarCiente (ClienteDTO clienteDTO){
       return salvarCliente(clienteDTO);

    }

    private Cliente montaCliente(ClienteDTO clienteDTO){

        return new Cliente(clienteDTO.getId(),
                        clienteDTO.getNomeCompleto(),
                        clienteDTO.getIdade(),
                        clienteDTO.getEndereco());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
            System.out.println("passei aqui");
        });
        return errors;

    }


}
