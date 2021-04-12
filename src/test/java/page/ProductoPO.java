package page;

import drivers.DriverContext;
import org.openqa.selenium.support.PageFactory;

public class ProductoPO {


    public ProductoPO() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }


}
