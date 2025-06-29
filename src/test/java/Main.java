import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        //tự động tải chrome driver
        WebDriverManager.chromedriver().setup();

        //khởi tạo trình duyệt chrome
        WebDriver driver = new ChromeDriver();

        //thiết lập ChromeOption để dùng profile thật -> mở chrome search chrome://version/
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=/Users/thanhtrinh/Library/Application Support/Google/Chrome/Default");
//        options.addArguments("--profile-directory=Default");

        //mở fullscreen
        driver.manage().window().maximize();
        //truy cập vào trang google
        driver.get("https://www.google.com/");
        //tìm tới ô tìm kiếm của google
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
        //nhập dữ liệu vào ô tìm kiếm của google
        searchBox.sendKeys("Doraemon");
        //nhấn enter tìm kiếm
//        searchBox.submit();
        //đóng trình duyệt
//        driver.quit();

        //xpath: "//tagname[@attribute="value"]
        // "//": tìm kiếm ở mọi nơi có trong cây html
        //tagname: tên thẻ html(div, input, span, p, h1, h2, h3, img,..) k bao gồm style và script
        //attribute: điều kiện lọc (type, id, class,....)

        //contains
        //xpath: //tagname[contains(@attribute, value)]
        //ví dụ: //h1[contains(@class, "text-2xl")]
        //ví dụ: //h1[text()="XPath Demo Page"] (dẫn tuyệt đối/khớp toàn bộ nội dung)
        // -> //h1[contains(@text()="XPath")] (dẫn tương đối/khớp 1 phần nội dung)

        //text()
        //xpath: //tagname[text()="value"]
        //ví dụ: //button[text()="Login"]

        //xpath: (xpath cơ bản)[vị trí] vị trí: vị trí của phần tử bắt đầu từ 1, 2, 3....
        //ví dụ: (//li[text()="Item"])[3]

        //following-sibling, preceding-sibling
        //following-sibling: dùng để lấy thẻ đứng sau
        //ví dụ1: //label/following-sibling::input[@name="username"]
        //ví dụ2: (//label/following-sibling::input)[1]

        //ví dụ: //input/preceding-sibling::label

        //and && or
        //and: thoả mãn hết tất cả các điều kiện đúng
        //ví dụ: //input[@type="text" and @name="username"]
        //or: thỏa mãn 1 trong những điều kiện đúng
        //ví dụ: //input[@type="text" or @name="username"]

        //normalize-space(): loại bỏ khoảng trắng đầu và cuối để so sánh
        //ví dụ: //button[normalize-space(@text="Login")]
    }
}