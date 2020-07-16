import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {

    private int columnCount = 3;
    private ArrayList<String []> dataList;

    MyTableModel() {
        dataList = new ArrayList<String[]>();
        for (int i = 0; i < dataList.size(); i ++ ) {
            dataList.add(new String[columnCount]);
        }
    }
    @Override
    public int getRowCount() {
        return dataList.size() ;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String [] rows = dataList.get(rowIndex);
        String str = rows[columnIndex];
        return str;
    }

    public void addData (String [] row) {
        String [] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataList.add(rowTable);
    }
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0 : return "#id";
            case 1 : return "Author";
            case 2 : return "Title";

        }
            return "";
    }
}
