import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class P2P {



   //Ui елементи для переказу з карти на карту

    By fromCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By toCard = By.xpath("//input[@data-qa-node='numberreceiver']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By currencyButton = By.xpath("//button[@data-qa-node='currency']");
    By currency = By.xpath("//button[@data-qa-value='USD']");
    By submitButton = By.xpath("//div[@class='sc-fjdhpX fMXqZt']");
    By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By firstNameReceiver = By.xpath("//input[@data-qa-node='firstNamereceiver']");
    By lastNameReceiver = By.xpath("//input[@data-qa-node='lastNamereceiver']");
    By comment = By.xpath("//textarea[@data-qa-node='comment']");
    By commentSelect = By.xpath("//span[@data-qa-node='toggle-comment']");

    //Ui елементи корзини
    By payerCard = By.xpath("//span[@data-qa-node='payer-card']");
    By receiverCard = By.xpath("//span[@data-qa-node='receiver-card']");
    By payerAmount = By.xpath("//div[@data-qa-node='payer-amount']");
    By receiverAmount = By.xpath("//div[@data-qa-node='receiver-amount']");
    By payerCommission = By.xpath("//div[@data-qa-node='payer-currency']");
    By total = By.xpath("//div[@data-qa-node='total']");
    By recieverCommission = By.xpath("//div[@data-qa-node='receiver-currency']");
    By receiverName = By.xpath("//div[@data-qa-node='receiver-name']");
    By coment = By.xpath("//div[@data-qa-node='comment']");





    @Test

  public void payToPay(){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("https://next.privat24.ua/money-transfer/card");
     driver.findElement(fromCard).sendKeys("4093206288191961");
     driver.findElement(expiredDate).sendKeys("0622");
     driver.findElement(cvv).sendKeys("494");
     driver.findElement(firstName).sendKeys("Ronald");
     driver.findElement(lastName).sendKeys("Clark");
     driver.findElement(toCard).sendKeys("4567739561253907");
     driver.findElement(firstNameReceiver).sendKeys("Ruth");
     driver.findElement(lastNameReceiver).sendKeys("Montavio");
     driver.findElement(amount).sendKeys("10");
     driver.findElement(currencyButton).click();
    driver.findElement(currency).click();
    driver.findElement(commentSelect).click();
    driver.findElement(comment).sendKeys("коментар");
    driver.findElement(submitButton).submit();
//#1

      System.out.println("value = " + driver.findElement(payerCard).getText());
      Assert.assertEquals("4093 2062 8819 1961",driver.findElement(payerCard).getText());
//#2
      System.out.println("value=" + driver.findElement(receiverCard).getText());
      Assert.assertEquals("4567 7395 6125 3907", driver.findElement(receiverCard).getText());

//#3
      System.out.println("value=" + driver.findElement(payerAmount).getText());
      Assert.assertEquals("10 USD", driver.findElement(payerAmount).getText());
//#4
      System.out.println("value=" + driver.findElement(receiverAmount).getText());
      Assert.assertEquals("10 USD", driver.findElement(receiverAmount).getText());
//#5
      System.out.println("value=" + driver.findElement(payerCommission).getText());
      Assert.assertEquals("3.15 USD", driver.findElement(payerCommission).getText());
//#6
      System.out.println("value=" + driver.findElement(total).getText());
       Assert.assertEquals("Разом до списання 13.15 USD", driver.findElement(total).getText());
//#7
       System.out.println("value=" + driver.findElement(recieverCommission).getText());
        Assert.assertEquals("0 USD", driver.findElement(recieverCommission).getText());

//#8
      System.out.println("value=" + driver.findElement(receiverName).getText());
      Assert.assertEquals("R*** M*******", driver.findElement(receiverName).getText());
//#9
       System.out.println("value=" + driver.findElement(comment).getText());
       Assert.assertEquals("коментар", driver.findElement(comment).getText());

  }


}
