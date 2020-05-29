package com.lti.plutusloan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.plutusloan.dto.EligibilityDTO;
import com.lti.plutusloan.dto.EmiDTO;
import com.lti.plutusloan.dto.LoginDTO;
import com.lti.plutusloan.dto.RegistrationDTO;
import com.lti.plutusloan.entity.Registration;
import com.lti.plutusloan.entity.Car;
import com.lti.plutusloan.entity.Employment;
import com.lti.plutusloan.entity.Loan;
import com.lti.plutusloan.entity.Offer;
import com.lti.plutusloan.repository.GenericRepository;
import com.lti.plutusloan.service.ApplicationService;
import com.lti.plutusloan.service.EligibilityCheckService;
import com.lti.plutusloan.service.EmiCalculatorService;
import com.lti.plutusloan.service.LoanService;
import com.lti.plutusloan.service.LoginService;
import com.lti.plutusloan.service.OfferService;
import com.lti.plutusloan.service.RegistrationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ServiceTest {

	@Autowired
	EmiCalculatorService calculator;
	@Autowired
	RegistrationService registrationService;
	@Autowired
	LoginService loginService;
	@Autowired
	ApplicationService applicationService;
	@Autowired
	EligibilityCheckService eligibilityCheckService;
	@Autowired
	LoanService loanService;
	@Autowired
	GenericRepository genericRepository;

	@Test
	public void testRegistration() {

		RegistrationDTO registrationDTO = new RegistrationDTO();
		registrationDTO.setFirstName("Jai");
		registrationDTO.setLastName("Mehta");
		registrationDTO.setAge(25);
		registrationDTO.setGender("Male");
		registrationDTO.setMobile("9782234578");
		registrationDTO.setEmailId("mehta.jay@gmail.com");
		registrationDTO.setPassword("Helloworld123");
		registrationDTO.setAddress("A/101,Vasant Vihar, Thane");
		registrationDTO.setCity("Mumbai");
		registrationDTO.setState("Maharashtra");
		registrationDTO.setPincode("400101");

		Registration registration = new Registration();
		registration.setFirstName(registrationDTO.getFirstName());
		registration.setLastName(registrationDTO.getLastName());
		registration.setAge(registrationDTO.getAge());
		registration.setGender(registrationDTO.getGender());
		registration.setMobile(registrationDTO.getMobile());
		registration.setEmailId(registrationDTO.getEmailId());
		registration.setPassword(registrationDTO.getPassword());
		registration.setAddress(registrationDTO.getAddress());
		registration.setCity(registrationDTO.getCity());
		registration.setState(registrationDTO.getState());
		registration.setPincode(registrationDTO.getPincode());
		registration.setRole(0);
		registrationService.doRegistration(registrationDTO);
	}

	@Test
	public void testLogin() {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setEmailId("mehta.jay@gmail.com");
		loginDTO.setPassword("Helloworld123");
		loginDTO.setRole(0);
		assertNotNull(loginService.validateUser(loginDTO));
		assertEquals(true, loginService.validateUser(loginDTO));
	}

	@Test
	public void testEMI() {

		EmiDTO emiDTO = new EmiDTO();
		emiDTO.setPrincipal(1000000);
		emiDTO.setRateOfInterest(10.5);
		emiDTO.setTenure(10);

		assertEquals(13493.5, Math.round(calculator.calculateEmi(emiDTO)));
	}

	@Test
	public void testEligibility() {
		EligibilityDTO eligibilityDTO = new EligibilityDTO();
		eligibilityDTO.setAge(50);
		eligibilityDTO.setAmount(200000);
		eligibilityDTO.setExistingEmi(1000);
		eligibilityDTO.setTenure(5);
		eligibilityDTO.setYearlySalary(500000);

		assertNotNull(eligibilityCheckService.checkEligibility(eligibilityDTO));
		assertEquals(true, eligibilityCheckService.checkEligibility(eligibilityDTO));

	}

	@Test
	public void testCar() {
		Car car = new Car();
		car.setCarModel("Maruti Suzuzki SX4");
		car.setCarMake("Maruti");
		car.setExShowroomPrice(500000);
		car.setOnRoadPrice(650000);
		genericRepository.store(car);
	}

	@Test
	public void testUserDetail() {
		Registration registration = applicationService.fetchUserDetails("loharepranav@gmail.com");
		assertNotNull(registration);
	}

	@Test
	public void testLoan() {
		Registration registration = new Registration();
		registration = genericRepository.fetchById(Registration.class, 449);
		Loan loan = new Loan();
		loan.setRegistration(registration);
		loan.setAmount(5888);
		loan.setTenure(4);
		loan.setRateOfInterest(6);
		loan.setEmi(15000);
		loan.setExistingEmi(2000);
		loan.setApproval("A");
		genericRepository.store(loan);
	}

	@Test
	public void testOffers() {

		Offer offer = new Offer();
		offer.setOfferAmount(250000);
		offer.setOfferRateOfInterest(6);
		offer.setOfferTenure(6);
		genericRepository.store(offer);

	}

	@Test
	public void testLoanSubmit() {
		Registration registration2 = new Registration();
		registration2 = genericRepository.fetchById(Registration.class, 449);
		Loan loan = new Loan();
		loan.setRegistration(registration2);
		loan.setAmount(5888);
		loan.setTenure(4);
		loan.setRateOfInterest(6);
		loan.setEmi(15000);
		loan.setExistingEmi(2000);
		loan.setApproval("A");
		Employment employment = new Employment();
		employment.setAccountType("Current");
		employment.setEmploymentType("Service");
		employment.setSalary(200000);
		employment.setRegistrationUser(registration2);

		loanService.submitLoan(loan, employment, "manas@gmail.com");

	}
}