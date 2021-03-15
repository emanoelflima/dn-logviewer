package com.dn.logviewer.abstracts.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.lang.NonNull;

import lombok.Data;

@Data
public abstract class Matchable {

    protected @NonNull String regex;
    protected Pattern pattern;
    protected Matcher matcher;

    /**
     * Class constructor
     * @param regex
     */
    public Matchable(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(this.regex);
    }

    /**
     * Sets the matcher using set pattern and returns if there is a match.
     * 
     * @param line
     * @return
     */
    public boolean match(String line) {
        matcher = pattern.matcher(line);
        return matcher.find();
    }
}
