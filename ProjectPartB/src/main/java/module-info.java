module projectpartb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens projectpartb to javafx.fxml;
    exports projectpartb;
}
