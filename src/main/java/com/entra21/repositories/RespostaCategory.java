package com.entra21.repositories;

import com.entra21.model.Categoria;
import com.entra21.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaCategory extends JpaRepository<Resposta, Long> {
}
