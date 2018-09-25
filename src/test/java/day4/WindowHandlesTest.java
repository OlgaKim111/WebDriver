package day4;

public class WindowHandlesTest extends BaseClass{


    @Test
    public void testName(){
        String url="http://the-internet.herokuapp.com/windows";
        String expectedText="New Window";
        String originalHandle=driver.getWindowHandle();


        navigateToUrl(url);
        clickOnTheLink();
        switchOverToLatestWindow(originalHandle);
        assertThatTextIsPresented(expectedText);
        printOutAllTheTitles();
        closeLastOpenWindow();

    }


}
