
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class tc_MintyApp {
 
                AndroidDriver driver;
                public static final String MC_FLAG = "No";
                public static final String MC_SERVER = "http://172.21.34.171:8090";
                public static final String MC_SERVER_USER = "hpmc_Automation@default.com";
                public static final String MC_SERVER_PASSWORD = "Airoli123";
                public static final String Device_Name = "Android";                         
                @Parameters("browser")
                @SuppressWarnings("unused")
                @BeforeClass
                public void setup () throws MalformedURLException{
                                System.out.println("*******Inside Setup******** " + new SimpleDateFormat("dd-MM-YYYY hh mm ss").format(new Date()));
                                DesiredCapabilities capabilities = new DesiredCapabilities();
                                capabilities.setCapability("browserName","");
                                capabilities.setCapability("platformName","Android");
                                capabilities.setCapability("deviceName", "Android");
                                capabilities.setCapability("automationName", "uiautomator2");
                                capabilities.setCapability("udid", "TA9330AGBL"); // Samsung Note II: 4df1b7b052888f8b || Moto G: ZY223X2LPR || R: TA9330AGBL
                                /*           Package Name and Launcher activity of app        */
                                capabilities.setCapability("appPackage", "com.financialhospital.admin.finh");
                                capabilities.setCapability("appActivity", "com.financialhospital.admin.finh.MainActivity");
                                capabilities.setCapability("autoGrantPermissions", "true");

                                if(MC_FLAG=="Yes"){
                                                capabilities.setCapability("userName", MC_SERVER_USER);
                                                capabilities.setCapability("password", MC_SERVER_PASSWORD);
                                                /* Connection String for HP Mobile Center  */
                                                driver = new AndroidDriver(new URL(MC_SERVER + "/wd/hub"), capabilities);                                                       
                                } else {
                                                driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                                }
                                System.out.println("*******Outside Setup******** "+new SimpleDateFormat("dd-MM-YYYY hh mm ss").format(new Date()));
                               
                }
                @Test
                public void testCalculator(){
                               
                                System.out.println("*******Inside test******** "+new SimpleDateFormat("dd-MM-YYYY hh mm ss").format(new Date()));
                                try {
                                                                Thread.sleep(5000);
                                                } catch (InterruptedException e) {
                                                                // TODO Auto-generated catch block
                                                                e.printStackTrace();
                                                }
                                
                                String pck_name = "com.financialhospital.admin.finh:id/";
                                /* Click on 'Calculator' */
                                String xpath_CalculatorButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.Button"; 
                                WebElement btn_Calculator=driver.findElement(By.id(pck_name+"calculator"));
                                //MobileElement btn_Calculator = (MobileElement) driver.findElement(By.xpath(xpath_CalculatorButton));
                                //WebElement btn_Calculator=driver.findElement(By.xpath(".///android.widget.Button"));
                                
                                		//findElement(By.xpath(xpath_CalculatorButton));
                                btn_Calculator.click();
                                try {
									Thread.sleep(3000);
								} catch (InterruptedException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
                                /* Click on 'SIP Calculator' */                     
                                WebElement btn_SIPCalculator=driver.findElement(By.xpath("//android.widget.TextView[@text='SIP Calculator']"));
                                btn_SIPCalculator.click();
                                try {
									Thread.sleep(3000);
								} catch (InterruptedException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
                                
                                /* Click on '+' */
                                WebElement btn_plusMonthlyContribution=driver.findElement(By.id(pck_name+"increase"));
                                btn_plusMonthlyContribution.click();
                                btn_plusMonthlyContribution.click();
                                btn_plusMonthlyContribution.click();
                                WebElement btn_plusTimeLeft=driver.findElement(By.id(pck_name+"increase1"));
                                btn_plusTimeLeft.click();
                                btn_plusTimeLeft.click();
                                btn_plusTimeLeft.click();
                                /* RoR */
                                WebElement btn_plusRoR=driver.findElement(By.id(pck_name+"increase3"));
                                btn_plusRoR.click();
                                btn_plusRoR.click();
                                btn_plusRoR.click();
                               
                                /*SWIPE */
                                new TouchAction(driver).press(120, 900).waitAction(1000).moveTo(120,520).release().perform();
                                
                                WebElement btn_Calculate=driver.findElement(By.id(pck_name+"calculate"));
                                btn_Calculate.click();
                               
                                try {
									Thread.sleep(3000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
                                /* Validate Output */
                                WebElement btn_output1=driver.findElement(By.id(pck_name+"text1"));
                                String text1 = btn_output1.getText();
                                System.out.println( "Amount Invested: " + text1.toString());
 
                                WebElement btn_output2=driver.findElement(By.id(pck_name+"text3"));
                                String text2 = btn_output2.getText();
                                System.out.println( "Amount You Will Get: " + text2.toString());
 
                                WebElement btn_output3=driver.findElement(By.id(pck_name+"text5"));
                                String text3 = btn_output3.getText();
                                System.out.println( "My Total Gain: " + text3.toString());
                               
         try {
                                Thread.sleep(5000);
                } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                }
         System.out.println("*******outside test******** ");
                }
                @AfterClass
                public void teardown(){
                                //close the app
                                System.out.println("*******Inside teardown******** ");
                                driver.quit();                     
                                System.out.println("*******outside teardown******** ");
                }             
               
}