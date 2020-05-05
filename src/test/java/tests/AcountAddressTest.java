package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddressPage;


public class AcountAddressTest extends BaseTest {

    private AddressPage addressPage;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        addressPage = new AddressPage(driver);
        softAssert = new SoftAssert();
    }


    @Test
    public void addNewAddressAndDeleteTest() {
        userAccountPage.clickMyAddress();
        addressPage.clickAddNewAddressButton();
        addressPage.enterAddressData("Veronika", "Richter", "TMSCompany", "ADDRESS1", "ADDRESS2",
                "LA", "California", "12345", "United States", "7546468735",
                "5468452138746515", "This address to be used as secondary.", "Secondary Address");
        addressPage.clickSubmitButton();
        softAssert.assertTrue(addressPage.isNameOnPage("Veronika"), "Name not found.");
        softAssert.assertTrue(addressPage.isNameOnPage("Richter"), "Surename not found.");
        softAssert.assertTrue(addressPage.isCompanyNameOnPage("TMSCompany"),  "Company not found.");
        softAssert.assertTrue(addressPage.isFirstAddressOnPage("ADDRESS1"), "First address not found.");
        softAssert.assertTrue(addressPage.isSecondAddressOnPage("ADDRESS2"), "Second  address not found.");
        softAssert.assertTrue(addressPage.isCityOnPage("LA"), "City not found.");
        softAssert.assertTrue(addressPage.isStateOnPage("California"), "State not found.");
        softAssert.assertTrue(addressPage.isPostalCodeOnPage("12345"), "Postal Code not found.");
        softAssert.assertTrue(addressPage.isCountryOnPage("United States"), "Country not found.");
        softAssert.assertEquals(addressPage.getAddressPhone(), "7546468735", "Home phone not found.");
        softAssert.assertEquals(addressPage.getAddressPhoneMobile(), "5468452138746515", "Mobile phone not found.");
        addressPage.deleteAddressBuTitle("Secondary Address");
        softAssert.assertFalse(addressPage.isAddressOnPage("Secondary Address"), "Address is not created");
        softAssert.assertAll();

    }

}
