package com.entra21.controller;

import com.entra21.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RespostaControlller {

    private List<Resposta> respostaList = new ArrayList<>();

    @RequestMapping("/resposta")
    @ResponseBody
    public List<Resposta> listarTudo(){
        Resposta resposta = new Resposta(1L, "resposta");

        return Arrays.asList(resposta);
    }

    @PostMapping("/resposta")
    public void cadastrar(Long id, String nome){

    }

}
