package pl.javex.ClientCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class ClientCardS extends MainService<ClientCardM, ClientCardR> {

	@Autowired
	private ClientCardR cardRepository;
	
}
