package ma.peps.sqli.zynerator.controller;

import jakarta.servlet.http.HttpServletRequest;
import ma.peps.sqli.zynerator.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public abstract class BaseController {

    @Autowired
    private MessageSource messageSource;


    @Value("${uploads.location.directory}")
    private String UPLOADED_FOLDER;

    protected static ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(200000);
        return factory;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e, HttpServletRequest request) throws IOException {
        GlobalException globalException = new GlobalException(e, messageSource, request.getRequestURI());
        ErrorResponse errorResponse = new ErrorResponse(globalException.getStatus(), e, globalException.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorResponse, globalException.getStatus());
    }

    // Download file
    protected ResponseEntity<InputStreamResource> getFileResource(String fichier, String fileName) throws Exception {
        if (fichier != null && !fichier.isEmpty()) {
            File file = new File(UPLOADED_FOLDER + fichier);
            if (file.exists()) {
                FileInputStream inputStream = new FileInputStream(file);
                InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
                return ResponseEntity.ok().eTag(fileName).contentLength(file.length()).contentType(MediaType.parseMediaType(Files.probeContentType(file.toPath()))).body(inputStreamResource);
            }
        }
        return new ResponseEntity<InputStreamResource>(HttpStatus.NOT_FOUND);
    }
}
