package com.dn.logviewer.util.matchers;

import java.util.HashMap;

import com.dn.logviewer.abstracts.classes.MatchableByUid;
import com.dn.logviewer.common.Constants;
import com.dn.logviewer.domain.Rendering;

public class GetRenderingMatcher extends MatchableByUid {

    public GetRenderingMatcher() {
        super(Constants.REGEX_GET_RENDERING);
    }

    @Override
    public Boolean match(String line, HashMap<String, Rendering> renderings) {
        
        Boolean isMatch = match(line);
        
        if(isMatch) {

            String dateTime = matcher.group(1);
            String documentUid = matcher.group(2);

            if(renderings.containsKey(documentUid)) {
                Rendering rendering = renderings.get(documentUid);
                rendering.getGets().add(dateTime);
            }
           
        }

        return isMatch;
    }
    
}
