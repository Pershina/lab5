package ru.pershina.lab5;

/**
 Класс "Четырёхугольник"
 @author Pershina Elena
 */

public class Quadrangle extends Point{ 
    private Point p2, p3, p4;
    private double AB, BC,CD,DA;//стороны
    private double dAC, dBD;//диоганали
    private double sumA, sumB,sumC,sumD;
    private double a, b, c, d;
      
    public Quadrangle(Point p1, Point p2, Point p3, Point p4){ // конструктор
        super(p1);
        this.setName("Четырехугольник");
        this.p2=p2;
        this.p3=p3;
        this.p4=p4;
        AB=this.length(p1, p2);
        BC=this.length(p2, p3);
        CD=this.length(p4, p3);
        DA=this.length(p4, p1);
        dAC=this.length(p2, p3);
        dBD=this.length(p4, p3);
        sumA=this.koor(p1,p2,p3);
        sumB=this.koor(p2,p3,p4);
        sumC=this.koor(p3,p4,p1);
        sumD=this.koor(p4,p1,p3);
    }
/**
 Реализация перемещения объекта на заданный вектор
 */ 
    public void move(Point p){
        setPoint(new Point(getX()+p.getX(),getY()+p.getY(),getZ()+p.getZ()));
        p2.setPoint(new Point(p2.getX()+p.getX(),p2.getY()+p.getY(),p2.getZ()+p.getZ()));
        p3.setPoint(new Point(p3.getX()+p.getX(),p3.getY()+p.getY(),p3.getZ()+p.getZ()));
        p4.setPoint(new Point(p4.getX()+p.getX(),p4.getY()+p.getY(),p4.getZ()+p.getZ()));
    }
/**
 Реализация симместрии объекта относительно начала координат
 */        
    public void simmetry(){
        setPoint(new Point(-getX(),-getY(),-getZ()));
        p2.setPoint(new Point(-p2.getX(),-p2.getY(),-p2.getZ()));
        p3.setPoint(new Point(-p3.getX(),-p3.getY(),-p3.getZ()));
        p4.setPoint(new Point(-p4.getX(),-p4.getY(),-p4.getZ()));
    }
    
    public Point getP2(){
        return p2;
    }
    public Point getP3(){
        return p3;
    }
    public Point getP4(){
        return p4;
    }
/**
  Метод вычисления стороны AB
 */ 
    public double getAB(){
        return AB;
    }
/**
  Метод вычисления стороны BС
 */
    public double getBC(){
        return BC;
    }
/**
  Метод вычисления стороны CD
 */
    public double getCD(){
        return CD;
    }
/**
  Метод вычисления стороны DA
 */
    public double getDA(){
        return DA;
    }
/**
  Метод вычисления диаганали AC
 */
    public double getDAC(){
        return dAC;
    }
/**
  Метод вычисления диаганали ВC
 */
    public double getDBD(){
        return dBD;
    }
     public double getSumA(){
       return sumA;
    }
     public double getSumB(){
       return sumB;
    }
     public double getSumC(){
       return sumC;
    }
     public double getSumD(){
       return sumD;
    }
/**
  Метод вычисления периметра
 */
       @Override
    public double getPerimetr(){
        return AB+BC+CD+DA;
    }
/**
  Метод вычисления cos(AB^BC)
 */
    public double getA(){
        return sumA/(AB*BC);
    }
/**
  Метод вычисления cos(BC^CD)
 */
    public double getB(){
        return sumB/(BC*CD);
    }
/**
  Метод вычисления cos(CD^DA)
 */
    public double getC(){
        return sumC/(CD*DA);
    }
/**
  Метод вычисления cos(DA^AB)
 */
    public double getD(){
        return sumD/(DA*AB);
    }
/**
  Метод нахождения максимального соs угла
 */
    public double getMax(){
        double[] mas={a,b,c,d};
        double max = mas[0];
        double iMax = 0;
        for(int i = 0; i < mas.length; i++){
            if(mas[i] > max){
                max = mas[i];
                iMax = i;
            }
        }
        return iMax = max;
    }
       
    @Override
    public String toString(){
        return "id = "+getId()+", "+getName()+
            ": AB = "+setRound(AB)+ 
            ", BC = "+setRound(BC)+
            ", CD = "+setRound(CD)+
            ", DA = "+setRound(DA)+
            ", AC = "+setRound(dAC)+
            ", BD = "+setRound(dBD)+
            ", cos(AB^BC) = "+setRound(getA())+ 
            ", cos(BC^CD) = "+setRound(getB())+
            ", cos(CD^DA) = "+setRound(getC())+
            ", cos(DA^AB) = "+setRound(getD())+
            ", Max(cos) = "+setRound(getMax())+
            ", P = "+setRound(getPerimetr());     
    }
}
