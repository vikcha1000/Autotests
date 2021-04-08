package com.google;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverSettings {

    public ChromeDriver driver; //инициализация переменной driver

    @Before   //аннотация действий до начала теста. Необходим, при повторении кода в тестах
    public void setUp() {   //метод setUp
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Виктория.DESKTOP-CU68ON8\\Desktop\\chromedriver_win32\\chromedriver.exe"); //путь к файлу ChromeDriver
        driver = new ChromeDriver(); //инициализация перменной driver
        driver.get("https://www.google.com/"); //команда открытия сайта
        driver.findElement(By.name("q")).sendKeys("Калькулятор");  //команда поиска поля ввода и ввод в него значения "калькулятор"
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click(); //команда поиска кнопки "поиск в Google" и нажатия на нее
        driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div/div")).click();

    }

    @After   //аннотация действий после теста. Необходим, при повторении кода в тестах
    public void close(){  //метод close

        driver.quit();//команда закрытия браузера
    }


}
