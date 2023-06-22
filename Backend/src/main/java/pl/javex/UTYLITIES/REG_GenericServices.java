package pl.javex.UTYLITIES;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import controllers.GenericController;
import pl.javex.MODELS.*;
import pl.javex.TRANSACTIONS.__INTERFACES.IAddress;
import pl.javex.TRANSACTIONS.__INTERFACES.IProduct;
import pl.javex.TRANSACTIONS.__INTERFACES.IUser;
import services.GenericService;

/**
 * Kontroler generyczny służący do rejestrowania serwisów rozszerzających {@link GenericService}.
 * Rozszerza {@link GenericController}.
 */
@RestController("rejestrator")
public class REG_GenericServices extends GenericController{}

//########		SERVICES
@Service class  Address     extends  GenericService<AddressM     > implements IAddress {@Override public AddressM      getField(){ return new AddressM     (); } }
@Service class  City        extends  GenericService<CityM        > implements IAddress {@Override public CityM         getField(){ return new CityM        (); } }
@Service class  PostalCode  extends  GenericService<PostalCodeM  > implements IAddress {@Override public PostalCodeM   getField(){ return new PostalCodeM  (); } }
                                
@Service class  Date        extends  GenericService<DateM        > implements IUser {@Override public DateM         getField(){ return new DateM        (); } }
@Service class  Email       extends  GenericService<EmailM       > implements IUser {@Override public EmailM        getField(){ return new EmailM       (); } }
@Service class  UserINFO    extends  GenericService<UserM        > implements IUser {@Override public UserM         getField(){ return new UserM        (); } }

@Service class  Brand       extends  GenericService<BrandM       >{@Override public BrandM        getField(){ return new BrandM       (); } }
@Service class  Category    extends  GenericService<CategoryM    >{@Override public CategoryM     getField(){ return new CategoryM    (); } }
@Service class  Color       extends  GenericService<ColorM       >{@Override public ColorM        getField(){ return new ColorM       (); } }
@Service class  Material    extends  GenericService<MaterialM    >{@Override public MaterialM     getField(){ return new MaterialM    (); } }
@Service class  Product     extends  GenericService<ProductM     >{@Override public ProductM      getField(){ return new ProductM     (); } }
@Service class  ProductType extends  GenericService<ProductTypeM >{@Override public ProductTypeM  getField(){ return new ProductTypeM (); } }
@Service class  Reserve    	extends  GenericService<ReserveM     >{@Override public ReserveM      getField(){ return new ReserveM     (); } }
@Service class  Sex         extends  GenericService<SexM         >{@Override public SexM          getField(){ return new SexM         (); } }
@Service class  Size        extends  GenericService<SizeM        >{@Override public SizeM         getField(){ return new SizeM        (); } }
@Service class  Type        extends  GenericService<TypeM        >{@Override public TypeM         getField(){ return new TypeM        (); } }
@Service class  Transaction extends  GenericService<TransactionM >{@Override public TransactionM  getField(){ return new TransactionM (); } }
@Service class  Order       extends  GenericService<OrderM       >{@Override public OrderM        getField(){ return new OrderM       (); } }
@Service class  Invoice     extends  GenericService<InvoiceM     >{@Override public InvoiceM      getField(){ return new InvoiceM     (); } }


@Service class  Boots       extends  GenericService<BootsM       > implements IProduct {@Override public BootsM        getField(){ return new BootsM       (); } }
@Service class  Hoodie      extends  GenericService<HoodieM      > implements IProduct {@Override public HoodieM       getField(){ return new HoodieM      (); } }
@Service class  Jacket      extends  GenericService<JacketM      > implements IProduct {@Override public JacketM       getField(){ return new JacketM      (); } }
@Service class  Pants       extends  GenericService<PantsM       > implements IProduct {@Override public PantsM        getField(){ return new PantsM       (); } }
@Service class  Sweater     extends  GenericService<SweaterM     > implements IProduct {@Override public SweaterM      getField(){ return new SweaterM     (); } }
@Service class  Shirt       extends  GenericService<ShirtM       > implements IProduct {@Override public ShirtM        getField(){ return new ShirtM       (); } }
                                                                     
