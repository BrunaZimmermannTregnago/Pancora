package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface EmpresaRepository extends JpaRepository<Empresa, BigDecimal> {
}