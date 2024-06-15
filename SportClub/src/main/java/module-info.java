module gui.sportclub {
    requires javafx.controls;
    requires javafx.fxml;



    opens gui.sportclub to javafx.fxml;
    opens Models;
    exports gui.sportclub;
}