package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

public class Commands extends RunCucumber {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element) {
        System.out.println("##############################################");
        try {
            System.out.println("Vai clicar no elemento: " + element);
            waitElementBeVisible(element, 5);
            getDriver().findElement(element).click();
            System.out.println("Clicou no elemento: " + element);
        } catch (Exception error) {
            System.out.println("************* Aconteceu um erro ao tentar clicar no elemento: " + element);
            new Exception(error);
        }
        System.out.println("##############################################");
    }

    public static void fillField(By element, String value) {
        System.out.println("##############################################");
        try {
            System.out.println("Vai preencher o campo: " + element);
            waitElementBeClickable(element, 5);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("Preencheu o campo: " + element);
        } catch (Exception error) {
            System.out.println("************* Aconteceu um erro ao tentar preencher o campo: " + element);
            new Exception(error);
        }
        System.out.println("##############################################");
    }

    public static void checkMessage(By element, String expectedMessage) {
        System.out.println("##############################################");
        System.out.println("Vai validar a mensagem: " + expectedMessage);

        WebDriverWait wait = new WebDriverWait(getDriver(), 5); // Aumente um pouco o tempo para o CI
        // Espera o elemento estar visível E conter o texto esperado
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element, expectedMessage));

        String actualMessage = getDriver().findElement(element).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        System.out.println("Mensagem validada: " + expectedMessage);
        System.out.println("##############################################");
    }

}
