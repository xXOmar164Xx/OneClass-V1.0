package controllers.DashboardElements;

import database.HandleRegister;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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

    @FXML DatePicker datePicker;
    @FXML ChoiceBox classPicker;
    @FXML Button resetButton;

    private ObservableList<Week> saveValue;

    private boolean saved=true;

    public void initialize()
    {
        datePicker.setShowWeekNumbers(false);

        datePicker.setValue(LocalDate.now());

        datePicker.valueProperty().addListener(((observable, oldValue, newValue) -> {saveRegisterView();updateRegisterView();}));

        classPicker.valueProperty().addListener(((observable, oldValue, newValue) -> {saveRegisterView();updateRegisterView();}));

        resetButton.setOnAction(event -> {updateRegisterView();});

        for (int i = 1; i < 6; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                TableColumn col = table.getColumns().get(i).getColumns().get(j);
                col.setCellFactory(TextFieldTableCell.forTableColumn());

                col.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent event)
                    {
                        TablePosition pos = event.getTablePosition();
                        ObservableList<Week> data = table.getItems();
                        if (event.getNewValue().toString().length() == 1)
                        {
                            data.get(pos.getRow()).setPeriod(pos.getColumn(), (String) event.getNewValue());
                            saved = false;
                        }
                        else
                        {
                            Popup.AlertBox("Invalid Input!");
                        }
                        table.setItems(data);
                        table.refresh();
                    }
                });
            }
        }

        updateRegisterView();
    }

    private void updateRegisterView()
    {
        try
        {
            table.setItems(HandleRegister.retrieveWeeksRegister(getWeekStarting(), classPicker.getValue().toString()));
            saveValue = table.getItems();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Popup.AlertBox("Table Not Found");
        }
    }

    @FXML
    private void saveRegisterView()
    {
        try
        {
            HandleRegister.setEditedRegister(table.getItems(), getWeekStarting(), classPicker.getValue().toString());
            saved=false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Popup.AlertBox("Could not save Register");
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