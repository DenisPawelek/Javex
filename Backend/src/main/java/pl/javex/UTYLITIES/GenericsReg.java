package pl.javex.UTYLITIES;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import controllers.GenericController;
import pl.javex.MODELS.*;




import services.GenericService;
import services.MainService;


@RestController("rejestrator")
public class GenericsReg extends GenericController{

//	@Autowired
//	private MainService<T> serv;
//	
//	
//	public rejestrator(){
//		//name = T.class.getSimpleName();
//	}
//	public String name;
//	
//	public ArrayList<Object> dosome(){
//		return (ArrayList<Object>)serv.getAllItems();
//	}
//	

	
}

//########		__ORDER__


//Address
//Boots
//Brand
//Category
//City
//Color
//Date
//Description
//Email
//Hoodie
//Jacket
//Material
//Pants
//PostalCode
//Product
//ProductType
//Sex
//Shirt
//Size
//Sweater
//Type
//User




//########		REPOS


interface RepoAddress     extends JpaRepository<AddressM      , Long>{}
interface RepoBoots       extends JpaRepository<BootsM        , Long>{}
interface RepoBrand       extends JpaRepository<BrandM        , Long>{}
interface RepoCategory    extends JpaRepository<CategoryM     , Long>{}
interface RepoCity        extends JpaRepository<CityM         , Long>{}
interface RepoColor       extends JpaRepository<ColorM        , Long>{}
interface RepoDate        extends JpaRepository<DateM         , Long>{}
interface RepoDescription extends JpaRepository<DescriptionM  , Long>{}
interface RepoEmail       extends JpaRepository<EmailM        , Long>{}
interface RepoHoodie      extends JpaRepository<HoodieM       , Long>{}
interface RepoJacket      extends JpaRepository<JacketM       , Long>{}
interface RepoMaterial    extends JpaRepository<MaterialM     , Long>{}
interface RepoPants       extends JpaRepository<PantsM        , Long>{}
interface RepoPostalCode  extends JpaRepository<PostalCodeM   , Long>{}
interface RepoProduct     extends JpaRepository<ProductM      , Long>{}
interface RepoProductType extends JpaRepository<ProductTypeM  , Long>{}
interface RepoSex         extends JpaRepository<SexM          , Long>{}
interface RepoShirt       extends JpaRepository<ShirtM        , Long>{}
interface RepoSize        extends JpaRepository<SizeM         , Long>{}
interface RepoSweater     extends JpaRepository<SweaterM      , Long>{}
interface RepoType        extends JpaRepository<TypeM         , Long>{}
interface RepoUser        extends JpaRepository<UserM         , Long>{}
interface RepoTransaction extends JpaRepository<TransactionM  , Long>{}
interface RepoOrder		  extends JpaRepository<OrderM  	  , Long>{}
interface RepoInvoice	  extends JpaRepository<InvoiceM  	  , Long>{}




//########		SERVICES
                                                                                          
@Service class  Address     extends  GenericService<AddressM     >{@Override public AddressM      getField(){ return new AddressM     (); } }
@Service class  Boots       extends  GenericService<BootsM       >{@Override public BootsM        getField(){ return new BootsM       (); } }
@Service class  Brand       extends  GenericService<BrandM       >{@Override public BrandM        getField(){ return new BrandM       (); } }
@Service class  Category    extends  GenericService<CategoryM    >{@Override public CategoryM     getField(){ return new CategoryM    (); } }
@Service class  City        extends  GenericService<CityM        >{@Override public CityM         getField(){ return new CityM        (); } }
@Service class  Color       extends  GenericService<ColorM       >{@Override public ColorM        getField(){ return new ColorM       (); } }
@Service class  Date        extends  GenericService<DateM        >{@Override public DateM         getField(){ return new DateM        (); } }
@Service class  Description extends  GenericService<DescriptionM >{@Override public DescriptionM  getField(){ return new DescriptionM (); } }
@Service class  Email       extends  GenericService<EmailM       >{@Override public EmailM        getField(){ return new EmailM       (); } }
@Service class  Hoodie      extends  GenericService<HoodieM      >{@Override public HoodieM       getField(){ return new HoodieM      (); } }
@Service class  Jacket      extends  GenericService<JacketM      >{@Override public JacketM       getField(){ return new JacketM      (); } }
@Service class  Material    extends  GenericService<MaterialM    >{@Override public MaterialM     getField(){ return new MaterialM    (); } }
@Service class  Pants       extends  GenericService<PantsM       >{@Override public PantsM        getField(){ return new PantsM       (); } }
@Service class  PostalCode  extends  GenericService<PostalCodeM  >{@Override public PostalCodeM   getField(){ return new PostalCodeM  (); } }
@Service class  Product     extends  GenericService<ProductM     >{@Override public ProductM      getField(){ return new ProductM     (); } }
@Service class  ProductType extends  GenericService<ProductTypeM >{@Override public ProductTypeM  getField(){ return new ProductTypeM (); } }
@Service class  Sex         extends  GenericService<SexM         >{@Override public SexM          getField(){ return new SexM         (); } }
@Service class  Shirt       extends  GenericService<ShirtM       >{@Override public ShirtM        getField(){ return new ShirtM       (); } }
@Service class  Size        extends  GenericService<SizeM        >{@Override public SizeM         getField(){ return new SizeM        (); } }
@Service class  Sweater     extends  GenericService<SweaterM     >{@Override public SweaterM      getField(){ return new SweaterM     (); } }
@Service class  Type        extends  GenericService<TypeM        >{@Override public TypeM         getField(){ return new TypeM        (); } }
@Service class  User        extends  GenericService<UserM        >{@Override public UserM         getField(){ return new UserM        (); } }
@Service class  Transaction extends  GenericService<TransactionM >{@Override public TransactionM  getField(){ return new TransactionM (); } }
@Service class  Order       extends  GenericService<OrderM       >{@Override public OrderM        getField(){ return new OrderM       (); } }
@Service class  Invoice     extends  GenericService<InvoiceM     >{@Override public InvoiceM      getField(){ return new InvoiceM     (); } }

                                                                                              






//
//@Service
//class mm extends GenericService<modelik>{}
//interface mmr extends JpaRepository<modelik, Long>{}
//
//
//@Service
//class mm2 extends GenericService<costam>{}
//interface mmr2 extends JpaRepository<costam, Long>{}
//
//
//@Service
//class mmk extends MainService<modelik>{}
//@Service
//class mmk2 extends MainService<costam>{}
//@Service
//class mmk3 extends MainService<typ>{}
//interface mmrk3 extends JpaRepository<typ, Long>{}

//
//@Service
//class m2m extends MainService<costam, JpaRepository<costam,Long>>{
//	
//}
