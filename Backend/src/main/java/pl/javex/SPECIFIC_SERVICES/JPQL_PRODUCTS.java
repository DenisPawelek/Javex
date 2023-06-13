package pl.javex.SPECIFIC_SERVICES;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pl.javex.__CUSTOM_REPOS.SelectProductsBy_Repo;
import pl.javex.MODELS.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("JPQLPROD")
@RequestMapping("/jpq")
public class JPQL_PRODUCTS {

	@Autowired
	List<SelectProductsBy_Repo> repos;
	@Autowired
	JpaRepository<SexM, Long> sex_repo;
	
	@GetMapping("/sex")
	public List<Object> sex(@RequestParam Long id) {
//		return id+"tutaj id";
		
		Optional<SexM> sex = sex_repo.findById(id);
		List<Object> products = new ArrayList<Object>();
		if(sex.isPresent()) {
			for(SelectProductsBy_Repo r : repos) {
				products.addAll(r.getBySex(sex.get()));
			}
		}
		return products;
	}
	
	@GetMapping("/priceRange")
	public List<ProductM> priceRange(@RequestParam Long priLow, @RequestParam Long priUpp) {
	
		List<ProductM> products = new ArrayList<ProductM>();
		for(SelectProductsBy_Repo r : repos) {
			products.addAll(r.getInPriceRange(priLow, priUpp));
		}
		return products;

	}
	
	@GetMapping("/filterName")
	public List<ProductM> filterName(@RequestParam String name) {
	
		List<ProductM> products = new ArrayList<ProductM>();
		for(SelectProductsBy_Repo r : repos) {
			products.addAll(r.getFilterName(name));
		}
		return products;
	
	}
	
	
	
	
}
