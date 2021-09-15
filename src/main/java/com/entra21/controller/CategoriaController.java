package com.entra21.controller;

import com.entra21.controller.dto.CategoriaDTO;
import com.entra21.controller.dto.CursoDTO;
import com.entra21.model.Categoria;
import com.entra21.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

        @Autowired
        CategoriaRepository categoriaRepository;

        @GetMapping
        public List<CategoriaDTO> listar(){
                List<Categoria> categoriaList = categoriaRepository.findAll();
                return CategoriaDTO.converter(categoriaList);
        }
}
