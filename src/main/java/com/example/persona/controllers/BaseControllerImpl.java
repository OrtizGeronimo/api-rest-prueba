package com.example.persona.controllers;

import com.example.persona.entities.Base;
import com.example.persona.entities.Persona;
import com.example.persona.services.BaseService;
import com.example.persona.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    @Autowired
    protected S servicio;


    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());//contiene el status de la respuesta y el body
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));//contiene el status de la respuesta y el body
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }


    @GetMapping("/{id}") //como en la uri debemos recibir el id, lo indicamos y el id parametro va a ser una pathvariable, que significa q va a ser una variable dentro del path
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E persona){ //especificamos que la entidad esta en el body del post
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(persona));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }


}
