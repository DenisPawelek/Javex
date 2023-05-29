package pl.javex.TRANSACTIONS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.javex.MODELS.AddressM;
import pl.javex.MODELS.DateM;
import pl.javex.MODELS.DescriptionM;
import pl.javex.MODELS.OrderM;
import pl.javex.MODELS.ReserveM;
import pl.javex.MODELS.TransactionM;
import pl.javex.MODELS.UserM;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTT;
import pl.javex.TRANSACTIONS.__ERROR_TYPES.E_NoSuchProductReserve;
import pl.javex.TRANSACTIONS.__ERROR_TYPES.E_NoSuchUser;
import pl.javex.TRANSACTIONS.__ERROR_TYPES.E_OrderAmountTooLarge;

@Component
public class TransactionTransactional {

	@Autowired JpaRepository<TransactionM,	Long> r_transaction;
	@Autowired JpaRepository<UserM,			Long> r_user;
	@Autowired JpaRepository<DateM,			Long> r_date;
	@Autowired JpaRepository<DescriptionM,	Long> r_description;
	@Autowired JpaRepository<OrderM,		Long> r_order;
	@Autowired JpaRepository<ReserveM,		Long> r_reserve;
	
	@Autowired AddressTransactional at;
	
	@Transactional
	public List<String> tryRegisterTransaction(StructTT transactionStruct) throws SQLException{
		
		List<String> ss = new ArrayList<String>();
		
		Optional<UserM> user = r_user.findById(transactionStruct.getUser().getId());
		
		if(user.isEmpty()) { throw new E_NoSuchUser("User undefined", new Exception());}
		for(OrderM order : transactionStruct.getOrders()) {
			
			Optional<ReserveM> reserve = r_reserve.findById(order.getReserve().getId());
			if(reserve.isEmpty()) throw new E_NoSuchProductReserve("Given reserve does not exist", new Exception());
			if(reserve.get().getAmount() - order.getAmount() < 0) throw new E_OrderAmountTooLarge("Order amount exceeds reserve" + order.getReserve().getProduct().getName(), new Exception());
			reserve.get().setAmount(reserve.get().getAmount() - order.getAmount());
			order.setPriceUnitDiscounted(reserve.get().getProduct().getPrice());
			order.setPriceUnitRaw(reserve.get().getProduct().getPrice());
			r_reserve.save(reserve.get());
		}
		AddressM address = at.addAddress(transactionStruct.getAddressStruct());
		
		DateM date = new DateM();
		date.setDate(transactionStruct.getDate());
		Optional<DateM> d = r_date.findOne(Example.of(date));
		if(d.isEmpty()) date = r_date.save(date);
		else date = d.get();
		
		DescriptionM desc = r_description.save(transactionStruct.getDesc());
		
		TransactionM transaction = new TransactionM();
		transaction.setAddress(address);
		transaction.setDate(date);
		transaction.setDescription(desc);
		transaction.setUser(user.get());
		
		transaction = r_transaction.save(transaction);
		
		for(OrderM order : transactionStruct.getOrders()) {
			order.setTransaction(transaction);
			r_order.save(order);
		}
		
		
		return ss;
		
	}
	
}
