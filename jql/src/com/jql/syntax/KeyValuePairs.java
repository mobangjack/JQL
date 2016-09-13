/**
 * Copyright (c) 2011-2015, Mobangjack 莫帮�? (mobangjack@foxmail.com).
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
package com.jql.syntax;

import java.util.Map;

/**
 * KeyValuePairs that helps construct sql sentences.
 * @author 帮杰
 *
 */
public class KeyValuePairs {

	protected String keyQuote = "";
	protected String valQuote = "";
	protected String equalSymbol = "=";
	protected String seperator = ",";
	protected StringBuilder sb = new StringBuilder();
	
	public KeyValuePairs() {}
	
	public KeyValuePairs(String keyQuote,String valQuote,String seperator) {
		this.keyQuote = keyQuote;
		this.valQuote = valQuote;
		this.seperator = seperator;
	}
	
	public KeyValuePairs(String keyQuote,String valQuote,String equalSymbol,String seperator) {
		this.keyQuote = keyQuote;
		this.valQuote = valQuote;
		this.equalSymbol = equalSymbol;
		this.seperator = seperator;
	}
	
	public KeyValuePairs(Map<String, Object> map) {
		this();
		add(map);
	}
	
	public KeyValuePairs add(String key,Object val) {
		if(sb.length()>0)
			sb.append(seperator).append(keyQuote).append(key).append(keyQuote).append(equalSymbol).append(valQuote).append(val).append(valQuote);
		else
			sb.append(keyQuote).append(key).append(keyQuote).append(equalSymbol).append(valQuote).append(val).append(valQuote);
		return this;
	}

	public KeyValuePairs add(Map<String, Object> map) {
		for(Map.Entry<String, Object> e:map.entrySet()){
			if(e.getValue()!=null)
				add(e.getKey(), e.getValue());
		}
		return this;
	}
	
	public String getKeyQuote() {
		return keyQuote;
	}

	public KeyValuePairs setKeyQuote(String keyQuote) {
		this.keyQuote = keyQuote;
		return this;
	}

	public String getValQuote() {
		return valQuote;
	}

	public KeyValuePairs setValQuote(String valQuote) {
		this.valQuote = valQuote;
		return this;
	}

	public String getEqualSymbol() {
		return equalSymbol;
	}

	public KeyValuePairs setEqualSymbol(String equalSymbol) {
		this.equalSymbol = equalSymbol;
		return this;
	}

	public String getSeperator() {
		return seperator;
	}

	public KeyValuePairs setSeperator(String seperator) {
		this.seperator = seperator;
		return this;
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}
	
	public boolean isEmpty() {
		return sb.length()<1;
	}
	
}
