package ru.pershina.lab5;

import java.io.*;
import java.util.*;

public class Lab5 {
    private static List<Point> list;
    private static void init(){
    list = new ArrayList<>();
     list.add(new Point(0,4,-8));
    list.add(new Vector(new Point(1,2,5),new Point(9,7,6)));
    list.add(new Triangle(new Point(5,3,4),new Point(5,6,7),new Point(8,9,5)));
    list.add(new Quadrangle(new Point(1,1,5),new Point(8,4,5),new Point(10,6,7),new Point(6,7,5)));
    list.add(new Point(2,2,7));
    list.add(new Triangle(new Point(0,0,3),new Point(5,4,5),new Point(3,3,4)));
    list.add(new Quadrangle(new Point(0,0,4),new Point(3,6,4),new Point(6,4,6),new Point(6,7,3)));
    list.add(new Vector(new Point(9,3,2),new Point(4,3,2)));
    list.add(new Triangle(new Point(-1,2,5),new Point(3,4,7),new Point(8,3,6)));
    list.add(new Quadrangle(new Point(1,1,4),new Point(7,4,3),new Point(2,4,5),new Point(8,9,6)));
    }
    public static void main(String[] args) throws IOException {
        init();

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        for(;;){//­бесконечный цикл
            System.out.println();
            System.out.println("Сотритровка():");
            System.out.println("--------------------------------------------------");
            System.out.println("1 - по возрастанию id");
            System.out.println("2 - по убыванию id");
            System.out.println("3 - по возрастанию имени");
            System.out.println("4 - по убыванию имени");
            System.out.println("5 - по возрастанию периметра");
            System.out.println("6 - по убыванию периметра");
            System.out.println("7 - добавить объект");
            System.out.println("8 - удалить объект");
            System.out.println("9 - смещение");
            System.out.println("10 - симметрия");
            System.out.println("--------------------------------------------------");
            String mode = br.readLine();
            if (mode.isEmpty()) break; 
            Scanner in = new Scanner(System.in);
            boolean sortUp = mode.equals("2") || mode.equals("4") || mode.equals("6");
            int sortMode=0;
            if (mode.equals("3")||mode.equals("4")) sortMode=1;
            else if (mode.equals("5")||mode.equals("6")) sortMode=2;
            else if (mode.equals("7")){
                int type;
                do{
                    System.out.println("1 - точка");
                    System.out.println("2 - вектор");
                    System.out.println("3 - треугольник");
                    System.out.println("4 - четырехугольник");
                    type = in.nextInt();
                
                }while(type < 0 || type > 5);
                Point [] p = new Point [type];
                for(int i = 0; i < p.length; i++){
                    System.out.print("x["+i+"] = ");
                    double x = in.nextDouble();
                    System.out.print("y["+i+"] = ");
                    double y = in.nextDouble();
                    System.out.print("z["+i+"] = ");
                    double z = in.nextDouble();
                    p[i] = new Point(x,y,z);
                }
                switch(type){
                    case 1 : {
                        list.add(p[0]);}break;
                    case 2 : {
                        list.add(new Vector(p[0], p[1]));
                    }break;
                    case 3 : {
                        list.add(new Triangle(p[0], p[1], p[2]));
                    }break;
                    case 4 : {
                        list.add(new Quadrangle(p[0], p[1], p[2], p[3]));
                    }break;
                    default : System.out.println("Упс!");
                }
            }
            else if(mode.equals("8")){
                int index = 0;
                System.out.print("id: ");
                int id = in.nextInt();
                for (Point p: list) {
                    if(p.getId() == id) index = list.indexOf(p);
                }
                list.remove(index);
            }
            
            else if (mode.equals("9")){ //смещение
                int id;
                double  x, y, z;
                System.out.print("id: ");
                id = in.nextInt();
                System.out.println("Введите координаты вектора на которое произведется смещение: ");
                System.out.print("x = ");
                x = in.nextDouble();
                System.out.print("y = ");
                y = in.nextDouble();
                System.out.print("z = ");
                z = in.nextDouble();
                Point a = new Point(x,y,z);
                for (Point p: list) {
                    if(p.getId() == id){
                        p.move(a);
                       
                    }
                }
           }
            
            else if(mode.equals("10")){
                int id;
                System.out.print("id: ");
                id = in.nextInt();
                for (Point p: list) {
                    if(p.getId() == id){
                        p.simmetry();
                       
                    }
                }
            }
            
            Collections.sort(list, new SortMode(sortUp,sortMode));
            for (Point p: list) {
                System.out.println(p);
            }
        }
    }
}
