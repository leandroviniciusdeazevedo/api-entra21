package com.entra21.controller;

import com.entra21.controller.dto.CursoDTO;
import com.entra21.model.Curso;
import com.entra21.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDTO> listar(){
        List<Curso> cursoList = cursoRepository.findAll();
        return CursoDTO.converter(cursoList);
    }
}
