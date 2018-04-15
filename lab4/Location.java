/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

//функция для сравнения точек
    public boolean equals(Object obj) 
    { 
	if (obj == null) {
	    return false;
	}

	if (obj instanceof Location) 
        {
            Location other = (Location) obj; 
            
            if (xCoord == other.xCoord && 
                yCoord == other.yCoord) 
            { 
                    return true; 
            } 
        } 
        
        return false; 
    }
    
    //подсчет хешкода
    public int hashCode() 
    { 
        int result = 17; 
        result = 9 * result + (xCoord * 8); 
        result = 14 * result + (yCoord * 10); 
        
        return result; 
    }
}