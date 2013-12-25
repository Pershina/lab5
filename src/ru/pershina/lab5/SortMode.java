package ru.pershina.lab5;

import java.util.Comparator;
/**
 Класс содержащий в себе параметры сортировки объектов
 @author Pershina Elena
  */

public class SortMode implements Comparator<Point>{
    
    private boolean sortUp;
    private int sortMode;
    
    public SortMode(boolean sortUp, int sortMpde){
        this.sortUp = sortUp;
        this.sortMode = sortMode;
    }
/**
 Метод сравнения объектов
 @return 1 Если p1 > p2
 @return -1 Если p2 > p1
 @return 0 Если p1 = p2
 */     
    public int compare(Point p1, Point p2){
        int res = 0;
        if(sortMode == 0){
            if(p1.getId() > p2.getId()) res = 1;
            else if(p1.getId() < p2.getId()) res = -1;
        }
        else if(sortMode == 1) {res = p1.getName().compareTo(p2.getName());}
        else{
            if(p1.getPerimetr() > p2.getPerimetr()) res = 1;
            else if(p1.getPerimetr() < p2.getPerimetr()) res = -1;
        }
        if(sortUp) res *= (-1);
        return res;
    }
}
