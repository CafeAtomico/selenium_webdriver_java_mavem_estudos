package com.example; // Ajuste para o seu pacote

import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions; // Import para asserções JUnit 5
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Para configurar opções do Chrome

public class PrimeiroTeste {

    private WebDriver driver; // Declara a variável do WebDriver

    @BeforeAll // Executa UMA VEZ antes de TODOS os testes da classe
    static void setupClass() {
        // Configura o WebDriver para o Chrome usando WebDriverManager
        // Isso baixa e configura o chromedriver automaticamente
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach // Executa ANTES de CADA método @Test
    void setupTest() {
        // Configurações opcionais para o Chrome (ex: rodar sem interface gráfica -
        // headless)
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        // options.addArguments("--disable-gpu"); // Necessário em alguns sistemas para
        // headless
        // options.addArguments("--window-size=1920,1080"); // Define tamanho da janela
        // em headless

        // Inicializa o WebDriver para Chrome a cada teste
        // Se usou ChromeOptions, passe como argumento: new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximiza a janela do navegador
    }

    @AfterEach // Executa DEPOIS de CADA método @Test
    void teardown() {
        // Fecha o navegador e encerra a sessão do WebDriver APÓS cada teste
        if (driver != null) {
            driver.quit();
        }
    }

    @Test // Marca este método como um caso de teste
    void verificarTituloDaPaginaGoogle() {
        // 1. Navega até o site
        driver.get("https://www.google.com");

        // 2. Obtém o título da página
        String tituloAtual = driver.getTitle();

        // 3. Define o título esperado
        String tituloEsperado = "Google";

        // 4. Verifica se o título atual é igual ao esperado usando JUnit Assertions
        Assertions.assertEquals(tituloEsperado, tituloAtual, "O título da página não é o esperado!");

        System.out.println("Teste de título da página Google executado com sucesso!");
    }

    @Test // Outro caso de teste
    void verificarTituloDaPaginaSelenium() {
        driver.get("https://www.selenium.dev/");
        String tituloAtual = driver.getTitle();
        String tituloEsperado = "Selenium"; // O título real pode ser mais complexo, ajuste se necessário
        Assertions.assertTrue(tituloAtual.contains(tituloEsperado), "O título da página não contém 'Selenium'");
        System.out.println("Teste de título da página Selenium executado com sucesso!");
    }
}