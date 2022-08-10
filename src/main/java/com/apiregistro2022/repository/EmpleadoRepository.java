package com.apiregistro2022.repository;

import com.apiregistro2022.entity.Cliente;
import com.apiregistro2022.entity.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
    @Query("select c from Empleado c where c.estado='1'")
    List<Empleado> findAllCustom();

    @Query("select c from Empleado c where upper(c.nombre) like upper(:nombre) and c.estado='1'")
    List<Empleado> findByName(@Param("nombre") String nombre);
    
}
