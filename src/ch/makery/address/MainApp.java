package ch.makery.address;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import ch.makery.address.model.SupremeTask;
import ch.makery.address.model.keywordInfo;
<<<<<<< HEAD
import ch.makery.address.view.SlackWebhookController;
import ch.makery.address.view.ImageScrapperController;
import ch.makery.address.view.InstoreRegistrationController;
=======
import ch.makery.address.view.ImageScrapperController;
>>>>>>> 624df5e6a043c3d053df7badcb64811464921010
import ch.makery.address.view.ProfileCreatorController;
import ch.makery.address.view.SupremeBotOverviewController;
import ch.makery.address.view.keywordController;
import ch.makery.address.view.reCaptchaController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	public Scene main;
	public Scene profileCreator;
	public Stage dialogue;
	private Stage primaryStage;
	private ObservableList<SupremeTask> taskData = FXCollections.observableArrayList();
	
<<<<<<< HEAD
	public Scene instoreScene;
	public Scene slackScene;
	
=======
>>>>>>> 624df5e6a043c3d053df7badcb64811464921010
	private SupremeBotOverviewController botController;
	private ProfileCreatorController profileController;
	private reCaptchaController recaptchaController;
	
    private Logger logger = Logger.getLogger(getClass().getName());


	// Gets current Table
	public ObservableList<SupremeTask> getTaskData() {
		return taskData;
	}

	@Override
	public void start(Stage primaryStage) {
		// Main preferences
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SupremeAIO");
		this.primaryStage.getIcons()
				.add(new Image("file:" + System.getProperty("user.dir") + "/resources/images/" + "icon.png"));

		initRootLayout();
	}

	// Main Application
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SupremeBotOverview.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();

			main = new Scene(rootLayout);
			main.getStylesheets().add(getClass().getResource("/css/ClearTheme.css").toExternalForm()); // Add Default
																										// Clear Theme
			primaryStage.setScene(main);
			primaryStage.show();
			primaryStage.setResizable(false);

			botController = loader.getController();
			botController.setMainApp(this, botController);
			
		} catch (IOException e) {
			logger.log(Level.SEVERE, "", e);
		}
	}


	public void showProfileCreator() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ProfileCreator.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			page.setId("pane");

			dialogue = new Stage();
			dialogue.setTitle("Edit Profile");
			dialogue.initModality(Modality.NONE);
			dialogue.initOwner(primaryStage);

<<<<<<< HEAD
=======
			String css = this.getClass().getResource("/css/ProfileTheme.css").toExternalForm();

>>>>>>> 624df5e6a043c3d053df7badcb64811464921010
			profileCreator = new Scene(page);
			dialogue.setScene(profileCreator);
			dialogue.getIcons()
					.add(new Image("file:" + System.getProperty("user.dir") + "/resources/images/" + "edit.png"));
			dialogue.setResizable(false);
<<<<<<< HEAD
			
			if (botController.tglSwitchGui.isSelected()) {
				profileCreator.getStylesheets().add(getClass().getResource("/css/ProfileThemeDark.css").toExternalForm());
			} else {
				profileCreator.getStylesheets().add(getClass().getResource("/css/ProfileTheme.css").toExternalForm());		  
			}
=======
			profileCreator.getStylesheets().add(css);
>>>>>>> 624df5e6a043c3d053df7badcb64811464921010
			
			profileController = loader.getController();
			profileController.setDialogStage(dialogue);
			
			profileController.setProfileCreatorController(botController);
		

			dialogue.show();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "", e);
		}
	}

	public void showRecaptchaWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/reCaptcha.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setResizable(false);
			dialogStage.setTitle("ReCaptcha Harvester");
			dialogStage.initModality(Modality.NONE);
			dialogStage.getIcons().add(
					new Image("file:" + System.getProperty("user.dir") + "/resources/images/" + "reCaptchaIcon.png"));
			String css = this.getClass().getResource("/css/ClearTheme.css").toExternalForm();
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			scene.getStylesheets().add(css);

			recaptchaController = loader.getController();
			recaptchaController.setDialogStage(dialogStage);

			dialogStage.setScene(scene);
			dialogStage.show();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "", e);		}
	}

	// Start Timer Dialog box
	public void timerDialog() {
		TextInputDialog dialog = new TextInputDialog("11:00:00");

		// Get the Stage.
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("/resources/images/timer.png").toString()));

		dialog.setHeaderText(null);
		dialog.setTitle("Tasks start timer");
		dialog.setContentText("Time:");
		dialog.setGraphic(null);
				
		ButtonType resetTimer = new ButtonType("Reset");
		dialog.getDialogPane().getButtonTypes().add(resetTimer);
		
		//Lookup button and reset the hasRunStarted variable to set timer to false
		final Button reset = (Button) dialog.getDialogPane().lookupButton(resetTimer);
		reset.addEventFilter(ActionEvent.ACTION, event -> 
			keywordInfo.getKeywordInfo().setHasRunStarted(false)
		);

		
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			keywordInfo.getKeywordInfo().setStartTimer(result.get());
			//Console log update
			botController.consoleWriter("[" + new SimpleDateFormat("HH:mm:ss:SS").format(new Date()) + "] - " + "Set tasks start timer: " + result.get() + "\n");
			keywordInfo.getKeywordInfo().setHasRunStarted(true);
		}

	}

	// Checkout delay
	public void checkoutDelayDialog() {
		TextInputDialog dialog = new TextInputDialog("0000");

		// Get the Stage.
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("/resources/images/delay.png").toString()));

		dialog.setHeaderText(null);
		dialog.setTitle("Checkout Delay");
		dialog.setContentText("Delay:");
		dialog.setGraphic(null);

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			keywordInfo.getKeywordInfo().setCheckoutDelay(Integer.parseInt(result.get()));
			botController.consoleWriter("[" + new SimpleDateFormat("HH:mm:ss:SS").format(new Date()) + "] - " + "Set checkout delay: " + result.get() + "\n");
		}

	}
	
	public void showAboutWindow() {
<<<<<<< HEAD
		String information = "Version: 1.5.0.0";
		String updates = 
				  "+ Each status message updates according to task "
				+ "\n+ Added image scraper "
				+ "\n+ Fixed console log bug "
				+ "\n+ Dark Theme Fixed "
				+ "\n+ Added slack webhook "
				+ "\n+ Updated recaptcha harvester "
				+ "\n+ Added instore registration for UK "
				+ "\n+ Fixed checkout billing information "
				+ "\n+ Added toggle switch for easy theme change "
				+ "\n+ Fixed keyword dialog "
				+ "\n+ Added update checker";
=======
		String information = "Version: 1.4.0.0";
		String updates = 
				  "\n+ Added start and top buttons for individual tasks "
				+ "\n+ Added action column "
				+ "\n+ New About window dialog showing updates and version info "
				+ "\n+ Delete a row by double clicking "
				+ "\n+ Fixed log output for each task "
				+ "\n+ Added slider for theme switcher";
>>>>>>> 624df5e6a043c3d053df7badcb64811464921010
				
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("Information");
		alert.setContentText(information);
		
		ButtonType resetTimer = new ButtonType("Twitter");
		alert.getDialogPane().getButtonTypes().add(resetTimer);
		
		Button resetTimerBtn = (Button) alert.getDialogPane().lookupButton(resetTimer);
		resetTimerBtn.addEventFilter(ActionEvent.ACTION, event -> 
			getHostServices().showDocument("https://twitter.com/DrExpresso")
		);
		
		ButtonType github = new ButtonType("Github");
		alert.getDialogPane().getButtonTypes().add(github);
		
		Button githutBtn = (Button) alert.getDialogPane().lookupButton(github);
		githutBtn.addEventFilter(ActionEvent.ACTION, event -> 
			getHostServices().showDocument("https://github.com/DrExpresso/SupremeAIO")
		);
		
		Label label = new Label("Updates:");

		TextArea textArea = new TextArea(updates);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();

	}
	
	public void showImageScraperDialog() throws FileNotFoundException {
		ImageScrapperController controller = new ImageScrapperController();
		
		Stage dialogStage = new Stage();
<<<<<<< HEAD
		dialogStage.initModality(Modality.NONE);
		String css = this.getClass().getResource("/css/ClearTheme.css").toExternalForm();
		dialogStage.getIcons().add(new Image(this.getClass().getResource("/resources/images/imageScrapper.png").toString()));
=======
		dialogStage.setTitle("Keywords");
		dialogStage.initModality(Modality.NONE);
		dialogStage.getIcons().add(
				new Image("file:" + System.getProperty("user.dir") + "/resources/images/" + "keyword.ico"));
		String css = this.getClass().getResource("/css/ClearTheme.css").toExternalForm();
>>>>>>> 624df5e6a043c3d053df7badcb64811464921010
		dialogStage.initOwner(primaryStage);
		
		
		controller.start(dialogStage);
	}
	
	//Keyword help
	public void keywordDialog() throws FileNotFoundException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/keywordOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Keywords");
			dialogStage.initModality(Modality.NONE);
			dialogStage.getIcons().add(
					new Image("file:" + System.getProperty("user.dir") + "/resources/images/" + "keyword.ico"));
			String css = this.getClass().getResource("/css/ClearTheme.css").toExternalForm();
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
<<<<<<< HEAD
			
			dialogStage.setScene(scene);
			dialogStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String exceptionText = sw.toString();
			    
			this.errorStackTraceDialog("Stacktrace error see log", exceptionText);
			    
		}
	}
	
	public void SlackWebhookDialog() throws FileNotFoundException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SlackWebhookOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Slack Webhook");
			dialogStage.initModality(Modality.NONE);
			dialogStage.getIcons().add(new Image(this.getClass().getResource("/resources/images/slack_icon.png").toString()));
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			slackScene = new Scene(page);
			if (botController.tglSwitchGui.isSelected()) {
				slackScene.getStylesheets().add(getClass().getResource("/css/SlackDark.css").toExternalForm());
			} else {
				slackScene.getStylesheets().add(getClass().getResource("/css/Slack.css").toExternalForm());		  
			}

			SlackWebhookController controller = loader.getController();
=======
			scene.getStylesheets().add(css);

			keywordController controller = loader.getController();
>>>>>>> 624df5e6a043c3d053df7badcb64811464921010
			controller.setMainApp(this);
			controller.setDialogStage(dialogStage);

			
			
<<<<<<< HEAD
			dialogStage.setScene(slackScene);
			dialogStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String exceptionText = sw.toString();
			    
			this.errorStackTraceDialog("Stacktrace error see log", exceptionText);
			    
		}
	}
	
	public void instoreRegistrationDialog() throws FileNotFoundException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/InstoreRegistrationOverview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			page.setId("pane");


			Stage dialogStage = new Stage();
			dialogStage.setTitle("Instore Registration Setup");
			dialogStage.initModality(Modality.NONE);
			dialogStage.getIcons().add(new Image(this.getClass().getResource("/resources/images/icon.png").toString()));
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			instoreScene = new Scene(page);
			if (botController.tglSwitchGui.isSelected()) {
				instoreScene.getStylesheets().add(getClass().getResource("/css/DarkTheme.css").toExternalForm());
			} else {
				instoreScene.getStylesheets().add(getClass().getResource("/css/ClearTheme.css").toExternalForm());		  
			}
			
			InstoreRegistrationController controller = loader.getController();
			controller.setDialogStage(dialogStage, this, botController);
			
			dialogStage.setScene(instoreScene);
=======
			dialogStage.setScene(scene);
>>>>>>> 624df5e6a043c3d053df7badcb64811464921010
			dialogStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String exceptionText = sw.toString();
			    
			this.errorStackTraceDialog("Stacktrace error see log", exceptionText);
			    
		}
	}

	public void errorStackTraceDialog(String Error, String stackTraceElements) throws FileNotFoundException {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setHeaderText("Look, an Exception Dialog");
		alert.setContentText(Error);

		Label label = new Label("The exception stacktrace was:");

		TextArea textArea = new TextArea(stackTraceElements);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
