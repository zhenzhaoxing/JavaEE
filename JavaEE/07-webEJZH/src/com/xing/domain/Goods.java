package com.xing.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter

	public class Goods {
		private Integer id;
		private String name;
		private Double price;

		@Override
		public String toString() {
			return "Goods [id=" + id + ", name=" + name + ", price=" + price + ",]";
		}
		
	
}