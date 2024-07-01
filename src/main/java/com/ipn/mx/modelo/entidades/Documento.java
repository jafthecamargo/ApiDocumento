package com.ipn.mx.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Documento")
public class Documento {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocumento", nullable = false)
    private Long idDocumento;

    @Column(name = "nombreDocumento", length = 100, nullable = false)
    private String nombreDocumento;

    @Column(name = "tipoDocumento", length = 100, nullable = false)
    private String tipoDocumento;

    @Lob
    @Column(name = "datosDocumento", length = 16777215, nullable = false)
    private byte[] datosDocumento;
}
