import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CompareSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
            Thread.sleep(5000);

            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

            System.out.println("Đăng nhập thành công");
            Thread.sleep(5000);

            //truy cập vào trang admin
            driver.findElement(By.xpath("//span[text()=\"Admin\"]")).click();
            Thread.sleep(5000);

            //Nhập dữ liệu vào username và search
            WebElement username = driver.findElement(By.xpath("//label[text()=\"Username\"]/../following-sibling::div/input"));
            username.sendKeys("Admin");

            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
            System.out.println("Đã ấn tìm kiếm");
            Thread.sleep(3000);

            //lấy danh sách
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]/div")); //=> [{username, userrole}]

            //đặt cờ
            boolean userFound = false; //không tìm thấy
            //tạo vòng lặp lấy dữ liệu từng dòng
            for(WebElement row : rows){
                String userFind = row.findElement(By.xpath(".//div[@role=\"cell\"][2]")).getText();
                if(userFind.equalsIgnoreCase("Admin")){
                    userFound = true;
                    break; // dừng vòng lặp
                }
            }
            if (userFound){
                System.out.println("tìm thấy user");
            }else {
                System.out.println("không tìm thấy");
            }
        } catch (Exception e) {

        }finally {
            driver.quit();
        }
    }
}
