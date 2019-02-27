import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;


public class SeleniumTest {
    private WebDriver wd;
    private String url;
    private String titlePage;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }

    @Before
    public void setup() throws InterruptedException {
        url = "http://example.com";
        titlePage = "Example Domain";
        wd = new ChromeDriver();
        wd.get(url);
        wd.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void checkTitlePage() {
        assertEquals(titlePage, wd.getTitle());
    }

    @Test
    public void getContent() {
        String text = wd.findElement(By.tagName("p")).getText();
        System.out.println(text);
    }

    @Test
    public void getLink(){
        wd.findElement(By.partialLinkText("More information...")).click();
        assertEquals("https://www.iana.org/domains/reserved", wd.getCurrentUrl());
    }

    @Test
    public void routeLink() {
        wd.findElement(By.xpath("//a[@href='http://www.iana.org/domains/example']")).click();
    }

    @Test
    public void getPageResource() {
        String text = wd.getPageSource();
        System.out.println(text);
    }

    @Test
    public void getInputs() {
        wd.get("https://www.w3schools.com/html/html_forms.asp");
        wd.findElement(By.xpath("//input[@name='firstname']")).clear();
        wd.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Lukasz Akademia Kodu");
    }


    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        wd.close();
    }
}
