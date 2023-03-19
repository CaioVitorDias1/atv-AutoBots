package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Documento;
import com.autobots.sistema.services.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    
    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/todos")
    public List<Documento> pegarDocumentos(){
        return documentoService.pegarTodos();
    };

    @GetMapping("/pegar/{id}")
    public Documento pegarDocumento(@PathVariable Long id){
        return documentoService.pegarUm(id);
    }

    @PostMapping("/cadastrar")
    public Documento cadastrarDocumento(@RequestBody Documento documento){
        documentoService.criarDocumento(documento);
        return documento;
    }

    @PutMapping("/alterar")
    public Documento alterarDocumento(@RequestBody Documento documento){
        documentoService.atualizandoDocumento(documento);
        return documento;
    }

    @DeleteMapping("/deletar")
    public void deletarDocumento(@RequestBody Documento deletarDoc){
        documentoService.deletandoDocumento(deletarDoc);
    }
}
