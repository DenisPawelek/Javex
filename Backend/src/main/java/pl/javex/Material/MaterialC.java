package pl.javex.Material;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialC {

	@Autowired
	private MaterialS materialService;
	
	@GetMapping("/materials")
	public List<MaterialM> getMaterials(){
		return materialService.getAllItems();
	}
}
