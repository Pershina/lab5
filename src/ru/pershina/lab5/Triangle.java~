package ru.pershina.lab5;

/**
 Класс "Треугольник"
 @author Pershina Elena
*/

public class Triangle extends Point{ 
    private Point p2, p3;
    private double perimetr, polperimetr, ab,bc,ca;
    public Triangle (Point p1, Point p2, Point p3){//конструктор
        super(p1);
        this.setName("Треугольник");
        this.p2=p2;
        this.p3=p3;
        ab=this.length(p1, p2);
        bc=this.length(p2, p3);
        ca=this.length(p1, p3);
    }
/**
 Реализация перемещения объекта на заданный вектор
 */   
        @Override
    public void move(Point p){
        setPoint(new Point(getX()+p.getX(),getY()+p.getY(),getZ()+p.getZ()));
        p2.setPoint(new Point(p2.getX()+p.getX(),p2.getY()+p.getY(),p2.getZ()+p.getZ()));
        p3.setPoint(new Point(p3.getX()+p.getX(),p3.getY()+p.getY(),p3.getZ()+p.getZ()));
    }
/**
 Реализация семместрии объекта относительно начала координат
 */     
        @Override
   public void simmetry(){
       setPoint(new Point(-getX(),-getY(),-getZ()));
       p2.setPoint(new Point(-p2.getX(),-p2.getY(),-p2.getZ()));
       p3.setPoint(new Point(-p3.getX(),-p3.getY(),-p3.getZ()));
    }
    
        public Point getP2(){
            return p2;
        }
        public Point getP3(){
            return p3;
        }
        public double getAb(){
            return ab;
        }
        public double getBc(){
            return bc;
        }
        public double getCa(){
            return ca;
        }
/**
 Метод для вычисления периметра
*/
            @Override
        public double getPerimetr(){
            perimetr =ab+bc+ca;
            return perimetr ;
        }
/**
 Метод для вычисления полупериметра
*/
        public double getPolperimetr(){
            polperimetr=perimetr/2; 
            return polperimetr;    
        }
/**
 Метод для вычисления площади
*/
        public double getArea(){
            return Math.sqrt(polperimetr*(polperimetr-ab)*(polperimetr-bc)*(polperimetr-ca));
        }
            @Override
        public String toString(){
            return "id = "+getId()+", "+getName()+":"+
                " AB = "+setRound(ab)+ 
                ", BC = "+setRound(bc)+
                ", CA = "+setRound(ca)+
                ", P = "+setRound(getPerimetr())+
                ", P/2 = "+setRound(getPolperimetr())+
                ", S = "+setRound(getArea());     
 
       }
}
