package com.entra21.controller.dto;

import com.entra21.model.Resposta;
import com.entra21.model.Topico;
import com.entra21.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class RespostaDTO {
    private String mensagem;
    private Topico topico;
    private Usuario autor;

    public RespostaDTO (Resposta resposta){
        this.mensagem = resposta.getMensagem();
        this.topico = resposta.getTopico();
        this.autor = resposta.getAutor();
    }

    public static List<RespostaDTO> converter (List<Resposta> respostas){
        return respostas.stream().map(RespostaDTO::new).collect(Collectors.toList());
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}
