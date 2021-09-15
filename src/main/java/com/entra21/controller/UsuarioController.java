package com.entra21.controller;

import com.entra21.controller.dto.UsuarioDTO;
import com.entra21.model.Usuario;
import com.entra21.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDTO> listar(){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return UsuarioDTO.converter(usuarioList);
    }
}
