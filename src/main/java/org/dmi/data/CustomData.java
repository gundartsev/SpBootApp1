package org.dmi.data;

import lombok.Data;

/**
 * @author Dmytro Gundartsev (dmytro.gundartsev@embedit.cz) on 11.12.17.
 */

@Data(staticConstructor = "of")
public class CustomData {
    private final Integer id;
    private final String message;

}
