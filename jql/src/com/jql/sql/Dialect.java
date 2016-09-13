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
package com.jql.sql;

import java.util.List;
import java.util.Map;

/**
 * Dialect interface.
 * @author 帮杰
 *
 */

public abstract class Dialect {
	
	public abstract String insert(String table,Map<String, Object> map,List<Object> params);
	
	public abstract String delete(String table,Map<String, Object> map,List<Object> params);
	
	public abstract String update(String table,Map<String, Object> target,Map<String, Object> replacement,List<Object> params);
	
	public abstract String select(String table,Map<String, Object> map,List<Object> params);
	
	public abstract String paginate(String table,Map<String, Object> map,int pageNumber,int pageSize,List<Object> params);
	
	public abstract String count(String table,Map<String, Object> map,List<Object> params);
	
	public abstract String validate(String table,Map<String, Object> map,List<Object> params);
	
}
