package com.ipn.mx.integracion;

import com.ipn.mx.modelo.entidades.Documento;
import com.ipn.mx.servicios.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class DocumentoController {
    @Autowired
    DocumentoService service;

    @PostMapping("/documentos")
    @ResponseStatus(HttpStatus.CREATED)
    public Documento almacenarDocumento(@RequestParam("documento") MultipartFile documento) throws IOException {
        return service.almacenarDocumento(documento);
    }

    @GetMapping("/documentos/{id}")
    public ResponseEntity<byte[]> descargarDocumento(@PathVariable Long id) {
        Optional<Documento> optionalDocumento = service.obtenerDocumentoPorId(id);

        if (optionalDocumento.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Documento documento = optionalDocumento.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documento.getNombreDocumento() + "\"")
                .contentType(MediaType.parseMediaType(documento.getTipoDocumento()))
                .body(documento.getDatosDocumento());
    }
}
