/*
* Copyright 2011 the original author or authors.
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



import static groovyx.javafx.GroovyFX.start
import javafx.scene.Scene;

/**
 *
 * @author jimclarke
 */
start {
    stage(title: "Circle (bind)  Demo", x: 100, y: 100, visible: true, style: "decorated", primary: true) {
        scene(id: "sc", fill: GROOVYBLUE, width: 400, height: 400) {
            circle( radius: bind(sc.width()/4.0), 
                    centerX: bind(sc.width()/2.0), 
                    centerY: bind(sc.height()/2.0)
            ) {
                fill yellow
            }
        }
    }
}

