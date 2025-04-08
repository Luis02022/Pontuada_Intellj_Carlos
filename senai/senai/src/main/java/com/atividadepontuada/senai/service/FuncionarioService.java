package com.atividadepontuada.senai.service;

import com.atividadepontuada.senai.model.Funcionario;
import com.atividadepontuada.senai.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Service
@Validated
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listartodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario) {
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Funcionario Cadastrado");
        }

        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario) {
        Funcionario funcionario1 = funcionarioRepository.findById(funcionario.getId()).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        funcionario1.setNome(funcionario.getNome());
        funcionario1.setCpf(funcionario.getCpf());
        funcionario1.setDatNascimento(funcionario.getDatNascimento());
        funcionario1.setSexo(funcionario1.getSexo());
        funcionario1.setSetor(funcionario.getSetor());
        funcionario1.setEstadoCivil(funcionario1.getEstadoCivil());
        funcionario1.setSalario(funcionario1.getSalario());
        funcionario1.setEmail(funcionario1.getEmail());

        return funcionarioRepository.save(funcionario1);
    }

    public void excluir(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado."));
        funcionarioRepository.deleteById(id);
    }


    public void validarEmailUnico(@Valid String email) {
        if (funcionarioRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("E-mail já está em uso.");
        }

    }
}