package model;

import java.util.Comparator;

public class Value_Compare implements Comparator<Objeto>{

	
	
	
	@Override
	public int compare(Objeto arg0, Objeto arg1) {
		// TODO Auto-generated method stub
		return arg0.getColorete() - arg1.getColorete();
	}

}
