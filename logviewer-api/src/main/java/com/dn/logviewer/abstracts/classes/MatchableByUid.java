package com.dn.logviewer.abstracts.classes;

import java.util.HashMap;

import com.dn.logviewer.domain.Rendering;

import lombok.Data;

@Data
/**
 * Abstract class for match operations that use only the renderings map by uid
 * @author Emanoel de Lima
 */
public abstract class MatchableByUid extends Matchable {
    
    /**
     * Class constructor
     * @param regex
     */
    public MatchableByUid(String regex) {
        super(regex);
    }

    /**
     * Matches a log line data with an object inside the renderings map by uid.
     * @param line
     * @param renderingsByUid hashMap of {@link Rendering} mapped by rendering uid
     * @return
     */
    public abstract Boolean match(String line, HashMap<String, Rendering> renderingsByUid);

}
