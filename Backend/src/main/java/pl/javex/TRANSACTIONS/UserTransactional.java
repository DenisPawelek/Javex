package pl.javex.TRANSACTIONS;

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

@Component
public class UserTransactional {

	@Autowired JpaRepository<UserM,			Long> r_user;	
	@Autowired JpaRepository<EmailM,		Long> r_email;	
	@Autowired JpaRepository<DateM,			Long> r_date;	
	
	@Autowired AddressTransactional at;
	
	@Transactional
	public List<String> tryRegister(StructTU userStruct){

		List<String> ss = new ArrayList<String>();
		
		UserM user = new UserM();
		
		user.setUserName(userStruct.getUser().getUserName());
		
		Example<UserM> userExample = Example.of(user, ExampleMatcher.matchingAny());
		
		if(r_user.exists(userExample)){ss.add("not null"); return ss;}
		
		user = userStruct.getUser();
		
		
		Example<EmailM> emailExample = Example.of(userStruct.getEmail());
		if(r_email.exists(emailExample)) {ss.add("email exists"); return ss;}
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
		
		r_user.save(user);

		return ss;
	}
	
}