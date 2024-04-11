package com.example.projetoescola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.DadosCursoDTO;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.services.CursoService;

import java.util.List;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Curso salvar(@RequestBody CursoDTO curso) {
        return cursoService.salvar(curso);
    }

    @GetMapping()
    public List<DadosCursoDTO> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public DadosCursoDTO ObterPorId(@PathVariable Long id) {
        return cursoService.ObterPorId(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        cursoService.deletar(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody CursoDTO curso) {
         cursoService.editar(id, curso);
    }

}
