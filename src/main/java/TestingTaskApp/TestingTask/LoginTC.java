package TestingTaskApp.TestingTask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginTC {
	
	
	public AndroidDriver driver;

	public LoginTC(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	

	SoftAssert softassert = new SoftAssert();

	@AndroidFindBy(id = "com.example.testingtask:id/ed_email")
	private WebElement Email;

	@AndroidFindBy(id = "com.example.testingtask:id/ed_password")
	private WebElement password;
	
	@AndroidFindBy(id = "com.example.testingtask:id/btn_login")
	private WebElement signIn;
	
	@AndroidFindBy(id = "com.example.testingtask:id/create_account")
	private WebElement CreateAccount;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
	private WebElement Success;

	

	public void EnterEmail(String email) {

		Email.sendKeys(email);
	}

	public void EnterPassword(String pass) {

		password.sendKeys(pass);
	}
	
	public void ClickonSignIn() throws InterruptedException {
		signIn.click();
		Thread.sleep(2000);
	}
	
	public void ClickOnCreateAccount()  {
		CreateAccount.click();
		
	
	}
	
	public void afterLogin() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(Success.getText());
		String successText = Success.getText();
		softassert.assertEquals(successText, "GOOD JOB SUCCESS!!");
	}


}
