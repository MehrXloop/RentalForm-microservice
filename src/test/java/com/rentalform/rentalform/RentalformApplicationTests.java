package com.rentalform.rentalform;

import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.rentalform.rentalform.controller.RentalFormController;
import com.rentalform.rentalform.model.RentalForm;
import com.rentalform.rentalform.repository.RentalFormRepository;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
class RentalformApplicationTests {
	private MockMvc mvc;
	@Mock
	private RentalFormRepository rentalFormRepository;

	@InjectMocks
	private RentalFormController rentalFormController;

	private JacksonTester<RentalForm> jsonRentalForm;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(rentalFormController).build();
	}

	// testing that user data is posting
	@Test
	public void canAddUserData() throws Exception {

		RentalForm newForm = new RentalForm(1L, 2L, "Mehr", "03350258417",
				"clifton x-loop office", "123456", null, null,200000);
		when(rentalFormRepository.save(newForm)).thenReturn((newForm));
		mvc.perform(MockMvcRequestBuilders
		.post("/rentalForm/add")
		.contentType(MediaType.APPLICATION_JSON)
		.content(jsonRentalForm.write(newForm).getJson()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
