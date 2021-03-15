package com.dn.logviewer.abstracts.classes;

import java.util.HashMap;

import com.dn.logviewer.domain.Rendering;
import com.dn.logviewer.domain.RenderingExecution;

import lombok.Data;

@Data
/**
 * Abstract class for match operations that use the Renderings map using file data and uid.
 * @author Emanoel de Lima
 */
public abstract class MatchableByThread extends Matchable {

    /**
     * Class constructor
     * @param regex
     */
    public MatchableByThread(String regex) {
        super(regex);
    }
    
    /**
     * Reads a log line, matches its data with the current rendering executions and assigns an object to uid map.
     * @param line 
     * @param renderingExecutions hashMap of {@link RenderingExecution} mapped by file id and page
     * @param renderingsByUid hashMap of {@link RenderingExecution} mapped by rendering uid
     * @return
     */
    public abstract Boolean match(String line, HashMap<String, RenderingExecution> renderingExecutions,
    HashMap<String, Rendering> renderingsByUid);

}
