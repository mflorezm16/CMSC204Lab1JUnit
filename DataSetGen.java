import java.util.ArrayList;

public class DataSetGen<T extends Measurable> {
	
	private double sum;
	private Measurable maximum;
	private int count;
	private ArrayList<T> data;
	
	public DataSetGen() {
		sum = 0;
		count = 0;
		maximum = null;
		data = new ArrayList<>();
	}
	
	public void add(T x) {
		sum = sum + x.getMeasure();
		
		if(count == 0 || maximum.getMeasure() < x.getMeasure()) {
			maximum = x;
		}
		count++;
		data.add(x);
	}
	
	public double getAverage() {
		if(count == 0) {
			return 0;
		}else {
			return sum / count;
		}
	}
	
	public Measurable getMaximum() {
		return maximum;
	}
	

}
