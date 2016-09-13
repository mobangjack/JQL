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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JsParser parses JsObj or JsArr from JSON String.
 * @author 帮杰
 *
 */
public class JsParser {

	public static JsObj parseJsObj(String json) {
		if(json==null)
			return null;
		json = json.trim();
		Pattern p = Pattern.compile("(\"\\w+\"):(\"[^\"]+\")");  
        Matcher m = p.matcher(json);
        if(!m.matches())
        	return null;
        JsObj jsObj = new JsObj();
        while(m.find()) {
        	String[] kv = m.group().split(":");
        	if(kv.length==2){
        		JsObj jo = parseJsObj(kv[1]);
                if(jo!=null){
                	jsObj.put(kv[0], jo);
                }else {
                	JsArr ja = parseJsArr(kv[1]);
                	if(ja!=null){
                		jsObj.put(kv[0], ja);
                	}else {
                		jsObj.put(kv[0], kv[1]);
					}
    			}
        	}
        }  
		return jsObj;
	}
	
	public static JsArr parseJsArr(String json) {
		if(json==null)
			return null;
		json = json.trim();
		Pattern p = Pattern.compile("(\"[^\"]+\")");  
        Matcher m = p.matcher(json);
        if(!m.matches())
        	return null;
        JsArr jsArr = new JsArr();
        while(m.find()) {
        	String item = m.group();
        	JsObj jsObj = parseJsObj(item);
            if(jsObj!=null){
            	jsArr.add(jsObj);
            }else {
				jsArr.add(item);
			}
        }  
		return jsArr;
	}

}
