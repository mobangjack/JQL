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

/**
 * JsTypeUtil helps to determine whether the value Object should be quoted or not.
 * @author 帮杰
 *
 */
public class JsTypeUtil {

	static boolean isBool(Object e) {
		if(e instanceof String){
			return Boolean.valueOf(e.toString());
		}
		return (e instanceof Boolean);
	}
	
	static boolean isShort(Object e) {
		if(e instanceof Short){
			return true;
		}
		if(e instanceof String){
			try {
				Short.parseShort(e.toString());
				return true;
			} catch (Exception ex) {}
		}
		return false;
	}
	
	static boolean isInt(Object e) {
		if(e instanceof Integer){
			return true;
		}
		if(e instanceof String){
			try {
				Integer.parseInt(e.toString());
				return true;
			} catch (Exception ex) {}
		}
		return false;
	}
	
	static boolean isLong(Object e) {
		if(e instanceof Long){
			return true;
		}
		if(e instanceof String){
			try {
				Long.parseLong(e.toString());
				return true;
			} catch (Exception ex) {}
		}
		return false;
	}
	
	static boolean isFloat(Object e) {
		if(e instanceof Float){
			return true;
		}
		if(e instanceof String){
			try {
				Float.parseFloat(e.toString());
				return true;
			} catch (Exception ex) {}
		}
		return false;
	}
	
	static boolean isDouble(Object e) {
		if(e instanceof Double){
			return true;
		}
		if(e instanceof String){
			try {
				Double.parseDouble(e.toString());
				return true;
			} catch (Exception ex) {}
		}
		return false;
	}
	
	static boolean isJsObj(Object e) {
		if(e instanceof JsObj)
			return true;
		if(e instanceof String){
			return JsParser.parseJsObj(e.toString())!=null;
		}
		return false;
	}
	
	static boolean isJsArr(Object e) {
		if(e instanceof JsArr)
			return true;
		if(e instanceof String){
			return JsParser.parseJsArr(e.toString())!=null;
		}
		return false;
	}

	static boolean needQuote(Object e) {
		if(e==null)
			return false;
		if(isBool(e)||isInt(e)||isLong(e)||isFloat(e)||isDouble(e)||isShort(e)||isJsObj(e)||isJsArr(e))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Integer integer = null;
		try {
			integer = Integer.parseInt("1.2");
			System.out.println("123");
		} catch (Exception e) {
			System.out.println(integer);
		}
	}
}
