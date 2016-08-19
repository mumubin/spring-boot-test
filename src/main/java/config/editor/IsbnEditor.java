package config.editor;

import config.converter.Isbn;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
//线程不安全,用Formatter吧
public class IsbnEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.hasText(text)) {
			setValue(new Isbn(text.trim()));
		}
		else {
			setValue(null);
		}
	}
	@Override
	public String getAsText() {
		Isbn isbn = (Isbn) getValue();
		if (isbn != null) {
			return isbn.getIsbn();
		}
		else {
			return "";
		}
	}

//	在相应的Controller下使用这个,即能使用编辑器
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(Isbn.class, new IsbnEditor());
//	}


}
