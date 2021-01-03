/*
 * Copyright (c) 2016 Helmut Neemann
 * Use of this source code is governed by the GPL v3 license
 * that can be found in the LICENSE file.
 */
package de.neemann.digital.core.basic;

import de.neemann.digital.core.NodeException;
import de.neemann.digital.core.ObservableValue;
import de.neemann.digital.core.element.ElementAttributes;
import de.neemann.digital.core.element.ElementTypeDescription;
import de.neemann.digital.core.element.Keys;
import de.neemann.digital.insight.InsightSimple;
import de.neemann.digital.insight.InsightTwoInputGate;

import java.util.ArrayList;

/**
 * The NOr
 */
public class NOr extends Or {

    /**
     * The NOr description
     */
    public static final ElementTypeDescription DESCRIPTION = new FanInDescription(NOr.class)
            .setInsightFactory(new InsightSimple()
                    .add("NOr3.dig", attr -> attr.getBits() == 1 && attr.get(Keys.INPUT_COUNT) == 3)
                    .add(InsightTwoInputGate.INSTANCE))
            .addAttribute(Keys.WIDE_SHAPE);

    /**
     * Creates a new instance
     *
     * @param attributes the attributes
     */
    public NOr(ElementAttributes attributes) {
        super(attributes);
    }

    @Override
    protected long calculate(ArrayList<ObservableValue> inputs) throws NodeException {
        return ~super.calculate(inputs);
    }
}
