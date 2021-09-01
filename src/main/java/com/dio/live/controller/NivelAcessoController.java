package com.dio.live.controller;

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {
    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.saveNivelAcesso(nivelAcesso);
    }

    @GetMapping
    public List<NivelAcesso> getNivelAcessoList(){
        return nivelAcessoService.findAll();
    }

    @GetMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoByID(@PathVariable("idNivelAcesso") long idNivelAcesso) throws Exception {
        return ResponseEntity.ok(nivelAcessoService.getById(idNivelAcesso).orElseThrow(() -> new NoSuchElementException("NivelAcesso não encontrada!")));
    }
    @PutMapping
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.updateNivelAcesso(nivelAcesso);
    }
    @DeleteMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> deleteByID(@PathVariable("idNivelAcesso") Long idNivelAcesso) throws Exception {
        try{
            nivelAcessoService.deleteNivelAcesso(idNivelAcesso);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<NivelAcesso>) ResponseEntity.ok();
    }
}
