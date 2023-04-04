package pl.javex.UTYLITIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import controllers.MainController;
import pl.javex.MODELS.AddressM;
import pl.javex.MODELS.BootsM;
import pl.javex.MODELS.BrandM;
import pl.javex.MODELS.CategoryM;
import pl.javex.MODELS.CityM;
import pl.javex.MODELS.ColorM;
import pl.javex.MODELS.DateM;
import pl.javex.MODELS.DescriptionM;
import pl.javex.MODELS.EmailM;
import pl.javex.MODELS.HoodieM;
import pl.javex.MODELS.JacketM;
import pl.javex.MODELS.MaterialM;
import pl.javex.MODELS.PantsM;
import pl.javex.MODELS.PostalCodeM;
import pl.javex.MODELS.ProductM;
import pl.javex.MODELS.ProductTypeM;
import pl.javex.MODELS.SexM;
import pl.javex.MODELS.ShirtM;
import pl.javex.MODELS.SizeM;
import pl.javex.MODELS.SweaterM;
import pl.javex.MODELS.TypeM;
import pl.javex.MODELS.UserM;
import services.MainService;

@RestController("MainReg")
public class MainReg extends MainController{

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


//interface RepoMultiAddress     extends JpaRepository<AddressM      , Long>{}
//interface RepoMultiBoots       extends JpaRepository<BootsM        , Long>{}
//interface RepoMultiBrand       extends JpaRepository<BrandM        , Long>{}
//interface RepoMultiCategory    extends JpaRepository<CategoryM     , Long>{}
//interface RepoMultiCity        extends JpaRepository<CityM         , Long>{}
//interface RepoMultiColor       extends JpaRepository<ColorM        , Long>{}
//interface RepoMultiDate        extends JpaRepository<DateM         , Long>{}
//interface RepoMultiDescription extends JpaRepository<DescriptionM  , Long>{}
//interface RepoMultiEmail       extends JpaRepository<EmailM        , Long>{}
//interface RepoMultiHoodie      extends JpaRepository<HoodieM       , Long>{}
//interface RepoMultiJacket      extends JpaRepository<JacketM       , Long>{}
//interface RepoMultiMaterial    extends JpaRepository<MaterialM     , Long>{}
//interface RepoMultiPants       extends JpaRepository<PantsM        , Long>{}
//interface RepoMultiPostalCode  extends JpaRepository<PostalCodeM   , Long>{}
//interface RepoMultiProduct     extends JpaRepository<ProductM      , Long>{}
//interface RepoMultiProductType extends JpaRepository<ProductTypeM  , Long>{}
//interface RepoMultiSex         extends JpaRepository<SexM          , Long>{}
//interface RepoMultiShirt       extends JpaRepository<ShirtM        , Long>{}
//interface RepoMultiSize        extends JpaRepository<SizeM         , Long>{}
//interface RepoMultiSweater     extends JpaRepository<SweaterM      , Long>{}
//interface RepoMultiType        extends JpaRepository<TypeM         , Long>{}
//interface RepoMultiUser        extends JpaRepository<UserM         , Long>{}
//                                                             




//########		SERVICES

@Service class  MAddress     extends  MainService<AddressM     >{}
@Service class  MBoots       extends  MainService<BootsM       >{}
@Service class  MBrand       extends  MainService<BrandM       >{}
@Service class  MCategory    extends  MainService<CategoryM    >{}
@Service class  MCity        extends  MainService<CityM        >{}
@Service class  MColor       extends  MainService<ColorM       >{}
@Service class  MDate        extends  MainService<DateM        >{}
@Service class  MDescription extends  MainService<DescriptionM >{}
@Service class  MEmail       extends  MainService<EmailM       >{}
@Service class  MHoodie      extends  MainService<HoodieM      >{}
@Service class  MJacket      extends  MainService<JacketM      >{}
@Service class  MMaterial    extends  MainService<MaterialM    >{}
@Service class  MPants       extends  MainService<PantsM       >{}
@Service class  MPostalCode  extends  MainService<PostalCodeM  >{}
@Service class  MProduct     extends  MainService<ProductM     >{}
@Service class  MProductType extends  MainService<ProductTypeM >{}
@Service class  MSex         extends  MainService<SexM         >{}
@Service class  MShirt       extends  MainService<ShirtM       >{}
@Service class  MSize        extends  MainService<SizeM        >{}
@Service class  MSweater     extends  MainService<SweaterM     >{}
@Service class  MType        extends  MainService<TypeM        >{}
@Service class  MUser        extends  MainService<UserM        >{}





