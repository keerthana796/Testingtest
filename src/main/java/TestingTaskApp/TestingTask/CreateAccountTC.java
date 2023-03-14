package TestingTaskApp.TestingTask;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateAccountTC {

	public AndroidDriver driver;

	public CreateAccountTC(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.example.testingtask:id/fullName_field")
	private WebElement Name;

	@AndroidFindBy(id = "com.example.testingtask:id/ed_email")
	private WebElement emailid;

	@AndroidFindBy(id = "com.example.testingtask:id/spinnerOccupation")
	private WebElement selectOcuupation;

	@AndroidFindBy(id = "com.example.testingtask:id/editTextAge")
	private WebElement Age;

	@AndroidFindBy(id = "com.example.testingtask:id/mobile_field")
	private WebElement mobileNumber;

	@AndroidFindBy(id = "com.example.testingtask:id/addressField")
	private WebElement Address;

	@AndroidFindBy(id = "com.example.testingtask:id/password_field")
	private WebElement Password;

	@AndroidFindBy(id = "com.example.testingtask:id/btn_register")
	private WebElement register;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.EditText[3]")
	private WebElement options;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
	private WebElement toastmesssage;

	public void EnterName(String name) throws InterruptedException {
		Thread.sleep(2000);
		Name.sendKeys(name);

	}

	public void Enteremail(String email) {
		emailid.sendKeys(email);
		

	}

	public void ChooseOcupation() throws InterruptedException {

		selectOcuupation.click();
		options.click();
	}

	public void EnterAge(String age) {
		driver.pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
		Age.sendKeys(age);

	}

	public void EnterMobile(String mobileNumb) {
		mobileNumber.sendKeys(mobileNumb);

	}

	public void Enteraddress(String address) {
		Address.sendKeys(address);

	}

	public void Enterpassword(String password) {
		Password.sendKeys(password);

	}

	public void ClickonRegister() throws InterruptedException {
		register.click();
		Thread.sleep(2000);
		System.out.println(toastmesssage.getText());
		
		if(toastmesssage.getText().contains("timeout")){
				driver.navigate().back();
				
	    }
		if(toastmesssage.getText().contains("Registration failed!")){
			driver.navigate().back();
			
        }
			
		}
		
	}

	
	

