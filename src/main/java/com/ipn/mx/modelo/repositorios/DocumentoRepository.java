package com.ipn.mx.modelo.repositorios;

import com.ipn.mx.modelo.entidades.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> { }