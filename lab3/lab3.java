import java.io.*;
import java.util.*;


public class lab3 {
    public static void main (String[] args) {
        List<Point3d> list = new ArrayList<Point3d>();//массив для хранения точек
       //проверка исключений на ошибку ввода вывода и запись в массив
        try{    
                //инициализация буфера и входного потока
                InputStreamReader inputReader = new InputStreamReader(System.in,"utf-8");
                BufferedReader buffReader = new BufferedReader(inputReader);
                //запись в массив
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
            //вызов функции подсчета площади
        try{
            System.out.println("Triangle area: " + computeArea(list.get(0), list.get(1), list.get(2)));
            }catch (IllegalArgumentException e) {//проверка на корректность передаваемого значения функции
                e.printStackTrace();
            }

    }
    
    // функция подсчета площади треугольника
    public static double computeArea (Point3d point1, Point3d point2, Point3d point3) {
        //проверка что 2 любые точки не эквивалентны иначе выдать сообщение
        if (point1.equals(point2) || point2.equals(point3) || point3.equals(point1)) {
            throw new IllegalArgumentException("Points shoud not be equal");
        }
        //подсчет площади
        double a = point1.distanceTo(point2),b = point2.distanceTo(point3),c = point3.distanceTo(point1),p = (a + b + c)/2,S = Math.sqrt(p * (p-a) * (p-b) * (p-c));;
        //возврат площади
        return S;
    }
} 