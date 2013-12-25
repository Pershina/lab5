package ru.pershina.lab5;

/**
 Класс "Вектор"
 @author Pershina Elena
*/

public class Vector extends Point{
    private double  perimetr;
    private double kx,ky,kz;
    private  Point p2;
    private double distance;
    public Vector(Point p1, Point p2){//конструктор
        super(p1);
        this.setName("Вектор");
        this.p2 = p2;
        distance = this.length(p1, p2);
   }
    public Point getP2(){
        return p2;
    }
/**
 Метод для вывода длины между точками вектора
*/    
    public double getDistance(){
        return distance;
    }
/**
 Метод для вычисления cos(OA^OB) 
*/
    public double getCos(){
       return (getX()*p2.getX()+getY()*p2.getY()+getZ()*p2.getZ())/((Math.sqrt(getX()*getX()+getY()*getY()
               +getZ()*getZ()))*(Math.sqrt(p2.getX()*p2.getX()+p2.getY()*p2.getY()+p2.getZ()*p2.getZ())));
    }
/**
 Метод для вычисления координаты х вектора 
*/   
    public double getKx(){
        kx=p2.getX()-getX();
        return kx;
    }
/**
 Метод для вычисления координаты у вектора 
*/ 
    public double getKy(){
        ky=p2.getY()-getY();
        return ky; 
    }
/**
 Метод для вычисления координаты z вектора 
*/ 
    public double getKz(){
        kz=p2.getZ()-getZ();
        return kz ;
    }
/**
 Метод для вычисления периметра который равен его длине
*/ 
    @Override
    public double getPerimetr(){
        perimetr = distance;
        return perimetr;
    }
/**
 Реализация перемещения объекта на заданный вектор 
 */    
        public void move(Point p){
        setPoint(new Point(getX()+p.getX(),getY()+p.getY(),getZ()+p.getZ()));
        p2.setPoint(new Point(p2.getX()+p.getX(),p2.getY()+p.getY(),p2.getZ()+p.getZ()));
    }
/**
 Реализация семместрии объекта относительно начала координат
 */     
        public void simmetry(){
        setPoint(new Point(-getX(),-getY(),-getZ()));
        p2.setPoint(new Point(-p2.getX(),-p2.getY(),-p2.getZ()));
    }
    
    @Override
    public String toString(){
         return "id = "+getId()+
                ", "+getName()+
                ": L = "+setRound(length(this, p2))+
                ", координаты("+setRound(getKx())+
                "," +setRound(getKy())+
                "," +setRound(getKz())+
                "), cos(OA^OB) = "+setRound(getCos());
    }
}
