package com.apiregistro2022.restcontroller;

import com.apiregistro2022.entity.Distrito;
import com.apiregistro2022.service.DistritoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distrito")
public class DistritoController {
    
    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public List<Distrito> findAll() {
        return distritoService.findAll();
    }

    @GetMapping("/custom")
    public List<Distrito> findAllCustom() {
        return distritoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Distrito> findById(@PathVariable Long id) {
        return distritoService.findById(id);
    }

    @PostMapping
    public Distrito add(@RequestBody Distrito p) {
        return distritoService.add(p);
    }

    @PutMapping("/{id}")
    public Distrito update(@PathVariable Long id, @RequestBody Distrito p) {
        p.setCodigo(id);
        return distritoService.update(p);
    }

    @DeleteMapping("/{id}")
    public Distrito delete(@PathVariable Long id) {
        Distrito objDistrito = new Distrito();
        objDistrito.setCodigo(id);
        return distritoService.delete(Distrito.builder().codigo(id).build());
    }
}
