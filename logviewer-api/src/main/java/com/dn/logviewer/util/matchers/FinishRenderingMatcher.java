package com.dn.logviewer.util.matchers;

import java.util.HashMap;

import com.dn.logviewer.abstracts.classes.MatchableByThread;
import com.dn.logviewer.common.Constants;
import com.dn.logviewer.domain.Rendering;
import com.dn.logviewer.domain.RenderingExecution;

public class FinishRenderingMatcher extends MatchableByThread {

    public FinishRenderingMatcher() {
        super(Constants.REGEX_FINISH_RENDERING);
    }

    @Override
    public Boolean match(String line, HashMap<String, RenderingExecution> renderingExecutions,
    HashMap<String, Rendering> renderingsByUid) {
        
        Boolean isMatch = match(line);
        
        if(isMatch) {

            String threadId = matcher.group(1);
            String documentUid = matcher.group(2);

            if(renderingExecutions.containsKey(threadId)) {
                RenderingExecution renderingExecution = renderingExecutions.get(threadId);

                if(!renderingsByUid.containsKey(documentUid)) {
                    Rendering newRendering = new Rendering(renderingExecution.getDocumentId(), renderingExecution.getPage(), documentUid);
                    renderingsByUid.put(documentUid, newRendering);
                }

                Rendering rendering = renderingsByUid.get(documentUid);
                rendering.getStarts().add(renderingExecution.getData());

                renderingExecutions.remove(threadId);
            }
        }

        return isMatch;
    }
    
}
