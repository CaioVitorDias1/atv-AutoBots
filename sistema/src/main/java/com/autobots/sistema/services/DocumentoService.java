package com.autobots.sistema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.autobots.sistema.entities.Documento;
import com.autobots.sistema.models.AtualizarDocumento;
import com.autobots.sistema.repositories.DocumentoRepository;

@Service
public class DocumentoService {
    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private AtualizarDocumento atualizarDocumento;

    public List<Documento> pegarTodos(){
        List<Documento> telefones = documentoRepository.findAll();
        return telefones;
    }

    public Documento pegarUm(@PathVariable Long id){
        List<Documento> documentos = documentoRepository.findAll();
        Documento documentoBuscado = null;
        for(Documento documentoABuscar : documentos){
            if(documentoABuscar.getId() == id){
                return documentoABuscar;
            }

            return documentoBuscado = documentoABuscar;

        };
        return documentoBuscado;
    }

    public Documento criarDocumento(@RequestBody Documento documento){
        documentoRepository.save(documento);
        return documento; 
    }

    public Documento atualizandoDocumento(@RequestBody Documento novoDocumento){
        Documento documento = documentoRepository.getReferenceById(novoDocumento.getId());
        atualizarDocumento.atualizar(documento, novoDocumento);
        documentoRepository.save(documento);
        return documento;
    }

    public void deletandoDocumento(@RequestBody Documento deletando){
        Documento documento = documentoRepository.getReferenceById(deletando.getId());
        documentoRepository.delete(documento);
    }

}
