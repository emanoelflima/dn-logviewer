package com.dn.logviewer.util.matchers;

import java.util.HashMap;

import com.dn.logviewer.abstracts.classes.MatchableByThread;
import com.dn.logviewer.common.Constants;
import com.dn.logviewer.domain.Rendering;
import com.dn.logviewer.domain.RenderingExecution;

public class StartRenderingMatcher extends MatchableByThread {

    public StartRenderingMatcher() {
        super(Constants.REGEX_START_RENDERING);
    }

    @Override
    public Boolean match(String line, HashMap<String, RenderingExecution> renderingExecutions,
    HashMap<String, Rendering> renderingsByUid) {
        
        Boolean isMatch = match(line);
        
        if(isMatch) {

            String dateTime = matcher.group(1);
            String threadId = matcher.group(2);
            Integer documentId = Integer.parseInt(matcher.group(3));
            Integer pageNumber = Integer.parseInt(matcher.group(4));

            renderingExecutions.put(threadId, new RenderingExecution(dateTime, documentId, pageNumber));
        }

        return isMatch;
    }
    
}
