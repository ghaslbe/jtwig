/**
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

package org.jtwig.acceptance.issues;

import org.jtwig.AbstractJtwigTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.jtwig.util.SyntacticSugar.*;

public class Issue86Test extends AbstractJtwigTest {

    @Test
    public void issue86() throws Exception {
        withResource("{{ -1 }}");
        then(theResult(), is(equalTo("-1")));
    }
    @Test
    public void issue86WithConstant() throws Exception {
        withResource("{{ 1-1 }}");
        then(theResult(), is(equalTo("0")));
    }
    @Test
    public void issue86WithVariable() throws Exception {
        given(theModel().withModelAttribute("value", 1));
        withResource("{{ value-1 }}");
        then(theResult(), is(equalTo("0")));
    }
    @Test
    public void issue86WithVariableUnary() throws Exception {
        given(theModel().withModelAttribute("value", -1));
        withResource("{{ -value }}");
        then(theResult(), is(equalTo("1")));
    }
}
