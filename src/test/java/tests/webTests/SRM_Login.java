package tests.webTests;

import omi_ri.utilities.baseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertTrue;


public class SRM_Login extends baseTest {
	

	
	 @BeforeTest
	    public void beforeMethod() throws MalformedURLException, InterruptedException {
	        try {


				setupData(APIWebData,"Login");
	            initialiseWeb();

	        } catch (Exception e) {
	            System.out.println("Before Test Error : " + e.getMessage());
	        }
	    }

@Test(dataProvider = "readTestData", groups = {"Login"})
         public void srmLogin(Object ...data) throws Exception{

		 buildScenarioData(data);

	        try {

				System.out.println("The data is " +testDataMap.size());
				if(testDataMap.size()>0) {

					//Launch
					setupWebDriver("Chrome");

					//user Srm Dev Env
					utilWeb.navigate("");
					//Login

					//srmAPIAppWeb.APIPortal_Login(utilWeb.getWebdriver(), "", "", test);

					if (testDataMap.get("UserName").equals("KGOTLELE")){
						System.out.println("USERNAME CORRECT");
					}else{
						assertTrue(false);
					}

					if (testDataMap.get("Password").equals("Treaty#89")){
						System.out.println("PASSWORD CORRECT");
					}else{
						assertTrue(false);
					}

                     //Logout
					//srmAPIAppWeb.APIPortal_LoginOut(utilWeb.getWebdriver(),test);
					utilWeb.getWebdriver().quit();
				}
	        } catch (Exception e) {
	        	System.out.println("The code is  not working");
	            //repo.ExtentLogInfoFail("Failed to Complete " + this.getClass().getSimpleName() + " Test Exception : " + e.getMessage(), test);
				assertTrue(false);

	        }
	    }
}
