package ua.opnu.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;

/*
 * Клас успадковує Application і є точкою входу для JavaFX-застосунку.
 */
public class SortingList extends Application {

    // Колекція студентів з підтримкою сповіщень про зміни
    private ObservableList<Student> students;

    /*
     * Метод викликається при запуску застосунку.
     * Створює головне вікно (Stage) та наповнює його елементами.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Список студентів");

        // Ініціалізація колекції студентів
        students = populateList();

        // Основний вертикальний контейнер
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5));
        vbox.setAlignment(Pos.CENTER);

        // Компонент для відображення списку студентів
        final ListView<Student> listView = new ListView<>(students);
        listView.setPrefSize(400, 240);

        // Додаємо список і кнопки в контейнер
        final HBox hbox = setButtons();
        vbox.getChildren().addAll(listView, hbox);

        // Створюємо сцену й прикріплюємо її до вікна
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /*
     * Наповнює список студентів вручну
     */
    private ObservableList<Student> populateList() {
        Student student1 = new Student("Григорій", "Іванов", 75);
        Student student2 = new Student("Сергій", "Петренко", 92);
        Student student3 = new Student("Григорій", "Сергієнко", 61);
        Student student4 = new Student("Максим", "Сковорода", 88);

        // Створюємо ObservableList зі студентами
        return FXCollections.observableArrayList(
                student1, student2, student3, student4);
    }

    /*
     * Створює горизонтальний контейнер із кнопками сортування
     */
    private HBox setButtons() {
        final Button sortByNameButton = new Button("Сортувати за ім'ям");
        final Button sortByLastNameButton = new Button("Сортувати за прізвищем");
        final Button sortByMarkButton = new Button("Сортувати за оцінкою");

        // Розтягуємо кнопки по ширині
        HBox.setHgrow(sortByNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByLastNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByMarkButton, Priority.ALWAYS);
        sortByNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByLastNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByMarkButton.setMaxWidth(Double.MAX_VALUE);

        // Прапори для зміни порядку сортування
        final boolean[] nameOrder = {true};
        final boolean[] lastNameOrder = {true};
        final boolean[] markOrder = {true};

        // Обробник сортування за ім’ям
        sortByNameButton.setOnAction(event -> {
            students.sort(new NameSorter(nameOrder[0]));
            nameOrder[0] = !nameOrder[0];
        });

        // Обробник сортування за прізвищем
        sortByLastNameButton.setOnAction(event -> {
            students.sort(new LastNameSorter(lastNameOrder[0]));
            lastNameOrder[0] = !lastNameOrder[0];
        });

        // Обробник сортування за оцінкою
        sortByMarkButton.setOnAction(event -> {
            students.sort(new MarkSorter(markOrder[0]));
            markOrder[0] = !markOrder[0];
        });

        // Формування контейнера з кнопками
        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.getChildren().addAll(sortByNameButton, sortByLastNameButton, sortByMarkButton);
        hb.setAlignment(Pos.CENTER);

        return hb;
    }

    public static void main(String[] args) {
        // Запуск програми
        launch(args);
    }
}
