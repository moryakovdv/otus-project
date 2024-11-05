/*
 * Copyright 2012-2014 the original author or authors.
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

package otus.moryakovdv.meteoapi;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest()
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"otus.moryakovdv.meteoservices.service", "otus.moryakovdv.meteoservices.rabbit"})
class ApplicationMockingTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired ApplicationContext context;
	
	@Test
	void testMocks() {
		
		assertNotNull(mockMvc);
		assertNotNull(context);
		
	}
	
	
	
}
