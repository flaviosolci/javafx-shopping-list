package br.com.javafx.shoppinglist;

import br.com.javafx.shoppinglist.controller.ShoppingListController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ShoppingListMain extends Application {

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final ShoppingListController controller = new ShoppingListController();
		controller.createWindow(primaryStage);

	}

	public static void main(final String[] args) {
		launch(ShoppingListMain.class, args);
	}

}
