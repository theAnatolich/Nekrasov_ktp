/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
import java.util.HashMap;
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;
    private HashMap<Location, Waypoint> openWp;
    private HashMap<Location, Waypoint> closeWp;
    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        openWp = new HashMap<Location, Waypoint>();
        closeWp = new HashMap<Location, Waypoint>();
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * Этот метод сканирует все открытые путевые точки
     *  и возвращает путевую точку с минимальной общей
     *  стоимостью.  Если открытых путевых точек нет,
     *  этот метод возвращает значение null.

     **/
    public Waypoint getMinOpenWaypoint()
    {
        Waypoint wp_min = null;
        float min = Float.POSITIVE_INFINITY;
        for (Waypoint point: openWp.values()) {
        	float weight = point.getTotalCost();
        	if (weight < min) {
        		min = weight;
        		wp_min = point;
            }
        }
        return wp_min;
    }

    /**
     * Этот метод добавляет маршрутную точку в коллекцию
     *  "открытые маршрутные точки" 
     * (или потенциально обновляет уже существующую). 
     *  Если уже не открыть точку на местоположение новой
     *  путевой точки, то новая точка будет добавлена в
     *  коллекцию.  Однако, если там уже есть точка на 
     * новой путевой точки местоположения новой путевой
     *  точки заменяет старый новый путевой "старой цене" значение меньше текущей
     *  путевой точки "старой цене" значение.

     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        Waypoint other = openWp.get(newWP.getLocation());
        
        if(other == null || newWP.getPreviousCost() < other.getPreviousCost())
        {
            openWp.put(newWP.getLocation(), newWP);
            return true;
        }
        return false;
    }


    /** Возвращает текущее количество открытых точек.
 **/
    public int numOpenWaypoints()
    {
        return openWp.size();
    }


    //Этот метод перемещает точку в указанном месте из открытого списка в закрытый список.

    public void closeWaypoint(Location loc)
    {
        Waypoint p = openWp.remove(loc);
        if(p != null)
        {
            closeWp.put(loc, p);
        }
    }

    //Возвращает True, если коллекция закрытых точек содержит точки в указанном месте.

    public boolean isLocationClosed(Location loc)
    {
        return closeWp.containsKey(loc);
    }
}
