module gui.sportclub {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens gui.sportclub to javafx.fxml;
    exports gui.sportclub;
}