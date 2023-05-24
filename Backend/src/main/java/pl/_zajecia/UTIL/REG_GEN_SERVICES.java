package pl._zajecia.UTIL;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import controllers.GenericController;
import pl._zajecia.z27marca.*;
import services.GenericService;

@RestController("testGenerics")
public class REG_GEN_SERVICES extends GenericController {}

@Service class  Costam    extends  GenericService<costam     >{@Override public costam      getField(){ return new costam     (); } }
@Service class  Modelik    extends  GenericService<modelik     >{@Override public modelik      getField(){ return new modelik     (); } }
@Service class  Typ    extends  GenericService<typ     >{@Override public typ      getField(){ return new typ     (); } }
