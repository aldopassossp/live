package com.dio.live.controller;

import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.saveMovimentacao(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> getMovimentacaoList(){
        return movimentacaoService.findAll();
    }

    @GetMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> getMovimentacaoByID(@PathVariable("idMovimentacao") long idMovimentacao) throws Exception {
        return ResponseEntity.ok(movimentacaoService.getById(idMovimentacao).orElseThrow(() -> new NoSuchElementException("Movimentacao não encontrada!")));
    }
    @PutMapping
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.updateMovimentacao(movimentacao);
    }
    @DeleteMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> deleteByID(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception {
        try{
            movimentacaoService.deleteMovimentacao(idMovimentacao);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Movimentacao>) ResponseEntity.ok();
    }
}
