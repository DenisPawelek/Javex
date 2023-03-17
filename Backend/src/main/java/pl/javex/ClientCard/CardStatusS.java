package pl.javex.ClientCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardStatusS {

	@Autowired
	private CardStatusR cardStatusRepository;
	
	public List<CardStatusM> getCardStatuses(){
		return cardStatusRepository.findAll();
	}
	
}
