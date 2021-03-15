package com.dn.logviewer.domain;

import java.util.ArrayList;

import lombok.Data;

/**
 * Class representing the report redering.
 * @author Emanoel de Lima
 */
@Data
public class Rendering {

    private Integer documentId;
    private Integer pageNumber;
    private String uid;
    private ArrayList<String> starts;
    private ArrayList<String> gets;

    /**
     * Class constructor
     * @param documentId
     * @param pageNumber
     * @param uid
     */
    public Rendering(Integer documentId, Integer pageNumber, String uid) {
        this.documentId = documentId;
        this.pageNumber = pageNumber;
        this.uid = uid;
        this.starts = new ArrayList<>();
        this.gets = new ArrayList<>();
    }

    @Override
    public Object clone() {
        return new Rendering(this.documentId, this.pageNumber, this.uid);
    }

}
