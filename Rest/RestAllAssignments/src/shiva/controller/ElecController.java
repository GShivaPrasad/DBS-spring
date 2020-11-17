package shiva.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shiva.model.Electricity;

@RestController
@RequestMapping("/bill")
public class ElecController {
	@RequestMapping(value="/{initialReading}/{thisMonthReading}", method=RequestMethod.GET)
	public String validateUser(@PathVariable double initialReading, @PathVariable double thisMonthReading) {
		Electricity elec = new Electricity(initialReading, thisMonthReading);
		elec.setTotalBill((elec.getThisMonthReading()-elec.getInitialReading())*Electricity.COST_PER_UNIT);
		return "Total Bill : "+elec.getTotalBill();
	}
}
