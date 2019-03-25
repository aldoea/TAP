package sample.Componentes;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.Modelos.PeliculaDAO;
import sample.Vistas.Pelicula;

public class ButtonCell extends TableCell<PeliculaDAO, String> {
    private Button celdaBoton;
    private int opc;
    PeliculaDAO objPeli;

    public  ButtonCell(int opc){
        this.opc = opc;
        //objPeli = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
        if(this.opc == 1) {
            celdaBoton = new Button("Editar");
            celdaBoton.setOnAction(event -> Editar());
        }else {
            celdaBoton = new Button("Eliminar");
            celdaBoton.setOnAction(event -> Eliminar());
        }

    }

    private void Editar(){
        objPeli = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
        new Pelicula(ButtonCell.this.getTableView()).setPeliculaDAO(objPeli);
    }

    private void Eliminar(){
        objPeli = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
        objPeli.eliminar();
        ButtonCell.this.getTableView().setItems(objPeli.seleccionar());
        ButtonCell.this.getTableView().refresh();
    }

    @Override
    protected void updateItem(String s, boolean empty) {
        super.updateItem(s, empty);
        if(!empty) {
            setGraphic(celdaBoton);
        }
    }
}
