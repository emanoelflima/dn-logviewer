package com.dn.logviewer.abstracts.interfaces;

import com.dn.logviewer.domain.Report;

import org.springframework.web.multipart.MultipartFile;

/**
 * Interface for report generators.
 * @author Emanoel de Lima
 */
public interface IReportService {
    
    /**
     * Generates a Report entity containing data read from a txt file.
     * @param file {@link MultipartFile}
     * @return {@link Report}
     */
    public Report generateReport(MultipartFile file);

    /**
     * Checks if file is in acceptable format
     * @param filename
     * @return
     */
    public Boolean checkFileExtension(String filename);

}
