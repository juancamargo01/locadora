package com.juancamargo.locadora.service;

import com.juancamargo.locadora.dto.ClienteDTO;
import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.model.entity.Filme;
import com.juancamargo.locadora.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

public class FilmeService {

    @Autowired
    FilmesRepository filmesRepository;



    public ClienteDTO salvarFilme(ClienteDTO clienteDTO) {

        Cliente cliente= filmesRepository.save(montaFilme(clienteDTO));

        return new ClienteDTO(cliente.getId(),cliente.getNomeCompleto(),cliente.getIdade(),cliente.getEndereco());
    }

    public Boolean deletarFilmePeloId(Long id) {
        try {
            if( buscarClientePeloId(id) != null) {
                filmesRepository.deleteById(id);
                return true;
            }
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return false;
        }
        return null;
    }

    public Cliente buscarFilmePeloId(Long id) {
        Optional<Cliente> cliente = filmesRepository.findById(id);

        if (cliente.isPresent()) {
            return filmesRepository.findById(id).get();
        }
        return null;

    }

    public List<Cliente> buscarTodosFilmesList<Cliente> cliente) {
        return filmesRepository.findAll();
    }

    public ClienteDTO atualizarfilme (ClienteDTO clienteDTO){
        return salvarCliente(clienteDTO);

    }

    private Cliente montaFilme(ClienteDTO clienteDTO){

        return new Cliente(clienteDTO.getId(),clienteDTO.getNomeCompleto(),clienteDTO.getIdade(),clienteDTO.getEndereco());
    }
}
