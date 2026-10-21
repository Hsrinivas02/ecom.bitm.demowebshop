package objRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //PageFactory->Selenium class that helps initialize web elements in a Page Object class.
        //driver tells Selenium which browser session to use.
        //this refers to the current RegisterPage object.
        //Selenium examines the fields in that object annotated with @FindBy and initializes them so you can use them in your test methods.
    }

    // Gender
    @FindBy(id = "gender-male")
    public WebElement maleGender;

    @FindBy(id = "gender-female")
    public WebElement femaleGender;

    // First Name
    @FindBy(id = "FirstName")
    public WebElement firstName;

    // Last Name
    @FindBy(id = "LastName")
    public WebElement lastName;

    // Email
    @FindBy(id = "Email")
    public WebElement email;

    // Password
    @FindBy(id = "Password")
    public WebElement password;

    // Confirm Password
    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    // Register button
    @FindBy(id = "register-button")
    public WebElement registerBtn;

    // Registration result
    @FindBy(css = ".result")
    public List<WebElement> resultMessages; //here it is class="result",
    // it shows after successfully registration i.e shows completed

    // Register link
    @FindBy(className = "ico-register")
    public WebElement registerLink;

    // Registration validation messages
    @FindBy(css = ".validation-summary-errors, .field-validation-error")
    public List<WebElement> validationMessages;
    //.validation-summary-errors-> gets whn already registered user registers
    //field-validation-error-> clicking for empty username text field, etc

    // Select gender
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            maleGender.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            femaleGender.click();
        }
    }

    // Enter first name
    public void enterFirstName(String value) {
        firstName.clear();
        firstName.sendKeys(value);
    }

    // Enter last name
    public void enterLastName(String value) {
        lastName.clear();
        lastName.sendKeys(value);
    }

    // Enter email
    public void enterEmail(String value) {
        email.clear();
        email.sendKeys(value);
    }

    // Enter password
    public void enterPassword(String value) {
        password.clear();
        password.sendKeys(value);
    }

    // Confirm password
    public void enterConfirmPassword(String value) {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    // Click Register
    public void clickRegister() throws InterruptedException {
        registerBtn.click();
        Thread.sleep(2000);
    }

    // Complete registration form
    public void register(String gender, String first, String last, String emailValue, String pwd, String confirmPwd) throws InterruptedException {
        selectGender(gender);
        enterFirstName(first);
        enterLastName(last);
        enterEmail(emailValue);
        enterPassword(pwd);
        enterConfirmPassword(confirmPwd);
        clickRegister();
    }

    // Check whether validation is displayed
    public boolean isValidationDisplayed() {
        for (WebElement message : validationMessages) {
            if (message.isDisplayed() && !message.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Check whether registration was successful
    public boolean isRegistrationSuccessful() {
        for (WebElement result : resultMessages) {
            if (result.isDisplayed() && result.getText().toLowerCase().contains("completed")) {
                return true;
            }
        }
        return false;
    }
}