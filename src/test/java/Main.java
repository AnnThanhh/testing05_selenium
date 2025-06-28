import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        //tự động tải chrome driver
        WebDriverManager.chromedriver().setup();

        //khởi tạo trình duyệt chrome
        WebDriver driver = new ChromeDriver();

        //mở fullscreen
        driver.manage().window().maximize();
        //truy cập vào trang google
        driver.get("https://www.google.com/");
        //tìm tới ô tìm kiếm của google
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
        //nhập dữ liệu vào ô tìm kiếm của google
        searchBox.sendKeys("Doraemon");
        //nhấn enter tìm kiếm
        searchBox.submit();
        //đóng trình duyệt
//        driver.quit();

        //xpath: "//tagname[@attribute="value"]
        // "//": tìm kiếm ở mọi nơi có trong cây html
        //tagname: tên thẻ html(div, input, span, p, h1, h2, h3, img,..) k bao gồm style và script
        //attribute: điều kiện lọc (type, id, class,....)
    }
}