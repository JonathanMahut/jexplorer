package mattw.jexplorer.v2;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;

public class DriveSideMenu extends VBox {

    class MenuSection<T> extends VBox {
        class MenuHeader extends StackPane {
            private StackPane content;
            public MenuHeader() {
                super();
                this.content = new StackPane();
                this.content.setPadding(new Insets(10));
                this.content.setStyle("-fx-border-color: lightgray;-fx-border-width:1px;");
                this.getChildren().addAll(content);
            }
            public StackPane getContent() {
                return this.content;
            }
        }

        private MenuHeader header;
        private ListView<T> contentList;

        public MenuSection() {
            super();
            this.setFillWidth(true);
            this.header = new MenuHeader();
            this.contentList = new ListView<>();
            this.getChildren().addAll(header, contentList);
        }

        public MenuHeader getHeader() {
            return this.header;
        }

        public ListView<T> getContentList() {
            return this.contentList;
        }
    }

    private MenuSection<Node> localSection;
    private MenuSection<Node> networkSection;

    public DriveSideMenu() {
        super();
        this.setFillWidth(true);

        localSection = new MenuSection<>();
        localSection.getHeader().getContent().getChildren().addAll(new Label("Local"));
        localSection.getContentList().getItems().addAll(new Label("A:"), new Label("B:"));

        networkSection = new MenuSection<>();
        networkSection.getHeader().getContent().getChildren().addAll(new Label("Network"));
        networkSection.getContentList().getItems().addAll(new Label("ssh://192.168.0.22"), new Label("ftp://192.168.0.22"));

        this.getChildren().addAll(localSection, networkSection);
    }

}
