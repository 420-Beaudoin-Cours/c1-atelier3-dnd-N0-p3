package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import org.w3c.dom.Text;

public class Controller {
        //----------------------------------------------EXERCISE 1----------------------------------------------

    public void txfSourceDragDetected(MouseEvent mouseEvent) {

        TextField source = ((TextField) mouseEvent.getSource());
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        db.setContent(content);
    }

    public void TrashDragOver(DragEvent dragEvent) {

        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void TrashDragDropped(DragEvent dragEvent) {

        TextField source = (TextField) dragEvent.getGestureSource();
        source.clear();
    }

        //----------------------------------------------EXERCISE 2 ET 3----------------------------------------------

    public void cmbDragOver(DragEvent dragEvent) {

        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void cmbDragDropped(DragEvent dragEvent) {

        TextField source = (TextField) dragEvent.getGestureSource();
        ComboBox target = (ComboBox) dragEvent.getGestureTarget();

        if (!source.getText().isEmpty()) {
            target.getItems().addAll(source.getText());
            target.getSelectionModel().selectLast();
            source.clear();
        }
    }

        //----------------------------------------------EXERCISE 3----------------------------------------------

    public void txfSourceDragDropped(DragEvent dragEvent) {

        TextField source = (TextField) dragEvent.getGestureSource();
        TextField target = (TextField) dragEvent.getGestureTarget();

        if (!source.getText().isEmpty()) {
            target.setText(source.getText());
            if(source != target) {
                source.clear();
            }
        }
    }

    public void txfSourceDragOver(DragEvent dragEvent) {

        dragEvent.acceptTransferModes(TransferMode.ANY);
    }
}
