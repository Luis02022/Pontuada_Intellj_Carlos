package com.atividadepontuada.senai.repository;

import com.atividadepontuada.senai.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository  extends JpaRepository<Funcionario, Long>{

}