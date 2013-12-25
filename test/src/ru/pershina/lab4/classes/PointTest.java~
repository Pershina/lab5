package ru.pershina.lab5.classes;


import org.junit.Test;
import static org.junit.Assert.*;

import ru.pershina.lab5.*;

/**
Тестирование методова класс "точка"
@author Pershina Elena
*/
public class PointTest{ 
   
   @Test
   public void testSpacing() 
   { 
        System.out.println("Тестируем метод getSpacing()");
	Point p = new Point(3,4,0);
	assertEquals(5.0, p.getSpacing(), 0.01);			
   }

   @Test
   public void testPlane()
   { 
        System.out.println("Тестируем метод Plane()");
	Point p = new Point(0,2,2);
	assertEquals(" принадлежит YOZ ", p.setPlane());			
   }
}
