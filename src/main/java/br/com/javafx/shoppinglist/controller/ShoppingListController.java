package br.com.javafx.shoppinglist.controller;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

public class ShoppingListController {

	@FXML
	private ListView<String> shopList;

	/** This stage */
	private final Stage stage = new Stage();

	public void createWindow(final Stage initStage) throws IOException {
		stage.initOwner(initStage);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.resizableProperty().set(false);
		stage.initStyle(StageStyle.DECORATED);
		stage.setOnCloseRequest((ae) -> {
			Platform.exit();
			System.exit(0);
		});
		stage.setTitle("Shopping List");
		stage.getIcons().add(new Image((getClass().getResource("/img/javafx.png").toExternalForm())));

		final FXMLLoader loader = new FXMLLoader();
		loader.setController(this);
		loader.setLocation(getClass().getResource("/view/ShoppingListView.fxml"));

		final Scene scene = new Scene(loader.load());
		scene.getStylesheets().add(getClass().getResource("/css/bootstrap3.css").toExternalForm());
		stage.setScene(scene);

		stage.showAndWait();

	}

	@FXML
	void addItem(final ActionEvent event) {
		System.out.println("Adding item");
		final TextInputDialog dialog = new TextInputDialog();
		final Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
		dialogStage.getIcons().add(new Image((getClass().getResource("/img/javafx.png").toExternalForm())));
		dialog.setTitle("Add Shopping List Item");
		dialog.setHeaderText("Please enter the item: ");
		final Optional<String> result = dialog.showAndWait();
		result.ifPresent(shopList.getItems()::add);
	}

	@FXML
	void clearList(final ActionEvent event) {
		System.out.println("Clearing itens");
		shopList.getItems().clear();
	}

	@FXML
	void quit(final ActionEvent event) {
		System.out.println("Exiting");
		Platform.exit();
		System.exit(0);
	}

	@FXML
    void removeSelectItem(MouseEvent event) {
		if (event.getClickCount() == 2) {
			System.out.println("Removing Item");
			String currentItemSelected = shopList.getSelectionModel().getSelectedItem();
			shopList.getItems().remove(currentItemSelected);
			
		 }
    }

}
