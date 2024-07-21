import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "NegativeLoginData")
    public static Object [][] getDataFromDataProvider (){
        return new Object[][]{
                {"involedemail@gmail.com"," 1238961"},
                {"demo@class.com" ,"invalid"},
                {"",""},
                {"invalidemail@gmail.com","valaid"},
        };

    }
}
