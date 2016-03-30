package com.cjw.common.utils;

import java.util.Collection;

public class CollectionUtils {

	public static <T> boolean isEmpty(Collection<T> values){
		return ((values == null || values.size() == 0) ? true : false);
	}
}
