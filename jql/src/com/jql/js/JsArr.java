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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jql.syntax.Values;

/**
 * JSON Array.
 * @author 帮杰
 *
 */
public class JsArr {

	private String name;
	private List<Object> list = new ArrayList<Object>();
	
	public JsArr(){}
	
	public JsArr(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public JsArr add(Object e) {
		list.add(e);
		return this;
	}
	
	public JsArr addAll(List<Object> list) {
		Collections.addAll(list, list.toArray());
		return this;
	}
	
	public JsArr add(int i,Object e) {
		list.add(i, e);
		return this;
	}
	
	public JsArr remove(Object e) {
		list.remove(e);
		return this;
	}
	
	public JsArr remove(int i) {
		list.remove(i);
		return this;
	}
	
	public Object get(int i) {
		return list.get(i);
	}
	
	public List<Object> list() {
		return list;
	}
	
	@Override
	public String toString() {
		if(list==null||list.isEmpty()){
			return "\""+name+"\":null";
		}else {
			Values vals = new Values().setQuote("").setSeperator(",");
			for(Object e:list){
				if(JsTypeUtil.needQuote(e)){
					vals.add("\""+e+"\"");
				}else {
					vals.add(e);
				}
			}
			return "\""+name+"\":["+vals+"]";
		}
	}

	public JsArr parse(String jsArr) {
		return JsParser.parseJsArr(jsArr);
	}
	
}
