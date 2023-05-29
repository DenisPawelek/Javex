package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.MainService;

@RestController("MainController")
@RequestMapping("/22")
public class MainController {

	@Autowired
	protected List<MainService> list = new ArrayList<MainService>();

	@GetMapping("/{type}")
	public List<Object> getAll(@PathVariable String type) {
		String search = "FALSE";
		List<Object> l = new ArrayList<Object>();

		int iter = 0;
		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				search = "TRUE";
				iter = i;
				return (ArrayList) list.get(i).getAllItems();
			}
		}

		return l;
	}

}
