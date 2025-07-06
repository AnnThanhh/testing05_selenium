import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareInfo {
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

            //truy cập vào trang my info
            driver.findElement(By.xpath("//span[text()=\"My Info\"]")).click();
            Thread.sleep(5000);

            //lấy giá trị firstname và lastname trên my info
            WebElement firstName = driver.findElement(By.name("firstName"));
            WebElement lastNAme = driver.findElement(By.name("lastName"));

            String firstNameValue = firstName.getAttribute("value").trim();
            String lastNameValue = lastNAme.getAttribute("value").trim();

            String fullNameValue = firstNameValue + " " + lastNameValue; // cu te

            // lấy xpath bằng classname => by.classname & by.cssSelector
            WebElement fullNameDisplay = driver.findElement(By.cssSelector(".oxd-userdropdown-name"));
            String fullNameValueDisplay = fullNameDisplay.getText().trim();

            //So sánh - .equalIgnoreCase -> so sánh giá trị bất kể là viết hoa hay viết thường
            if(fullNameValue.equalsIgnoreCase(fullNameValueDisplay)){
                System.out.println("Kết quả trùng khớp");
            }else {
                System.out.println("Kết qủa không trùng khớp");
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
