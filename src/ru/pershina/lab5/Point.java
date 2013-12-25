package ru.pershina.lab5;

import java.text.DecimalFormat;

/**
 Класс "Точка"
 @author Pershina Elena
*/


public class Point implements Movable, Simmetry{ 
    private String name="Точка";
    private double x, y, z, perimetr;
    private int id;
    private static int nextId=1;
    { id = nextId++; }
    public Point(double x, double y, double z){ // конструктор
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Point(Point p){ // второй конструктор
        this(p.getX(),p.getY(), p.getZ()); 
    }
    
    protected void setPoint(Point p){
        x = p.getX();
        y = p.getY();
        z = p.getZ();
    }
/**
 Реализация перемещения объекта на заданный вектор 
 */      
        @Override
    public void move(Point p){
         setPoint(new Point(getX()+p.getX(),getY()+p.getY(),getZ()+p.getZ()));
        
    }
/**
 Реализация семместрии объекта относительно начала координат
 */    
        @Override
    public void simmetry(){
        setPoint(new Point(-getX(),-getY(),-getZ()));
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
/**
 Метод преобразование формата вывода числа с плавающей точкой
 */
    protected double setRound(double x){
        return Math.round(x*100)/100d;
    }
/**
 Метод вычисления расстояния до точки
 @param p точка до которой вычисляется расстояние
 @return расстояние
 */    
    public double getSpacing(){
        return Math.sqrt(x*x+y*y+z*z); // удаленность от начало координат
    }
/**
 Метод вычисления периметра у точки он равен 0
 */     
    public double getPerimetr (){
        perimetr=0;
        return perimetr;
    }
/**
 Метод вычисления расстояния от точки до точки
 @param p1,p2  точки между которыми вычисляется растояние
 @return длина вектора
 */     
    public double length (Point p1, Point p2){
        double dx=p1.x-p2.x;
        double dy=p1.y-p2.y;
        double dz=p1.z-p2.z;
        return Math.sqrt(dx*dx+dy*dy+dz*dz);
    }
/**
 Метод вычисления скалярного произведения для вычисления углов в классе Четырехугольник
@param p3,p4,p5  точки между которыми вычисляется растояние
 @return скалярное произведение
 */ 
    public double koor (Point p3, Point p4, Point p5){
        
        double bx = p4.x - p3.x;
        double by = p4.y - p3.y;
        double bz = p4.z - p3.z;
        
        double ax = p5.x - p4.x;
        double ay = p5.y - p4.y;
        double az = p5.z - p4.z;
        return bx*ax+by*ay+bz*az;
    }
/**
 Метод вычисления в какой плоскости лежит точка 
 */    
    public String setPlane(){
        String str = "";
        if(x == 0 && y != 0 && z != 0) str = " принадлежит YOZ ";
        else if(x != 0 && y == 0 && z != 0) str = " принадлежит XOZ ";
        else if(x != 0 && y != 0 && z == 0) str = " принадлежит XOY ";
        else str = " принадлежит множеству плоскостей";
        return str;
    }

    @Override
    public String toString(){
        return "id = "+id+", "+name+" ("+x+","+y+","+z+"), "+setPlane()
                +", удаленность от (0,0,0): "+setRound(getSpacing());
    }
}
