package com.samsonSiba.moms.model;
import java.time.LocalDate;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


//import lombok.Data;
//
//@Data //  @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor 한번에 제공, setter 로 인한 문제 발생가능

@ToString(exclude="")
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EqualsAndHashCode(of= {"id"})
@Entity
@Table(name="account_book")
public class AccountBook {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임
	private long id;
	
	@Column(name="item_name", nullable=false)
	private String itemName;

	@Column(name="count", nullable=false)
	private int count;
	
	@Column(name="total_price", nullable=false)
	private int total_price;
	
	@Column(name="expenditure_date", nullable=false)
	private LocalDate expenditureDate;
	
	@Column(name="register_ymdt", nullable=false)
	private Timestamp registerYmdt;
	
	@Column(name="update_ymdt", nullable=false)
	private Timestamp updateYmdt;
	
	
	@Builder
	public AccountBook(long id, String itemName, int count, int total_price, 
			LocalDate expenditure_date, Timestamp register_ymdt, Timestamp update_ymdt ) {
		this.id=id;
		this.itemName=itemName;
		this.count=count;
		this.total_price=total_price;
		this.expenditureDate= expenditure_date;
		this.registerYmdt = register_ymdt;
		this.updateYmdt = update_ymdt;
	}

	@Override
	public String toString() {
		return "AccountBook [id=" + id + ", itemName=" + itemName + ", count=" + count + ", total_price=" + total_price
				+ ", expenditure_date=" + expenditureDate + ", register_ymdt=" + registerYmdt + ", update_ymdt="
				+ updateYmdt + "]";
	}
	

	
}
