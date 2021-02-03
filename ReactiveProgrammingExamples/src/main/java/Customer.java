import java.util.ArrayList;
import java.util.List;

public class Customer {

        private String name;
        private List<Cells> cell = new ArrayList<>();

        public Customer(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Cells> getCellList() {
            return cell;
        }



        public void setCell(List<Cells> cell) {
            this.cell = cell;
        }

        public void addCell(Cells cell) {
            this.cell.add(cell);
        }
}

