package edu.westga.comp2320.events;

import edu.westga.comp2320.manager.ResourceManager;
import edu.westga.comp2320.resources.Resource;

import java.util.Random;

import static edu.westga.comp2320.SimulationParameters.*;

/**
 * The CheckoutEvent class represents a resource being checked out from the resource center.
 *
 * @author Andrew Davenport
 */
public class CheckoutEvent extends Event {
    private ResourceManager resourceManager;

    /**
     * Creates a new CheckoutEvent at the specified time with access
     * to the ResourceManager.
     *
     * @param time The time the event occurs
     * @param resourceManager The ResourceManager from which a
     * resource is checked out
     */
    public CheckoutEvent(int time, ResourceManager resourceManager) {
        super(time);
        this.resourceManager = resourceManager;
    }

    @Override
    public Event processEvent() {
        Resource resource = this.resourceManager.getResource();
        if (resource == null) {
            System.out.println("*** resource not available at time " + this.getTime());
            return null;
        } else {
            System.out.println("Checkout of " + resource + " at time " + this.getTime());
            Random random = new Random();
            int maxDuration = 60;
            int extraTime = random.nextInt(maxDuration - MIN_CHECKOUT_DURATION + 1);
            int returnTime = this.getTime() + MIN_CHECKOUT_DURATION + extraTime;
            return new ReturnEvent(returnTime, resource);
        }
    }
}