import func.Call;
import func.Reader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ApiTest {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Compare Endpoint from file1 and file2")
    @Test(dataProvider = "getData")
    public void ApiTest(String url1, String url2) {
        Call apiCall = new Call(url1, url2);
        try {
            Assert.assertTrue(apiCall.isEqual(), "URIs Response Not Equal");
        }
        catch (AssertionError e){
            e.setStackTrace(new StackTraceElement[0]);
            throw e;
        }
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        Reader fReader = new Reader();
        return fReader.fileData();
    }

}
