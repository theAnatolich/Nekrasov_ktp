public class Location
{
    public int xCoord, yCoord;


    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    public Location()
    {
        this(0, 0);
    }
    
    public boolean equals(Object obj) 
        { 
        if (obj == null) {
            return false;
        }

        if (obj instanceof Location) 
            {
                Location other = (Location) obj; 
                
                if (xCoord == other.xCoord && yCoord == other.yCoord) 
                { 
                        return true; 
                } 
            } 
        
        return false; 
    }
    
    public int hashcode() 
    { 
        int result = 19;         
        result = 17 * result + (xCoord * 11); 
        result = 23 * result + (yCoord * 13); 
        return result; 
    }
}
