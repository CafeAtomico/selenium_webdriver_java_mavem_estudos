package com.example; 

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PrimeiroTeste {

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
 
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach 
    void setupTest() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach 
    void teardown() {
      
        if (driver != null) {
            driver.quit();
        }
    }

    @Test 
    void verificarTituloDaPaginaGoogle() {
      
        driver.get("https://www.google.com");

       
        String tituloAtual = driver.getTitle();

  
        String tituloEsperado = "Google";

     
        Assertions.assertEquals(tituloEsperado, tituloAtual, "O título da página não é o esperado!");

        System.out.println("Teste de título da página Google executado com sucesso!");
    }

    @Test 
    void verificarTituloDaPaginaSelenium() {
        driver.get("https://www.selenium.dev/");
        String tituloAtual = driver.getTitle();
        String tituloEsperado = "Selenium"; // O título real pode ser mais complexo, ajuste se necessário
        Assertions.assertTrue(tituloAtual.contains(tituloEsperado), "O título da página não contém 'Selenium'");
        System.out.println("Teste de título da página Selenium executado com sucesso!");
    }
}
