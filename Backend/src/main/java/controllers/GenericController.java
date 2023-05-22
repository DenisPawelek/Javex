package controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import services.GenericService;

/**
 * Kontroler generyczny obsługujący podstawowe operacje dla serwisów: Get, Post, Put, Delete.
 * Rozszerza {@link MainController}.
 * 
 * @param <T>
 */
@RestController("GenericController")
@RequestMapping("/g")
public class GenericController<T> extends MainController {
	
	@Autowired
	protected List<GenericService> list = new ArrayList<GenericService>();

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

	@PostMapping("/single/{type}")
	public List<Object> postSingle(@PathVariable String type, @RequestBody String obj)
			throws JsonMappingException, JsonProcessingException {

		List<Object> l = new ArrayList<Object>();

		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				ObjectMapper jacksonMapper = new ObjectMapper();
				list.get(i).AddItem(jacksonMapper.readValue(obj, list.get(i).getField().getClass()));
				l = new ArrayList<Object>();
				l.add("ADDED SINGLE ITEM");
				return l;
			}
		}
		return l;

	}

	@PostMapping("/many/{type}")
	public List<Object> postMany(@PathVariable String type, @RequestBody String obj)
			throws JsonMappingException, JsonProcessingException {
		List<Object> l = new ArrayList<Object>();

		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				ObjectMapper jacksonMapper = new ObjectMapper();
				list.get(i).AddItems(jacksonMapper.readValue(obj, jacksonMapper.getTypeFactory()
						.constructCollectionType(ArrayList.class, list.get(i).getField().getClass())));
				l = new ArrayList<Object>();
				l.add("ADDED MANY ITEMS");
				return l;
			}
		}
		return l;

	}

	@DeleteMapping("/single/{type}")
	public List<Object> deleteSingle(@PathVariable String type, @RequestParam Long id) {

		List<Object> l = new ArrayList<Object>();
		l.add(type);
		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				list.get(i).DeleteItem(id);
				l = new ArrayList<Object>();
				l.add("DELETED SINGLE ITEM");
				return l;
			}
		}

		return l;
	}

	@DeleteMapping("/many/{type}")
	public List<Object> deleteMany(@PathVariable String type, @RequestParam List<Long> ids) {

		List<Object> l = new ArrayList<Object>();
		l.add(type);
		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				list.get(i).DeleteManyItems(ids);
				l = new ArrayList<Object>();
				l.add("DELETED MANY ITEMS");
				return l;
			}
		}

		return l;
	}

	@PutMapping("/single/{type}")
	public List<Object> modifySingle(@PathVariable String type, @RequestParam Long id, @RequestBody String obj)
			throws JsonMappingException, JsonProcessingException, IllegalAccessException, InvocationTargetException,
			NoSuchFieldException, SecurityException, NoSuchMethodException {

		List<Object> l = new ArrayList<Object>();
		l.add(type);
		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				ObjectMapper jacksonMapper = new ObjectMapper();
				l = list.get(i).ModifyItem(id, jacksonMapper.readValue(obj, list.get(i).getField().getClass()));
//				l = new ArrayList<Object>();
				l.add("MODIFIED SINGLE ITEM");
				return l;
			}
		}

		return l;
	}

	@PutMapping("/many/{type}")
	public List<Object> modifyMany(@PathVariable String type, @RequestParam List<Long> ids, @RequestBody String obj)
			throws JsonMappingException, JsonProcessingException, IllegalAccessException, InvocationTargetException,
			NoSuchFieldException, SecurityException, NoSuchMethodException {

		List<Object> l = new ArrayList<Object>();
		l.add(type);
		for (int i = 0; i < list.size(); i++) {
			l.add(list.get(i).getClass());
			if (type.equals(list.get(i).getClass().getSimpleName())) {
				ObjectMapper jacksonMapper = new ObjectMapper();
				list.get(i).ModifyItems(ids, jacksonMapper.readValue(obj, jacksonMapper.getTypeFactory()
						.constructCollectionType(ArrayList.class, list.get(i).getField().getClass())));

				l = new ArrayList<Object>();
				l.add("MODIFIED MANY ITEMS");
				return l;
			}
		}

		return l;
	}

}
