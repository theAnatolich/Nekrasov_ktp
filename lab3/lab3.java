import java.io.*;
import java.util.*;


public class lab3 {
    public static void main (String[] args) {
        List<Point3d> list = new ArrayList<Point3d>();
        try{
                InputStreamReader inputReader = new InputStreamReader(System.in,"utf-8");
			    BufferedReader buffReader = new BufferedReader(inputReader);
            for (int i=0;i<3;i++){
                     System.out.print("Write the new point:\n x- ");
                    double x = Double.parseDouble(buffReader.readLine());
                    System.out.print(" y- ");
                    double y = Double.parseDouble(buffReader.readLine());
                    System.out.print(" z- ");
                    double z = Double.parseDouble(buffReader.readLine());
                    list.add(new Point3d(x,y,z));
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }  
        try{
            System.out.println("Triangle area: " + computeArea(list.get(0), list.get(1), list.get(2)));
            }catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

    }
    
    
    public static double computeArea (Point3d point1, Point3d point2, Point3d point3) {
        if (point1.equals(point2) || point2.equals(point3) || point3.equals(point1)) {
            throw new IllegalArgumentException("Points shoud not be equal");
        }
        double a = point1.distanceTo(point2),b = point2.distanceTo(point3),c = point3.distanceTo(point1),p = (a + b + c)/2,S = Math.sqrt(p * (p-a) * (p-b) * (p-c));;
        return S;
    }
} 