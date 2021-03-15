package com.dn.logviewer.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class representing the summary of the report.
 * @author Emanoel de Lima
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="Report")
@XmlAccessorType(XmlAccessType.FIELD)
public class Summary {
    private long count;
    private long duplicates;
    private long unecessary;
}
