package pl.javex.ClientCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCardS {

	@Autowired
	private ClientCardR cardRepository;
	
	public List<ClientCardM> getCards(){
		return cardRepository.findAll();
	}
	
}
