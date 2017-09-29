import com.epam.lab.excelutils.CsvParser;
import com.epam.lab.excelutils.ExcelUtils;
import com.epam.lab.page.GmailLoginPage;
import com.epam.lab.singleton.SingletonDriver;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.epam.lab.excelutils.CsvParser.listOfEmails;
import static com.epam.lab.excelutils.CsvParser.listOfPasswords;
@Listeners(com.epam.lab.reporter.TestNGListener.class)
public class TestGmail {
    private String sTestCaseName;
    private int iTestCaseRow;
    private CsvParser csvParser = new CsvParser();

    @Test(dataProvider = "csv",threadPoolSize = 1)
    public void test(String UserName, String Password) throws InterruptedException {
        GmailLoginPage gmailLoginPage = new GmailLoginPage();
        gmailLoginPage.typeLoginAndSubmit(UserName);
        gmailLoginPage.typePasswordAndSubmit(Password);
        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
    }
    @DataProvider(parallel = true)
    public Object[][] Authentication() throws Exception{
        ExcelUtils.setExcelFile("./src/main/resources/TestData.xlsx","Sheet1");
        sTestCaseName = this.toString();
        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
        Object[][] testObjArray = ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx","Sheet1",iTestCaseRow);
        return (testObjArray);
    }
    @DataProvider(name = "csv",parallel = true)
    public Object[][] getDataFromCsv() {
        csvParser.parse();
        Object data[][] = new Object[listOfEmails.size()][2];
        for (int i = 0; i < listOfEmails.size(); i++) {
            data[i][0] = listOfEmails.get(i);
            data[i][1] = listOfPasswords.get(i);
        }
        return data;
    }
    @AfterMethod
    public void closeDriver(){
        SingletonDriver.quit();
    }
}
