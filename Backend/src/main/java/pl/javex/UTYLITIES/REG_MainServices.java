package pl.javex.UTYLITIES;

import org.springframework.stereotype.Service;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import controllers.MainController;
import pl.javex.MODELS.*;
import services.MainService;
import pl.javex.TRANSACTIONS.__INTERFACES.IAddress;
import pl.javex.TRANSACTIONS.__INTERFACES.IProduct;
import pl.javex.TRANSACTIONS.__INTERFACES.IUser;
@RestController("MainReg")
public class REG_MainServices extends MainController {
}

//########		SERVICES

//@Service class  MAddress     extends  MainService<AddressM     >{}
//@Service class  MBoots       extends  MainService<BootsM       >{}
//@Service class  MBrand       extends  MainService<BrandM       >{}
//@Service class  MCategory    extends  MainService<CategoryM    >{}
//@Service class  MCity        extends  MainService<CityM        >{}
//@Service class  MColor       extends  MainService<ColorM       >{}
//@Service class  MDate        extends  MainService<DateM        >{}
//@Service class  MDescription extends  MainService<DescriptionM >{}
//@Service class  MEmail       extends  MainService<EmailM       >{}
//@Service class  MHoodie      extends  MainService<HoodieM      >{}
//@Service class  MJacket      extends  MainService<JacketM      >{}
//@Service class  MMaterial    extends  MainService<MaterialM    >{}
//@Service class  MPants       extends  MainService<PantsM       >{}
//@Service class  MPostalCode  extends  MainService<PostalCodeM  >{}
//@Service class  MProduct     extends  MainService<ProductM     >{}
//@Service class  MProductType extends  MainService<ProductTypeM >{}
//@Service class  MSex         extends  MainService<SexM         >{}
//@Service class  MShirt       extends  MainService<ShirtM       >{}
//@Service class  MSize        extends  MainService<SizeM        >{}
//@Service class  MSweater     extends  MainService<SweaterM     >{}
//@Service class  MType        extends  MainService<TypeM        >{}
//@Service class  MUser        extends  MainService<UserM        >{}
//

//@Service class  AccesAddress     extends  MainService<AddressM     >  {@Override public AddressM      getField(){ return new AddressM     (); } }
//@Service class  AccesCity        extends  MainService<CityM        >  {@Override public CityM         getField(){ return new CityM        (); } }
//@Service class  AccesPostalCode  extends  MainService<PostalCodeM  >  {@Override public PostalCodeM   getField(){ return new PostalCodeM  (); } }//
//@Service class  AccesDate        extends  MainService<DateM        >  {@Override public DateM         getField(){ return new DateM        (); } }
//@Service class  AccesEmail       extends  MainService<EmailM       >  {@Override public EmailM        getField(){ return new EmailM       (); } }
@Service class  AccesBrand       extends  MainService<BrandM       >  {@Override public BrandM        getField(){ return new BrandM       (); } }
@Service class  AccesCategory    extends  MainService<CategoryM    >  {@Override public CategoryM     getField(){ return new CategoryM    (); } }
@Service class  AccesColor       extends  MainService<ColorM       >  {@Override public ColorM        getField(){ return new ColorM       (); } }
@Service class  AccesMaterial    extends  MainService<MaterialM    >  {@Override public MaterialM     getField(){ return new MaterialM    (); } }
@Service class  AccesProduct     extends  MainService<ProductM     >  {@Override public ProductM      getField(){ return new ProductM     (); } }
@Service class  AccesProductType extends  MainService<ProductTypeM >  {@Override public ProductTypeM  getField(){ return new ProductTypeM (); } }
@Service class  AccesReserve     extends  MainService<ReserveM     >  {@Override public ReserveM      getField(){ return new ReserveM     (); } }
@Service class  AccesSex         extends  MainService<SexM         >  {@Override public SexM          getField(){ return new SexM         (); } }
@Service class  AccesSize        extends  MainService<SizeM        >  {@Override public SizeM         getField(){ return new SizeM        (); } }
@Service class  AccesType        extends  MainService<TypeM        >  {@Override public TypeM         getField(){ return new TypeM        (); } }
//@Service class  AccesTransaction extends  MainService<TransactionM >  {@Override public TransactionM  getField(){ return new TransactionM (); } }
//@Service class  AccesOrder       extends  MainService<OrderM       >  {@Override public OrderM        getField(){ return new OrderM       (); } }
//@Service class  AccesInvoice     extends  MainService<InvoiceM     >  {@Override public InvoiceM      getField(){ return new InvoiceM     (); } }
@Service class  AccesBoots       extends  MainService<BootsM       >  {@Override public BootsM        getField(){ return new BootsM       (); } }
@Service class  AccesHoodie      extends  MainService<HoodieM      >  {@Override public HoodieM       getField(){ return new HoodieM      (); } }
@Service class  AccesJacket      extends  MainService<JacketM      >  {@Override public JacketM       getField(){ return new JacketM      (); } }
@Service class  AccesPants       extends  MainService<PantsM       >  {@Override public PantsM        getField(){ return new PantsM       (); } }
@Service class  AccesSweater     extends  MainService<SweaterM     >  {@Override public SweaterM      getField(){ return new SweaterM     (); } }
@Service class  AccesShirt       extends  MainService<ShirtM       >  {@Override public ShirtM        getField(){ return new ShirtM       (); } }
      
