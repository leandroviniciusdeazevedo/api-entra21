package com.entra21.controller;

import com.entra21.controller.dto.AtualizarDadoDTO;
import com.entra21.controller.dto.DetalheTopicoDTO;
import com.entra21.controller.dto.TopicoDTO;
import com.entra21.controller.dto.TopicoFORM;
import com.entra21.model.*;
import com.entra21.repositories.CursoRepository;
import com.entra21.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> listar(String nomeCurso) {
        List<Topico> topicoList;

        if (nomeCurso == null) {
            topicoList = topicoRepository.findAll();
        } else {
            topicoList = topicoRepository.carregarPorNomeDoCurso(nomeCurso);
        }
        return TopicoDTO.converter(topicoList);
    }

    @PostMapping
    public ResponseEntity<TopicoDTO>
        gravar(@RequestBody @Valid TopicoFORM topicoFORM, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoFORM.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()){
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity <DetalheTopicoDTO> redirecionamento (@PathVariable Long id) {
        Optional <Topico> topicoPesquisado = topicoRepository .findById (id) ;
        if (topicoPesquisado.isPresent()) {
            return ResponseEntity.ok( new DetalheTopicoDTO (topicoPesquisado.get())) ;
        }
        return ResponseEntity. notFound () .build () ;
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar (@PathVariable Long id, @RequestBody @Valid AtualizarDadoDTO form){
        Optional<Topico> topicoPesquisado = topicoRepository.findById(id);
        if(topicoPesquisado.isPresent()){
            Topico topico = form.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDTO(topico));
        }
        return ResponseEntity.notFound().build();
    }
}