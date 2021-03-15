package com.dn.logviewer.resource;

import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import com.dn.logviewer.domain.Report;
import com.dn.logviewer.abstracts.interfaces.IReportService;
import com.dn.logviewer.service.TextLogReportService;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller for report manipulation.
 * @author Emanoel de Lima
 */
@RestController
@RequestMapping("/report")
public class ReportResource {
    
    private IReportService service;

    public ReportResource(TextLogReportService service) {
        this.service = service;
    }

    /**
     * Generates a report over a log file.
     * @param uploadedInputStream {@link InputStream}
     * @param fileDetails {@link FormDataContentDisposition}
     * @return {@link Report}
     */
    @PostMapping(value = "/generate", consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.APPLICATION_XML)
    public Report generate(@RequestParam("file") MultipartFile file) {
        Report response = service.generateReport(file);
        return response;
    }

}
