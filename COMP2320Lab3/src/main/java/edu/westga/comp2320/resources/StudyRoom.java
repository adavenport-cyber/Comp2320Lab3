package edu.westga.comp2320.resources;
import static edu.westga.comp2320.SimulationParameters.*;

/**
 * The StudyRoom class represents a study room resource in the resource center.
 * Each study room has a unique code and a defined checkout duration.
 *
 * @author Andrew Davenport
 */
public class StudyRoom extends Resource {
    private static final String TYPE = "StudyRoom";

    private static int studyRoomCount = 0;
    private String code;

    /**
     * Creates a new StudyRoom with a unique code.
     */
    public StudyRoom() {
        studyRoomCount++;
        this.code = TYPE + "-" + studyRoomCount;
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