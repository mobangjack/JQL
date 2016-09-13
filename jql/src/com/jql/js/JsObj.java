/**
 * Copyright (c) 2011-2015, Mobangjack 莫帮杰 (mobangjack@foxmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jql.js;

import java.util.LinkedHashMap;
import java.util.Map;

import com.jql.syntax.KeyValuePairs;

/**
 * JSON Object.
 * @author 帮杰
 *
 */
public class JsObj {

	Map<String, Object> map = new LinkedHashMap<String, Object>();
	
	public JsObj() {}

	public JsObj put(String k,Object v) {
		map.put(k, v);
		return this;
	}
	
	public JsObj putAll(Map<String, Object> map) {
		map.putAll(map);
		return this;
	}
	
	public JsObj remove(String k) {
		map.remove(k);
		return this;
	}
	
	public JsObj remove(String k,Object v) {
		map.remove(k, v);
		return this;
	}
	
	public JsObj clear() {
		map.clear();
		return this;
	}
	
	public Object get(String k) {
		return map.get(k);
	}
	
	public Map<String, Object> map() {
		return map;
	}
	
	@Override
	public String toString() {
		if(map==null||map.isEmpty()){
			return "null";
		}
		KeyValuePairs kvps = new KeyValuePairs().setKeyQuote("\"").setEqualSymbol(":").setSeperator(",");
		for(Map.Entry<String, Object> e:map.entrySet()){
			if(JsTypeUtil.needQuote(e.getValue())){
				kvps.add(e.getKey(), "\""+e.getValue()+"\"");
			}else {
				kvps.add(e.getKey(), e.getValue());
			}
		}
		return "{"+kvps+"}";
	}
	
	public JsObj parse(String jsObj) {
		return JsParser.parseJsObj(jsObj);
	}
	
}
