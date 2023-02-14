package backend.dto;

import java.io.Serializable;

import backend.entity.Composition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoComposition implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String operator;
	private String totalCoins;
	private String totalNotes;
	private String totalPagments;
	private String initialValue;
	
	public DtoComposition(Composition composition) {
		operator = composition.getOperator();
		totalCoins = Double.toString(composition.getTotalCoins()) ;
		totalNotes = Double.toString(composition.getTotalNotes());
		totalPagments = Double.toString(composition.getTotalPagments());
		initialValue = Double.toString(composition.getInitialValue());
	}
}
