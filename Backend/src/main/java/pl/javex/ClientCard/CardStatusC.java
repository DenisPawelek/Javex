package pl.javex.ClientCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardStatusC {

	
	@Autowired
	private CardStatusS cardStatusService;
	
	@GetMapping("/cardStatuses")
	public List<CardStatusM> getCardStatuses(){
		return cardStatusService.getAllItems();
	}
}
