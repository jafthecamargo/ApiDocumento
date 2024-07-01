package com.ipn.mx.servicios;

import com.ipn.mx.modelo.entidades.Documento;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface DocumentoService {
    Documento almacenarDocumento(MultipartFile documento) throws IOException;
    Optional<Documento> obtenerDocumentoPorId(Long id);
}
