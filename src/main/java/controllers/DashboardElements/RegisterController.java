package controllers.DashboardElements;

import com.sun.javafx.scene.control.skin.TableHeaderRow;
import database.HandleRegister;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import scripts.DataRetriever;
import scripts.Week;
import windows.Popup;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RegisterController
{
    @FXML BorderPane root;
    @FXML VBox studentInfoPanel;
    @FXML TableView<Week> table;

    @FXML DatePicker datePicker;
    @FXML ChoiceBox classPicker;
    @FXML Button resetButton;
    @FXML Button hideStudentProperties;
    @FXML ListView studentProperties;

    public void initialize()
    {
        try {
            //HandleRegister.createWeekTable(getWeekStarting());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        table.getSelectionModel().setCellSelectionEnabled(true);

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        datePicker.setShowWeekNumbers(false);

        datePicker.setValue(LocalDate.now());

        datePicker.valueProperty().addListener(((observable, oldValue, newValue) -> {saveRegisterView();updateRegisterView();datePicker.setValue(newValue);}));

        classPicker.valueProperty().addListener(((observable, oldValue, newValue) -> {saveRegisterView();updateRegisterView();}));

        resetButton.setOnAction(event -> {updateRegisterView();});

        table.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event)
            {
                table.requestFocus();
                if (event.getCode().isLetterKey())
                {
                    table.requestFocus();
                    ObservableList<TablePosition> positions = table.getSelectionModel().getSelectedCells();
                    ObservableList<Week> data = table.getItems();
                    for (TablePosition pos : positions)
                    {
                        data.get(Math.max(0, pos.getRow())).setPeriod(Math.max(0, pos.getColumn()), event.getText());
                    }
                    table.setItems(data);
                    table.refresh();
                }
            }
        });

        table.skinProperty().addListener((obs, oldSkin, newSkin) ->
        {
            final TableHeaderRow header = (TableHeaderRow) table.lookup("TableHeaderRow");
            header.reorderingProperty().addListener((o, oldVal, newVal) -> header.setReordering(false));
        });

        table.getFocusModel().focusedCellProperty().addListener(((observable, oldValue, newValue) ->
        {
            try
            {
                table.requestFocus();

                if (table.getSelectionModel().getSelectedCells().size() > 0)
                {
                    TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
                    updateStudentProperties(table.getItems().get(pos.getRow()).getId());
                }
            }
            catch (Exception e) { e.printStackTrace(); }
        }));

        updateRegisterView();
    }

    private void updateRegisterView()
    {
        try
        {
            table.setItems(HandleRegister.retrieveWeeksRegister(getWeekStarting(), classPicker.getValue().toString()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Popup.AlertBox("Table Not Found");
        }
    }

    private void updateStudentProperties(int studentID)
    {
        try
        {
            ArrayList a = HandleRegister.retrieveStudentInfo(studentID);
            ((ImageView)((HBox)studentProperties.getItems().get(0)).getChildren().get(0)).setImage((Image) a.get(0));
            studentProperties.getItems().set(1, a.get(1));
            studentProperties.getItems().set(2, a.get(2));
            studentProperties.getItems().set(3, a.get(3));
            studentProperties.getItems().set(4, a.get(4));
            studentProperties.getItems().set(5, a.get(5));
            studentProperties.getItems().set(6, a.get(6));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML private ArrayList<Integer> getSelectedStudents()
    {
        table.requestFocus();

        ArrayList<Integer> studentIDs = new ArrayList<>();

        ObservableList<TablePosition> cellsSelected =table.getSelectionModel().getSelectedCells();

        for (TablePosition pos : cellsSelected)
        {
            studentIDs.add(table.getItems().get(pos.getRow()).getId());
        }

        return studentIDs;
    }

    @FXML private void hideStudentInfo() { studentProperties.setVisible(false); studentInfoPanel.setPrefWidth(0);hideStudentProperties.setVisible(false);}

    @FXML private void showStudentInfo() { studentProperties.setVisible(true); studentInfoPanel.setPrefWidth(270);hideStudentProperties.setVisible(true);}

    @FXML
    private void saveRegisterView()
    {
        try
        {
            HandleRegister.setEditedRegister(table.getItems(), getWeekStarting(), classPicker.getValue().toString());
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

    @FXML private void addMerit()
    {
        try
        {
            for (Integer studentId : getSelectedStudents())
                HandleRegister.addMerit(studentId, 1);
        }
        catch (SQLException e) { e.printStackTrace(); }
    }

    @FXML private void addDemerit()
    {
        try
        {
            for (Integer studentId : getSelectedStudents())
                HandleRegister.addDemerit(studentId, 1);
        }
        catch (SQLException e) { e.printStackTrace(); }
    }
    @FXML private void getInfo()
    {
        try
        {
            Popup.DisplayWidget(new VBox(new HBox(DataRetriever.getMeritValues(classPicker.getValue().toString()), DataRetriever.getAttendance(getWeekStarting(), getSelectedStudents().get(0))), DataRetriever.getAttendanceValues(getWeekStarting(), classPicker.getValue().toString())));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}