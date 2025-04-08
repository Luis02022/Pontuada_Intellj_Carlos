package com.atividadepontuada.senai.controller;

import com.atividadepontuada.senai.model.Funcionario;
import com.atividadepontuada.senai.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/dev")
    public String desenvolvedor(){
        return "Luis Felipe de jesus Santana😑";
    }

    @GetMapping("/list")
    public List<Funcionario> listarTodos(){
        return funcionarioService.listartodos();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Funcionario cadastrado com sucesso"));
    }

    @PutMapping("/up")
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário Atualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        funcionarioService.excluir(id);
        return ResponseEntity.ok().body("Funcionário excluído com sucesso");
    }


}