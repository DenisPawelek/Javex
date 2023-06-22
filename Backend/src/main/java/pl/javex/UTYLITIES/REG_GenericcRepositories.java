package pl.javex.UTYLITIES;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.javex.MODELS.AddressM;
import pl.javex.MODELS.BootsM;
import pl.javex.MODELS.BrandM;
import pl.javex.MODELS.CategoryM;
import pl.javex.MODELS.CityM;
import pl.javex.MODELS.ColorM;
import pl.javex.MODELS.DateM;
//import pl.javex.MODELS.DescriptionM;
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
import pl.javex.MODELS.ReserveM;
import pl.javex.MODELS.SexM;
import pl.javex.MODELS.ShirtM;
import pl.javex.MODELS.SizeM;
import pl.javex.MODELS.SweaterM;
import pl.javex.MODELS.TransactionM;
import pl.javex.MODELS.TypeM;
import pl.javex.MODELS.UserM;

import pl.javex.__CUSTOM_REPOS.SelectProductsBy_Repo;

/**
 * Klasa służąca do rejestrowania interfejsów repozytoriów rozszerzających {@link JpaRepository}
 */
public class REG_GenericcRepositories {}
//########		REPOS
interface RepoProduct     extends SelectProductsBy_Repo<ProductM      , Long>{}


interface RepoBoots       extends SelectProductsBy_Repo<BootsM        , Long>{}
interface RepoHoodie      extends SelectProductsBy_Repo<HoodieM       , Long>{}
interface RepoJacket      extends SelectProductsBy_Repo<JacketM       , Long>{}
interface RepoPants       extends SelectProductsBy_Repo<PantsM        , Long>{}
interface RepoShirt       extends SelectProductsBy_Repo<ShirtM        , Long>{}
interface RepoSweater     extends SelectProductsBy_Repo<SweaterM      , Long>{}


interface RepoAddress     extends JpaRepository<AddressM      , Long>{}
interface RepoBrand       extends JpaRepository<BrandM        , Long>{}
interface RepoCategory    extends JpaRepository<CategoryM     , Long>{}
interface RepoCity        extends JpaRepository<CityM         , Long>{}
interface RepoColor       extends JpaRepository<ColorM        , Long>{}
interface RepoDate        extends JpaRepository<DateM         , Long>{}
interface RepoEmail       extends JpaRepository<EmailM        , Long>{}
interface RepoMaterial    extends JpaRepository<MaterialM     , Long>{}
interface RepoPostalCode  extends JpaRepository<PostalCodeM   , Long>{}
interface RepoProductType extends JpaRepository<ProductTypeM  , Long>{}
interface RepoReserve     extends JpaRepository<ReserveM      , Long>{}
interface RepoSex         extends JpaRepository<SexM          , Long>{}
interface RepoSize        extends JpaRepository<SizeM         , Long>{}
interface RepoType        extends JpaRepository<TypeM         , Long>{}
interface RepoUser        extends JpaRepository<UserM         , Long>{}
interface RepoTransaction extends JpaRepository<TransactionM  , Long>{}
interface RepoOrder		  extends JpaRepository<OrderM  	  , Long>{}
interface RepoInvoice	  extends JpaRepository<InvoiceM  	  , Long>{}

