package edu.westga.comp2320.resources;
import static edu.westga.comp2320.SimulationParameters.*;

/**
 * The Tablet class represents a tablet resource in the resource center.
 * Each tablet has a unique code and a defined checkout duration.
 *
 * @author Andrew Davenport
 */
public class Tablet extends Resource {
    private static final String TYPE = "Tablet";

    private static int tabletCount = 0;
    private String code;

    /**
     * Creates a new Tablet with a unique code.
     */
    public Tablet() {
        tabletCount++;
        this.code = TYPE + "-" + tabletCount;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public int getCheckoutDuration() {
        return TABLET_CHECKOUT_DURATION;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}