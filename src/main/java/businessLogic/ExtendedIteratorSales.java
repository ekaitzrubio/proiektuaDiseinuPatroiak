package businessLogic;

import java.util.List;
import java.util.NoSuchElementException;
import domain.Sale;

public class ExtendedIteratorSales implements ExtendedIterator<Sale> {
    
    private List<Sale> sales;
    private int currentIndex;

    public ExtendedIteratorSales(List<Sale> sales) {
        this.sales = sales;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < sales.size();
    }

    @Override
    public Sale next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return sales.get(currentIndex++);
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex >= 0;
    }

    @Override
    public Sale previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        return sales.get(currentIndex--);
    }

    @Override
    public void goFirst() {
        currentIndex = 0;
    }

    @Override
    public void goLast() {
        if (!sales.isEmpty()) {
            currentIndex = sales.size() - 1;
        } else {
            currentIndex = 0;
        }
    }
}