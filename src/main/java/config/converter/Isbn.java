package config.converter;

import lombok.Data;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
public class Isbn {
	private String isbn;

	public Isbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}

}
