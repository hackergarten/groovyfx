/*
* Copyright 2012 the original author or authors.
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

/**
 * Showing how multiple effects can be chained via the 'input' property or through groups
 * @author Dierk Koenig
 */

import static groovyx.javafx.GroovyFX.start

start {
    stage title: "Chained Effects Demo", width: 450, height: 300, visible: true, {
        scene fill: groovyblue, {
            //simple
            rectangle x:10, y:10, width:100, height:100, fill:whitesmoke, {
                effect dropShadow(color: yellow, input: innerShadow(color: groovyblue))
            }
            // changing the sequence leads to different results
            rectangle x:120, y:10, width:100, height:100, fill:whitesmoke, {
                effect innerShadow(color: groovyblue, input: dropShadow(color: yellow))
            }
            // chaining by using groups
            group {
                rectangle x:230, y:10, width:100, height:100, fill:whitesmoke, {
                    effect innerShadow(color: groovyblue)
                }
                effect dropShadow(color: yellow)
            }
            // changing the effects at runtime
            def inner = innerShadow(color: groovyblue)
            def outer = dropShadow(color:yellow)
            rectangle id: 'interactive', x:340, y:10, width:100, height:100, fill:whitesmoke, {
                effect outer
                onMouseEntered { outer.input = inner }
                onMouseExited  { outer.input = null  }
                onMouseClicked { interactive.effect = reflection(input: outer) }
            }
        }
    }
}


