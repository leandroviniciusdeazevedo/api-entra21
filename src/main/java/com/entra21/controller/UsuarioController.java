package com.entra21.controller;

import com.entra21.controller.dto.UsuarioDTO;
import com.entra21.model.Usuario;
import com.entra21.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    /*
    @PostMapping
    public ResponseEntity<UsuarioDTO>
        gravar(@RequestBody @Valid UsuarioFORM usuarioFORM, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioFORM.converter(cursoRepository);
        usuarioRepository.save(usuario);

        URI uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuariooDTO(usuario));
    }
     */

    @PostMapping
    public void cadastrar(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody String nome) {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);
        if (usuarioBuscado.isPresent()) {
            Usuario u = usuarioRepository.getById(id);
            u.setNome(nome);
            usuarioRepository.save(u);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
