import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {
    public static void main(String[] args) {
        //truy cập vào trang web
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try{
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(5000);

            //bắt locator
//            WebElement username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
            WebElement username = driver.findElement(By.id("user-name"));
//            WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
            WebElement password = driver.findElement(By.id("password"));
//            WebElement login = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
            WebElement login = driver.findElement(By.id("login-button"));

            //nhập liệu
            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            login.click();

            Thread.sleep(10000);

            System.out.println("Đăng nhập thành công");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }finally {
            driver.quit();
        }
    }
}
