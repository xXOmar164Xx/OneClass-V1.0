package controllers.DashboardElements;

import database.HandleRegister;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import scripts.Week;
import windows.Popup;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;


public class RegisterController
{
    @FXML VBox root;
    @FXML TableView<Week> table;
    @FXML TableColumn nameCol;
    @FXML DatePicker datePicker;
    @FXML ChoiceBox classPicker;
    @FXML Button button;

    public void initialize()
    {
        datePicker.setShowWeekNumbers(false);
        datePicker.setValue(LocalDate.now());
        nameCol.setCellFactory(TextFieldTableCell.<Week>forTableColumn());

        datePicker.valueProperty().addListener(((observable, oldValue, newValue) ->
        {
            updateRegisterView();
        }));

        classPicker.valueProperty().addListener(((observable, oldValue, newValue) ->
        {
            updateRegisterView();
        }));

        updateRegisterView();
    }

    private void updateRegisterView()
    {
        try
        {
            table.setItems(HandleRegister.retreiveWeeksRegister(getWeekStarting(), classPicker.getValue().toString()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Popup.AlertBox("Table Not Found");
        }
    }

    private String getWeekStarting()
    {
        LocalDate weekStarting;
        int daysToSubtract = 0;
        switch (datePicker.getValue().getDayOfWeek())
        {
            case MONDAY:
                daysToSubtract = 0;
                break;
            case TUESDAY:
                daysToSubtract = 1;
                break;
            case WEDNESDAY:
                daysToSubtract = 2;
                break;
            case THURSDAY:
                daysToSubtract = 3;
                break;
            case FRIDAY:
                daysToSubtract = 4;
                break;
            case SATURDAY:
                daysToSubtract = 5;
                break;
            case SUNDAY:
                daysToSubtract = 6;
                break;
        }
        weekStarting = Year.of(datePicker.getValue().getYear()).atDay(datePicker.getValue().getDayOfYear() - daysToSubtract);

        return (weekStarting.format(DateTimeFormatter.ofPattern("ddMMyy")));
    }
}
