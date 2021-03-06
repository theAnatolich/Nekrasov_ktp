
//класс 3х мерной точки
public class Point3d {
    private double _x,_y,_z;//координаты точки
       
        
    
    public Point3d(){//конструктор по умлчанию
        this(0.,0.,0.);
    }
    public Point3d(double x,double y,double z) {// конструктор инициализации
        _x=x;
        _y=y;
        _z=z;
    }
    //функции для возврата значений
    public double getX(){
        return _x;
    }
    public double getY(){
        return _y;
    }
    public double getZ(){
        return _z;
    }
    //функции для записи значений
    public void setX(double val){
        _x=val;
    }
    public void setY(double val){
        _y=val;
    }
    public void setZ(double val){
        _z=val;
    }
    //функция проверки 2х точек на эквиваленность
    public boolean equiv(Point3d point){
        return (point.getX()==this.getX()&&point.getY()==this.getY()&&point.getZ()==this.getZ());
    }
    //рсчет растояния между двумя точками
    public double distanceTo(Point3d point) {
        return Math.sqrt(Math.pow(point.getX() - this.getX(), 2) + Math.pow(point.getY() - this.getY(), 2));
    }
}