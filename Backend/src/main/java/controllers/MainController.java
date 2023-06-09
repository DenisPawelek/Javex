package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.MainService;

@RestController("MainController")
@RequestMapping("/m")
public class MainController<T> {

	@Autowired
	protected List<MainService> list = new ArrayList<MainService>();


	@GetMapping("/single/{type}")
	public List<Object> getSingle(@PathVariable String type, @RequestParam Long id) {

		List<Object> l = new ArrayList<Object>();
		l.add(type);
		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				l = new ArrayList<Object>();
				l.add((Object) list.get(i).getOneItem(id));
				return l;
			}
		}

		return l;
	}

	@GetMapping("/many/{type}")
	public List<Object> getAll(@PathVariable String type) {

		List<Object> l = new ArrayList<Object>();
		l.add(type);
		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				return (ArrayList<Object>) list.get(i).getAllItems();

			}
		}

		return l;
	}


}
