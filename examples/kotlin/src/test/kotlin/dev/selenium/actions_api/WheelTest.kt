package dev.selenium.getting_started

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScrollTest {
    private lateinit var driver: WebDriver

    @BeforeEach
    fun setupBrowser() {
        driver = ChromeDriver()
    }

    @AfterEach
    fun cleanupBrowser() {
        driver.quit()
    }

    @Test
    fun shouldScrollToElement() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        WebElement iframe = driver.findElement(By.tagName("iframe"));

        Assertions.assertFalse(inViewport(iframe));

        new Actions(driver).scrollToElement(iframe).perform();

        Assertions.assertTrue(inViewport(iframe));
    }

    @Test
    fun shouldScrollFromElementByGivenAmount() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(iframe);

        new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 200).perform();

        driver.switchTo().frame(iframe);
        WebElement checkbox = driver.findElement(By.name("scroll_checkbox"));
        Assertions.assertTrue(inViewport(checkbox));
    }

    @Test
    fun shouldScrollFromElementByGivenAmountWithOffset() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        WebElement footer = driver.findElement(By.tagName("footer"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(footer, 0, -50);

        new Actions(driver).scrollFromOrigin(scrollOrigin,0, 200).perform();

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement checkbox = driver.findElement(By.name("scroll_checkbox"));
        Assertions.assertTrue(inViewport(checkbox));
    }

    @Test
    fun shouldScrollFromViewportByGivenAmount() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        WebElement footer = driver.findElement(By.tagName("footer"));
        int deltaY = footer.getRect().y;

        new Actions(driver).scrollByAmount(0, deltaY).perform();

        Assertions.assertTrue(inViewport(footer));
    }

    @Test
    fun shouldScrollFromViewportByGivenAmountFromOrigin() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame.html");
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);

        new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 200).perform();

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement checkbox = driver.findElement(By.name("scroll_checkbox"));
        Assertions.assertTrue(inViewport(checkbox));
    }

    fun inViewport(WebElement element) {
        String script =
                "for(var e=arguments[0],f=e.offsetTop,t=e.offsetLeft,o=e.offsetWidth,n=e.offsetHeight;\n"
                        + "e.offsetParent;)f+=(e=e.offsetParent).offsetTop,t+=e.offsetLeft;\n"
                        + "return f<window.pageYOffset+window.innerHeight&&t<window.pageXOffset+window.innerWidth&&f+n>\n"
                        + "window.pageYOffset&&t+o>window.pageXOffset";

        return (boolean) ((JavascriptExecutor) driver).executeScript(script, element);
    }
}