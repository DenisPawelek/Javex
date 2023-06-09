package pl.javex.TRANSACTIONS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.javex.MODELS.DateM;
import pl.javex.MODELS.EmailM;
import pl.javex.MODELS.UserM;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTU;
import pl.javex.TRANSACTIONS.__ERROR_TYPES.E_EmailAlreadyTaken;
import pl.javex.TRANSACTIONS.__ERROR_TYPES.E_UserNameTaken;

import pl.javex.UTYLITIES.CODER;


@Component
public class UserTransactional {

	@Autowired JpaRepository<UserM,			Long> r_user;	
	@Autowired JpaRepository<EmailM,		Long> r_email;	
	@Autowired JpaRepository<DateM,			Long> r_date;	
	
	@Autowired AddressTransactional at;
	
	@Transactional
	public List<String> tryRegister(StructTU userStruct) throws SQLException{

		List<String> ss = new ArrayList<String>();
		
		UserM user = new UserM();
		
		user.setUsername(userStruct.getUser().getUsername());
		
		Example<UserM> userExample = Example.of(user, ExampleMatcher.matchingAny());
		
		
		if(r_user.exists(userExample)){throw new E_UserNameTaken("User of that name already exists", new Exception());}
		
		user = userStruct.getUser();
		
		
		Example<EmailM> emailExample = Example.of(userStruct.getEmail());
		if(r_email.exists(emailExample)) { throw new E_EmailAlreadyTaken("There already exists accont connected with given email address", new Exception());}
		user.setEmail(r_email.save(userStruct.getEmail()));
		
		DateM birthDate = new DateM();
		birthDate.setDate(userStruct.getBirth());
		
		Example<DateM> birthDateExample = Example.of(birthDate);
		Optional<DateM> birthDateOptional = r_date.findOne(birthDateExample);
		
		if(birthDateOptional.isPresent()) {user.setUserBd(birthDateOptional.get());}
		else {user.setUserBd(r_date.save(birthDate));}

		DateM joinDate = new DateM();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Date d = cal.getTime();
	
		
		joinDate.setDate(d);
		
		Example<DateM> joinDateExample = Example.of(joinDate);
		Optional<DateM> joinDateOptional = r_date.findOne(joinDateExample);
		
		if(joinDateOptional.isPresent()) {user.setUserJd(joinDateOptional.get());}
		else {user.setUserJd(r_date.save(joinDate));}
		
		
		user.setUserAddress(at.addAddress(userStruct.getAddressStruct()));
		user.setPassword(CODER._GET_INSTANCE().getCoder().encode(user.getPassword()));
		user.setRole("ROLE_USER");
		r_user.save(user);

		return ss;
	}
	
}