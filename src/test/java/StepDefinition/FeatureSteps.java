package StepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import keyWord.engineClass;

import java.util.List;

public class FeatureSteps {

    engineClass engineClass= new engineClass();

    @Given("^\"([^\"]*)\" Browser$")
    public void browser(String browserAction) {

        engineClass.browserActions(browserAction);

    }

    @And("^I am as a user entering field in \"([^\"]*)\" page$")
    public void i_am_as_a_user_entering_field_in_page(String sheetName, DataTable ElementNameAndValues) {

     List<List<String>> valuesAndElementNames = ElementNameAndValues.raw();

     for(int i = 0 ; i <valuesAndElementNames.size() ;i++){
         String elementName = valuesAndElementNames.get(i).get(0);
         String elementValue = valuesAndElementNames.get(i).get(1);

         engineClass.sendKeysFunctionality(elementName , elementValue , sheetName);
     }
  }

    @When("^I click on element in \"([^\"]*)\" page$")
    public void i_click_on_element_in_page(String sheetName, DataTable dataElement) {

        List<List<String>> allElementNames = dataElement.raw();

        for(int i = 0 ; i < allElementNames.size() ; i++){

            String myElement = allElementNames.get(i).get(0);
            System.out.println("Clicking on the element " + myElement);

            engineClass.clickFunctionality(myElement,sheetName);

        }

    }

}
