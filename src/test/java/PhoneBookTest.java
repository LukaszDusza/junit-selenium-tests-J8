import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;


public class PhoneBookTest {

    private WebDriver wd;
    private String url;
    private String titlePage;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }

    @Before
    public void setup() throws InterruptedException {
        url = "http://localhost:8080/";
        wd = new ChromeDriver();
        wd.get(url);
        wd.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void checkTitlePage() {
        titlePage = "PhoneApp";
        assertEquals(titlePage, wd.getTitle());
    }

    @Test
    public void getContent() {

        String text = wd.findElement(By.tagName("h3")).getText();
        assertEquals("Welcome to My Phone App!", text);
      //  System.out.println(text);
    }

    @Test
    public void getLink(){
        wd.findElement(By.partialLinkText("Swagger Documentation")).click();
        assertEquals("http://localhost:8080/swagger-ui.html", wd.getCurrentUrl());
    }

    @Test
    public void routeLink() {
        wd.findElement(By.xpath("//a[@href='swagger-ui.html']")).click();
    }

    @Test
    public void getPageResource() {
        String text = wd.getPageSource();
        System.out.println(text);
    }

    @Test
    public void getInputs() throws InterruptedException {
        wd.findElement(By.xpath("//input[@name='email']")).clear();
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("jacek.mail@gmail.com");
        Thread.sleep(1000);

        wd.findElement(By.xpath("//input[@name='email']")).clear();
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("lukasz.mail@gmail.com");
        Thread.sleep(1000);

        wd.findElement(By.xpath("//input[@name='email']")).clear();
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("Kunegunda.mail@gmail.com");
        Thread.sleep(1000);

        wd.findElement(By.tagName("button")).click();

        String paragraph = wd.findElement(By.xpath("//p[@id='paragraph']")).getText();

        assertEquals("Kunegunda.mail@gmail.com", paragraph);
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        wd.close();
    }


}

