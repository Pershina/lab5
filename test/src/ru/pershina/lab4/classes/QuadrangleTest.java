package ru.pershina.lab5.classes;

import org.junit.Test;
import static org.junit.Assert.*;

import ru.pershina.lab5.*;

/**
Тестирование методова класс "Четырехугольник"
@author Pershina Elena
*/
public class QuadrangleTest{ 
   
   @Test
   public void testPerimetr() 
   { 
	System.out.println("Тестируем метод getPerimetr()");
	Quadrangle p =new Quadrangle(new Point(1,2,2), new Point(1,2,3),new Point(1,2,2),new Point(1,2,3));
	assertEquals(4.0,p.getPerimetr(), 0.01);			
   }

   @Test
   public void testSt() 
   { 
	System.out.println("Тестируем метод getAB()");
	Quadrangle p = new Quadrangle(new Point(1,2,2), new Point(1,2,3),new Point(1,2,2), new Point(1,2,3));
	assertEquals(1.0, p.getAB(), 0.01);
	assertEquals(1.0, p.getBC(), 0.01);
	assertEquals(1.0, p.getCD(), 0.01);
	assertEquals(1.0, p.getDA(), 0.01);			
   }
}
