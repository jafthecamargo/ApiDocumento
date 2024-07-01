package com.ipn.mx.servicios;

import com.ipn.mx.modelo.entidades.Documento;
import com.ipn.mx.modelo.repositorios.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    DocumentoRepository repository;

    @Override
    @Transactional
    public Documento almacenarDocumento(MultipartFile documento) throws IOException {
        String nombreDocumento = StringUtils.cleanPath(documento.getOriginalFilename());
        Documento documentoBD = Documento.builder()
                .nombreDocumento(nombreDocumento)
                .tipoDocumento(documento.getContentType())
                .datosDocumento(documento.getBytes())
                .build();
        return repository.save(documentoBD);
    }

    @Override
    public Optional<Documento> obtenerDocumentoPorId(Long id) {
        return repository.findById(id);
    }
}
