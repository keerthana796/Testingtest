package TestingTaskApp.TestingTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.Test;

public class Testingtaskmain extends BaseClass {

	public LoginTC login;
	public CreateAccountTC account;
	public Properties prop;
	public FileInputStream fis;



	@Test(priority =1)
	public void createaccount() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		login = new LoginTC(driver);
		login.ClickOnCreateAccount();
		account = new CreateAccountTC(driver);

		prop = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//Resources//data.properties");

		prop.load(fis);
		account.EnterName(prop.getProperty("name"));
		account.Enteremail(prop.getProperty("emailid"));
		account.ChooseOcupation();
		account.EnterAge(prop.getProperty("age"));
		account.EnterMobile(prop.getProperty("mobile"));
		account.Enteraddress(prop.getProperty("address"));
		account.Enterpassword(prop.getProperty("pwd"));
		account.ClickonRegister();

	}
	
	@Test(priority = 2)
	public void login() throws InterruptedException, IOException {

		login = new LoginTC(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		prop = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//Resources//data.properties");

		prop.load(fis);

		login.EnterEmail(prop.getProperty("email"));
		login.EnterPassword(prop.getProperty("password"));
		login.ClickonSignIn();
		login.afterLogin();

	}

}
