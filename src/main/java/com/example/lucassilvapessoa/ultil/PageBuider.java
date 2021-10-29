package com.example.lucassilvapessoa.ultil;

import org.springframework.data.domain.PageRequest;

public class PageBuider {
   
	private int page = 0;
    private	int size = 10;
    
    public PageBuider PageBuider() {
      return this;	
    }
    
    public PageBuider setPage(int page) {
       this.page = page;
       return this;
    }
    
    public PageRequest buid() {
       return PageRequest.of(page, size);	
    }
}
