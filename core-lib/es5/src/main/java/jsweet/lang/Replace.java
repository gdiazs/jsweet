/* 
 * JSweet - http://www.jsweet.org
 * Copyright (C) 2015 CINCHEO SAS <renaud.pawlak@cincheo.fr>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jsweet.lang;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation allows the programmer to substitute a method body
 * implementation by a TypeScript implementation.
 * 
 * <p>
 * The annotation's value contains TypeScript which is generated as is by the
 * JSweet transpiler. The code will be checked by the TypeScript transpiler.
 * 
 * <p>
 * The replacing code can contain variables substituted using a mustache-like
 * convention ({{variableName}}). Here is the list of supported variables:
 * 
 * <ul>
 * <li>{{className}}: the current class.</li>
 * <li>{{methodName}}: the current method name.</li>
 * <li>{{body}}: the body of the current method. A typical use of this variable
 * is to wrap the original behavior in a lambda. For instance:
 * <code>[before code] let _result = () => { {{body}} }(); [after code] return result;</code>
 * </li>
 * <li>{{baseIndent}}: the indentation of the replaced method. Can be used to
 * generate well-formatted code.</li>
 * <li>{{indent}}: substituted with an indentation. Can be used to generate
 * well-formatted code.</li>
 * </ul>
 * 
 * @author Renaud Pawlak
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Replace {

    /**
     * The code that will be generated by the transpiler in place of the
     * annotated method body.
     */
    java.lang.String value();

}
