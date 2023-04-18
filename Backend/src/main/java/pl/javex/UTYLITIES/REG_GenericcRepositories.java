package pl.javex.UTYLITIES;

import org.springframework.data.jpa.repository.JpaRepository;

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
import pl.javex.MODELS.InvoiceM;
import pl.javex.MODELS.JacketM;
import pl.javex.MODELS.MaterialM;
import pl.javex.MODELS.OrderM;
import pl.javex.MODELS.PantsM;
import pl.javex.MODELS.PostalCodeM;
import pl.javex.MODELS.ProductM;
import pl.javex.MODELS.ProductTypeM;
import pl.javex.MODELS.SexM;
import pl.javex.MODELS.ShirtM;
import pl.javex.MODELS.SizeM;
import pl.javex.MODELS.SweaterM;
import pl.javex.MODELS.TransactionM;
import pl.javex.MODELS.TypeM;
import pl.javex.MODELS.UserM;

/**
 * Klasa służąca do rejestrowania interfejsów repozytoriów rozszerzających {@link JpaRepository}
 */
public class REG_GenericcRepositories {}
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

