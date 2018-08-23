package org.litespring.service.v2;

import org.litespring.dao.v2.AccountDao;
import org.litespring.dao.v2.ItemDao;

public class PetStoreService {
	private AccountDao account;
	private ItemDao item;
	
	
	
	public PetStoreService() {
		super();
	}
	
	
	public PetStoreService(AccountDao account, ItemDao item) {
		super();
		this.account = account;
		this.item = item;
	}


	public AccountDao getAccount() {
		return account;
	}
	public void setAccount(AccountDao account) {
		this.account = account;
	}
	public ItemDao getItem() {
		return item;
	}
	public void setItem(ItemDao item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "PetStoreService [account=" + account + ", item=" + item + "]";
	}
	
	
	
	
}
