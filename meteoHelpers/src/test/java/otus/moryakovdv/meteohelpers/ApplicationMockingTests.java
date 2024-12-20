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

package otus.moryakovdv.meteohelpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import otus.moryakovdv.meteohelpers.service.PasswordHasher;


@SpringBootTest(classes = {otus.moryakovdv.meteohelpers.web.HelperController.class})
@AutoConfigureMockMvc
class ApplicationMockingTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ApplicationContext context;
	
	private PasswordHasher hasher;

	
}
