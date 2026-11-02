package gui;

import javax.swing.table.AbstractTableModel;
import domain.Seller;
import domain.Sale;
import java.util.List;

public class SellerAdapter extends AbstractTableModel {
    
    private Seller seller;
    private String[] columnNames = {"title", "description", "price"};
    private List<Sale> sales;

    public SellerAdapter(Seller seller) {
        this.seller = seller;
        if (this.seller != null) {
            this.sales = this.seller.getSales();
        }
    }

    @Override
    public int getRowCount() {
        return (sales != null) ? sales.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sale sale = sales.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sale.getTitle();
            case 1:
                return sale.getDescription();
            case 2:
                return sale.getPrice();
            default:
                return null;
        }
    }
}