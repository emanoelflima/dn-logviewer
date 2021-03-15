package com.dn.logviewer.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * Class representing the renderings report.
 * @author Emanoel de Lima
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Report {

    @XmlElement(name="rendering", nillable = true)
    private List<Rendering> renderings;
    
    @XmlElement(name="summary", nillable = true)
    public Summary getSummary() {
        Long count = Long.valueOf(renderings.size());
        Long duplicates = renderings.stream().filter(x -> x.getStarts().size() > 1).count();
        Long unecessary = renderings.stream().filter(x -> x.getGets().size() == 0).count();
        return new Summary(count, duplicates, unecessary);
    }
}
