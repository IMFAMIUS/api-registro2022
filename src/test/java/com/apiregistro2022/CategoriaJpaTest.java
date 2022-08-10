package com.apiregistro2022;

import com.apiregistro2022.entity.Categoria;
import com.apiregistro2022.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CategoriaJpaTest {
    private static Categoria objcategoria;
    
    @Autowired
    private CategoriaRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objcategoria= new Categoria(); 
        System.out.println("BeforeAll -> Inicio() ");        
    }
    @BeforeAll
    public static void Final(){
        objcategoria= null; 
        System.out.println("BeforeAll -> Final() ");        
    }
    
    @Test
    @Rollback(false)
    public void RegistrarCategoria(){
        objcategoria.setNombre("Instrumentos musicales"); 
        objcategoria.setEstado(true);
        Categoria categoria=repositorio.save(objcategoria);
        assertNotNull(categoria);
        System.out.println("Test -> RegistrarCategoria");
    }
    
    @Test
    public void BuscarCategoriaXCodigoTest(){
        long cod=15;
        Optional<Categoria> categoria=repositorio.findById(cod);
        assertNotNull(categoria);
    }
    
    @Test
    public void ActualizarCategoriaTest(){
        objcategoria.setCodigo(15);
        objcategoria.setNombre("Equipos de sonido");
        objcategoria.setEstado(true);
        Categoria categoria=repositorio.save(objcategoria);
        assertNotNull(categoria);
        
        System.out.println("Test -> ActualizarCategoriaTest");
    }
    
    @Test
    @Rollback(false)
    public void EliminarCategoriaTest(){
        objcategoria.setCodigo(19);
        objcategoria.setNombre("Instrumentos musicales");
        objcategoria.setEstado(false);
        Categoria categoria=repositorio.save(objcategoria);
        assertNotNull(categoria);
        
        System.out.println("Test -> EliminarCategoriaTest");
    }
    
    @Test
    public void MostrarCategoriaTest(){
        List<Categoria> categoria = repositorio.findAll();
        assertNotNull(categoria);
        
        System.out.println("Test -> MostrarCategoriaTest");
    }
    
    @Test
    public void MostrarCategoriaCustomTest(){
        List<Categoria> categoria = repositorio.findAllCustom();
        assertNotNull(categoria);
        
        System.out.println("Test -> MostrarCategoriaCustomTest");
    }
}
