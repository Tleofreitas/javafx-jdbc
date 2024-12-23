package gui;

import java.io.IOException;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController {
	
	@FXML
	private MenuItem menuItemVendedor;
	
	@FXML
	private MenuItem menuItemDepartamento;
	
	@FXML
	private MenuItem menuItemSobre;
	
	public void onMenuItemVendedorAction() {
		System.out.println("onMenuItemVendedorAction");
	}
	
	public void onMenuItemDepartamentoAction() {
		loadView("/gui/DepartmentList.fxml");
	}
	
	public void onMenuItemSobreAction() {
		loadView("/gui/About.fxml");
	}
	
	// synchronized para que o processamento todo não seja interrompido durante as multi-threads
	private synchronized void loadView(String absoluteName) {
		try {
			// Carregar outra View
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();		
			
			// Pegar a referência da cena principal
			Scene mainScene = Main.getMainScene();
			
			// Pegar o primeiro elemento da view principal, acessar o content e 
			// pegar a referência para o VBox
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			// Pegar o primeiro filho da janela principal, o main menu
			Node mainMenu = mainVBox.getChildren().get(0);
			
			// Limpar todos os filhos do main vbox
			mainVBox.getChildren().clear();
			
			// Adicionar o main menu
			mainVBox.getChildren().add(mainMenu);
			
			// Adicionar os filhos do new vbox (Sobre)
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			
			
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Erro ao carregara a página", e.getMessage(), AlertType.ERROR);
		}
	}
}
