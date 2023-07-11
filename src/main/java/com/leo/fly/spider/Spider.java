package com.leo.fly.spider;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Spider {
    private WebDriver driver;
    private void init(){
        System.setProperty("webdriver.chrome.driver", "D:\\sofa\\开发\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(option);
    }
    public Spider(){
        init();
    }



    public WebDriver getDriver(){
        return this.driver;
    }


}
