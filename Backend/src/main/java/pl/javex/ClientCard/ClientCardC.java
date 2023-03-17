package pl.javex.ClientCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientCardC {

	@Autowired
	private ClientCardS cardService;
	
	@GetMapping("/cards")
	public List<ClientCardM> getCards(){
		return cardService.getCards();
	}
}
