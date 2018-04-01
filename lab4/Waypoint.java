/**
 * This class represents a single step in a path generated by the A* pathfinding
 * algorithm.  Waypoints consist of a location, the previous waypoint in the
 * path, and some cost values used to determine the best path.
 **/
public class Waypoint
{
    /** The location of this waypoint. **/
    Location loc;

    /**
     * The previous waypoint in this path, or <code>null</code> if this is
     * the root of the A* search.
     **/
    Waypoint prevWaypoint;

    /**
     * This field stores the total previous cost of getting from the starting
     * location to this waypoint, through the chain of waypoints.  This is an
     * actual cost of following the path; it does not include any estimates.
     **/
    private float prevCost;

    /**
     * This field stores an estimate of the remaining cost of traveling from
     * this waypoint to the final destination.
     **/
    private float remainingCost;


    /**
     * Construct a new waypoint for the specified location.  A previous waypoint
     * can optionally be specified, or the reference can be <code>null</code> to
     * indicate that the waypoint is the start of the path.
     **/
    public Waypoint(Location loc, Waypoint prevWaypoint)
    {
        this.loc = loc;
        this.prevWaypoint = prevWaypoint;
    }

    /** Returns the location of the waypoint. **/
    public Location getLocation()
    {
        return loc;
    }
    
    /**
     * Returns the previous waypoint in the path, or <code>null</code> if this
     * is the start of the path.
     **/
    public Waypoint getPrevious()
    {
        return prevWaypoint;
    }
    
    /**
     * This mutator allows both the previous cost and the remaining cost to be
     * set in one method call.  Normally these values will be set at the same
     * time anyway.
     **/
    public void setCosts(float prevCost, float remainingCost)
    {
        this.prevCost = prevCost;
        this.remainingCost = remainingCost;
    }

    /**
     * Returns the actual cost of getting to this point from the starting
     * location, through the series of waypoints in this chain.
     **/
    public float getPreviousCost()
    {
        return prevCost;
    }

    /**
     * Returns an estimate of the remaining cost of traveling from this
     * point to the final destination.
     **/
    public float getRemainingCost()
    {
        return remainingCost;
    }

    /**
     * Returns the total cost estimate for this waypoint.  This includes the
     * actual cost of getting to this point from the starting location, plus
     * the estimate of the remaining cost of traveling from this point to
     * the final destination.
     **/
    public float getTotalCost()
    {
        return prevCost + remainingCost;
    }
}

