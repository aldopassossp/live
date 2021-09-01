package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario createCalendario(@RequestBody Calendario calendario){
        return calendarioService.saveCalendario(calendario);
    }

    @GetMapping
    public List<Calendario> getCalendarioList(){
        return calendarioService.findAll();
    }

    @GetMapping("/{idCalendario}")
    public ResponseEntity<Calendario> getCalendarioByID(@PathVariable("idCalendario") long idCalendario) throws Exception {
        return ResponseEntity.ok(calendarioService.getById(idCalendario).orElseThrow(() -> new NoSuchElementException("Calendario não encontrada!")));
    }
    @PutMapping
    public Calendario updateCalendario(@RequestBody Calendario calendario){
        return calendarioService.updateCalendario(calendario);
    }
    @DeleteMapping("/{idCalendario}")
    public ResponseEntity<Calendario> deleteByID(@PathVariable("idCalendario") Long idCalendario) throws Exception {
        try{
            calendarioService.deleteCalendario(idCalendario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Calendario>) ResponseEntity.ok();
    }
}
