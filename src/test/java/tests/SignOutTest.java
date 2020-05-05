package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignOutTest extends BaseTest {

    @Test
    public void signOutTest(){
        Assert.assertEquals(userAccountPage.getAccountName(), "Veronika Richter");
        userAccountPage.clickLogout();
        Assert.assertTrue(userAccountPage.userIsSignedOut());
    }
}