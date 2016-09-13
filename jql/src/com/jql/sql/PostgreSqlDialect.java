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
 * PostgreSqlDialect for PostgreSql data base server.
 * @author 帮杰
 *
 */
public class PostgreSqlDialect extends DefaultDialect {

	@Override
	public String paginate(String table, Map<String, Object> map,
			int pageNumber, int pageSize,List<Object> params) {
		int offset = pageSize * (pageNumber - 1);
		String limit = " limit "+pageSize+" offset "+offset;
		return select(table, map, params)+limit;
	}
}
