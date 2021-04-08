package com.google;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

//

public class SimberSoftTest extends WebDriverSettings {    //наследование класса WebDriverSettings

    @Test
    public void firstCase(){  //метод firstCase. Каждый автотект вынесен в свой метод

      driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div")).sendKeys("(1+2)×3-40/5=");   //ввод выражения в поле калькулятора
      String result = driver.findElement(By.xpath("//*[@id='cwos']")).getAttribute("innerHTML");   //получение вычисленного калькуляторм значения
      Assert.assertTrue(result.equals("1")); //проверка того, что результат, вычисленный калькулятором верен
      String calculation = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/span")).getAttribute("innerHTML");   //получение значения из строки памяти
      Assert.assertTrue(calculation.equals("(1 + 2) × 3 - 40 ÷ 5 =")); //проверка того, что введеная нами формула отображается в строке памяти
    }

    @Test
    public void secondCase(){   //метод secondCase. Каждый автотект вынесен в свой метод
        driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div")).sendKeys("6/0=");  //ввод выражения в поле калькулятора
        String result = driver.findElement(By.xpath("//*[@id='cwos']")).getAttribute("innerHTML");   //получение вычисленного калькуляторм значения
        Assert.assertTrue(result.equals("Infinity")); //проверка того, что результат, вычисленный калькулятором верен
        String calculation = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/span")).getAttribute("innerHTML");   //получение значения из строки памяти
        Assert.assertTrue(calculation.equals("6 ÷ 0 ="));  //проверка того, что введеная нами формула отображается в строке памяти
    }

    @Test
    public void thirdCase(){    //метод thirdCase. Каждый автотект вынесен в свой метод
        driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[3]/div/table[1]/tbody/tr[2]/td[2]/div/div[1]")).click();   //нажатие кнопки "sin" на калькуляторе
        driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div")).click();   //нажатие кнопки "=" на калькуляторе
        String result = driver.findElement(By.xpath("//*[@id='cwos']")).getAttribute("innerHTML");   //получение вычисленного калькуляторм значенияы
        Assert.assertTrue(result.equals("Error")); //проверка того, что результат, вычисленный калькулятором верен
        String calculation = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/span")).getText();  //получение значения из строки памяти
        Assert.assertTrue(calculation.equals("sin() =")); //проверка того, что введеная нами формула отображается в строке памяти
    }


}
