package com.dn.logviewer.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dn.logviewer.abstracts.interfaces.IReportService;
import com.dn.logviewer.common.Constants;
import com.dn.logviewer.domain.Rendering;
import com.dn.logviewer.domain.RenderingExecution;
import com.dn.logviewer.domain.Report;
import com.dn.logviewer.util.matchers.FinishRenderingMatcher;
import com.dn.logviewer.util.matchers.GetRenderingMatcher;
import com.dn.logviewer.util.matchers.StartRenderingMatcher;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service for report manipulation.
 * @author Emanoel de Lima
 */
@Service
public class TextLogReportService implements IReportService {
    
    public Report generateReport(MultipartFile file) {

        Report report = new Report();
        if(checkFileExtension(file.getName()) || checkFileExtension(file.getOriginalFilename())) {
            try {
                InputStream is = file.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = null;
    
                HashMap<String, RenderingExecution> renderingExecutions = new HashMap<>();
                HashMap<String, Rendering> renderingsByUid = new HashMap<>();
                
                StartRenderingMatcher startRendMatch = new StartRenderingMatcher();
                FinishRenderingMatcher finishRendMatch = new FinishRenderingMatcher();
    
                GetRenderingMatcher getRenderingMatcher = new GetRenderingMatcher();
    
                while((line = br.readLine()) != null) {
    
                    if(startRendMatch.match(line, renderingExecutions, renderingsByUid)) {
                        continue;
                    }
    
                    if(finishRendMatch.match(line, renderingExecutions, renderingsByUid)) {
                        continue;
                    }
    
                    getRenderingMatcher.match(line, renderingsByUid);
                    
                }
    
                List<Rendering> renderingList = new ArrayList<Rendering>(renderingsByUid.values());
    
                report.setRenderings(renderingList);
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return report;
    }

    @Override
    public Boolean checkFileExtension(String filename) {
        return filename.contains(Constants.EXTENSION_LOG) || filename.contains(Constants.EXTENSION_TXT);
    }

}
