package com.dn.logviewer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class representing a Rendering execution
 * @see {@link Rendering}
 */
@Data
@AllArgsConstructor
public class RenderingExecution {
    private String data;
    private Integer documentId;
    private Integer page;
}
