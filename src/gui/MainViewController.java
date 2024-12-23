package gui;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

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
		System.out.println("onMenuItemDepartamentoAction");
	}
	
	public void onMenuItemSobreAction() {
		System.out.println("onMenuItemSobreAction");
	}
}
