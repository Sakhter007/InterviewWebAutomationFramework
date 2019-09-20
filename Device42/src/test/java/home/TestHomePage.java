package home;

import common.CommonAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends CommonAPI {

    //Requirement for Test in Device42
    //Automate the following steps:
    //1.Create a building
    //2.Create a Room
    //3.Create a Rack
    //The rack should be in the room that will be created and room will be in the building
    //it is running through .xml file

        @Test
        public void testLoginPage (){
        driver.findElement(By.id("id_username")).sendKeys("admin");
        driver.findElement(By.id("id_password")).sendKeys("adm!nd42");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Test
    public void testCreateABuilding() throws InterruptedException {
        // Login with valid used and password
        driver.findElement(By.id("id_username")).sendKeys("admin");
        driver.findElement(By.id("id_password")).sendKeys("adm!nd42");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // click on buildings
        driver.findElement(By.cssSelector("#bldgtable\\ class\\=\\'dashtable > tbody > tr:nth-child(1) > td:nth-child(1)")).click();
        Thread.sleep(4000);
        // click on add building
        driver.findElement(By.xpath("//*[@id=\"content-main\"]/ul/li/a")).click();
        //Enter Building Name
        driver.findElement(By.cssSelector("#id_name")).sendKeys("Device42");
        // Enter Room Number
        driver.findElement(By.cssSelector("#id_room_set-0-name")).sendKeys("Room01");
        // Save
        driver.findElement(By.cssSelector("#building_form > div:nth-child(2) > div.submit-row > input.default")).click();
        Thread.sleep(4000);

        String actualResult=driver.findElement(By.xpath("//a[text()='Device42']")).getText();
        Assert.assertEquals(actualResult,"Device42");

    }



}
