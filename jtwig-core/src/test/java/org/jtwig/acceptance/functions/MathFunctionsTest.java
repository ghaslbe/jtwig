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

package org.jtwig.acceptance.functions;

import org.jtwig.AbstractJtwigTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.jtwig.util.SyntacticSugar.then;
import static org.jtwig.util.SyntacticSugar.when;

public class MathFunctionsTest extends AbstractJtwigTest {
    @Test
    public void absTest() throws Exception {
        withResource("{{ abs(-1) }}");
        then(theResult(), is(equalTo("1")));
    }

    @Test
    public void roundTest() throws Exception {
        withResource("{{ round(1.12) }}");
        then(theResult(), is(equalTo("1")));
    }
    @Test
    public void roundCeilTest() throws Exception {
        withResource("{{ round(1.12, 'ceil') }}");
        then(theResult(), is(equalTo("2")));
    }
    @Test
    public void roundFloorTest() throws Exception {
        withResource("{{ round(1.62, 'floor') }}");
        then(theResult(), is(equalTo("1")));
    }
}
